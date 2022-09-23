package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Discount;
import ks44team02.mapper.DiscountMapper;

@Service
public class DiscountService {
	
	private final DiscountMapper discountMapper;
	
	public DiscountService(DiscountMapper discountMapper) {
		this.discountMapper = discountMapper;
	}
	
	//주문서별 할인혜택 목록 조회
	public List<Discount> getOrderDiscountList(){
		return null;
	}
	
	//주문서별 할인혜택 등록
	
	
	

}
