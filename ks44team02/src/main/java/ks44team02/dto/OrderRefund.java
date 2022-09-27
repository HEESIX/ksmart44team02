package ks44team02.dto;
//환불내역 객체
public class OrderRefund {
	private String orderRefundCode;
	private String refundExchangeInCode;
	private int orderRefundApprove;
	private String orderRefundApproveDatetime;
	public String getOrderRefundCode() {
		return orderRefundCode;
	}
	public void setOrderRefundCode(String orderRefundCode) {
		this.orderRefundCode = orderRefundCode;
	}
	public String getRefundExchangeInCode() {
		return refundExchangeInCode;
	}
	public void setRefundExchangeInCode(String refundExchangeInCode) {
		this.refundExchangeInCode = refundExchangeInCode;
	}
	public int getOrderRefundApprove() {
		return orderRefundApprove;
	}
	public void setOrderRefundApprove(int orderRefundApprove) {
		this.orderRefundApprove = orderRefundApprove;
	}
	public String getOrderRefundApproveDatetime() {
		return orderRefundApproveDatetime;
	}
	public void setOrderRefundApproveDatetime(String orderRefundApproveDatetime) {
		this.orderRefundApproveDatetime = orderRefundApproveDatetime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderRefund [orderRefundCode=");
		builder.append(orderRefundCode);
		builder.append(", refundExchangeInCode=");
		builder.append(refundExchangeInCode);
		builder.append(", orderRefundApprove=");
		builder.append(orderRefundApprove);
		builder.append(", orderRefundApproveDatetime=");
		builder.append(orderRefundApproveDatetime);
		builder.append("]");
		return builder.toString();
	}
	
}
