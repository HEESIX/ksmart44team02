package ks44team02.seller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsApply;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.Ingredient;
import ks44team02.service.CommonService;
import ks44team02.service.FileService;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/seller/goods")
public class SellerGoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerGoodsController.class);

	private final GoodsService goodsService;
	private final FileService fileService;
	private final CommonService commonService;
	
	public SellerGoodsController(GoodsService goodsService, FileService fileService, CommonService commonService) {
		this.goodsService = goodsService;
		this.fileService = fileService;
		this.commonService = commonService;
	}
	
	//상품 등록 신청 폼
	@GetMapping("/regGoodsApply")
	public String applyGoodsRegisterForm(Model model
										,HttpSession session) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListUser();
		List<GoodsDiscount> goodsDiscountList = goodsService.getGoodsDiscountListSeller(session);
		
		model.addAttribute("title", "상품 등록 신청");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		model.addAttribute("goodsDiscountList", goodsDiscountList);
		return "seller/goods/regGoodsApply";
	}
	
	//상품 등록 신청 처리
	@PostMapping("/regGoodsApply")
	@Transactional
	@ResponseBody
	public boolean applyGoodsRegister(@RequestParam MultipartFile goodsMainImage
									,@RequestParam MultipartFile goodsInfoImage
									,GoodsApply goodsApply
									,HttpServletRequest request
									,HttpSession session
									,Ingredient ingredient) {
		
		//세션의 아이디로 입점업체 코드를 조회하여 입점업체 코드가 존재한다면 값을 세팅
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		int isExistEnterCode = commonService.isExistEnterCode(memberId);
		
		if(isExistEnterCode == 0) return false;
			
		String enterCode = commonService.getEnterCodeOfMebmerId(memberId);
		goodsApply.setEnterCode(enterCode);
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		String fileRealPath = ""; 
		int isLocalhost = 1;
		
		if ("localhost".equals(serverName)) { 
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/"; 
			//fileRealPath = 
			// request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/"); 
		} else { 
			// fileRealPath = 
			// request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/"); 
			isLocalhost = 0; 
			fileRealPath = System.getProperty("user.dir") + "/resources/"; 
		}
		
		String goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
		String goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
		
		goodsApply.setGoodsApplyMainImage(goodsMainImageIdx);
		goodsApply.setGoodsApplyInfoImage(goodsInfoImageIdx);
		
		//tb_goods_apply INSERT 준비
		String goodsApplyCode = commonService.getNewCode("tb_goods_apply");
		goodsApply.setGoodsApplyCode(goodsApplyCode);
		
		// 상품별 할인혜택 조회 후 할인된 혹은 할인되지 않은 가격 세팅
		String goodsDiscountCode = goodsApply.getGoodsDiscountCode();
		int goodsApplyPrice = goodsApply.getGoodsApplyPrice();
		int goodsApplyDiscountedPrice = 0;
		
		if("noDiscount".equals(goodsDiscountCode)) {
			goodsApplyDiscountedPrice = goodsApplyPrice;
		}else {
			GoodsDiscount goodsDiscount = goodsService.getGoodsDiscount(goodsDiscountCode);
			int goodsApplyDiscountPrice = goodsDiscount.getGoodsDiscountPrice();
			int goodsApplyDiscountRate = goodsDiscount.getGoodsDiscountRate();
			
			if(goodsApplyDiscountPrice == 0 && goodsApplyDiscountRate == 0) {
				goodsApplyDiscountPrice = goodsApplyPrice;
			}else if(goodsApplyDiscountPrice != 0 && goodsApplyDiscountRate == 0) {
				goodsApplyDiscountedPrice = (goodsApplyPrice - goodsApplyDiscountPrice);
			}else {
				double percent = goodsApplyDiscountRate * 0.01;
				double discount = goodsApplyPrice * percent;
				goodsApplyDiscountedPrice = (int) (goodsApplyPrice - discount);
			}
		}
		goodsApply.setGoodsApplyDiscount(goodsApplyDiscountedPrice);
		
		//상품 등록 신청 테이블에 INSERT
		boolean addGoodsRegApplyResult = goodsService.addGoodsRegApply(goodsApply);
		if(!addGoodsRegApplyResult) return false;
		
		//상품 등록 신청 영양 정보에 INSERT
		String ingredientCode = commonService.getNewCode("tb_goods_apply_ingredient");
		ingredient.setIngredientCode(ingredientCode);
		ingredient.setGoodsCode(goodsApplyCode);
		
		boolean addGoodsApplyIngredientResult = goodsService.addGoodsApplyIngredient(ingredient);
		if(!addGoodsApplyIngredientResult) return false;
		

		return true;
	}
	
	//상품 등록 신청 내역 조회
	@GetMapping("/goodsApplyList")
	public String getGoodsApplyList(Model model
								   ,HttpSession session) {
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		
		List<GoodsApply> goodsApplyList = goodsService.getGoodsRegApplyList(map);
		log.info(">>>>>>>>>>{}", goodsApplyList);
		
		model.addAttribute("goodsApplyList", goodsApplyList);
		return "seller/goods/goodsApplyList";
	}
	
	//상품 리스트, seller 본인이 등록한 상품만 조회 가능
	@GetMapping("/goodsList")
	public String getSellerGoodsList(Model model
									,HttpServletRequest request
									,HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		String serverName = request.getServerName(); 
		int isLocalhost = 0;
		 
		if ("localhost".equals(serverName)) { 
			isLocalhost = 1;
		}
		
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		
		map.put("isLocalhost", isLocalhost);
		map.put("memberId", memberId);
		
		List<Goods> sellerGoodsList = goodsService.getGoodsList(map);
		log.info(">>>>>>>>>>>>{}", sellerGoodsList);
		
		model.addAttribute("sellerGoodsList", sellerGoodsList);
		return "seller/goods/goodsList";
	}
	
	//상품 상세 페이지: 구매자가 보는 화면
	@GetMapping("/goodsDetail/{goodsCode}")
	public String getGoodsDetail(@PathVariable(value = "goodsCode") String goodsCode
								,Model model) {
		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		log.info(">>>>>>>>>>{}", goodsInfo);
		model.addAttribute("goodsInfo", goodsInfo);
		return "seller/goods/goodsDetail";
	}
	
	//기존 데이터 조회(상품 수정 화면): 상품 수정 폼
	//common 폴더로 admin goods modify와 기능이 모두 같다면 병합해야할까?
	//그냥 service 하위에서 같이 쓰면 해결되는 문제일까?
	//요청 주소의 헷갈림 방지를 위해서 나눠놓은 지금이 나을까?
	@GetMapping("/updateGoods/{goodsCode}")
	public String getSellerGoodsInfo(@PathVariable(value = "goodsCode") String goodsCode
									,HttpSession session) {
		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListUser();
		List<GoodsDiscount> goodsDicountList = goodsService.getGoodsDiscountListSeller(session);
		
		
		
		return "seller/goods/updateGoods";
	}

	//상품 수정 처리
	@PostMapping("/updateGoods")
	public String modifySellerGoods() {
		return "redirect:/seller/goods/goodsList";
	}
	
	//상품 삭제 처리
	@PostMapping("/removeGoods/{g_code}")
	public String removeSellerGoods(@PathVariable(value = "g_code") String g_code) {
		return "redirect:/seller/goods/removeGoods";
	}
}
