package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.AdminDeliveryeService;

@Controller
@RequestMapping(value = "/admin/order")
public class AdminDeliveryController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdminDeliveryController.class);
	
	private final AdminDeliveryeService adminDeliveryeService;
	
	public AdminDeliveryController(AdminDeliveryeService adminDeliveryeService) {
		this.adminDeliveryeService = adminDeliveryeService;
	}
	
	
	//구매자의 배송현황 조회
	@GetMapping("/buyerOrderDeliveryStatus")
	public String getAdminOrderStatusList() {
		return null;
	}

	//환불 사유 카테고리 등록
	@GetMapping("/refundExchangeReasonAdd")
	public String addRefundExchangeReason(Model model) {
		return null;
	}

	//환불 사유 카테고리 등록 처리
	@PostMapping("/refundExchangeReasonAdd")
	public String addRefundExchangeReason() {
		return null;
	}

	//환불 사유 카테고리 수정
	@GetMapping("/refundExchangeReasonModify/{refund_exchange_reasons_code}")
	public String modifyRefundExchangeReason(@PathVariable(value = "refund_exchange_reasons_code") String refund_exchange_reasons_code) {
		return null;
	}
	
	//환불 사유 카테고리 수정 처리
	@PostMapping("/refundExchangeReasonModify")
	public String modifyRefundExchangeReason() {
		return null;
	}
	
	//환불 사유 카테고리 리스트
	@GetMapping("/refundExchangeReasonList")
	public String getRefundExchangeReasonList() {
		return null;
	}
}

