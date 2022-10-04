package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ks44team02.service.JoinService;


@Controller
@RequestMapping ("/admin/login")
public class AdminJoinController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminJoinController.class);

	private final JoinService joinServie;

	public AdminJoinController (JoinService joinservie) {
		this.joinServie = joinservie;
	}
	
	//판매자 회원 가입
	@GetMapping("adminJoin")
	public String adminJoinForm() {
		return "admin/login/adminJoin";
			
	}
	
}
	
	

