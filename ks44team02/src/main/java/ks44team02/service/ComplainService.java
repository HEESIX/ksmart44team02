package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Complain;
import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.Review;
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

	//신고내역 코드 조회
	public Complain getComplainInfo(String complainCode) {
		Complain complainInfo = complainMapper.getComplainInfo();
		return complainInfo;
	
	}
	//신고내역 내용,제목 조회
	public Complain getComplainInfo(String complainContent, String complainTitle) {
		Complain complainInfo = complainMapper.getComplainInfo();
		return complainInfo;
	}
	//회원 신고 등록
	public boolean regBuyerComplain(Complain complain) {
		boolean result = complainMapper.regBuyerComplain(complain);
		return result;
	}

	public List<Complain> getComplainListSearch(String memberId) {
		List<Complain> complainList = complainMapper.getComplainListSearch(memberId);
		return complainList;
	}

}
