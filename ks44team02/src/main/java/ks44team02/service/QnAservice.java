package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.QnA;
import ks44team02.mapper.QnAmapper;


	@Service
	public class QnAservice {
		
		private final QnAmapper qnaMapper;
		
		public QnAservice(QnAmapper qnaMapper) {
			this.qnaMapper = qnaMapper;
		}
		
		//회원 QnA 데이터 조회(QnA내역 조회)
		public List<QnA> getqnaList() {
			return null;
		}
		
		//회원 QnA 답글 등록
		public int qnaAnswer() {
			return 0;
		}

		//특정회원QnA 답변
		public QnA getqnaInfo(String qnaAnswer) {
			
			return null;
		}

		public boolean qnaAnswer(QnA qna) {
			// TODO Auto-generated method stub
			return false;
		}
		
		//판매자 문의 조회
				public String getSellerInqueryList() {
					return null;
				}
					
				//판매자 문의 답변
				public int answerInquery() {
					return 0;
				}
			
				//구매자 문의 조회
				public List<QnA> getBuyerInqueryList() {
					return null;
				}
				
					//구매자 문의 수정
					public int modifyBuyerInquery() {
						return 0;
					}
					//구매자 문의 삭제
					public int deleteBuyerInquery() {
						return 0;
					}

					public QnA getQnAInfo(String qnaContents, String qnaTitle) {
						// TODO Auto-generated method stub
						return null;
					}
					
					//구매자 문의 등록
					public boolean regBuyerInquery(QnA qna) {
						boolean result = qnaMapper.regBuyerInquery(qna);
						return result;
					}
					
					//구매자 문의수정
					public boolean modifyBuyerInquery(QnA qna) {
						boolean result = qnaMapper.modifyBuyerInquery(qna);
						return result;
					}

					public boolean deleteBuyerInquery(String qnaCode) {
						boolean result = qnaMapper.deleteBuyerInquery(qnaCode);
						return result;
						
					}

				

			
				

	
	}

