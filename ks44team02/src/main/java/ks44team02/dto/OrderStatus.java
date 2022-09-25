package ks44team02.dto;

//상품주문현황
public class OrderStatus {

	private String orderStatusCode;
	private String memberId;
	private String goodsCode;
	private String orderStatusStandardCode;
	private String orderStatusUpdateDatetime;
	public String getOrderStatusCode() {
		return orderStatusCode;
	}
	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
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
	public String getOrderStatusStandardCode() {
		return orderStatusStandardCode;
	}
	public void setOrderStatusStandardCode(String orderStatusStandardCode) {
		this.orderStatusStandardCode = orderStatusStandardCode;
	}
	public String getOrderStatusUpdateDatetime() {
		return orderStatusUpdateDatetime;
	}
	public void setOrderStatusUpdateDatetime(String orderStatusUpdateDatetime) {
		this.orderStatusUpdateDatetime = orderStatusUpdateDatetime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderStatus [orderStatusCode=");
		builder.append(orderStatusCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", orderStatusStandardCode=");
		builder.append(orderStatusStandardCode);
		builder.append(", orderStatusUpdateDatetime=");
		builder.append(orderStatusUpdateDatetime);
		builder.append("]");
		return builder.toString();
	}
	
}
