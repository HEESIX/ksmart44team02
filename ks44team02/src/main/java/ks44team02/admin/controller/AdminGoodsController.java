package ks44team02.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/goods_reg_apply_list")
	public String getGoodsRegApplyList(Model model) {

		List<Map<String, Object>> goodsRegApplyList = goodsService.getGoodsRegApplyList();
		model.addAttribute("title", "상품 등록 신청 목록");
		model.addAttribute("goodsRegApplyList", goodsRegApplyList);
		return "admin/goods/goods_reg_apply_list";
	}

	// 상품 카테고리 등록 폼
	@GetMapping("/category/goodscate_reg")
	public String addGoodsCategoryForm(Model model) {

		model.addAttribute("title", "상품 카테고리 등록");
		return "admin/goods/category/goodscate_reg";
	}

	// 상품 카테고리 등록 처리
	@PostMapping("/category/goodscate_reg")
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
		return "redirect:/admin/goods/category/goodscate_list";
	}

	// 상품 카테고리 리스트
	@GetMapping("/category/goodscate_list")
	public String getGoodsCategoryList(Model model, @RequestParam(value = "msg", required = false) String msg) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		model.addAttribute("title", "상품 카테고리 목록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		if (msg != null)
			model.addAttribute("msg", msg);

		return "admin/goods/category/goodscate_list";
	}

	// 상품 카테고리 수정 폼
	@GetMapping("/category/goodscate_update/{goodsCategoryCode}")
	public String modifyGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);

		model.addAttribute("title", "상품 카테고리 수정");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);
		return "admin/goods/category/goodscate_update";
	}

	// 상품 카테고리 수정 처리
	@PostMapping("/category/goodscate_update")
	public String modifyGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {

		boolean result = goodsService.modifyGoodsCategory(goodsCategory);

		if (result) {
			reAttr.addAttribute("msg", "수정 완료");
		} else {
			reAttr.addAttribute("msg", "수정 실패");
		}

		return "redirect:/admin/goods/category/goodscate_list";
	}

	// 상품 카테고리 삭제 폼
	@GetMapping("/category/goodscate_remove/{goodsCategoryCode}")
	public String removeGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);
		System.out.println(goodsCategoryInfo.toString());
		model.addAttribute("title", "상품 카테고리 삭제");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);

		return "admin/goods/category/goodscate_remove";
	}

	// 상품 카테고리 삭제 처리
	@PostMapping("/category/goodscate_remove")
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
		return "redirect:/admin/goods/category/goodscate_list";
	}

	// 상품 등록 폼
	@GetMapping("/goods_reg_form")
	public String addGoodsForm(Model model) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListAdmin();

		model.addAttribute("title", "상품 등록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		return "admin/goods/goods_reg_form";
	}

	// 상품 등록 처리 및 영양 정보 등록 처리
	@PostMapping("/goods_reg_form")
	public String addGoods() {
		return "redirect:/admin/goods/goods_list_admin";
	}

	// 상품 리스트
	@GetMapping("/goods_list_admin")
	public String getAdminGoodsList(Model model) {
		List<Goods> goodsList = goodsService.getAdminGoodsList();

		model.addAttribute("goodsList", goodsList);
		return "admin/goods/goods_list_admin";
	}

	// 개별 상품 정보
	@GetMapping("/goods_detail_admin/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String goodsCode, Model model) {

		// 받은 g_code로 상품 정보 select 후 모델에 담는 작업 필요
		// g_code null? 혹은 존재하지 않을경우?

		Map<String, Object> goodsInfo = goodsService.getGoodsInfo(goodsCode);
		model.addAttribute("goodsInfo", goodsInfo);
		return "admin/goods/goods_detail_admin";
	}

	// 상품 수정 폼
	@GetMapping("/goods_update_admin/{g_code}")
	public String modifyGoodsForm(@PathVariable(value = "g_code") String g_code) {

		return "admin/goods/goods_update_admin";
	}

	// 상품 수정 처리
	@PostMapping("/goods_update_admin")
	public String modifyGoods() {

		// 수정 처리 후 돌아갈 화면 redirect
		return "redirect:/admin/goods/goods_list_admin";
	}

	// 상품 삭제 처리
	@PostMapping("/goods_remove/{g_code}")
	public String removeAdminGoods(@PathVariable(value = "g_code") String g_code) {

		return "redirect:/admin/goods/goods_list_admin";
	}

	// 식단 등록 폼
	@GetMapping("/menu/menu_reg_form")
	public String addAdminMenuForm(Model model) {
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListAdmin();
		List<Map<String, Object>> goodsList = goodsService.getGoodsList();

		model.addAttribute("title", "식단 등록");
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		model.addAttribute("goodsList", goodsList);
		return "admin/goods/menu/menu_reg_form";
	}

	// 식단 등록 처리
	@PostMapping("/menu/menu_reg_form")
	public String addAdminMenu(@RequestParam(value = "goodsMainImage") MultipartFile goodsMainImage,
			@RequestParam(value = "goodsInfoImage") MultipartFile goodsInfoImage, Goods goods, Ingredient ingredient,
			MenuOrganize[] menuOrganize, HttpServletRequest request) {
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
		goods.setGoodsMainImage(goodsMainImageIdx);
		goods.setGoodsInfoImage(goodsInfoImageIdx);
		ingredient.setIngredientCode(ingredientCode);
		ingredient.setGoodsCode(goodsCode);

		return "redirect:/admin/goods/menu/menu_list";
	}

	// 식단 리스트
	@GetMapping("/menu/menu_list")
	public String getAdminMenuList(Model model) {
		//image가 관련된 부분은 전부 isLocal test 필요
		List<Map<String, Object>> adminMenuList = goodsService.getAdminMenuList();
		model.addAttribute("adminMenuList", adminMenuList);
		return "admin/goods/menu/menu_list";
	}

	// 식단 수정 폼
	@GetMapping("/menu/menu_update_admin/{menuCode}")
	public String modifyAdminMenuForm(@PathVariable(value = "menuCode") String menuCode) {

		return "admin/goods/menu/menu_update_admin";
	}

	// 식단 수정 처리
	@PostMapping("menu/menu_update_admin/{menuCode}")
	public String modifyAdminMenu(@PathVariable(value = "menuCode") String menuCode) {

		return "redirect:/admin/goods/menu/menu_list";
	}

	// 식단 삭제 처리
	@PostMapping("menu/menu_remove/{menuCode}")
	public String removeAdminMenu(@PathVariable(value = "menuCode") String menuCode) {

		return "redirect:/admin/goods/menu/menu_list";
	}

	// 개별 식단 정보
	@GetMapping("/menu/menu_detail_admin/{menuCode}")
	public String getMenuInfo(@PathVariable(value = "menuCode") String menuCode
							 ,Model model
							 ,HttpServletRequest request) {
		//String serverName = request.getServerName();
		List<Map<String, Object>> menuOrgarnizeGoodsInfoList = goodsService.getMenuOrganizeGoodsInfo(menuCode);
		Map<String, Object> menuInfo = goodsService.getMenuInfo(menuCode);
		
		model.addAttribute("title", "개별 식단 정보");
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrgarnizeGoodsInfoList", menuOrgarnizeGoodsInfoList);
		return "admin/goods/menu/menu_detail_admin";
	}

	// 상품별 할인 혜택 등록 폼
	@GetMapping("/discount/goods_discount_reg_form")
	public String addGoodsDiscountForm() {
		return "admin/goods/discount/goods_discount_reg_form";
	}

	// 상품별 할인 혜택 등록 처리
	@PostMapping("/discount/goods_discount_reg_form")
	public String addGoodsDiscount() {
		return "redirect:/admin/goods/discount/goods_discount_list";
	}

	// 상품별 할인 혜택 리스트
	@GetMapping("/discount/goods_discount_list")
	public String getGoodsDiscountList() {
		return "admin/goods/discount/goods_discount_list";
	}

	// 상품별 할인 혜택 수정 폼
	@GetMapping("/discount/goods_discount_update_form/{g_discount_code}")
	public String modifyGoodsDiscountForm(@PathVariable(value = "g_discount_code") String g_discount_code) {

		return "admin/goods/discount/goods_discount_update_form";
	}

	// 상품별 할인 혜택 수정 처리
	@PostMapping("/discount/goods_discount_update_form")
	public String modifyGoodsDiscount() {

		return "redirect:/admin/goods/discount/goods_discount_list";
	}

	// 상품별 할인 혜택 삭제 처리
	@PostMapping("discount/goods_discount_remove/{g_discount_code}")
	public String removeGoodsDiscount(@PathVariable(value = "g_discount_code") String g_discount_code) {

		return "redirect:/admin/goods/discount/goods_discount_list";
	}
}
