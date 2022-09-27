package ks44team02.dto;

public class SellerLevelStates {
	private String sellerLevelStatesCode;
	private String sellerLevelCode;
	private String memberId; 
	private String levelRegDatetime;
	private int accPurchaseAmt;
	public String getSellerLevelStatesCode() {
		return sellerLevelStatesCode;
	}
	public void setSellerLevelStatesCode(String sellerLevelStatesCode) {
		this.sellerLevelStatesCode = sellerLevelStatesCode;
	}
	public String getSellerLevelCode() {
		return sellerLevelCode;
	}
	public void setSellerLevelCode(String sellerLevelCode) {
		this.sellerLevelCode = sellerLevelCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLevelRegDatetime() {
		return levelRegDatetime;
	}
	public void setLevelRegDatetime(String levelRegDatetime) {
		this.levelRegDatetime = levelRegDatetime;
	}
	public int getAccPurchaseAmt() {
		return accPurchaseAmt;
	}
	public void setAccPurchaseAmt(int accPurchaseAmt) {
		this.accPurchaseAmt = accPurchaseAmt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellerLevelStates [sellerLevelStatesCode=");
		builder.append(sellerLevelStatesCode);
		builder.append(", sellerLevelCode=");
		builder.append(sellerLevelCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", levelRegDatetime=");
		builder.append(levelRegDatetime);
		builder.append(", accPurchaseAmt=");
		builder.append(accPurchaseAmt);
		builder.append("]");
		return builder.toString();
	}
	
}
