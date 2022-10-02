package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.JoinMapper;

@Service
public class JoinService {
	private final JoinMapper joinMapper;
		
	public JoinService (JoinMapper joinMapper) {
		this.joinMapper = joinMapper;
	}
	
	//판매자 회원 가입
	public String adminJoin () {
		return null;
	}
	
	//구매자 회원 가입
	public String buyerJoin () {
		return null;
	}
	
	//판매자 회원 가입 
	public String sellerJoin () {
		return null;
	}

}
