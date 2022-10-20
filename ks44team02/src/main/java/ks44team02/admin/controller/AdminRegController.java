package ks44team02.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks44team02.dto.Member;
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
	
	//관리자 가입 
	@PostMapping("/adminLoginReg")
	public String addAdmin(Member member){
		log.info("사용자가 입력한 회원의 정보 ::: {}", member);
		System.out.println("사용자가 입력한 회원의 정보 -> " + member);
		loginService.addAdmin(member);
		return "redirect:admin/login/adminLoginReg";
	}
	
	@GetMapping("/adminLoginReg")
	public String addAdminForm (Model model) {
		List<Member> member = loginService.getAddAdmin();
		model.addAttribute("tittle","회원가입");
		model.addAttribute("member", member);
		return "admin/login/adminLoginReg";
	}
	
	
	
	
	
	
	//관리자 아이디 중복 검사
	@GetMapping ("/adminLoginIdcheck")
	@ResponseBody
	public boolean CheckAdminId(@RequestParam(name="memberId") String memberId) {
		boolean result = loginService.idCheck(memberId);
		return result;
	}
	
	
	
}