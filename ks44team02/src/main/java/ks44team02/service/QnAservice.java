package ks44team02.service;

import org.springframework.stereotype.Service;


import ks44team02.mapper.QnAmapper;


	@Service
	public class QnAservice {
		
		private final QnAmapper qnaMapper;
		
		public QnAservice(QnAmapper qnaMapper) {
			this.qnaMapper = qnaMapper;
		}
		
		//회원 QnA 데이터 조회(QnA내역 조회)
		public String getqnaList() {
			return null;
		}
		
		//회원 QnA 답글 등록
		public int qnaAnswer() {
			return 0;
		}
	}

