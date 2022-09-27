package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerSalesMapper {

	//판매자 매출 현황 화면
	public String getSaleList();
	
	//판매자 매출 정산 확인 화면
	public String sellerSalesSuccess();
}