package ks44team02.dto;
//환불교환사유 객체
public class RefundExchangeReasons {
	private String refundExchangeReasonsCode;
	private String refundExchangeReasons;
	public String getRefundExchangeReasonsCode() {
		return refundExchangeReasonsCode;
	}
	public void setRefundExchangeReasonsCode(String refundExchangeReasonsCode) {
		this.refundExchangeReasonsCode = refundExchangeReasonsCode;
	}
	public String getRefundExchangeReasons() {
		return refundExchangeReasons;
	}
	public void setRefundExchangeReasons(String refundExchangeReasons) {
		this.refundExchangeReasons = refundExchangeReasons;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundExchangeReasons [refundExchangeReasonsCode=");
		builder.append(refundExchangeReasonsCode);
		builder.append(", refundExchangeReasons=");
		builder.append(refundExchangeReasons);
		builder.append("]");
		return builder.toString();
	}
	
}
