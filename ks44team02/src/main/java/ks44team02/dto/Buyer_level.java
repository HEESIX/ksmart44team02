package ks44team02.dto;

public class Buyer_level {
	private String buyerLevelCode;
	private String memberLevelCode;
	private int buyerCondition;
	private int buyerMileage;
	public String getBuyerLevelCode() {
		return buyerLevelCode;
	}
	public void setBuyerLevelCode(String buyerLevelCode) {
		this.buyerLevelCode = buyerLevelCode;
	}
	public String getMemberLevelCode() {
		return memberLevelCode;
	}
	public void setMemberLevelCode(String memberLevelCode) {
		this.memberLevelCode = memberLevelCode;
	}
	public int getBuyerCondition() {
		return buyerCondition;
	}
	public void setBuyerCondition(int buyerCondition) {
		this.buyerCondition = buyerCondition;
	}
	public int getBuyerMileage() {
		return buyerMileage;
	}
	public void setBuyerMileage(int buyerMileage) {
		this.buyerMileage = buyerMileage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer_level [buyerLevelCode=");
		builder.append(buyerLevelCode);
		builder.append(", memberLevelCode=");
		builder.append(memberLevelCode);
		builder.append(", buyerCondition=");
		builder.append(buyerCondition);
		builder.append(", buyerMileage=");
		builder.append(buyerMileage);
		builder.append("]");
		return builder.toString();
	}

	
}
