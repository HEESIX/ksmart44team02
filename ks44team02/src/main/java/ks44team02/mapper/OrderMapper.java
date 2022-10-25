package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Cart;

@Mapper
public interface OrderMapper {

	//주문 화면 조회
	public List<Cart> order(String sessionId);
}
