package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/admin/goods")
public class AdminGoodsController {

	private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

	private final GoodsService goodsService;

	public AdminGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@PostConstruct
	public void adminGoodsControllerInit() {
		log.info("AdminGoodsController bean 생성");
	}

	// 상품 카테고리 등록 폼
	@GetMapping("/category/goodscate_reg")
	public String addGoodsCategoryForm() {
		return "admin/goods/category/goodscate_reg";
	}

	// 상품 카테고리 등록 처리
	@PostMapping("/category/goodscate_reg")
	public String addGoodsCategory() {
		return null;
	}

	// 상품 카테고리 리스트
	@GetMapping("/category/goodscate_list")
	public String getGoodsCategoryList() {
		return "admin/goods/category/goodscate_list";
	}

	// 상품 카테고리 수정 폼
	@GetMapping("/category/goodscate_update")
	public String modifyGoodsCategoryForm() {
		return "admin/goods/category/goodscate_update";
	}

	// 상품 카테고리 수정 처리
	@PostMapping("/category/goodscate_update")
	public String modifyGoodsCategory() {
		return "redirect:/admin/goods/category/goodscate_list";
	}

	// 상품 카테고리 삭제 처리(세션과 비밀번호 입력받아서?, 아니면 ajax?)
	@PostMapping("category/goodscate_remove/{g_cate_code}")
	public String removeGoodsCategory(@PathVariable(value = "g_cate_code") String g_cate_code) {
		return "redirect:/admin/goods/category/goodscate_list";
	}

	// 상품 등록 폼
	@GetMapping("/goods_reg_form")
	public String addGoodsForm() {
		return "admin/goods/goods_reg_form";
	}

	// 상품 등록 처리
	@PostMapping("/goods_reg_form")
	public String addGoods() {
		return "redirect:/admin/goods/goods_list_admin";
	}

	// 상품 리스트
	@GetMapping("/goods_list_admin")
	public String getAdminGoodsList() {
		return "admin/goods/goods_list_admin";
	}

	// 개별 상품 정보
	@GetMapping("/goods_detail_admin/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String g_code) {

		// 받은 g_code로 상품 정보 select 후 모델에 담는 작업 필요
		// g_code null? 혹은 존재하지 않을경우?
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
	@PostMapping("/goods_remove_form/{g_code}")
	public String removeAdminGoodsForm(@PathVariable(value = "g_code") String g_code) {

		return "redirect:/admin/goods/goods_list_admin";
	}

	// 식단 등록 폼
	@GetMapping("/menu/menu_reg_form")
	public String addAdminMenuForm() {
		return "admin/goods/menu/menu_reg_form";
	}

	// 식단 등록 처리
	@PostMapping("/menu/menu_reg_form")
	public String addAdminMenu() {
		return "redirect:/admin/goods/menu/menu_list";
	}

	// 식단 리스트
	@GetMapping("/menu/menu_list")
	public String getAdminMenuList() {
		return "admin/goods/menu/menu_list";
	}

	// 식단 수정 폼
	@GetMapping("/menu/menu_update_admin/{menu_code}")
	public String modifyAdminMenuForm(@PathVariable(value = "menu_code") String menu_code) {

		return "admin/goods/menu/menu_update_admin";
	}

	// 식단 수정 처리
	@PostMapping("menu/menu_update_admin")
	public String modifyAdminMenu() {

		return "redirect:/admin/goods/menu/menu_list";
	}

	// 식단 삭제 처리
	@PostMapping("menu/menu_remove_form/{menu_code}")
	public String removeAdminMenu(@PathVariable(value = "menu_code") String menu_code) {

		return "redirect:/admin/goods/menu/menu_list";
	}

	// 개별 식단 정보
	@GetMapping("/menu/menu_detail_admin/{menu_code}")
	public String getMenuInfo(@PathVariable(value = "menu_code") String menu_code) {

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
	@PostMapping("discount/goods_discount_remove_form/{g_discount_code}")
	public String removeGoodsDiscount(@PathVariable(value = "g_discount_code") String g_discount_code) {

		return "redirect:/admin/goods/discount/goods_discount_list";
	}
}
