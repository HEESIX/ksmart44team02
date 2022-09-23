package ks44team02.dto;

public class BuyerLevelStates {
	private String buyerLevelStatesCode;
	private String buyerLevelCode;
	private String memberId; 
	private String levelRegDatetime;
	private String accPurchaseAmt;
	public String getBuyerLevelStatesCode() {
		return buyerLevelStatesCode;
	}
	public void setBuyerLevelStatesCode(String buyerLevelStatesCode) {
		this.buyerLevelStatesCode = buyerLevelStatesCode;
	}
	public String getBuyerLevelCode() {
		return buyerLevelCode;
	}
	public void setBuyerLevelCode(String buyerLevelCode) {
		this.buyerLevelCode = buyerLevelCode;
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
	public String getAccPurchaseAmt() {
		return accPurchaseAmt;
	}
	public void setAccPurchaseAmt(String accPurchaseAmt) {
		this.accPurchaseAmt = accPurchaseAmt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BuyerLevelStates [buyerLevelStatesCode=");
		builder.append(buyerLevelStatesCode);
		builder.append(", buyerLevelCode=");
		builder.append(buyerLevelCode);
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
