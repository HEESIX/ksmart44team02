package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	}

