package ks44team02.dto;

public class Review {
	
	private String revCode;
	private String deliveryCode;
	private String orderDetailCode;
	private String gCode;
	private String memberId;
	private String revImage;
	private String reviewTitle;
	private String reviewContents;
	private String revRegDatetime;
	private String reviewScore;
	private String enterCode;
	public String getRevCode() {
		return revCode;
	}
	public void setRevCode(String revCode) {
		this.revCode = revCode;
	}
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRevImage() {
		return revImage;
	}
	public void setRevImage(String revImage) {
		this.revImage = revImage;
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
	public String getRevRegDatetime() {
		return revRegDatetime;
	}
	public void setRevRegDatetime(String revRegDatetime) {
		this.revRegDatetime = revRegDatetime;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [revCode=");
		builder.append(revCode);
		builder.append(", deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", gCode=");
		builder.append(gCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", revImage=");
		builder.append(revImage);
		builder.append(", reviewTitle=");
		builder.append(reviewTitle);
		builder.append(", reviewContents=");
		builder.append(reviewContents);
		builder.append(", revRegDatetime=");
		builder.append(revRegDatetime);
		builder.append(", reviewScore=");
		builder.append(reviewScore);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append("]");
		return builder.toString();
	}
	
}



	