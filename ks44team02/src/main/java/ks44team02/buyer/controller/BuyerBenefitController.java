package ks44team02.buyer.controller;

import org.springframework.stereotype.Controller;

import ks44team02.service.DiscountService;

@Controller
public class BuyerBenefitController {
	
	private final DiscountService discountService;
	
	public BuyerBenefitController(DiscountService discountService) {
		this.discountService = discountService;
	}
	
}
