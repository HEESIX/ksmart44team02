package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.JoinMapper;

@Service
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
