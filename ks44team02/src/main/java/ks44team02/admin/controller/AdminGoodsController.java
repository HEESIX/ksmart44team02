package ks44team02.admin.controller;

import java.awt.peer.MenuPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.Ingredient;
import ks44team02.dto.MenuOrganize;
import ks44team02.service.CommonService;
import ks44team02.service.FileService;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/admin/goods")
public class AdminGoodsController {

	private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

	private final GoodsService goodsService;
	private final CommonService commonService;
	private final FileService fileService;

	public AdminGoodsController(GoodsService goodsService, CommonService commonService, FileService fileService) {
		this.goodsService = goodsService;
		this.commonService = commonService;
		this.fileService = fileService;
	}

	@PostConstruct
	public void adminGoodsControllerInit() {
		log.info("AdminGoodsController bean 생성");
	}

	// 상품 등록 신청 리스트
	@GetMapping("/goodsRegApplyList")
	public String getGoodsRegApplyList(Model model) {

		List<Map<String, Object>> goodsRegApplyList = goodsService.getGoodsRegApplyList();
		model.addAttribute("title", "상품 등록 신청 목록");
		model.addAttribute("goodsRegApplyList", goodsRegApplyList);
		return "admin/goods/goodsRegApplyList";
	}

	// 상품 카테고리 등록 폼
	@GetMapping("/category/regGoodsCate")
	public String addGoodsCategoryForm(Model model) {

		model.addAttribute("title", "상품 카테고리 등록");
		return "admin/goods/category/regGoodsCate";
	}

	// 상품 카테고리 등록 처리
	@PostMapping("/category/regGoodsCate")
	public String addGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {
		String goodsCateCode = commonService.getNewCode("tb_goods_cate");
		goodsCategory.setGoodsCategoryCode(goodsCateCode);
		boolean result = goodsService.addGoodsCategory(goodsCategory);
		String msg = "";
		if (result) {
			msg = "등록 성공";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:/admin/goods/category/goodsCateList";
	}

	// 상품 카테고리 리스트
	@GetMapping("/category/goodsCateList")
	public String getGoodsCategoryList(Model model, @RequestParam(value = "msg", required = false) String msg) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		model.addAttribute("title", "상품 카테고리 목록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		if (msg != null)
			model.addAttribute("msg", msg);

		return "admin/goods/category/goodsCateList";
	}

	// 상품 카테고리 수정 폼
	@GetMapping("/category/updateGoodsCate/{goodsCategoryCode}")
	public String modifyGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);

