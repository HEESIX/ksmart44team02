package ks44team02.dto;

//상품주문현황정의
public class OrderStatus {

	private String orderStatusCode;
	private String memberId;
	private String orderStatusStandardCode;
	private String orderDetailCode;
	private String enterCode;
	private String goodsCode;
	private String orderStatusUpdateDatetime;
	
	private OrderStatusStandard orderStatusStandard;

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

	public String getOrderStatusStandardCode() {
		return orderStatusStandardCode;
	}

	public void setOrderStatusStandardCode(String orderStatusStandardCode) {
		this.orderStatusStandardCode = orderStatusStandardCode;
	}

	public String getOrderDetailCode() {
		return orderDetailCode;
	}

	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}

	public String getEnterCode() {
		return enterCode;
	}

	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getOrderStatusUpdateDatetime() {
		return orderStatusUpdateDatetime;
	}

	public void setOrderStatusUpdateDatetime(String orderStatusUpdateDatetime) {
		this.orderStatusUpdateDatetime = orderStatusUpdateDatetime;
	}

	public OrderStatusStandard getOrderStatusStandard() {
		return orderStatusStandard;
	}

	public void setOrderStatusStandard(OrderStatusStandard orderStatusStandard) {
		this.orderStatusStandard = orderStatusStandard;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderStatus [orderStatusCode=");
		builder.append(orderStatusCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", orderStatusStandardCode=");
		builder.append(orderStatusStandardCode);
		builder.append(", orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", orderStatusUpdateDatetime=");
		builder.append(orderStatusUpdateDatetime);
		builder.append(", orderStatusStandard=");
		builder.append(orderStatusStandard);
		builder.append("]");
		return builder.toString();
	}
	
	
}
