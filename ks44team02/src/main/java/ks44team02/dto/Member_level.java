package ks44team02.dto;
//회원등급관리
public class Member_level {
	private String memberLevelCode;
	private String memberLevelClassName;
	private String memberLevelName;
	private String  memberLevelRegRate;
	
	
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
	public String getMemberLevelRegRate() {
		return memberLevelRegRate;
	}
	public void setMemberLevelRegRate(String memberLevelRegRate) {
		this.memberLevelRegRate = memberLevelRegRate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member_level [memberLevelCode=");
		builder.append(memberLevelCode);
		builder.append(", memberLevelClassName=");
		builder.append(memberLevelClassName);
		builder.append(", memberLevelName=");
		builder.append(memberLevelName);
		builder.append(", memberLevelRegRate=");
		builder.append(memberLevelRegRate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
