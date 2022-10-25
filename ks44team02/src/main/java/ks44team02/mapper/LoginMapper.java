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
	
	//관리자 로그인
	public String adminLogin();

	//관리자 로그아웃
	public String adminLogout();	
	
	//판매자 회원 정보 리스트 조회 
	public List<Member> getMemberListAdmin(Map<String, Object> map);
	
	//(공통 1) 로그인 이력 삭제
	public int removeLoginHistory(String memberId);
		
	//(공통 2) 회원 삭제
	public int removeMember(String memberId);
		
	//판매자 조회
	public List<Member> getSellerList();
		
	//회원 수정
	public int modifyMember(Member member);
		
	//특정 회원 정보 조회
	public Member getMemberInfoById(String memberId);

	//아이디 중복체크
	public boolean idCheck(String memberId);
	
	//아이디 중복체크 구매자
	public boolean idCheckBuyer(String memberId);
	
	//아이디 중복체크 판매자
	public boolean idCheckSeller(String memberId);
	

	//회원 목록 조회
	public List<Member> getMemberList();
	

	//관리자회원 리스트
	public List<Member> getAddAdmin();
	
	//관리자회원 가입
	public int addAdmin(Member member);
	
	//구매자 회원 리스트
	public List<Member> getAddBuyer();

	//구매자 회원가입 
	public int addBuyer(Member member);



	
	
	
}
