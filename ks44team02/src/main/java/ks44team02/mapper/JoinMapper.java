package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {
		
	// 관리자 회원 가입 폼
	public String adminJoinForm();	
	
	// 구매자 회원 가입 폼
	public String buyerJoinForm();	
		
	// 판매자 회원 가입 폼
	public String sellerJoinForm();	

}
