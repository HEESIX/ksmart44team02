package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Mileage;

@Mapper
public interface MileageMapper {
	
	//회원 적립금 조회
		public List<Mileage> getMileageList();

		//회원 적립금 적립
		public int giveMileage();
		
		//회원 적립금 소멸
		public int MileageExtinction();
		
		//buyer적립금 조회
		public String getBuyerMileageList();
}
