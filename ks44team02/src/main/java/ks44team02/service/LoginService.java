package ks44team02.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import ks44team02.dto.Member;
import ks44team02.mapper.LoginMapper;

@Service
public class LoginService {
	
	private final LoginMapper loginMapper;
	
	
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
			
		
	//회원수정
	public void modifyMember(Member member) {
		loginMapper.modifyMember(member);
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
	
	//특정회원 조회
	public Member getMemberInfoById(String memberId) {
		Member member = loginMapper.getMemberInfoById(memberId);
		return member;
	}
	
	//회원 아이디 중복체크
	public boolean idCheck(String memberId) {
		boolean result = loginMapper.idCheck(memberId);
		return result;
	}

	//회원 아이디 중복체크 구매자
	public boolean idCheckBuyer(String memberId) {
		boolean result = loginMapper.idCheckBuyer(memberId);
		return result;
	}
	
	//회원 아이디 중복체크 판매자
	public boolean idCheckSeller(String memberId) {
		boolean result = loginMapper.idCheckSeller(memberId);
		return result;
		}
		
	//관리자 회원가입
	public void addAdmin(Member member) {
	       int result = loginMapper.addAdmin(member);
	       System.out.println("회원가입 결과:" + result);
	    }	
	public List<Member> getAddAdmin(){
		List<Member>addAdmin = loginMapper.getAddAdmin();
		return addAdmin;
	}
		
	//구매자 회원가입
	public void addBuyer(Member member) {
			int result = loginMapper.addBuyer(member);
			System.out.println("회원가입 결과:" + result);
	 	}
	public List<Member> getAddBuyer(){
		List<Member>addBuyer = loginMapper.getAddBuyer();
		return addBuyer;
		
	}
		
		
		
		
}
