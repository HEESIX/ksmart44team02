package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.OrderDiscount;

@Mapper
public interface DiscountMapper {

	//주문서별 할인혜택 목록조회
	public List<OrderDiscount> getOrderDiscountList();
	
	//특정 주문서별 할인혜택 조회
	public OrderDiscount getOrderDiscountInfo();
		
	//주문서별 할인혜택 수정
	public boolean modifyOrderDiscount(OrderDiscount orderDiscount);
	
	//주문서별 할인혜택 등록
	public void addOrderDiscount(OrderDiscount orderDiscount);
		
	//주문서별 할인혜택 삭제
	public void removeOrderDiscount(OrderDiscount orderDiscount);
}
