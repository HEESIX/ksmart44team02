package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.mapper.MileageMapper;
import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.OrderDiscount;

@Service
public class MileageService {
	
	private final MileageMapper mileageMapper;
	
	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}
	
	//특정회원 적립금 조회
	public MemberMileageAcc getMileageInfo(String currentMileage) {
		MemberMileageAcc mileage = mileageMapper.getMileageInfo();
		return mileage;
	}
	
	   //회원 적립금 조회
		public List<MemberMileageAcc> getMileageList() {
			List<MemberMileageAcc> mileageList = mileageMapper.getMileageList();
			return mileageList;
		}

		//회원 적립금 적립
		public int giveMileage() {
			return 0;
		}
		
		//buyer 적립금 조회
		public String getBuyerMileageList() {
			return null;
		}
		public boolean giveMileage(MemberMileageAcc memberMileageAcc) {
			boolean result = mileageMapper.giveMileage(memberMileageAcc);
			return result;
		}

		//회원 적립금 소멸
		public String MileageExtinction(String mMileageCode) {
			return null;
				
		}


}
