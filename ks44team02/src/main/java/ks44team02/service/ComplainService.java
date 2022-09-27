package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.ComplainMapper;

@Service
public class ComplainService {
	
	private final ComplainMapper complainMapper;
	
	public ComplainService(ComplainMapper complainMapper) {
		this.complainMapper = complainMapper;
	}
	
	//회원 신고내역 조회
    public String getComplainList() {
		return null;
	}

	//회원 신고내역 삭제
	public int ComplainDelete() {
		return 0;
	}
	
	//판매자 신고내역 조회
	public String getSellerComplainList() {
		return null;
	}
		
	// 구매자 신고 등록
	public int regBuyerComplain() {
		return 0;

	}

}
