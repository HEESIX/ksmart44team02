package ks44team02.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminCalculateService {
	
	//판매자 일일 정산금 확인
		@GetMapping("/admin_seller_daily_calculate")
		public String sellerTodayCalculate() {
			return "admin/calculatepage/admin_seller_daily_calculate";
		}
		
		//관리자 수수료 확인
		@GetMapping("/admin_fee_check")
		public String adminFeeCheck() {
			return "admin/calculatepage/admin_fee_check";
		}
		
		//관리자 수수료 정산
		@GetMapping("/adminFeeCalculate")
		public String admin_fee_calculate() {
			return "admin/calculatepage/adminFeeCalculate";
		}
		
		//판매자 정산금 정산
		@GetMapping("/admin_fee_calculate")
		public String sellerCalculateSuccess() {
			return "admin/calculatepage/admin_fee_calculate";
		}
	}