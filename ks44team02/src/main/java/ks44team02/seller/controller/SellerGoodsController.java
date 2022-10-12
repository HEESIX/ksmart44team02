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
		
		List<GoodsApply> goodsApplyList = goodsService.getGoodsRegApplyListForSeller(map);
		log.info(">>>>>>>>>>{}", goodsApplyList);
		
		model.addAttribute("title", "상품 등록 신청 내역");
		model.addAttribute("goodsApplyList", goodsApplyList);
		return "seller/goods/goodsApplyList";
	}
	
	//상품 등록 신청 내역 검색
	@PostMapping("/goodsApplyList")
	public String getSearchGoodsApplyList(Model model
										 ,HttpServletRequest request
										 ,HttpSession session
										 ,@RequestParam(value = "msg", required = false) String msg
										 ,@RequestParam(value = "searchKey", defaultValue = "goodsName") String searchKey
										 ,@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue
										 ,@RequestParam(value = "minNum", required = false, defaultValue = "") String minNum
										 ,@RequestParam(value = "maxNum", required = false, defaultValue = "") String maxNum
									     ,@RequestParam(value = "minDate", required = false, defaultValue = "") String minDate
									     ,@RequestParam(value = "maxDate", required = false, defaultValue = "") String maxDate
									     ,@RequestParam(value = "approveRefuse", required = false, defaultValue = "") String approveRefuse) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		int isLocalhost = 1;
		
		if (!"localhost".equals(serverName)) { 
			isLocalhost = 0;
		}
		map.put("isLocalhost", isLocalhost);
		
		if("goodsName".equals(searchKey)) {
			searchKey = "ga.ga_name";
		}else if("goodsCategory".equals(searchKey)) {
			searchKey = "gc.cate_name";
		}else if("goodsProduce".equals(searchKey)) {
			searchKey = "ga.ga_produce";
		}else if("goodsPrice".equals(searchKey)) {
			searchKey = "ga.ga_price";
		}else if("goodsDiscountName".equals(searchKey)) {
			searchKey = "gdm.discount_name";
		}else if("goodsDiscountPrice".equals(searchKey)) {
			searchKey = "ga.ga_discount";
		}else if("goodsStock".equals(searchKey)) {
			searchKey = "ga.ga_stock";
		}else if("goodsDeliveryCharge".equals(searchKey)) {
			searchKey = "ga.ga_delivery_charge";
		}else if("regDate".equals(searchKey)) {
			searchKey = "ga.ga_reg_apply_datetime";
		}else if("approveRefuse".equals(searchKey)) {
			searchKey = "ga.ga_approve_refuse";
		}		
		
		map.put("sk", searchKey);
		map.put("sv", searchValue);
		map.put("minNum", minNum);
		map.put("maxNum", maxNum);
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		map.put("approveRefuse", approveRefuse);
		
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		map.put("memberId", memberId);
		
		log.info(">>>>>>>>>{}", map);
		
		List<GoodsApply> goodsApplyList = goodsService.getGoodsRegApplyListForSeller(map);
		log.info(">>>>>>>>>>{}", goodsApplyList);
		
		model.addAttribute("title", "상품 등록 신청 내역");
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
		
		model.addAttribute("title", "상품 목록");
		model.addAttribute("sellerGoodsList", sellerGoodsList);
		return "seller/goods/goodsList";
	}
	
	//상품 목록 검색
	@PostMapping("/goodsList")
	public String getSearchSellerGoodsList(Model model
										  ,HttpServletRequest request
										  ,HttpSession session
										  ,@RequestParam(value = "msg", required = false) String msg
										  ,@RequestParam(value = "searchKey", defaultValue = "goodsName") String searchKey
										  ,@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue
										  ,@RequestParam(value = "minNum", required = false, defaultValue = "") String minNum
										  ,@RequestParam(value = "maxNum", required = false, defaultValue = "") String maxNum
									      ,@RequestParam(value = "minDate", required = false, defaultValue = "") String minDate
									      ,@RequestParam(value = "maxDate", required = false, defaultValue = "") String maxDate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		int isLocalhost = 1;
		
		if (!"localhost".equals(serverName)) { 
			isLocalhost = 0;
		}
		map.put("isLocalhost", isLocalhost);
		
		if("goodsName".equals(searchKey)) {
			searchKey = "g.g_name";
		}else if("goodsCategory".equals(searchKey)) {
			searchKey = "gc.cate_name";
		}else if("goodsProduce".equals(searchKey)) {
			searchKey = "g.g_produce";
		}else if("goodsPrice".equals(searchKey)) {
			searchKey = "g.g_price";
		}else if("goodsDiscountName".equals(searchKey)) {
			searchKey = "gdm.discount_name";
		}else if("goodsDiscountPrice".equals(searchKey)) {
			searchKey = "g.g_discount";
		}else if("goodsStock".equals(searchKey)) {
			searchKey = "g.g_stock";
		}else if("goodsDeliveryCharge".equals(searchKey)) {
			searchKey = "g.g_delivery_charge";
		}else if("regDate".equals(searchKey)) {
			searchKey = "g.g_reg_datetime";
		}
		
		map.put("sk", searchKey);
		map.put("sv", searchValue);
		map.put("minNum", minNum);
		map.put("maxNum", maxNum);
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		map.put("memberId", memberId);
		
		log.info(">>>>>>>>>{}", map);
		
		List<Goods> sellerGoodsList = goodsService.getGoodsList(map);
		log.info(">>>>>>>>>>>>{}", sellerGoodsList);
		
		model.addAttribute("title", "상품 목록");
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
	@GetMapping("/updateGoods/{goodsCode}")
	public String getSellerGoodsInfo(@PathVariable(value = "goodsCode") String goodsCode
									,HttpSession session
									,Model model) {
		
		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListUser();
		List<GoodsDiscount> goodsDiscountList = goodsService.getGoodsDiscountListSeller(session);
		
		model.addAttribute("title", "상품 수정");
		model.addAttribute("goodsInfo", goodsInfo);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		model.addAttribute("goodsDiscountList", goodsDiscountList);
		
		log.info(">>>>>>>>>>>{}", goodsInfo);
		
		return "seller/goods/updateGoods";
	}

	//상품 수정 처리
	@PostMapping("/updateGoods/{goodsCode}")
	@ResponseBody
	@Transactional
	public boolean modifySellerGoods(@PathVariable(value = "goodsCode") String goodsCode
								   ,Goods goods
								   ,Ingredient ingredient
								   ,@RequestParam(value = "goodsMainImage", required = false) MultipartFile goodsMainImage
								   ,@RequestParam(value = "goodsInfoImage", required = false) MultipartFile goodsInfoImage
								   ,HttpSession session
								   ,HttpServletRequest request) {
		log.info(">>>>>>>{}", goods);
		log.info(">>>>>>>{}", ingredient);
		
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
		
		String goodsMainImageIdx = "";
		String goodsInfoImageIdx = "";
		
		if(!goodsMainImage.isEmpty()) {
			if(!goodsInfoImage.isEmpty()) {
				//goodsMainImage와 goodsInfoImage 모두 수정
				goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
				goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
				goods.setGoodsMainImageCode(goodsMainImageIdx);
				goods.setGoodsInfoImageCode(goodsInfoImageIdx);
			}else {
				//goodsMainImage만 수정
				goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
				goods.setGoodsMainImageCode(goodsMainImageIdx);
			}
		}else{
			if(!goodsInfoImage.isEmpty()) {
				//goodsInfoImage만 수정
				goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
				goods.setGoodsInfoImageCode(goodsInfoImageIdx);
			}
		}
		
		log.info(">>>>>>{}",goodsMainImage);
		
		// 상품별 할인혜택 조회 후 할인된 혹은 할인되지 않은 가격 세팅
		String goodsDiscountCode = goods.getGoodsDiscountCode();
		int goodsPrice = goods.getGoodsPrice();
		int goodsDiscountedPrice = 0;
		
		if("noDiscount".equals(goodsDiscountCode)) {
			goodsDiscountedPrice = goodsPrice;
		}else {
			GoodsDiscount goodsDiscount = goodsService.getGoodsDiscount(goodsDiscountCode);
			int goodsDiscountPrice = goodsDiscount.getGoodsDiscountPrice();
			int goodsDiscountRate = goodsDiscount.getGoodsDiscountRate();
			
			if(goodsDiscountPrice == 0 && goodsDiscountRate == 0) {
				goodsDiscountedPrice = goodsPrice;
			}else if(goodsDiscountPrice != 0 && goodsDiscountRate == 0) {
				goodsDiscountedPrice = (goodsPrice - goodsDiscountPrice);
			}else {
				double percent = goodsDiscountRate * 0.01;
				double discount = goodsPrice * percent;
				goodsDiscountedPrice = (int) (goodsPrice - discount);
			}
		}
		goods.setGoodsDiscountedPrice(goodsDiscountedPrice);
		log.info(">>>>>>>> {}", goods);
		
		//상품 수정
		boolean modifyGoodsResult = goodsService.modifyGoods(goods);
		if(!modifyGoodsResult) return false;
		
		//상품 영양 정보 수정
		ingredient.setGoodsCode(goodsCode);
		log.info(">>>>>>>>>{}", ingredient);
		
		boolean modifyIngredientResult = goodsService.modifyIngredient(ingredient);
		if(!modifyIngredientResult) return false;
		
		return true;
	}
	
	//상품 삭제 처리
	@PostMapping("/removeGoods/{goodsCode}")
	@ResponseBody
	public boolean removeSellerGoods(@PathVariable(value = "goodsCode") String goodsCode
								   ,@RequestParam(value = "memberPw") String memberPw
								   ,HttpSession session) {
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		if(!idCheckResult) return false;
		
		boolean removeGoodsResult = goodsService.removeGoods(goodsCode);
		if(!removeGoodsResult) return false;
		
		return true;
	}
}
