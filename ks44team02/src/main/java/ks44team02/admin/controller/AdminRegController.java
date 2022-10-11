package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks44team02.service.LoginService;



@Controller
@RequestMapping(value = "/admin/login")
public class AdminRegController {
	private static final Logger log = LoggerFactory.getLogger(AdminRegController.class);

	private final LoginService loginService;
	
	public AdminRegController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	// 관리자 등록 폼
	@GetMapping("/adminLoginRegForm")
	public String addAdminForm() {
		return "admin/login/adminLoginRegForm";
	}
	
	//관리자 등록처리 
	@PostMapping("/adminLoginReg")
	public String addAdminInsert(){
		return "redirect:admin/login/adminLoginReg";
	}
	
	//관리자 아이디 중복 검사
	@GetMapping ("/adminLoginIdcheck")
	@ResponseBody
	public boolean CheckAdminId(@RequestParam(name="MemberId")String memberId) {
		boolean result = loginService.idCheck(memberId);
		return result;
	}
	
	
	
}