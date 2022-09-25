package ks44team02.dto;

//상품 주문 현황 정의
public class OrderStatusStandard {
	private String orderStatusStandardCode;
	private String orderStatusStandardDetails;
	private String memberId;
	private String orderStatusStandardRegDatetime;
	public String getOrderStatusStandardCode() {
		return orderStatusStandardCode;
	}
	public void setOrderStatusStandardCode(String orderStatusStandardCode) {
		this.orderStatusStandardCode = orderStatusStandardCode;
	}
	public String getOrderStatusStandardDetails() {
		return orderStatusStandardDetails;
	}
	public void setOrderStatusStandardDetails(String orderStatusStandardDetails) {
		this.orderStatusStandardDetails = orderStatusStandardDetails;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderStatusStandardRegDatetime() {
		return orderStatusStandardRegDatetime;
	}
	public void setOrderStatusStandardRegDatetime(String orderStatusStandardRegDatetime) {
		this.orderStatusStandardRegDatetime = orderStatusStandardRegDatetime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderStatusStandard [orderStatusStandardCode=");
		builder.append(orderStatusStandardCode);
		builder.append(", orderStatusStandardDetails=");
		builder.append(orderStatusStandardDetails);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", orderStatusStandardRegDatetime=");
		builder.append(orderStatusStandardRegDatetime);
		builder.append("]");
		return builder.toString();
	}
	
}
