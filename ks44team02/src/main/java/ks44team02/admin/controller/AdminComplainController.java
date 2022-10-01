package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "/admin")
public class AdminComplainController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final ComplainService complainService;

	public AdminComplainController(ComplainService complainService) {
		this.complainService = complainService;
	}

	@PostConstruct
	public void adminComplainControllerInit() {
		log.info("adminComplainControllerInit bean 생성");
	}
	
	//회원 신고내역 조회
	@GetMapping("/complainManage/complainList")
	public String getComplainList() {
		return "admin/complainManage/complainList";
	}

	//회원 신고내역 삭제 폼
	@GetMapping("/complainManage/complainDelete")
	public String ComplainDeleteForm() {
		return "admin/complainManage/complainDelete";
	}
	
	//회원 신고내역 삭제처리
	@PostMapping("/complainManage/complainDelete/{complainCode}")
	public String ComplainDelete( ) {
		return "admin/complainManage/complainDelete";
	}
}
