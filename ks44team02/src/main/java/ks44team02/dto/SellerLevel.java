package ks44team02.dto;

public class SellerLevel {
	private String sellerLevelCode;
	private String memberLevelCode;
	private String sellerCondition;
	private String canRegAmt;
	private String sellerMileage;
	
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
	public String getSellerCondition() {
		return sellerCondition;
	}
	public void setSellerCondition(String sellerCondition) {
		this.sellerCondition = sellerCondition;
	}
	public String getCanRegAmt() {
		return canRegAmt;
	}
	public void setCanRegAmt(String canRegAmt) {
		this.canRegAmt = canRegAmt;
	}
	public String getSellerMileage() {
		return sellerMileage;
	}
	public void setSellerMileage(String sellerMileage) {
		this.sellerMileage = sellerMileage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellerLevel [sellerLevelCode=");
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
