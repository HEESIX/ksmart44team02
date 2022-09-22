package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper {
	// 구매 회원 등록
	public String addBuyerInsert();
	
	// 구매회원 등록시 아이디 중복 체크 
	public String CheckBuyerId();
	
	// 구매 회원 등록시 핸드폰 중복 체크 
	public String CheckBuyerNum();
	
	// 구매회원 정보 수정시 기존 데이터 불러오기
	public String getBuyerInfomation();
	
	// 구매 회원 정보 수정
	public String modifyBuyer();
			
	// 판매 회원 정보 등록
	public String addVenderInsert();
	
	// 판매 회원 등록시 아이디 중복 체크 
	public String CheckVenderId();	
				
	// 판매 회원 등록시 핸드폰 중복 체크 
	public String CheckVenderInum();		
	
	// 판매 회원 정보 수정시 기존 데이트 불러오기
	public String getVenderInfomation();
	
	// 판매 회원 정보 수정
	public String modifyVender();
	
	// 관리자 회원 등록
	public String addAdminInsert();
	

}
