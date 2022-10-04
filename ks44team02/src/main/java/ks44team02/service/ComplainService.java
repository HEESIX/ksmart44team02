package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Complain;
import ks44team02.dto.MemberMileageAcc;
import ks44team02.mapper.ComplainMapper;

@Service
public class ComplainService {
	
	private final ComplainMapper complainMapper;
	
	public ComplainService(ComplainMapper complainMapper) {
		this.complainMapper = complainMapper;
	}
	
	//회원 신고내역 조회
    public List<Complain> getComplainList() {
    	List<Complain> complainList = complainMapper.getComplainList();
		return complainList;
	}
	

	//회원 신고내역 삭제
	public String ComplainDelete(String complainCode) {
		return null;
	}
	
	//판매자 신고내역 조회
	public String getSellerComplainList() {
		return null;
	}
		
	// 구매자 신고 등록
	public int regBuyerComplain() {
		return 0;

	}

	public Complain getComplainInfo(String complainCode) {
		Complain complainInfo = complainMapper.getComplainInfo();
		return complainInfo;
	
	}

}
