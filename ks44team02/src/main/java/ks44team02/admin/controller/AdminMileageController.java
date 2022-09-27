package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.Mileage;
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
	@GetMapping("/mileageManage/mileage_management")
	public String getMileageList(Model model) {
		List<Mileage> mileageList = mileageService.getMileageList();
		model.addAttribute("title", "회원 적립금 현황");
		model.addAttribute("mileageList", mileageList);
		return "admin/mileageManage/mileage_management";
	}
	
	//적립금 적립 폼
	@PostMapping("/mileageManage/mileage_give")
	public String giveMileage() {
		return "admin/mileageManage/mileage_give";
	}
	
	//적립금 소멸 폼
	@PostMapping("/mileageManage/mileage_extinct")
	public String MileageExtinction() {
		return "admin/mileageManage/mileage_extinct";
	}
	

}
