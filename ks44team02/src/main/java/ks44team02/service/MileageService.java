package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.mapper.MileageMapper;
import ks44team02.dto.Mileage;

@Service
public class MileageService {
	
	private final MileageMapper mileageMapper;
	
	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}
	
	   //회원 적립금 조회
		public List<Mileage> getMileageList() {
			List<Mileage> mileage = mileageMapper.getMileageList();
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
		//buyer 적립금 조회
		public String getBuyerMileageList() {
			return null;
		}

}
