package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Cart;
import ks44team02.dto.Goods;

@Mapper
public interface CartMapper {

	//장바구니에 담을 상품 중복 체크 처리
	public int cartOverlapCheck(Cart cart);
	
	//장바구니에 없는 상품 담는 처리
	public boolean addCart(Cart cart);
	
	//장바구니에 있는 상품 갯수 증가 처리
	public boolean plusCartOrderAmount(Cart cart);
	
	//장바구니 목록 조회
	public List<Cart> getCartList(String sessionId);
	
	//장바구니 상품 삭제 처리
	public boolean removeCartGoods(String cartListCode);
}
