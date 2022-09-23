package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "buyer/mypage/order")
public class BuyerDeliveryController {
		
		
		private static final Logger log = LoggerFactory.getLogger(BuyerDeliveryController.class);

	
		// 주문 목록 조회
		@GetMapping("/myorder_status_list")
		public String getOrderList() {
			return null;
		}
		
		// 상세주문현황 조회
		@GetMapping("/myorder_delivery_detail")
		public String getOrderStatus() {
			return null;
		}

		// 환불 신청 폼
		@GetMapping("/myrefund_apply")
		public String addRefundRequest(Model model) {
			return null;
		}
		
		// 환불 신청 제출 처리
		@PostMapping("/myrefund_apply")
		public String addRefundRequest() {
			return null;
		}
		
		// 교환 신청 폼
		@GetMapping("/myexchange_apply")
		public String addExchangeRequest(Model model) {
			return null;
		}
		
		// 교환 신청 제출 처리
		@PostMapping("/myexchange_apply")
		public String addExchangeRequest() {
			return null;
		}
		
		// 취소/교환/환불 조회
		@GetMapping("/myorder_apply_list")
		public String getRefundExchangeList() {
			return null;
		}
		
}