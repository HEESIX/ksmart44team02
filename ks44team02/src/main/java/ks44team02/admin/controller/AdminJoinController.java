package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ks44team02.service.Joinservice;


@Controller
@RequestMapping ("/admin/login")
public class AdminJoinController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminJoinController.class);

	private final Joinservice joinservie;

	public AdminJoinController (Joinservice joinservie) {
		this.joinservie = joinservie;
	}
	
	//판매자 회원 가입
	@GetMapping("admin_join")
	public String adminJoinForm() {
		return "admin/login/admin_join";
			
	}
	
}
	
	

