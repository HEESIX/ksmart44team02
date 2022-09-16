package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.PenaltyMapper;

@Service
public class PenaltyService {
	
	private final PenaltyMapper penaltyMapper;
	
	public PenaltyService(PenaltyMapper penaltyMapper) {
		this.penaltyMapper = penaltyMapper;
	}
	
	//회원 QnA 데이터 조회(QnA내역 조회)
	public String getqnaList() {
		return null;
	}

}
