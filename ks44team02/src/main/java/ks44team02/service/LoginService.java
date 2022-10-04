package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ks44team02.dto.Member;
import ks44team02.mapper.LoginMapper;

@Service
public class LoginService {
	
	private final LoginMapper LoginMapper;
	
	//
	public LoginService(LoginMapper loginMapper) {
		this.LoginMapper = loginMapper;
	}
	

	//관리자 구매자 판매자 정보 조회 
	public List<Member> getMemberListAdmin(String memberId){
		List<Member> memberListAdmin = LoginMapper.getMemberListAdmin();
		return  memberListAdmin;
	}



}
