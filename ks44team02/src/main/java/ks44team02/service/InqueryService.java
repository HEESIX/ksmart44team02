package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.InqueryMapper;

@Service
public class InqueryService {

	private final InqueryMapper inqueryMapper;

	public InqueryService(InqueryMapper inqueryMapper) {
		this.inqueryMapper = inqueryMapper;
	}

	// 문의 조회
	public String getSellerInqueryList() {
		return null;
	}

	// 문의 답변
	public int answerInquery() {
		return 0;
	}

}
