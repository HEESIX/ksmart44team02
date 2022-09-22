package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MileageMapper {
	
	//회원 적립금 조회
		public String getMileageList();

		//회원 적립금 적립
		public int giveMileage();
		
		//회원 적립금 소멸
		public int MileageExtinction();
		
		//buyer적립금 조회
		public String getBuyerMileageList();
}
