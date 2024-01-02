package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.mapper.MileageMapper;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.OrderDetail;

@Service
public class MileageService {

	private final MileageMapper mileageMapper;

	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}

	

	// 회원 적립금 조회
	public List<MemberMileageAcc> getMileageList() {
		List<MemberMileageAcc> mileageList = mileageMapper.getMileageList();
		return mileageList;
	}
	
	
	// 회원 적립금 검색
	public List<MemberMileageAcc> getMileageListSearch(String memberId) {
		List<MemberMileageAcc> mileageList = mileageMapper.getMileageListSearch(memberId);
		return mileageList;
	}

	


//회원 적립금 적립
	public List<MemberMileageAcc> addMileage(String mMileageCode, String member_Id, String orderDetailCode,
			String mileageDistinct, int addedUsedMileage, int currentMileage, String orderGroupCode) {
		
		List<MemberMileageAcc> memberMileageAccInfo = mileageMapper.addMileage(mMileageCode,member_Id,orderDetailCode
						,mileageDistinct,addedUsedMileage,currentMileage,orderGroupCode);
		
		return memberMileageAccInfo;
	}
	
	//회원 적립금 소멸
	public List<MemberMileageAcc> useMileage(String mMileageCode, String member_Id, String orderDetailCode, String mileageDistinct,
			int addedUsedMileage, int currentMileage, String orderGroupCode) {
		List<MemberMileageAcc> memberMileageAccInfo = mileageMapper.useMileage(mMileageCode,member_Id,orderDetailCode
				,mileageDistinct,addedUsedMileage,currentMileage,orderGroupCode);
		
		return memberMileageAccInfo;
		
	}




}
