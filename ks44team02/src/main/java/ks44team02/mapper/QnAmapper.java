package ks44team02.mapper;

public interface QnAmapper {

	//회원 QnA 내역 조회
	public String getqnaList();
	
	//회원 QnA 답글 등록
	public int qnaAnswer();
}
