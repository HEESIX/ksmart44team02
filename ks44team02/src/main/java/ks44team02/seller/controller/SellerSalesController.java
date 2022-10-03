package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.SellerCompanyService;
import ks44team02.service.SellerSalesService;

@Controller
@RequestMapping(value = "/seller/salespage")
public class SellerSalesController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerSalesController.class);
	
	private final SellerSalesService sellerSalesService;
	
	public SellerSalesController(SellerSalesService sellerSalesService) {
		this.sellerSalesService = sellerSalesService;
	}
	
	//판매자 매출 현황 화면
	@GetMapping("/sellerSales")
	public String getSaleList() {
		return "seller/salespage/sellerSales";
	}
	
	//판매자 매출 정산 확인 화면
	@GetMapping("/sellerSalesCalculate")
	public String sellerSalesSuccess() {
		return "seller/salespage/sellerSalesCalculate";	
	}
}