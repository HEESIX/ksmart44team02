package ks44team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.MemberInfoservice;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminRegController {
	
	private final MemberInfoservice memberInfoservice;
	
	public AdminRegController (MemberInfoservice memberInfoservice) {
		this.memberInfoservice = memberInfoservice;
	}
	// 관리자 등록
	@GetMapping("/admin_login_reg")
	public String addAdminInsert() {
		return "admin/login/admin_login_reg";
	}
}
