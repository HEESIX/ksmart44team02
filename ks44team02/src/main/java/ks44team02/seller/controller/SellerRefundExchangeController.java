package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.RefundExchangeService;

@Controller
@RequestMapping(value = "/seller/exchange_refund")
public class SellerRefundExchangeController {

	private final RefundExchangeService refundExchangeService;
	public SellerRefundExchangeController(RefundExchangeService refundExchangeService) {
		this.refundExchangeService = refundExchangeService;
	}
	//환불,교환 리스트 조회
	@GetMapping("/seller_exchange_refund_all_list")
	public String getRefundExchangeList(Model model) {
		return null;
	}
	
	/*
	//환불 승인
	@GetMapping
	public String refundSuccess(Model model) {
		return null;
	}
	//환불 승인처리
	@PostMapping
	public String refundSuccess() {
		return null;
	}*/
	
	//환불 처리 폼
	@GetMapping("/seller_refund")
	public String addRefundDeal(Model model) {
		return null;
	}
	//환불 처리
	@PostMapping("/seller_refund")
	public String addRefundDeal() {
		return null;
	}


}
