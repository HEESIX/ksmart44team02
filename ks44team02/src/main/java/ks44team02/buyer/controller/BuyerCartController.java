package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.CartService;

@Controller
@RequestMapping(value = "/buyer/mypage/cart")
public class BuyerCartController {

	
	private static final Logger log = LoggerFactory.getLogger(BuyerCartController.class);

	private final CartService cartService;
	
	public BuyerCartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostConstruct
	public void buyerCartController() {
		log.info("BuyerCartController bean 생성");
	}
	
	//장바구니에 담긴 상품 목록 조회
	@GetMapping("/cartList")
	public String getCartList() {
		return "buyer/mypage/cart/cartList";
	}
	//장바구니에 담긴 상품 선택 삭제
	@PostMapping("/cartList")
	public String removeCartGoods() {
		return "buyer/mypage/cart/cartList";
	}
	//장바구니에 담긴 상품 주문화면으로 선택 이동
	@PostMapping("/cartMove")
	public String moveCartGoods() {
		return "buyer/order/order";
	}
}
