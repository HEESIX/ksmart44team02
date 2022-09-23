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
	@GetMapping("/buyermenu/menu_reg_buyer")
	public String addBuyerMenuForm() {
		return "buyer/goods/buyermenu/menu_reg_buyer";
	}

	// 개인 맞춤 식단 생성 처리
	@PostMapping("/buyermenu/menu_reg_buyer")
	public String addBuyerMenu() {
		return "redirect:/buyer/goods/buyermenu/buyer_menu_list";
	}

	// 개인 맞춤 식단 목록 조회
	@GetMapping("/buyermenu/buyer_menu_list")
	public String getBuyerMenuList() {
		return "buyer/goods/buyermenu/buyer_menu_list";
	}

	// 개인 맞춤 식단 수정 폼
	@GetMapping("/buyermenu/update_buyer_menu/{menu_code}")
	public String modifyBuyerMenuForm(@PathVariable(value = "menu_code") String menu_code) {
		// 세션 SID와 불러오는 식단 정보의 memberId 유효성 검사 필요

		return "buyer/goods/buyermenu/update_buyer_menu";
	}

	// 개인 맞춤 식단 수정 처리
	@PostMapping("/buyermenu/update_buyer_menu")
	public String modifyBuyerMenu() {
		return "redirect:/buyer/goods/buyermenu/buyer_menu_list";
	}

	// 개인 맞춤 식단 삭제 처리
	@PostMapping("/buyermenu/remove_buyer_menu/{menu_code}")
	public String removeBuyerMenu(@PathVariable(value = "menu_code") String menu_code) {
		return "redirect:/buyer/goods/buyermenu/buyer_menu_list";
	}

	// 개인 맞춤 식단 개별 정보
	@GetMapping("/buyermenu/buyer_menu_detail/{menu_code}")
	public String getBuyerMenuInfo(@PathVariable(value = "menu_code") String menu_code) {
		
		return "buyer/goods/buyermenu/buyer_menu_detail";
	}

	// 판매 식단 목록 조회
	@GetMapping("/menu/menu_list")
	public String getMenuList(Model model) {
		
		return "buyer/goods/menu/menu_list";
	}

	// 판매 상품 목록 조회
	@GetMapping("/goods_list_buyer")
	public String getGoodsList(Model model) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListBuyer();
		
		model.addAttribute("title", "상품 목록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "buyer/goods/goods_list_buyer";
	}

	// 개별 식단 정보
	@GetMapping("/menu/menu_detail/{menu_code}")
	public String getMenuInfo(@PathVariable(value = "menu_code") String menu_code) {
		return "buyer/goods/menu/menu_detail";
	}

	// 개별 상품 정보
	@GetMapping("/goods_detail/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String g_code) {
		
		return "buyer/goods/goods_detail";
	}

}
