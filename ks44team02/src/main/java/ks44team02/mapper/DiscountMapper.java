package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.BuyerBenefit;
import ks44team02.dto.OrderDiscount;

@Mapper
public interface DiscountMapper {

	//주문서별 할인혜택 목록조회
	public List<OrderDiscount> getOrderDiscountList();
	
	//특정 주문서별 할인혜택 조회
	public OrderDiscount getOrderDiscountInfo(String orderDiscountCode);
		
	//주문서별 할인혜택 수정
	public boolean modifyOrderDiscount(OrderDiscount orderDiscount);
	
	//주문서별 할인혜택 등록
	public boolean addOrderDiscount(OrderDiscount orderDiscount);
		
	//주문서별 할인혜택 삭제
	public boolean removeOrderDiscount(String orderDiscount);
	
	//회원별 보유 혜택 목록 조회(buyer세션 아이디와 일치하는 것만?)
	public List<BuyerBenefit> getBuyerBenefitList(String memberId);
	
}
