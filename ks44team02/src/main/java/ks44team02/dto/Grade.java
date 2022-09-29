package ks44team02.dto;

// 등급 정의 
public class Grade {
	private String memberLevelCode;
	private String memberLevelClassName;
	private String memberLevelName;
	private String memberLevelRegDate;
	public String getMemberLevelCode() {
		return memberLevelCode;
	}
	public void setMemberLevelCode(String memberLevelCode) {
		this.memberLevelCode = memberLevelCode;
	}
	public String getMemberLevelClassName() {
		return memberLevelClassName;
	}
	public void setMemberLevelClassName(String memberLevelClassName) {
		this.memberLevelClassName = memberLevelClassName;
	}
	public String getMemberLevelName() {
		return memberLevelName;
	}
	public void setMemberLevelName(String memberLevelName) {
		this.memberLevelName = memberLevelName;
	}
	public String getMemberLevelRegDate() {
		return memberLevelRegDate;
	}
	public void setMemberLevelRegDate(String memberLevelRegDate) {
		this.memberLevelRegDate = memberLevelRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Grade [memberLevelCode=");
		builder.append(memberLevelCode);
		builder.append(", memberLevelClassName=");
		builder.append(memberLevelClassName);
		builder.append(", memberLevelName=");
		builder.append(memberLevelName);
		builder.append(", memberLevelRegDate=");
		builder.append(memberLevelRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
