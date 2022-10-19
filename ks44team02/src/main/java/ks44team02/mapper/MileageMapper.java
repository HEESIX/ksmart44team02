package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.MemberMileageAcc;

@Mapper
public interface MileageMapper {
	

	
	    //회원 적립금 조회
		public List<MemberMileageAcc> getMileageList();

	    //회원 적립금 검색
		public List<MemberMileageAcc> getMileageListSearch(String memberId);
		
		
		//회원 적립금 적립
		public MemberMileageAcc giveMileage(MemberMileageAcc memberMileageAcc);
		
		public List<MemberMileageAcc> giveMileageForm(MemberMileageAcc memberMileageAcc);
		
		//회원 적립금 소멸
		public int MileageExtinction();
		
		//buyer적립금 조회
		public String getBuyerMileageList();
		
		//특정회원 마일리지 조회
		public MemberMileageAcc getMileageInfo();

		public MemberMileageAcc getMemberMileageAccInfo(String mMileageCode, String currentMileage);

		public boolean MileageExtinction(String mMileageCode);
		
		public MemberMileageAcc getMileageInfo(String mMileageCode, String currentMileage, String memberId);

		
}
