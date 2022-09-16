package ks44team02.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/buyer/goods")
public class BuyerGoodsController {
	
	private final GoodsService goodsService;
	
	public BuyerGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	//개인 맞춤 식단 생성
	public String addBuyerMenu() {
		return null;
	}
	
	//개인 맞춤 식단 목록 조회
	public String getBuyerMenuList() {
		return null;
	}
	
	//개인 맞춤 식단 수정
	public String modifyBuyerMenu() {
		return null;
	}
	
	//개인 맞춤 식단 삭제
	public String removeBuyerMenu() {
		return null;
	}
	
	//개인 맞춤 식단 정보
	public String getBuyerMenuInfo() {
		return null;
	}
	
	//판매 식단 목록 조회
	@GetMapping("/menu/menu_list")
	public String getMenuList() {
		return "buyer/goods/menu/menu_list";
	}
	
	//판매 상품 목록 조회
	@GetMapping("/goods_list_buyer")
	public String getGoodsList() {
		return "buyer/goods/goods_list_buyer";
	}
	
	//개별 식단 정보
	public String getMenuInfo() {
		return null;
	}
	
	//개별 상품 정보
	public String getGoodsInfo() {
		return null;
	}

}
