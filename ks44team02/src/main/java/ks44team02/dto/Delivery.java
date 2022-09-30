package ks44team02.dto;

//배송관리(주문 세부내역) 객체
public class Delivery {
	private String deliveryCode;
	private String orderDetailCode;
	private String orderExchangeCode;
	private String paymentCode;
	private String deliveryType;
	private String deliveryGetName;
	private String deliveryGetAddress;
	private String deliveryGetPhone;
	private String deliveryOrderDatetime;
	private String deliveryMemo;
	private String deliveryReleaseDatetime;
	private String enterCode;
	private String orderStatusStandardCode;
	private String deliveryCompleteDatetime;
	private String deliveryEnter;
	private String deliveryNum;
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	public String getOrderExchangeCode() {
		return orderExchangeCode;
	}
	public void setOrderExchangeCode(String orderExchangeCode) {
		this.orderExchangeCode = orderExchangeCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDeliveryGetName() {
		return deliveryGetName;
	}
	public void setDeliveryGetName(String deliveryGetName) {
		this.deliveryGetName = deliveryGetName;
	}
	public String getDeliveryGetAddress() {
		return deliveryGetAddress;
	}
	public void setDeliveryGetAddress(String deliveryGetAddress) {
		this.deliveryGetAddress = deliveryGetAddress;
	}
	public String getDeliveryGetPhone() {
		return deliveryGetPhone;
	}
	public void setDeliveryGetPhone(String deliveryGetPhone) {
		this.deliveryGetPhone = deliveryGetPhone;
	}
	public String getDeliveryOrderDatetime() {
		return deliveryOrderDatetime;
	}
	public void setDeliveryOrderDatetime(String deliveryOrderDatetime) {
		this.deliveryOrderDatetime = deliveryOrderDatetime;
	}
	public String getDeliveryMemo() {
		return deliveryMemo;
	}
	public void setDeliveryMemo(String deliveryMemo) {
		this.deliveryMemo = deliveryMemo;
	}
	public String getDeliveryReleaseDatetime() {
		return deliveryReleaseDatetime;
	}
	public void setDeliveryReleaseDatetime(String deliveryReleaseDatetime) {
		this.deliveryReleaseDatetime = deliveryReleaseDatetime;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public String getOrderStatusStandardCode() {
		return orderStatusStandardCode;
	}
	public void setOrderStatusStandardCode(String orderStatusStandardCode) {
		this.orderStatusStandardCode = orderStatusStandardCode;
	}
	public String getDeliveryCompleteDatetime() {
		return deliveryCompleteDatetime;
	}
	public void setDeliveryCompleteDatetime(String deliveryCompleteDatetime) {
		this.deliveryCompleteDatetime = deliveryCompleteDatetime;
	}
	public String getDeliveryEnter() {
		return deliveryEnter;
	}
	public void setDeliveryEnter(String deliveryEnter) {
		this.deliveryEnter = deliveryEnter;
	}
	public String getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Delivery [deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", orderExchangeCode=");
		builder.append(orderExchangeCode);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", deliveryType=");
		builder.append(deliveryType);
		builder.append(", deliveryGetName=");
		builder.append(deliveryGetName);
		builder.append(", deliveryGetAddress=");
		builder.append(deliveryGetAddress);
		builder.append(", deliveryGetPhone=");
		builder.append(deliveryGetPhone);
		builder.append(", deliveryOrderDatetime=");
		builder.append(deliveryOrderDatetime);
		builder.append(", deliveryMemo=");
		builder.append(deliveryMemo);
		builder.append(", deliveryReleaseDatetime=");
		builder.append(deliveryReleaseDatetime);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", orderStatusStandardCode=");
		builder.append(orderStatusStandardCode);
		builder.append(", deliveryCompleteDatetime=");
		builder.append(deliveryCompleteDatetime);
		builder.append(", deliveryEnter=");
		builder.append(deliveryEnter);
		builder.append(", deliveryNum=");
		builder.append(deliveryNum);
		builder.append("]");
		return builder.toString();
	}

}
