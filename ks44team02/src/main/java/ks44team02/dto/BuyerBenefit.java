package ks44team02.dto;

import java.util.List;

public class BuyerBenefit {
	private String memberBenefitCode;
	private String memberId;
	private String orderDiscountCode;
	private String benefitInfo;
	private String benefitIssueDate;
	private String benefitExpirationDate;
	
	private List<OrderDiscount> orderDiscountList;
	

	public List<OrderDiscount> getOrderDiscountList() {
		return orderDiscountList;
	}
	public void setOrderDiscountList(List<OrderDiscount> orderDiscountList) {
		this.orderDiscountList = orderDiscountList;
	}
	public String getMemberBenefitCode() {
		return memberBenefitCode;
	}
	public void setMemberBenefitCode(String memberBenefitCode) {
		this.memberBenefitCode = memberBenefitCode;
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
		builder.append("BuyerBenefit [memberBenefitCode=");
		builder.append(memberBenefitCode);
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
		builder.append(", orderDiscountList=");
		builder.append(orderDiscountList);
		builder.append("]");
		return builder.toString();
	}
	
}
