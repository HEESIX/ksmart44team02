package ks44team02.dto;

//신고내역 구성요소,내용(객체)
public class Complain {
	private String memberId;
	private String complainCategory;
	private String complainTitle;
	private String complainContent;
	private String complainRegDate;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getComplainCategory() {
		return complainCategory;
	}
	public void setComplainCategory(String complainCategory) {
		this.complainCategory = complainCategory;
	}
	public String getComplainTitle() {
		return complainTitle;
	}
	public void setComplainTitle(String complainTitle) {
		this.complainTitle = complainTitle;
	}
	public String getComplainContent() {
		return complainContent;
	}
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}
	public String getComplainRegDate() {
		return complainRegDate;
	}
	public void setComplainRegDate(String complainRegDate) {
		this.complainRegDate = complainRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Complain [memberId=");
		builder.append(memberId);
		builder.append(", complainCategory=");
		builder.append(complainCategory);
		builder.append(", complainTitle=");
		builder.append(complainTitle);
		builder.append(", complainContent=");
		builder.append(complainContent);
		builder.append(", complainRegDate=");
		builder.append(complainRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