		model.addAttribute("title", "상품 카테고리 수정");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);
		return "admin/goods/category/updateGoodsCate";
	}

	// 상품 카테고리 수정 처리
	@PostMapping("/category/updateGoodsCate")
	public String modifyGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {

		boolean result = goodsService.modifyGoodsCategory(goodsCategory);

		if (result) {
			reAttr.addAttribute("msg", "수정 완료");
		} else {
			reAttr.addAttribute("msg", "수정 실패");
		}

		return "redirect:/admin/goods/category/goodsCateList";
	}

	// 상품 카테고리 삭제 폼
	@GetMapping("/category/removeGoodsCate/{goodsCategoryCode}")
	public String removeGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);
		System.out.println(goodsCategoryInfo.toString());
		model.addAttribute("title", "상품 카테고리 삭제");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);

		return "admin/goods/category/removeGoodsCate";
	}

	// 상품 카테고리 삭제 처리
	@PostMapping("/category/removeGoodsCate")
	public String removeGoodsCategory(@RequestParam(value = "goodsCategoryCode") String goodsCategoryCode,
			@RequestParam(value = "memberPw") String memberPw, HttpSession session, RedirectAttributes reAttr) {
		// session 저장하는 로그인 완성되면 이 부분 session 아이디 가져오게 교체
		// String memberId = session.getAttribute("SID");
		// null일 경우 체크(비정상적인 접근)
		// 현재 없으므로 픽스된 값 입력
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		if (idCheckResult) {
			// 아이디 비번 일치
			goodsService.removeGoodsCategory(goodsCategoryCode);
			reAttr.addAttribute("msg", "삭제가 정상적으로 완료되었습니다.");
		} else {
			// 아이디 비번 불일치
			reAttr.addAttribute("msg", "삭제 실패: 비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/admin/goods/category/goodsCateList";
	}

	// 상품 리스트
	@GetMapping("/goodsList")
	public String getAdminGoodsList(Model model) {
		List<Goods> goodsList = goodsService.getAdminGoodsList();
		System.out.println(goodsList.toString());
		model.addAttribute("goodsList", goodsList);
		return "admin/goods/goodsList";
	}

	// 개별 상품 정보
	@GetMapping("/goodsDetail/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String goodsCode, Model model) {

		// 받은 g_code로 상품 정보 select 후 모델에 담는 작업 필요
		// g_code null? 혹은 존재하지 않을경우?

		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		model.addAttribute("goodsInfo", goodsInfo);
		return "admin/goods/goodsDetail";
	}

	// 상품 수정 폼
	@GetMapping("/updateGoods/{g_code}")
	public String modifyGoodsForm(@PathVariable(value = "g_code") String g_code) {

		return "admin/goods/updateGoods";
	}

	// 상품 수정 처리
	@PostMapping("/updateGoods")
	public String modifyGoods() {

		// 수정 처리 후 돌아갈 화면 redirect
		return "redirect:/admin/goods/goodsList";
	}

	// 상품 삭제 처리
	@PostMapping("/removeGoods/{g_code}")
	public String removeAdminGoods(@PathVariable(value = "g_code") String g_code) {

		return "redirect:/admin/goods/goodsList";
	}

	// 식단 등록 폼
	@GetMapping("/menu/regMenu")
	public String addAdminMenuForm(Model model) {
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListForReg();
		List<Map<String, Object>> goodsList = goodsService.getGoodsList();

		model.addAttribute("title", "식단 등록");
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		model.addAttribute("goodsList", goodsList);
		return "admin/goods/menu/regMenu";
	}

	// 식단 등록 처리
	@PostMapping("/menu/regMenu")
	@ResponseBody
	public String addAdminMenu(@RequestBody Map<String, Object> param
							  ,HttpServletRequest request) {
		log.info(">>>>>>>>>>>>{}", param);
		System.out.println(param.toString());
		/*
		log.info(goods.toString());
		List<MenuOrganize> menuOrganizes = new ArrayList<MenuOrganize>();
		commonService.getNewCode("tb_");
		int num = goodsOfMenuCode.length;
		for(int i = 0; i < num; i++) {
			MenuOrganize menuOrganize = new MenuOrganize();
			menuOrganize.setMenuGoodsCode(commonService.getNewCode("tb_menu_organize"));
			menuOrganize.setGoodsOfMenuCode(goodsOfMenuCode[i]);
			menuOrganize.setMenuGoodsAmount(menuGoodsAmount[i]);
			menuOrganizes.add(menuOrganize);
		}
		System.out.println(menuOrganizes);
		
		String serverName = request.getServerName();
		log.info("{} <<<< serverName", serverName);
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		String fileRealPath = "";
		boolean isLocalhost = true;

		if ("localhost".equals(serverName)) {
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			// fileRealPath =
			// request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		} else {
			// fileRealPath =
			// request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
			isLocalhost = false;
			fileRealPath = System.getProperty("user.dir") + "/resources/";
		}
		String goodsMainImageIdx = fileService.fileUpload(goodsMainImage, fileRealPath, isLocalhost);
		String goodsInfoImageIdx = fileService.fileUpload(goodsInfoImage, fileRealPath, isLocalhost);
		String goodsCode = commonService.getNewCode("tb_goods");
		String ingredientCode = commonService.getNewCode("tb_ingredient");

		goods.setGoodsCode(goodsCode);
		//goods.setGoodsMainImage(goodsMainImageIdx);
		//goods.setGoodsInfoImage(goodsInfoImageIdx);
		ingredient.setIngredientCode(ingredientCode);
		ingredient.setGoodsCode(goodsCode);
		*/
		return "redirect:/admin/goods/menu/menuList";
	}

	// 식단 리스트
	@GetMapping("/menu/menuList")
	public String getAdminMenuList(Model model) {
		//image가 관련된 부분은 전부 isLocal test 필요
		List<Goods> adminMenuList = goodsService.getAdminMenuList();
		model.addAttribute("adminMenuList", adminMenuList);
		return "admin/goods/menu/menuList";
	}

	// 식단 수정 폼
	@GetMapping("/menu/updateMenu/{menuCode}")
	public String modifyAdminMenuForm(@PathVariable(value = "menuCode") String menuCode) {
		
		return "admin/goods/menu/updateMenu";
	}

	// 식단 수정 처리
	@PostMapping("menu/updateMenu/{menuCode}")
	public String modifyAdminMenu(@PathVariable(value = "menuCode") String menuCode) {

		return "redirect:/admin/goods/menu/menuList";
	}

	// 식단 삭제 처리
	@PostMapping("menu/removeMenu/{menuCode}")
	public String removeAdminMenu(@PathVariable(value = "menuCode") String menuCode) {

		return "redirect:/admin/goods/menu/menuList";
	}

	// 개별 식단 정보
	@GetMapping("/menu/menuDetail/{menuCode}")
	public String getMenuInfo(@PathVariable(value = "menuCode") String menuCode
							 ,Model model
							 ,HttpServletRequest request) {
		//String serverName = request.getServerName();
		List<Goods> menuOrgarnizeGoodsInfoList = goodsService.getMenuOrganizeGoodsInfo(menuCode);
		Goods menuInfo = goodsService.getMenuInfo(menuCode);
		List<MenuOrganize> menuOrganizeList = goodsService.getMenuOrganizeList(menuCode);
		
		model.addAttribute("title", "개별 식단 정보");
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrgarnizeGoodsInfoList", menuOrgarnizeGoodsInfoList);
		model.addAttribute("menuOrganizeList", menuOrganizeList);
		return "admin/goods/menu/menuDetail";
	}

	// 상품별 할인 혜택 등록 폼
	@GetMapping("/discount/regGoodsDiscount")
	public String addGoodsDiscountForm() {
		return "admin/goods/discount/regGoodsDiscount";
	}

	// 상품별 할인 혜택 등록 처리
	@PostMapping("/discount/regGoodsDiscount")
	public String addGoodsDiscount(GoodsDiscount goodsDiscount
								  ,@RequestParam(value = "selectRatePrice") String selectRatePrice
								  ,@RequestParam(value = "discountNumber") int discountNumber
								  ,HttpSession session) {
		if("rate".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(discountNumber);
			goodsDiscount.setGoodsDiscountPrice(0);
		}else if("price".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(0);
			goodsDiscount.setGoodsDiscountPrice(discountNumber);
		}
		
		String newCode = commonService.getNewCode("tb_goods_discount_management");
		goodsDiscount.setGoodsDiscountCode(newCode);
		
		//세션 생성 후 변경 
		//String memberId = session.getAttribute("SID");
		//해당 아이디 값으로 enterprise 조회후 entercode 또한 세팅해줘야함
		//픽스한 값으로 설정
		String memberId = "id001";
		goodsDiscount.setGoodsDiscountRegistrant(memberId);
		
		log.info(goodsDiscount.toString());
		goodsService.addGoodsDiscount(goodsDiscount);
		
		return "redirect:/admin/goods/discount/goodsDiscountList";
	}

	// 상품별 할인 혜택 리스트
	@GetMapping("/discount/goodsDiscountList")
	public String getGoodsDiscountList(Model model
									  ,@RequestParam(value = "msg", required = false) String msg) {
		List<GoodsDiscount> goodsDiscountList = goodsService.getGoodsDiscountList();
		
		model.addAttribute("title", "상품별 할인 혜택 목록");
		model.addAttribute("goodsDiscountList", goodsDiscountList);
		if(msg!=null) model.addAttribute("msg", msg);
		return "admin/goods/discount/goodsDiscountList";
	}

	// 상품별 할인 혜택 수정 폼
	@GetMapping("/discount/updateGoodsDiscount/{goodsDiscountCode}")
	public String modifyGoodsDiscountForm(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
										 ,Model model) {
		GoodsDiscount goodsDiscountInfo = goodsService.modifyGoodsDiscountForm(goodsDiscountCode);
		model.addAttribute("goodsDiscountInfo", goodsDiscountInfo);
		return "admin/goods/discount/updateGoodsDiscount";
	}

	// 상품별 할인 혜택 수정 처리
	@PostMapping("/discount/updateGoodsDiscount/{goodsDiscountCode}")
	public String modifyGoodsDiscount(GoodsDiscount goodsDiscount
									 ,@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
									 ,@RequestParam(value = "memberPw") String memberPw
									 ,@RequestParam(value = "selectRatePrice") String selectRatePrice
									 ,@RequestParam(value = "discountNumber") int discountNumber
									 ,HttpSession session
									 ,RedirectAttributes reAttr) {
		
		if("rate".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(discountNumber);
			goodsDiscount.setGoodsDiscountPrice(0);
		}else if("price".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(0);
			goodsDiscount.setGoodsDiscountPrice(discountNumber);
		}
		
		//세션 생성 후 아래 과정으로 대체
		//String memberId = session.getAttribute("SID");
		//없으니 픽스된 값 사용
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		System.out.println(goodsDiscount.toString());
		if(idCheckResult) {
			boolean result = goodsService.modifyGoodsDiscount(goodsDiscount);
			if(result) {
				reAttr.addAttribute("msg", "수정이 정상적으로 완료되었습니다.");
			}else {
				reAttr.addAttribute("msg", "수정 실패: GoodsMapper 확인");
			}
		}else {
			reAttr.addAttribute("msg", "수정 실패: 비밀번호를 확인해주세요.");
		}

		return "redirect:/admin/goods/discount/goodsDiscountList";
	}
	
	//상품별 할인 혜택 삭제 폼
	@GetMapping("/discount/removeGoodsDiscount/{goodsDiscountCode}")
	public String removeGoodsDiscountForm(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
										 ,Model model) {
		GoodsDiscount goodsDiscountInfo = goodsService.removeGoodsDiscountForm(goodsDiscountCode);
		
		model.addAttribute("goodsDiscountInfo", goodsDiscountInfo);
		return "admin/goods/discount/removeGoodsDiscount";
	}

	// 상품별 할인 혜택 삭제 처리
	@PostMapping("/discount/removeGoodsDiscount/{goodsDiscountCode}")
	public String removeGoodsDiscount(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
									 ,@RequestParam(value = "memberPw") String memberPw
									 ,HttpSession session
									 ,RedirectAttributes reAttr) {
		//세션 생성 후 아래 과정으로 대체
		//String memberId = session.getAttribute("SID");
		//없으니 픽스한 값 사용
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		
		if(idCheckResult) {
			boolean result2 = goodsService.removeGoodsDiscount(goodsDiscountCode);
			if(result2) {
				reAttr.addAttribute("msg", "삭제가 정상적으로 완료되었습니다");
			}else {
				reAttr.addAttribute("msg", "삭제 실패: GoodsMapper 확인");
			}
		}else {
			reAttr.addAttribute("msg", "삭제 실패: 비밀번호를 확인해주세요.");
		}
		
		return "redirect:/admin/goods/discount/goodsDiscountList";
	}
}
