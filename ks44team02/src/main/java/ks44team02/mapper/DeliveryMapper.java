package ks44team02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ks44team02.dto.Delivery;
import ks44team02.dto.OrderDetail;
import ks44team02.dto.OrderStatus;
import ks44team02.dto.OrderStatusStandard;

@Mapper
public interface DeliveryMapper {

	//판매자 측 신규 주문 및 배송 현황 조회(구매자 전체)
	public List<OrderDetail> sellerOrderList(Map<String, Object> searchMap) ;
	
	//판매자 측 주문서 주문상태 변경(수정)
	public boolean modifyOrderStatus(OrderDetail sellerOrderList);
	
	//판매자 측 특정 주문서 조회
	public OrderDetail getOrderStatusInfo(String orderDetailCode);
	
	//추가1 상품현황
	public OrderStatus getOrderStatus(String orderDetailCode);
	
	//추가2 상품현황정의
	public List<OrderStatusStandard> getOrderStatusStandard();
	
	//판매자측 운송장 번호 등록
	public boolean addDeliNumber(Delivery delivery);
	
	
	//구매자 배송처리
	public String OrderDeal();
			
	// 주문 목록 조회 list<>
	public List<Map<String, Object>> getOrderList(String memberId);
	
	// 상세주문현황 조회
	public List<Map<String, Object>> getOrderDetailList(String orderGroupCode);
	
	//추가(결제정보조회)
	public Map<String, Object> getPaymentList(String orderGroupCode);
	
	//추가(배송정보조회)
	public Map<String, Object> getDeliveryinfo(String orderGroupCode);
	
	
	// 환불 신청
	public String addRefundRequest();
	
	// 교환 신청
	public String addExchangeRequest();
	
	//취소,환불,교환 조회 list<>
	public String getRefundExchangeList();
	

}
