package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Cart;
import ks44team02.dto.Goods;

@Mapper
public interface CartMapper {

	//장바구니에 상품 담는 처리
	public boolean addCart(Cart cart);
	
	//장바구니 목록 조회
	public List<Cart> getCartList(String sessionId);
	
	//장바구니 상품 삭제 처리
	public boolean removeCartGoods(String cartListCode);
}
