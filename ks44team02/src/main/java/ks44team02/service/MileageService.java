package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.mapper.MileageMapper;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.OrderDiscount;

@Service
public class MileageService {

	private final MileageMapper mileageMapper;

	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}

	// 특정회원 적립금 조회
	public MemberMileageAcc getMileageInfo(String currentMileage, String mMileageCode) {
		MemberMileageAcc mileageInfo = mileageMapper.getMileageInfo();
		return mileageInfo;
	}

	// 회원 적립금 조회
	public List<MemberMileageAcc> getMileageList() {
		List<MemberMileageAcc> mileageList = mileageMapper.getMileageList();
		return mileageList;
	}
	
	//마일리지 적립 폼
	public List<MemberMileageAcc> giveMileageForm(MemberMileageAcc memberMileageAcc) {
		List<MemberMileageAcc> mileageList = mileageMapper.giveMileageForm(memberMileageAcc);
		return mileageList;
	}
	
	// 회원 적립금 검색
	public List<MemberMileageAcc> getMileageListSearch(String memberId) {
		List<MemberMileageAcc> mileageList = mileageMapper.getMileageListSearch(memberId);
		return mileageList;
	}

	// 회원 적립금 적립
	public int giveMileage() {
		return 0;
	}

	// 기존 데이터 조회(마일리지 적립화면)
	public MemberMileageAcc getMemberMileageAccInfo(String mMileageCode, String currentMileage) {
		MemberMileageAcc memberMileageAccInfo = mileageMapper.getMemberMileageAccInfo(mMileageCode, currentMileage);
		return memberMileageAccInfo;
	}

	// buyer 적립금 조회
	public List<MemberMileageAcc> getBuyerMileageList() {
		return null;
	}

	// 회원 적립금 부여
	public boolean giveMileage(MemberMileageAcc memberMileageAcc) {
		boolean result = mileageMapper.giveMileage(memberMileageAcc);
		return result;
	}

	// 회원 적립금 소멸
	public boolean MileageExtinction(String mMileageCode) {
		boolean resultRemove = mileageMapper.MileageExtinction(mMileageCode);
		return resultRemove;

	}

	public MemberMileageAcc getMileageInfo(MemberMileageAcc memberMileageAcc) {
		// TODO Auto-generated method stub
		return null;
	}

}
