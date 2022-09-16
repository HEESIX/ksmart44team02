package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/seller/goods")
public class SellerGoodsController {
	
	private final GoodsService goodsService;
	
	public SellerGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	//상품 등록 신청
	@GetMapping("/goods_reg_apply")
	public String applyGoodsRegister() {
		return "seller/goods/goods_reg_apply";
	}
	
	//상품 리스트
	@GetMapping("/goods_list_seller")
	public String getSellerGoodsList() {
		return "seller/goods/goods_list_seller";
	}
	
	//기존 데이터 조회(상품 수정 화면)
	public String getSellerGoodsInfo() {
		return null;
	}

	//상품 수정
	public String modifySellerGoods() {
		return null;
	}
	
	//상품 삭제
	public String removeSellerGoods() {
		return null;
	}
}
