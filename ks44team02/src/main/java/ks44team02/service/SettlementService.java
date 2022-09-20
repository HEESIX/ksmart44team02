package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.SettlementMapper;

@Service
public class SettlementService {
	
private final SettlementMapper settlementMapper;
	
	public SettlementService(SettlementMapper settlementMapper) {
		this.settlementMapper = settlementMapper;
	}
	
	// 매출현황 조회
	public String getSalesStateList() {
		return null;
	}

	// 매출 정산
	public int SalesSettlement() {
		return 0;
	}

	// 정산금 정산현황 조회
	public String getAddfareStateList() {
		return null;
	}

	// 정산금 정산
	public int AddfareSettlement() {
		return 0;
	}
				
			
	

}
