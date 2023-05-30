package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.QnA;

@Mapper
public interface QnAmapper {

	//회원 QnA 내역 조회(관리자)
	public QnA getqnaList();
	
	//회원 QnA 답글 등록(관리자)
	public int qnaAnswer();
	
	// 판매자 문의 조회
		public String getSellerInqueryList();

		// 판매자 문의 답변
		public int answerInquery();

		// 구매자 문의 조회
		public String getBuyerInqueryList();

		// 구매자 문의 등록
		public int regBuyerInquery();

		// 구매자 문의 수정
		public int modifyBuyerInquery();

		// 구매자 문의 삭제
		public int deleteBuyerInquery();

		public boolean regBuyerInquery(QnA qna);

		public boolean modifyBuyerInquery(QnA qna);

		public boolean deleteBuyerInquery(String qnaCode);

		public QnA getQnAListSearch(String memberId);

}
