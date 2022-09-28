package ks44team02.dto;

//QnA 구성요소,내용(객체)
public class QnA {
	private String memberId;
	private String qnaCategory;
	private String qnaTitle;
	private String qnaContents;
	private String qnaAnswer;
	private String qnaRegDate;
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getQnaCategory() {
		return qnaCategory;
	}
	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContents() {
		return qnaContents;
	}
	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}
	public String getQnaRegDate() {
		return qnaRegDate;
	}
	public void setQnaRegDate(String qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QnA [memberId=");
		builder.append(memberId);
		builder.append(", qnaCategory=");
		builder.append(qnaCategory);
		builder.append(", qnaTitle=");
		builder.append(qnaTitle);
		builder.append(", qnaContents=");
		builder.append(qnaContents);
		builder.append(", qnaAnswer=");
		builder.append(qnaAnswer);
		builder.append(", qnaRegDate=");
		builder.append(qnaRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
