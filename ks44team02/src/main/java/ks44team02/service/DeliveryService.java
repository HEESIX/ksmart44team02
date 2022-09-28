package ks44team02.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ks44team02.dto.OrderRecordList;
import ks44team02.dto.OrderRefund;
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
			
	// 주문 리스트 list<>
	public List<Map<String, Object>> getOrderList() {
		List<Map<String, Object>> getOrderList = deliveryMapper.getOrderList();
		return getOrderList;
	}
	
	// 상세주문현황
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

