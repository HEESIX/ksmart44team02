package ks44team02.dto;

import java.time.LocalDateTime;

//QnA 구성요소,내용(객체)
public class QnA {
	private String qnaCode;
	private String memberId;
	private String gCode;
	private String qnaCategory;
	private String enterCode;
	private String qnaImage;
	private String qnaTitle;
	private LocalDateTime qnaRegDatetime;
	private String qnaContents;
	private String qnaAnswerConfirm;
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public String getQnaImage() {
		return qnaImage;
	}
	public void setQnaImage(String qnaImage) {
		this.qnaImage = qnaImage;
	}
	public LocalDateTime getQnaRegDatetime() {
		return qnaRegDatetime;
	}
	public void setQnaRegDatetime(LocalDateTime qnaRegDatetime) {
		this.qnaRegDatetime = qnaRegDatetime;
	}
	public String getQnaAnswerConfirm() {
		return qnaAnswerConfirm;
	}
	public void setQnaAnswerConfirm(String qnaAnswerConfirm) {
		this.qnaAnswerConfirm = qnaAnswerConfirm;
	}
	public void setQnaRegDate(LocalDateTime qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}
	private String qnaAnswer;
	private LocalDateTime qnaRegDate;
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
	
	public String getQnaCode() {
		return qnaCode;
	}
	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}
	@Override
	public String toString() {
		return "QnA [qnaCode=" + qnaCode + ", memberId=" + memberId + ", gCode=" + gCode + ", qnaCategory="
				+ qnaCategory + ", enterCode=" + enterCode + ", qnaImage=" + qnaImage + ", qnaTitle=" + qnaTitle
				+ ", qnaRegDatetime=" + qnaRegDatetime + ", qnaContents=" + qnaContents + ", qnaAnswerConfirm="
				+ qnaAnswerConfirm + ", qnaAnswer=" + qnaAnswer + ", qnaRegDate=" + qnaRegDate + "]";
	}
	
	
}
