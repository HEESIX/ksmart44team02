package ks44team02.dto;

public class Payment {
	private String paymentCode;
	private String orderCode;
	private String paymentInputBankCardNumber;
	private String paymentAgency;
	private int paymentCash;
	private int paymentCashSum;
	private String paymentDate;
	private String paymentPayerName;
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPaymentInputBankCardNumber() {
		return paymentInputBankCardNumber;
	}
	public void setPaymentInputBankCardNumber(String paymentInputBankCardNumber) {
		this.paymentInputBankCardNumber = paymentInputBankCardNumber;
	}
	public String getPaymentAgency() {
		return paymentAgency;
	}
	public void setPaymentAgency(String paymentAgency) {
		this.paymentAgency = paymentAgency;
	}
	public int getPaymentCash() {
		return paymentCash;
	}
	public void setPaymentCash(int paymentCash) {
		this.paymentCash = paymentCash;
	}
	public int getPaymentCashSum() {
		return paymentCashSum;
	}
	public void setPaymentCashSum(int paymentCashSum) {
		this.paymentCashSum = paymentCashSum;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentPayerName() {
		return paymentPayerName;
	}
	public void setPaymentPayerName(String paymentPayerName) {
		this.paymentPayerName = paymentPayerName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [paymentCode=");
		builder.append(paymentCode);
		builder.append(", orderCode=");
		builder.append(orderCode);
		builder.append(", paymentInputBankCardNumber=");
		builder.append(paymentInputBankCardNumber);
		builder.append(", paymentAgency=");
		builder.append(paymentAgency);
		builder.append(", paymentCash=");
		builder.append(paymentCash);
		builder.append(", paymentCashSum=");
		builder.append(paymentCashSum);
		builder.append(", paymentDate=");
		builder.append(paymentDate);
		builder.append(", paymentPayerName=");
		builder.append(paymentPayerName);
		builder.append("]");
		return builder.toString();
	}
	
}
