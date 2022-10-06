package ks44team02.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import ks44team02.dto.Member;
import ks44team02.mapper.LoginMapper;

@Service
public class LoginService {
	
	private final LoginMapper loginMapper;
	
	//
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	//구매자 로그인
	public String buyerLogin () {
		return null;
	}
	
	//구매자 로그아웃
	public String buyeLogout () {
		return null;
	}
	
	//판매자 로그인
	public String sellerLogin () {
			return null;
	}

	//판매자 로그아웃
	public String sellerLogout () {
			return null;
	}
		
	//판매자 로그인
	public String adminLogin () {
			return null;
	}
		
	//판매자 로그아웃
	public String adminLogout () {
			return null;
	}

	//관리자가 구매자 판매자 정보 조회 
		public List<Member> getMemberListAdmin(Map<String, Object> map){
			List<Member> memberListAdmin = loginMapper.getMemberListAdmin(map);
			return  memberListAdmin;
		}
	
}
