package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/seller/goods")
public class SellerGoodsController {
	
	private final GoodsService goodsService;
	
	public SellerGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	//상품 등록 신청 폼
	@GetMapping("/goods_reg_apply")
	public String applyGoodsRegisterForm() {
		return "seller/goods/goods_reg_apply";
	}
	
	//상품 등록 신청 처리
	@PostMapping("/goods_reg_apply")
	public String applyGoodsRegister() {
		return "redirect:/seller/goods/goods_list_apply";
	}
	
	//상품 리스트, seller 본인이 등록한 상품만 조회 가능
	@GetMapping("/goods_list_seller")
	public String getSellerGoodsList() {
		return "seller/goods/goods_list_seller";
	}
	
	//기존 데이터 조회(상품 수정 화면): 상품 수정 폼
	//common 폴더로 admin goods modify와 기능이 모두 같다면 병합해야할까?
	//그냥 service 하위에서 같이 쓰면 해결되는 문제일까?
	//요청 주소의 헷갈림 방지를 위해서 나눠놓은 지금이 나을까?
	@GetMapping("/goods_update_seller/{g_code}")
	public String getSellerGoodsInfo(@PathVariable(value = "g_code") String g_code) {
		
		return "seller/goods/goods_update_seller";
	}

	//상품 수정 처리
	@PostMapping("/goods_update_seller")
	public String modifySellerGoods() {
		return "redirect:/seller/goods/goods_list_seller";
	}
	
	//상품 삭제 처리
	@PostMapping("/goods_remove_seller/{g_code}")
	public String removeSellerGoods(@PathVariable(value = "g_code") String g_code) {
		return "redirect:/seller/goods/goods_list_seller";
	}
}
