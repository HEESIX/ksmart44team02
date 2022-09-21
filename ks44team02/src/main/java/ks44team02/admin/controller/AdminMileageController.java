package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.MileageService;

@Controller
@RequestMapping(value = "/admin/Mileage")
public class AdminMileageController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final MileageService mileageService;

	public AdminMileageController(MileageService mileageService) {
		this.mileageService = mileageService;
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	
	//회원 적립금 조회
	public String getMileageList() {
		return null;
	}

	//회원 적립금 적립
	public int giveMileage() {
		return 0;
	}
	//회원 적립금 소멸
	public int MileageExtinction() {
		return 0;
	}
	

}
