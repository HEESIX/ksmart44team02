package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "/admin/Complain")
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
	public String getComplainList() {
		return null;
	}

	//회원 신고내역 삭제
	public int ComplainDelete() {
		return 0;
	}
}
