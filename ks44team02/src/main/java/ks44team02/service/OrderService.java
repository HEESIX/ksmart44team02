package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.OrderMapper;

@Service
public class OrderService {

	private final OrderMapper orderMapper;
	
	public OrderService(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
}
