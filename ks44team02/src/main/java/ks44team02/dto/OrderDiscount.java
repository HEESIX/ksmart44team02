package ks44team02.dto;

import java.util.List;

//주문서별 할인혜택
public class OrderDiscount {
	private String orderDiscountCode;
	private int discountRate;
	private int discountPrice;
	private String discountName;
	private int minOrderPrice;
	private int maxDiscountPrice;
	private String gProductionRegDateTime;
	
	private List<BuyerBenefit>	buyerBenefitList;
	
	public List<BuyerBenefit> getBuyerBenefitList() {
		return buyerBenefitList;
	}
	public void setBuyerBenefit(List<BuyerBenefit> buyerBenefitList) {
		this.buyerBenefitList = buyerBenefitList;
	}
	public String getOrderDiscountCode() {
		return orderDiscountCode;
	}
	public void setOrderDiscountCode(String orderDiscountCode) {
		this.orderDiscountCode = orderDiscountCode;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getDiscountName() {
		return discountName;
	}
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	public int getMinOrderPrice() {
		return minOrderPrice;
	}
	public void setMinOrderPrice(int minOrderPrice) {
		this.minOrderPrice = minOrderPrice;
	}
	public int getMaxDiscountPrice() {
		return maxDiscountPrice;
	}
	public void setMaxDiscountPrice(int maxDiscountPrice) {
		this.maxDiscountPrice = maxDiscountPrice;
	}
	public String getgProductionRegDateTime() {
		return gProductionRegDateTime;
	}
	public void setgProductionRegDateTime(String gProductionRegDateTime) {
		this.gProductionRegDateTime = gProductionRegDateTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDiscount [orderDiscountCode=");
		builder.append(orderDiscountCode);
		builder.append(", discountRate=");
		builder.append(discountRate);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append(", discountName=");
		builder.append(discountName);
		builder.append(", minOrderPrice=");
		builder.append(minOrderPrice);
		builder.append(", maxDiscountPrice=");
		builder.append(maxDiscountPrice);
		builder.append(", gProductionRegDateTime=");
		builder.append(gProductionRegDateTime);
		builder.append(", buyerBenefitList=");
		builder.append(buyerBenefitList);
		builder.append("]");
		return builder.toString();
	}
}