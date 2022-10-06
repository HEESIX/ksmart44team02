package ks44team02.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Member;




@Mapper
public interface LoginMapper {


	//구매자 로그인
	public String buyerLogin();

	//구매자 로그아웃
	public String buyerLogout();	
	
	//판매자 로그인
	public String sellerLogin();

	//구매자 로그아웃
	public String sellerLogout();	
	
	//구매자 로그인
	public String adminLogin();

	//구매자 로그아웃
	public String adminLogout();	
	
	//판매자 회원 정보 리스트 조회 
	public List<Member> getMemberListAdmin(Map<String, Object> map);
	
	
}
