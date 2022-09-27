package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.PenaltyService;

@Controller
@RequestMapping(value = "/admin/penalty")
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
	
	//패널티 부여
	public int givePenalty() {
		return 0;
	}

}
