package ks44team02.dto;

//교환내역
public class OrderExchange {
	private String orderExchangeCode;
	private String refundExchangeInCode;
	private int orderExchangeApproveCheck;
	private String exchangeDeliveryEnter;
	private String exchangeDeliveryNum;
	public String getOrderExchangeCode() {
		return orderExchangeCode;
	}
	public void setOrderExchangeCode(String orderExchangeCode) {
		this.orderExchangeCode = orderExchangeCode;
	}
	public String getRefundExchangeInCode() {
		return refundExchangeInCode;
	}
	public void setRefundExchangeInCode(String refundExchangeInCode) {
		this.refundExchangeInCode = refundExchangeInCode;
	}
	public int getOrderExchangeApproveCheck() {
		return orderExchangeApproveCheck;
	}
	public void setOrderExchangeApproveCheck(int orderExchangeApproveCheck) {
		this.orderExchangeApproveCheck = orderExchangeApproveCheck;
	}
	public String getExchangeDeliveryEnter() {
		return exchangeDeliveryEnter;
	}
	public void setExchangeDeliveryEnter(String exchangeDeliveryEnter) {
		this.exchangeDeliveryEnter = exchangeDeliveryEnter;
	}
	public String getExchangeDeliveryNum() {
		return exchangeDeliveryNum;
	}
	public void setExchangeDeliveryNum(String exchangeDeliveryNum) {
		this.exchangeDeliveryNum = exchangeDeliveryNum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderExchange [orderExchangeCode=");
		builder.append(orderExchangeCode);
		builder.append(", refundExchangeInCode=");
		builder.append(refundExchangeInCode);
		builder.append(", orderExchangeApproveCheck=");
		builder.append(orderExchangeApproveCheck);
		builder.append(", exchangeDeliveryEnter=");
		builder.append(exchangeDeliveryEnter);
		builder.append(", exchangeDeliveryNum=");
		builder.append(exchangeDeliveryNum);
		builder.append("]");
		return builder.toString();
	}
	
}
