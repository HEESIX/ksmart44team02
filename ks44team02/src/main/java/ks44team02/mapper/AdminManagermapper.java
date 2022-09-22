package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminManagermapper {

	// 관리자 페이지 전체 회원 정보 조회
	public String getReviewAdminList();

	// 관리자 페이지 판매자 탈퇴 승인
	public String getAuthorizeSellerWithdrawal();
	
	// 관리자 페이지 전체 회원 정보 수정 
	public String getModifyAdminList();
	
	
}
