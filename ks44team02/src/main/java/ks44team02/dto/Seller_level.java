package ks44team02.dto;

public class Seller_level {
	private String sellerLevelCode;
	private String memberLevelCode;
	private int sellerCondition;
	private int canRegAmt;
	private int sellerMileage;
	public String getSellerLevelCode() {
		return sellerLevelCode;
	}
	public void setSellerLevelCode(String sellerLevelCode) {
		this.sellerLevelCode = sellerLevelCode;
	}
	public String getMemberLevelCode() {
		return memberLevelCode;
	}
	public void setMemberLevelCode(String memberLevelCode) {
		this.memberLevelCode = memberLevelCode;
	}
	public int getSellerCondition() {
		return sellerCondition;
	}
	public void setSellerCondition(int sellerCondition) {
		this.sellerCondition = sellerCondition;
	}
	public int getCanRegAmt() {
		return canRegAmt;
	}
	public void setCanRegAmt(int canRegAmt) {
		this.canRegAmt = canRegAmt;
	}
	public int getSellerMileage() {
		return sellerMileage;
	}
	public void setSellerMileage(int sellerMileage) {
		this.sellerMileage = sellerMileage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Seller_level [sellerLevelCode=");
		builder.append(sellerLevelCode);
		builder.append(", memberLevelCode=");
		builder.append(memberLevelCode);
		builder.append(", sellerCondition=");
		builder.append(sellerCondition);
		builder.append(", canRegAmt=");
		builder.append(canRegAmt);
		builder.append(", sellerMileage=");
		builder.append(sellerMileage);
		builder.append("]");
		return builder.toString();
	}
	
	
}
