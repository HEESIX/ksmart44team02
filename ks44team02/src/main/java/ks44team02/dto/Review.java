package ks44team02.dto;

public class Review {
	
	private String memberId;
	private String reviewTitle;
	private String reviewContents;
	private String reviewScore;
	private String reviewregDate;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewregDate() {
		return reviewregDate;
	}
	public void setReviewregDate(String reviewregDate) {
		this.reviewregDate = reviewregDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [memberId=");
		builder.append(memberId);
		builder.append(", reviewTitle=");
		builder.append(reviewTitle);
		builder.append(", reviewContents=");
		builder.append(reviewContents);
		builder.append(", reviewScore=");
		builder.append(reviewScore);
		builder.append(", reviewregDate=");
		builder.append(reviewregDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
