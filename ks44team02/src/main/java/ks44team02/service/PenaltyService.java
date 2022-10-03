package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.admin.controller.AdminPenaltyController;
import ks44team02.dto.Complain;
import ks44team02.dto.Penalty;
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

	public Penalty getPenaltyInfo(String penaltyStateCode) {
		Penalty PanaltyInfo = penaltyMapper.getPenaltyInfo();
		return null;
	}

	public boolean givePenalty(Penalty penalty) {
		boolean result = penaltyMapper.givePenalty(penalty);
		return result;

	}

}
