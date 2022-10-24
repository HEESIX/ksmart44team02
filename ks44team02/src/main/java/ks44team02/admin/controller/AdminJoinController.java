package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.Member;
import ks44team02.service.JoinService;


@Controller
@RequestMapping ("/admin/login")
public class AdminJoinController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminJoinController.class);

	private final JoinService joinService;
	

	public AdminJoinController (JoinService joinservice) {
		this.joinService = joinservice;
	}
	
	//관리자 회원 가입 폼
	/*
	@GetMapping("/adminLoginList")
	public String adminJoinForm() {
		return "admin/login/adminLoginList";
			
	}
	*/
	//관리자 회원 가입 처리
	
	@GetMapping("/adminJoin")
	public String adminJoin() {
		
		return "admin/login/adminJoin";
	}
	
	@PostMapping("/adminJoin")
	public String adminJoin(Member member) {
		log.info("member {}", member);
		joinService.adminJoin(member);
		return "redirect:/admin";
	}

}
	
	

