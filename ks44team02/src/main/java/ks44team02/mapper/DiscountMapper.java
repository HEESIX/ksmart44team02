package ks44team02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.BuyerBenefit;
import ks44team02.dto.OrderDiscount;

@Mapper
public interface DiscountMapper {

	//주문서별 할인혜택 목록조회
	public List<OrderDiscount> getOrderDiscountList(Map<String, Object>	searchMap);
	
	//특정 주문서별 할인혜택 조회
	public OrderDiscount getOrderDiscountInfo(String orderDiscountCode);
		
	//주문서별 할인혜택 수정
	public boolean modifyOrderDiscount(OrderDiscount orderDiscount);
	
	//주문서별 할인혜택 등록
	public boolean addOrderDiscount(OrderDiscount orderDiscount);
		
	//주문서별 할인혜택 삭제
	public boolean removeOrderDiscount(String orderDiscount);
	
	//전체 회원의 할인 혜택 보유 현황 조회
	public List<BuyerBenefit> getAllBuyerBenefitList(Map<String, Object>	searchMap);
	
	//구매자별 보유 혜택 목록 조회(buyer세션 아이디와 일치하는 것만?)
	public List<BuyerBenefit> getBuyerBenefitList(String sessionId);
	
	//주문서별 할인혜택 부여
	public boolean giveOrderDiscount(OrderDiscount orderDiscount);
	
}
