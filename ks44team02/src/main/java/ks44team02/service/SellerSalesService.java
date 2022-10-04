package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.SellerSalesMapper;

@Service
public class SellerSalesService {
	
	private final SellerSalesMapper sellerSalesMapper;
	
	public SellerSalesService(SellerSalesMapper sellerSalesMapper) {
		this.sellerSalesMapper = sellerSalesMapper;
	}

	//판매자 매출 현황 화면
	public String getSaleList() {
		return "seller/salespage/sellerSales";
	}
	
	//판매자 매출 정산 확인 화면
	public String sellerSalesSuccess() {
		return "seller/salespage/sellerSalesCalculate";	
	}
}

