package ks44team02.service;

import ks44team02.mapper.JoinMapper;


public class JoinService {
	
	private final JoinMapper joinMapper;
	
	public JoinService(JoinMapper joinMapper) {
		this.joinMapper = joinMapper;
	}
	
	//판매자 회원가입
	public String adminJoinForm() {
		return null;
	}
	
}
