package ks44team02.service;

import ks44team02.mapper.InqueryMapper;


	public class InqueryService {
	
		private final InqueryMapper inqueryMapper;
	
		public InqueryService(InqueryMapper inqueryMapper) {
			this.inqueryMapper = inqueryMapper;
		}
		
		//문의 조회
		public String getSellerInqueryList() {
			return null;
		}
			
		//문의 답변
		public int answerInquery() {
			return 0;
		}
	
		//구매자 문의 조회
		public String getBuyerInqueryList() {
			return null;
		}
		//구매자 문의 등록
			public int regBuyerInquery() {
				return 0;
			}
			//구매자 문의 수정
			public int modifyBuyerInquery() {
				return 0;
			}
			//구매자 문의 삭제
			public int deleteBuyerInquery() {
				return 0;
			}	
	}
