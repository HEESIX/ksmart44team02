package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.service.PenaltyService;
import ks44team02.dto.Penalty;

@Mapper
public interface PenaltyMapper {
	
	//패널티 부여
	public int givePenalty();
	
	//판매자 패널티 조회
	public String getPenaltyList();

	public Penalty getPenaltyInfo();

	public boolean givePenalty(Penalty penalty);
	
			
}
