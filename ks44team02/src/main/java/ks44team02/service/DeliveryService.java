package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.DeliveryMapper;

@Service
public class DeliveryService {
	
	private final DeliveryMapper deliveryMapper;
	
	public DeliveryService(DeliveryMapper deliveryMapper) {
		this.deliveryMapper = deliveryMapper;
	}
	
	//신규 주문 및 배송 현황 조회(구매자 전체)
	//list로 해야되나?
	public String getDelivery() {
		return null;
	}
	
	//구매자 배송처리
	public String OrderDeal() {
		return null;
	}
			
	// 주문 목록 조회 list<>
	public String getOrderList() {
		return null;
	}
	
	// 상세주문현황 조회
	public String getOrderStatus() {
		return null;
	}
	
	// 환불 신청
	public String addRefundRequest() {
		return null;
	}
	
	// 교환 신청
	public String addExchangeRequest() {
		return null;
	}
	
	//취소,환불,교환 조회 list<>
	public String getRefundExchangeList() {
		return null;
	}
	
}

