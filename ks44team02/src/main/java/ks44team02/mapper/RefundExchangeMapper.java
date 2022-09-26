package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.RefundExchangeIn;

@Mapper
public interface RefundExchangeMapper {

	//환불,교환 리스트
	public List<RefundExchangeIn> getRefundExchangeList();
	
	//환불 처리
	public String addRefundDeal();
	
	
}
