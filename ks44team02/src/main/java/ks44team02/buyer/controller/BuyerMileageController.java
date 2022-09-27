package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.service.MileageService;

@Controller
@RequestMapping(value = "/buyer/Mileage")
public class BuyerMileageController {
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final MileageService mileageService;

	public BuyerMileageController(MileageService mileageService) {
		this.mileageService = mileageService;
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	
	//회원 적립금 조회
	public String getBuyerMileageList() {
		return null;
	}
}
