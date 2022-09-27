package ks44team02.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import ks44team02.dto.RefundExchangeIn;
import ks44team02.mapper.RefundExchangeMapper;

@Service
public class RefundExchangeService {

	private final RefundExchangeMapper refundExchangeMapper;
	
	public RefundExchangeService(RefundExchangeMapper refundExchangeMapper) {
		this.refundExchangeMapper = refundExchangeMapper;
	}

	//환불,교환 리스트
	public List<RefundExchangeIn> getRefundExchangeList(){
		List<RefundExchangeIn> refundexchangelist = refundExchangeMapper.getRefundExchangeList();
		return refundexchangelist;
		
	}
	
	//환불 처리
	public String addRefundDeal() {
		return null;
	}


}
