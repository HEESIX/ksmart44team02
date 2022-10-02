package ks44team02.dto;

//신고내역 구성요소,내용(객체)
public class Complain {
	private String complainCode;
	private String memberId;
	private String gCode;
	private String complainCategory;
	private String enterCode;
	private String complainTitle;
	private String complainContent;
	private String complainRegDatetime;
	private char complainAnswerConfirm;
	private String complainAnswerContent;
	private String complainAnswerDatetime;
	public String getComplainCode() {
		return complainCode;
	}
	public void setComplainCode(String complainCode) {
		this.complainCode = complainCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getComplainCategory() {
		return complainCategory;
	}
	public void setComplainCategory(String complainCategory) {
		this.complainCategory = complainCategory;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
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
	public String getComplainRegDatetime() {
		return complainRegDatetime;
	}
	public void setComplainRegDatetime(String complainRegDatetime) {
		this.complainRegDatetime = complainRegDatetime;
	}
	public char getComplainAnswerConfirm() {
		return complainAnswerConfirm;
	}
	public void setComplainAnswerConfirm(char complainAnswerConfirm) {
		this.complainAnswerConfirm = complainAnswerConfirm;
	}
	public String getComplainAnswerContent() {
		return complainAnswerContent;
	}
	public void setComplainAnswerContent(String complainAnswerContent) {
		this.complainAnswerContent = complainAnswerContent;
	}
	public String getComplainAnswerDatetime() {
		return complainAnswerDatetime;
	}
	public void setComplainAnswerDatetime(String complainAnswerDatetime) {
		this.complainAnswerDatetime = complainAnswerDatetime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Complain [complainCode=");
		builder.append(complainCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", gCode=");
		builder.append(gCode);
		builder.append(", complainCategory=");
		builder.append(complainCategory);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", complainTitle=");
		builder.append(complainTitle);
		builder.append(", complainContent=");
		builder.append(complainContent);
		builder.append(", complainRegDatetime=");
		builder.append(complainRegDatetime);
		builder.append(", complainAnswerConfirm=");
		builder.append(complainAnswerConfirm);
		builder.append(", complainAnswerContent=");
		builder.append(complainAnswerContent);
		builder.append(", complainAnswerDatetime=");
		builder.append(complainAnswerDatetime);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
