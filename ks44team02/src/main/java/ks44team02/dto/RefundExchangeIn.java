package ks44team02.dto;
//환불/교환 신청 객체
public class RefundExchangeIn {
	private String refundExchangeInCode;
	private String orderDetailCode;
	private String paymentCode;
	private String refundExchangeReasonsCode;
	private String detailReason;
	private String refundExchangeSelect;
	private String requestDatetime;
	private String refundExchangeSigunupCheck;
	private String refundExchangeSigunupCheckDatetime;
	private String refundInputBankCardNumber;
	private String refundType;
	private String refundAgency;
	public String getRefundExchangeInCode() {
		return refundExchangeInCode;
	}
	public void setRefundExchangeInCode(String refundExchangeInCode) {
		this.refundExchangeInCode = refundExchangeInCode;
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
	public String getRefundExchangeReasonsCode() {
		return refundExchangeReasonsCode;
	}
	public void setRefundExchangeReasonsCode(String refundExchangeReasonsCode) {
		this.refundExchangeReasonsCode = refundExchangeReasonsCode;
	}
	public String getDetailReason() {
		return detailReason;
	}
	public void setDetailReason(String detailReason) {
		this.detailReason = detailReason;
	}
	public String getRefundExchangeSelect() {
		return refundExchangeSelect;
	}
	public void setRefundExchangeSelect(String refundExchangeSelect) {
		this.refundExchangeSelect = refundExchangeSelect;
	}
	public String getRequestDatetime() {
		return requestDatetime;
	}
	public void setRequestDatetime(String requestDatetime) {
		this.requestDatetime = requestDatetime;
	}
	public String getRefundExchangeSigunupCheck() {
		return refundExchangeSigunupCheck;
	}
	public void setRefundExchangeSigunupCheck(String refundExchangeSigunupCheck) {
		this.refundExchangeSigunupCheck = refundExchangeSigunupCheck;
	}
	public String getRefundExchangeSigunupCheckDatetime() {
		return refundExchangeSigunupCheckDatetime;
	}
	public void setRefundExchangeSigunupCheckDatetime(String refundExchangeSigunupCheckDatetime) {
		this.refundExchangeSigunupCheckDatetime = refundExchangeSigunupCheckDatetime;
	}
	public String getRefundInputBankCardNumber() {
		return refundInputBankCardNumber;
	}
	public void setRefundInputBankCardNumber(String refundInputBankCardNumber) {
		this.refundInputBankCardNumber = refundInputBankCardNumber;
	}
	public String getRefundType() {
		return refundType;
	}
	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}
	public String getRefundAgency() {
		return refundAgency;
	}
	public void setRefundAgency(String refundAgency) {
		this.refundAgency = refundAgency;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundExchangeIn [refundExchangeInCode=");
		builder.append(refundExchangeInCode);
		builder.append(", orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", refundExchangeReasonsCode=");
		builder.append(refundExchangeReasonsCode);
		builder.append(", detailReason=");
		builder.append(detailReason);
		builder.append(", refundExchangeSelect=");
		builder.append(refundExchangeSelect);
		builder.append(", requestDatetime=");
		builder.append(requestDatetime);
		builder.append(", refundExchangeSigunupCheck=");
		builder.append(refundExchangeSigunupCheck);
		builder.append(", refundExchangeSigunupCheckDatetime=");
		builder.append(refundExchangeSigunupCheckDatetime);
		builder.append(", refundInputBankCardNumber=");
		builder.append(refundInputBankCardNumber);
		builder.append(", refundType=");
		builder.append(refundType);
		builder.append(", refundAgency=");
		builder.append(refundAgency);
		builder.append("]");
		return builder.toString();
	}
	
	
}
