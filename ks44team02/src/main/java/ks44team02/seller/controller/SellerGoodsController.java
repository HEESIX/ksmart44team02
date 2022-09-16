package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;

import ks44team02.service.GoodsService;

@Controller
public class SellerGoodsController {
	
	private final GoodsService goodsService;
	
	public SellerGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	//상품 등록 신청
	public String applyGoodsRegister() {
		return null;
	}
	
	//상품 리스트
	public String getSellerGoodsList() {
		return null;
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
