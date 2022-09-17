package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PenaltyMapper {
	
	//패널티 부여
	public int givePenalty();
}
