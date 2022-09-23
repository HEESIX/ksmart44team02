package ks44team02.dto;

public class BuyerBenefit {
	private String buyerBenefitCode;
	private String memberId;
	private String orderDiscountCode;
	private String benefitInfo;
	private String benefitIssueDate;
	private String benefitExpirationDate;
	public String getBuyerBenefitCode() {
		return buyerBenefitCode;
	}
	public void setBuyerBenefitCode(String buyerBenefitCode) {
		this.buyerBenefitCode = buyerBenefitCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderDiscountCode() {
		return orderDiscountCode;
	}
	public void setOrderDiscountCode(String orderDiscountCode) {
		this.orderDiscountCode = orderDiscountCode;
	}
	public String getBenefitInfo() {
		return benefitInfo;
	}
	public void setBenefitInfo(String benefitInfo) {
		this.benefitInfo = benefitInfo;
	}
	public String getBenefitIssueDate() {
		return benefitIssueDate;
	}
	public void setBenefitIssueDate(String benefitIssueDate) {
		this.benefitIssueDate = benefitIssueDate;
	}
	public String getBenefitExpirationDate() {
		return benefitExpirationDate;
	}
	public void setBenefitExpirationDate(String benefitExpirationDate) {
		this.benefitExpirationDate = benefitExpirationDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BuyerBenefit [buyerBenefitCode=");
		builder.append(buyerBenefitCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", orderDiscountCode=");
		builder.append(orderDiscountCode);
		builder.append(", benefitInfo=");
		builder.append(benefitInfo);
		builder.append(", benefitIssueDate=");
		builder.append(benefitIssueDate);
		builder.append(", benefitExpirationDate=");
		builder.append(benefitExpirationDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
