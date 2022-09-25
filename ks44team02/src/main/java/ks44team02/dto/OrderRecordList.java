package ks44team02.dto;

//주문이력 객체
public class OrderRecordList {
	private String orderRecordCode;
	private String memberId;
	private String orderDetailCode;
	private String paymentCode;
	private String deliveryCode;
	private String revCode;
	private String orderGroupCode;
	private String orderRecordRegDatetime;
	private int purchaseConfirm;
	public String getOrderRecordCode() {
		return orderRecordCode;
	}
	public void setOrderRecordCode(String orderRecordCode) {
		this.orderRecordCode = orderRecordCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	public String getRevCode() {
		return revCode;
	}
	public void setRevCode(String revCode) {
		this.revCode = revCode;
	}
	public String getOrderGroupCode() {
		return orderGroupCode;
	}
	public void setOrderGroupCode(String orderGroupCode) {
		this.orderGroupCode = orderGroupCode;
	}
	public String getOrderRecordRegDatetime() {
		return orderRecordRegDatetime;
	}
	public void setOrderRecordRegDatetime(String orderRecordRegDatetime) {
		this.orderRecordRegDatetime = orderRecordRegDatetime;
	}
	public int getPurchaseConfirm() {
		return purchaseConfirm;
	}
	public void setPurchaseConfirm(int purchaseConfirm) {
		this.purchaseConfirm = purchaseConfirm;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderRecordList [orderRecordCode=");
		builder.append(orderRecordCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", revCode=");
		builder.append(revCode);
		builder.append(", orderGroupCode=");
		builder.append(orderGroupCode);
		builder.append(", orderRecordRegDatetime=");
		builder.append(orderRecordRegDatetime);
		builder.append(", purchaseConfirm=");
		builder.append(purchaseConfirm);
		builder.append("]");
		return builder.toString();
	}
	
	
}
