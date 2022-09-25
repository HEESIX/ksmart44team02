package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.RefundExchangeReasons;

@Mapper
public interface AdminDeliveryMapper {
	
	//환불 사유 카테고리 등록
	public String addRefundExchangeReason();

	//환불 사유 카테고리 수정
	public String modifyRefundExchangeReason();
			
	//환불 사유 카테고리 리스트
	public List<RefundExchangeReasons> getRefundExchangeReasonList();
			
	//구매자 배송현황 조회
	public String getAdminOrderStatusList();


}
