package ks44team02.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.RefundExchangeReasons;
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
	public String getRefundExchangeReasonList(Model model
											,@RequestParam(value = "msg", required = false) String msg) {
		List<RefundExchangeReasons> refundExchangeReasonList = adminDeliveryeService.getRefundExchangeReasonList();
		
		model.addAttribute("titele", "환불/교환사유 목록");
		model.addAttribute("refundExchangeReasonList", refundExchangeReasonList);
		if(msg!=null) model.addAttribute("msg", msg);
		
		return "admin/order/refundExchangeReasonList";
	}
}

