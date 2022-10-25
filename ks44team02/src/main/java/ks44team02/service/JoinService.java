package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.dto.Member;
import ks44team02.mapper.LoginMapper;

@Service
public class JoinService {
	
	private final LoginMapper loginMapper;
	
	public JoinService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	//관리자 회원가입
	public String adminJoin(Member member) {
		String addResult = "회원가입실패";
		
		int result = loginMapper.addAdmin(member);
		
		if(result > 0) addResult = "회원가입성공";
		
		return addResult;
	}
	
	//구매자 회원가입
	public String sellerJoin() {
			return null;
		}
		
	//판매자 회원가입
	public String buyerJoin(Member member) {
		String addResult = "회원가입실패";
		int result = loginMapper.addBuyer(member);
		if(result > 0 ) addResult = "회원가입성공";
		return addResult;
	}
	
}
