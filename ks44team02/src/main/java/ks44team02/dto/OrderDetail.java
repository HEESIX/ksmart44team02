package ks44team02.dto;

public class OrderDetail {
	private String orderDetailCode;
	private String memberId;
	private String goodsCode;
	private int discountPrice;
	private int orderAmount;
	private int regularPriceSubtotal;
	private String orderDateTime;
	private String orderGroupCode;
	private String enterCode;
	private int gDeliveryCharge;
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getRegularPriceSubtotal() {
		return regularPriceSubtotal;
	}
	public void setRegularPriceSubtotal(int regularPriceSubtotal) {
		this.regularPriceSubtotal = regularPriceSubtotal;
	}
	public String getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public String getOrderGroupCode() {
		return orderGroupCode;
	}
	public void setOrderGroupCode(String orderGroupCode) {
		this.orderGroupCode = orderGroupCode;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public int getgDeliveryCharge() {
		return gDeliveryCharge;
	}
	public void setgDeliveryCharge(int gDeliveryCharge) {
		this.gDeliveryCharge = gDeliveryCharge;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetail [orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append(", orderAmount=");
		builder.append(orderAmount);
		builder.append(", regularPriceSubtotal=");
		builder.append(regularPriceSubtotal);
		builder.append(", orderDateTime=");
		builder.append(orderDateTime);
		builder.append(", orderGroupCode=");
		builder.append(orderGroupCode);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", gDeliveryCharge=");
		builder.append(gDeliveryCharge);
		builder.append("]");
		return builder.toString();
	}
	
}
