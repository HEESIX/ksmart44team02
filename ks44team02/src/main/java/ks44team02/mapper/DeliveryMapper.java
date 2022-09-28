package ks44team02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Mapper
public interface DeliveryMapper {

	//신규 주문 및 배송 현황 조회(구매자 전체)
		//list로 해야되나?
	public String getDelivery() ;
	
	//구매자 배송처리
	public String OrderDeal();
			
	// 주문 목록 조회 list<>
	public List<Map<String, Object>> getOrderList();
	
	
	// 상세주문현황 조회
	public List<Map<String, Object>> getOrderDetailList();
	
	
	// 환불 신청
	public String addRefundRequest();
	
	// 교환 신청
	public String addExchangeRequest();
	
	//취소,환불,교환 조회 list<>
	public String getRefundExchangeList();
	

}
