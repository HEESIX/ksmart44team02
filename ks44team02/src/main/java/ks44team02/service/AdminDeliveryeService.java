package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.RefundExchangeReasons;
import ks44team02.mapper.AdminDeliveryMapper;

@Service
public class AdminDeliveryeService {
	
	private final AdminDeliveryMapper adminDeliveryMapper;
		public AdminDeliveryeService(AdminDeliveryMapper adminDeliveryMapper) {
			this.adminDeliveryMapper = adminDeliveryMapper;
		}
		
	//환불 사유 카테고리 등록
		public boolean addRefundExchangeReason(RefundExchangeReasons refundExchangeReasonList) {
			boolean result = adminDeliveryMapper.addRefundExchangeReason(refundExchangeReasonList);
			return result;
		}

	//환불 사유 카테고리 수정처리
		public boolean modifyRefundExchangeReason(RefundExchangeReasons refundExchangeReasonList) {
			boolean result = adminDeliveryMapper.modifyRefundExchangeReason(refundExchangeReasonList);
			return result;
		}
		
	//특정 환불사유 조회
		public RefundExchangeReasons getRefundExchangeReasonsInfo(String refundExchangeReasonsCode) {
			
			RefundExchangeReasons refundExchangeReasonsInfo = adminDeliveryMapper.getRefundExchangeReasonsInfo(refundExchangeReasonsCode);
			
			return refundExchangeReasonsInfo;
		}
		
		
	//환불 사유 카테고리 리스트
		public List<RefundExchangeReasons> getRefundExchangeReasonList() {
			
			List<RefundExchangeReasons> refundExchangeReasonList = adminDeliveryMapper.getRefundExchangeReasonList();
			
			return refundExchangeReasonList;
		}
		
	//환불 사유 카테고리 삭제
		public boolean removeRefundExchangeReason(String refundExchangeReasonsCode) {
			boolean resultRemove = adminDeliveryMapper.removeRefundExchangeReason(refundExchangeReasonsCode);
			return resultRemove;
			
		}
		
		
		
	//구매자 배송현황 조회
		public String getAdminOrderStatusList() {
			return null;
		}
}
