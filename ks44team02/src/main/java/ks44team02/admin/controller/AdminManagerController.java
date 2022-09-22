package ks44team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.AdminManagerservice;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminManagerController {
	
	private final AdminManagerservice adminManagerservice;
	
	public AdminManagerController (AdminManagerservice adminManagerservice) {
		this.adminManagerservice = adminManagerservice;
	}
	
	
	// 관리자 전체 회원 정보 조회
	@GetMapping("/member_list_admin")
	public String getReviewAdminList() {
		return "admin/login/member_list_admin";
	}
	// 관리자 판매자 탈퇴 승인
	@GetMapping("/member_delete_admin")
	public String getAuthorizeSellerWithdrawal() {
		return "admin/login/member_delete_admin";
	}
	//관리자 회원 정보 수정
	@GetMapping("/member_update_admin")
	public String getModifyAdminList() {
		return "admin/login/member_update_admin";
	}
	
}
