package ks44team02.dto;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberLevelCode;
	private int memberMileage;
	private String memberPhone;
	private String memberEmail;
	private String memberGender; 
	private String memberBirth; 
	private String memberAddr;
	private String memberRegDate;
	private String recommenderId;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberLevelCode() {
		return memberLevelCode;
	}
	public void setMemberLevelCode(String memberLevelCode) {
		this.memberLevelCode = memberLevelCode;
	}
	public int getMemberMileage() {
		return memberMileage;
	}
	public void setMemberMileage(int memberMileage) {
		this.memberMileage = memberMileage;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberRegDate() {
		return memberRegDate;
	}
	public void setMemberRegDate(String memberRegDate) {
		this.memberRegDate = memberRegDate;
	}
	public String getRecommenderId() {
		return recommenderId;
	}
	public void setRecommenderId(String recommenderId) {
		this.recommenderId = recommenderId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", memberPw=");
		builder.append(memberPw);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberLevelCode=");
		builder.append(memberLevelCode);
		builder.append(", memberMileage=");
		builder.append(memberMileage);
		builder.append(", memberPhone=");
		builder.append(memberPhone);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append(", memberGender=");
		builder.append(memberGender);
		builder.append(", memberBirth=");
		builder.append(memberBirth);
		builder.append(", memberAddr=");
		builder.append(memberAddr);
		builder.append(", memberRegDate=");
		builder.append(memberRegDate);
		builder.append(", recommenderId=");
		builder.append(recommenderId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
