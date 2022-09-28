package ks44team02.dto;

public class Penalty {

	private String memberId;
	private String penaltySort;  //패널티종류
	private String reviewAvg;
	private String ComplainNum;
	private String penaltyApplyDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPenaltySort() {
		return penaltySort;
	}
	public void setPenaltySort(String penaltySort) {
		this.penaltySort = penaltySort;
	}
	public String getReviewAvg() {
		return reviewAvg;
	}
	public void setReviewAvg(String reviewAvg) {
		this.reviewAvg = reviewAvg;
	}
	public String getComplainNum() {
		return ComplainNum;
	}
	public void setComplainNum(String complainNum) {
		ComplainNum = complainNum;
	}
	public String getPenaltyApplyDate() {
		return penaltyApplyDate;
	}
	public void setPenaltyApplyDate(String penaltyApplyDate) {
		this.penaltyApplyDate = penaltyApplyDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Penalty [memberId=");
		builder.append(memberId);
		builder.append(", penaltySort=");
		builder.append(penaltySort);
		builder.append(", reviewAvg=");
		builder.append(reviewAvg);
		builder.append(", ComplainNum=");
		builder.append(ComplainNum);
		builder.append(", penaltyApplyDate=");
		builder.append(penaltyApplyDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
