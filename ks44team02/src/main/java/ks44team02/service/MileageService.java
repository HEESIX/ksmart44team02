package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.MileageMapper;

@Service
public class MileageService {
	
	private final MileageMapper mileageMapper;
	
	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}
	
	//회원 적립금 조회
		public String getMileageList() {
			return null;
		}

		//회원 적립금 적립
		public int giveMileage() {
			return 0;
		}
		//회원 적립금 소멸
		public int MileageExtinction() {
			return 0;
		}
	

}
