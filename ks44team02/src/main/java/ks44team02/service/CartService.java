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
	//장바구니에 상품 담는 처리
	public boolean addCart(Cart cart) {
		//1단계 동일 상품있는지 count
		int count = cartMapper.cartOverlapCheck(cart);
		boolean result = false;
		
		if(count > 0) {
			// 동일 상품이 있으면 업데이트
			result = cartMapper.plusCartOrderAmount(cart);
		}else {			
			// 동일 상품이 없으면 인서트
			result = cartMapper.addCart(cart);
		}
		return result;
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
