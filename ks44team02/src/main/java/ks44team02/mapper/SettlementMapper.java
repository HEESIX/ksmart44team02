package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettlementMapper {
	
	// 매출현황 조회
	public String getSalesStateList();

	// 매출 정산
	public int SalesSettlement();

	// 정산금 정산현황 조회
	public String getAddfareStateList();

	// 정산금 정산
	public int AddfareSettlement();
				
			

}
