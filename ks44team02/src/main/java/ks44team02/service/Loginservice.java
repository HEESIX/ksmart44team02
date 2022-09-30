package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.dto.Member;
import ks44team02.mapper.LoginMapper;

@Service
public class Loginservice {
	private final LoginMapper loginmapper;
	
	public Loginservice (LoginMapper Loginmapper) {
		this.loginmapper = Loginmapper;
	}
	//구매자 로그인
	public String buyerLogin () {
		return null;
	}
	
	//구매자 로그아웃
	public String buyelogout () {
		return null;
	}
	
	//판매자 로그인
	public String sellerLogin () {
			return null;
	}

	//판매자 로그아웃
	public String sellerlogout () {
			return null;
	}
		
	//판매자 로그인
	public String adminLogin () {
			return null;
	}
		
	//판매자 로그아웃
	public String adminlogout () {
			return null;
	}
	
	//판매자 회원 정보
	public Member getAdminMemberList(String memberId) {
		Member memberInfo = loginmapper.getAdminMemberList(memberId);
		return memberInfo;
	}
}
