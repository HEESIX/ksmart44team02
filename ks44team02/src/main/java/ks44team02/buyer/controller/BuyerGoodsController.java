package ks44team02.buyer.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.GoodsCategory;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/buyer/goods")
public class BuyerGoodsController {

	private final GoodsService goodsService;
	
	public BuyerGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	// 개인 맞춤 식단 생성 폼
	@GetMapping("/buyermenu/regMenu")
	public String addBuyerMenuForm() {
		return "buyer/goods/buyermenu/regMenu";
	}

	// 개인 맞춤 식단 생성 처리
	@PostMapping("/buyermenu/regMenu")
	public String addBuyerMenu() {
		return "redirect:/buyer/goods/buyermenu/myMenuList";
	}

	// 개인 맞춤 식단 목록 조회
	@GetMapping("/buyermenu/myMenuList")
	public String getBuyerMenuList() {
		return "buyer/goods/buyermenu/myMenuList";
	}

	// 개인 맞춤 식단 수정 폼
	@GetMapping("/buyermenu/updateMyMenu/{menu_code}")
	public String modifyBuyerMenuForm(@PathVariable(value = "menu_code") String menu_code) {
		// 세션 SID와 불러오는 식단 정보의 memberId 유효성 검사 필요

		return "buyer/goods/buyermenu/updateMyMenu";
	}

	// 개인 맞춤 식단 수정 처리
	@PostMapping("/buyermenu/updateMyMenu")
	public String modifyBuyerMenu() {
		return "redirect:/buyer/goods/buyermenu/myMenuList";
	}

	// 개인 맞춤 식단 삭제 처리
	@PostMapping("/buyermenu/removeMyMenu/{menu_code}")
	public String removeBuyerMenu(@PathVariable(value = "menu_code") String menu_code) {
		return "redirect:/buyer/goods/buyermenu/myMenuList";
	}

	// 개인 맞춤 식단 개별 정보
	@GetMapping("/buyermenu/myMenuDetail/{menu_code}")
	public String getBuyerMenuInfo(@PathVariable(value = "menu_code") String menu_code) {
		
		return "buyer/goods/buyermenu/myMenuDetail";
	}

	// 판매 식단 목록 조회
	@GetMapping("/menu/menuList")
	public String getMenuList(Model model) {
		
		return "buyer/goods/menu/menuList";
	}

	// 판매 상품 목록 조회
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListUser();
		
		model.addAttribute("title", "상품 목록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "buyer/goods/goodsList";
	}

	// 개별 식단 정보
	@GetMapping("/menu/menuDetail/{menu_code}")
	public String getMenuInfo(@PathVariable(value = "menu_code") String menu_code) {
		return "buyer/goods/menu/menuDetail";
	}

	// 개별 상품 정보
	@GetMapping("/goodsDetail/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String g_code) {
		
		return "buyer/goods/goodsDetail";
	}

}
