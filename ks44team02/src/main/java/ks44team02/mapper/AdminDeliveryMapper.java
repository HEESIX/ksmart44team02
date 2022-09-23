package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDeliveryMapper {
	
	//환불 사유 카테고리 등록
		public String addRefundExchangeReason();

	//환불 사유 카테고리 수정
		public String modifyRefundExchangeReason();
			
	//환불 사유 카테고리 리스트
	//dto만들어서 List<>로 수정필요
		public String getRefundExchangeReasonList();
			
	//구매자 배송현황 조회
		public String getAdminOrderStatusList();


}
