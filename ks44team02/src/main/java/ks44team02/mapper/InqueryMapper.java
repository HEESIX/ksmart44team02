package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InqueryMapper {
	
	
	// 문의 조회
	public String getSellerInqueryList();

	// 문의 답변
	public int answerInquery();

	// 구매자 문의 조회
	public String getBuyerInqueryList();

	// 구매자 문의 등록
	public int regBuyerInquery();

	// 구매자 문의 수정
	public int modifyBuyerInquery();

	// 구매자 문의 삭제
	public int deleteBuyerInquery();

}
