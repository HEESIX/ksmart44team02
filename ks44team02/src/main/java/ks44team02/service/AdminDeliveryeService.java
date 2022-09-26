package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.AdminDeliveryMapper;

@Service
public class AdminDeliveryeService {
	
	private final AdminDeliveryMapper adminDeliveryMapper;
		public AdminDeliveryeService(AdminDeliveryMapper adminDeliveryMapper) {
			this.adminDeliveryMapper = adminDeliveryMapper;
		}
		
	//환불 사유 카테고리 등록
		public String addRefundExchangeReason() {
			return null;
		}

	//환불 사유 카테고리 수정
		public String modifyRefundExchangeReason() {
			return null;
		}
		
	//환불 사유 카테고리 리스트
	//dto만들어서 List<>로 수정필요
		public String getRefundExchangeReasonList() {
			return null;
		}
		
	//구매자 배송현황 조회
		public String getAdminOrderStatusList() {
			return null;
		}
}
