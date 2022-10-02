package ks44team02.service;

import ks44team02.dto.Member;
import ks44team02.mapper.LoginMapper;

public class LoginService {
	
	private final LoginMapper LoginMapper;

	public LoginService(LoginMapper LoginMapper) {
		this.LoginMapper = LoginMapper;
	 }

	public Member getAdminMemberList(String memberId) {

		return null;
	}


}
