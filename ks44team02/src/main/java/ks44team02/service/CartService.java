package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.CartMapper;

@Service
public class CartService {

	private final CartMapper cartMapper;
	
	public CartService(CartMapper cartmapper) {
		this.cartMapper = cartmapper;
	}
}
