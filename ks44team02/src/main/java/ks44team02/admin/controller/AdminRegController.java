package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.MemberInfoservice;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminRegController {
	private static final Logger log = LoggerFactory.getLogger(AdminRegController.class);

	private final MemberInfoservice memberInfoservice;
	
	public AdminRegController (MemberInfoservice memberInfoservice) {
		this.memberInfoservice = memberInfoservice;
	}
	
	// 관리자 등록 폼
	@GetMapping("/admin_login_reg_form")
	public String addAdminForm() {
		return "admin/login/admin_login_reg_form";
	}
	
	//관리자 등록처리 
	@PostMapping("/admin_login_reg")
	public String addAdminInsert(){
		return "redirect:admin/login/admin_login_reg";
	}
	
	//관리자 아이디 중복 검사
	@GetMapping ("/admin_login_idcheck")
	public String CheckAdminId() {
		return "admin/login/admin_login_idcheck";
	}
	
	
	
}