package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.PenaltyMapper;

@Service
public class PenaltyService {
	
	private final PenaltyMapper penaltyMapper;
	
	public PenaltyService(PenaltyMapper penaltyMapper) {
		this.penaltyMapper = penaltyMapper;
	}
	
	//판매자 패널티 조회
	public String getPenaltyList() {
		  return null;
		}
	
	//관리자 패널티 부여
	public int givePenalty() {
		return 0;
	}

}
