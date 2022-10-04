package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.buyer.controller.BuyerOrderController;
import ks44team02.service.AdminCalculateService;

@Controller
@RequestMapping(value = "/admin/calculatepage")
public class AdminCalculateController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminCalculateController.class);

	private final AdminCalculateService adminCalculateService;
	
	public AdminCalculateController(AdminCalculateService adminCalculateService) {
		this.adminCalculateService = adminCalculateService;
	}
	
	//판매자 일일 정산금 확인
	@GetMapping("/adminSellerDailyCalculate")
	public String sellerTodayCalculate() {
		return "admin/calculatepage/adminSellerDailyCalculate";
	}
			
	//관리자 수수료 확인
	@GetMapping("/adminFeeCheck")
	public String adminFeeCheck() {
		return "admin/calculatepage/adminFeeCheck";
	}
			
	//관리자 수수료 정산
	@GetMapping("/adminFeeCalculate")
	public String adminFeeCalculate() {
		return "admin/calculatepage/adminFeeCalculate";
	}
			
	//판매자 정산금 정산
	@GetMapping("/adminSellerCalculate")
	public String sellerCalculateSuccess() {
		return "admin/calculatepage/adminSellerCalculate";
	}
}
