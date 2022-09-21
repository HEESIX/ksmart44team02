package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnAmapper {

	//회원 QnA 내역 조회
	public String getqnaList();
	
	//회원 QnA 답글 등록
	public int qnaAnswer();
}
