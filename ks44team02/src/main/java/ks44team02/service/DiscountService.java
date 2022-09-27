package ks44team02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks44team02.dto.OrderDiscount;
import ks44team02.mapper.DiscountMapper;

@Service
@Transactional
public class DiscountService {
	
	private static final Logger log = LoggerFactory.getLogger(DiscountService.class);

	
	private final DiscountMapper discountMapper;
	
	public DiscountService(DiscountMapper discountMapper) {
		this.discountMapper = discountMapper;
	}
	
	//주문서별 할인혜택 목록 조회
	public List<OrderDiscount> getOrderDiscountList(){
		List<OrderDiscount> orderDiscount = discountMapper.getOrderDiscountList();
		return orderDiscount;
	}
	//특정 주문서별 할인혜택 조회
	public OrderDiscount getOrderDiscountInfo(String orderDiscountCode) {
		OrderDiscount orderDiscount = discountMapper.getOrderDiscountInfo();
		return orderDiscount;
	}
	//주문서별 할인혜택 수정
	public boolean modifyOrderDiscount(OrderDiscount orderDiscount) {
		boolean result = discountMapper.modifyOrderDiscount(orderDiscount);
		return result;
	}
	//주문서별 할인혜택 등록
	public void addOrderDiscount(OrderDiscount orderDiscount) {
	}
	//주문서별 할인혜택 삭제
	public void removeOrderDiscount(OrderDiscount orderDiscount) {
		
	}

}
