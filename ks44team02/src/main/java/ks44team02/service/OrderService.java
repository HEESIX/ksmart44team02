package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Cart;
import ks44team02.mapper.OrderMapper;

@Service
public class OrderService {

	private final OrderMapper orderMapper;
	
	public OrderService(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	//주문 화면 조회
	public List<Cart> order(String sessionId){
		List<Cart> orderList = orderMapper.order(sessionId);
		return orderList;
	}
}
