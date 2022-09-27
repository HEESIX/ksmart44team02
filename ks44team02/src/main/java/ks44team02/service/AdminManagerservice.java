package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.mapper.AdminManagermapper;

import ks44team02.dto.AdminManager;


@Service
public class AdminManagerservice {
	
	private final AdminManagermapper adminManagerMapper;
	
	public AdminManagerservice (AdminManagermapper adminManagerMapper) {
		this.adminManagerMapper = adminManagerMapper;
	}
	//관리자 페이지 전체 회원 정보 조회
	public List<AdminManager> getReviewAdminList() {
		return null;
	}

	//관리자 페이지 판매자 탈퇴 승인
	public String getAuthorizeSellerWithdrawal() {
		return null;
	}
	
	//관리자 페이지 전체 회원 정보 수정 
	public String getModifyAdminList() {
		return null;
	}
	
}
