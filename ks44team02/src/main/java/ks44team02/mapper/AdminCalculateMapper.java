package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminCalculateMapper {
	
	//판매자 일일 정산금 확인
	public String sellerTodayCalculate();
			
	//관리자 수수료 확인
	public String adminFeeCheck();
			
	//관리자 수수료 정산
	public String adminFeeCalculate();
			
	//판매자 정산금 정산
	public String sellerCalculateSuccess();

}
