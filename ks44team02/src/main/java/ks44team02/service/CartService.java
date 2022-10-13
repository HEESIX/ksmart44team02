package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Cart;
import ks44team02.mapper.CartMapper;

@Service
public class CartService {

	private final CartMapper cartMapper;
	
	public CartService(CartMapper cartmapper) {
		this.cartMapper = cartmapper;
	}
	
	//장바구니 목록 조회
	public List<Cart> getCartList(String sessionId){
		
		List<Cart> cartList = cartMapper.getCartList(sessionId);
		
		return cartList;
	}
	//장바구니 특정 상품 삭제 처리
	public boolean removeCartGoods(String cartListCode) {
		boolean result = cartMapper.removeCartGoods(cartListCode);
		return result;
	}

}
