package ks44team02.dto;
//주문서별 할인혜택
public class OrderDiscount {
	private String orderDiscountCode;
	private int discountRate;
	private int discountPrice;
	private String discountName;
	private String discountExpirationDate;
	private int minOrderPrice;
	private int maxDiscountPrice;
	private int gProductionRegDateTime;
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
	public String getDiscountExpirationDate() {
		return discountExpirationDate;
	}
	public void setDiscountExpirationDate(String discountExpirationDate) {
		this.discountExpirationDate = discountExpirationDate;
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
	public int getgProductionRegDateTime() {
		return gProductionRegDateTime;
	}
	public void setgProductionRegDateTime(int gProductionRegDateTime) {
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
		builder.append(", discountExpirationDate=");
		builder.append(discountExpirationDate);
		builder.append(", minOrderPrice=");
		builder.append(minOrderPrice);
		builder.append(", maxDiscountPrice=");
		builder.append(maxDiscountPrice);
		builder.append(", gProductionRegDateTime=");
		builder.append(gProductionRegDateTime);
		builder.append("]");
		return builder.toString();
	}
}