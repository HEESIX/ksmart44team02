package ks44team02.buyer.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.dto.MemberMileageAcc;
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
	public void BuyerMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	
	//회원 적립금 조회
	@GetMapping("/mileageList")
	public String getBuyerMileageList(Model model) {
		log.info("/Mileage/mileageList getBuyerMileageList BuyerMileageController");
		System.out.println("/Mileage/mileageList getBuyerMileageList BuyerMileageController");
		List<MemberMileageAcc> mileageList = mileageService.getMileageList();
		System.out.println(mileageList.toString());
		model.addAttribute("title", "회원 적립금 현황");
		model.addAttribute("mileageList", mileageList);
		return "/buyer/Mileage/mileageList";
	}
}
