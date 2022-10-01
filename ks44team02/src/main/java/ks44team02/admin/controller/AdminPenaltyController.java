package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.PenaltyService;

@Controller
@RequestMapping(value = "/admin")
public class AdminPenaltyController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final PenaltyService penaltyService;

	public AdminPenaltyController(PenaltyService penaltyService) {
		this.penaltyService = penaltyService;
	}

	@PostConstruct
	public void adminPenaltyControllerInit() {
		log.info("adminqnaControllerInit bean 생성");
	}
	
	//패널티 부여 폼
	@GetMapping("/pernaltyManage/givePenalty")
	public String givePenaltyForm() {
		return "admin/pernaltyManage/givePenalty";
	}
	
	//패널티 부여 처리
	@PostMapping("/pernaltyManage/givePenalty")
	public String givePenalty() {
		return"/admin/pernaltyManage/givePenalty";
	}

}
