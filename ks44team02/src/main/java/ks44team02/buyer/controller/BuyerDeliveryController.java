package ks44team02.buyer.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.OrderRecordList;
import ks44team02.dto.OrderRefund;
import ks44team02.service.DeliveryService;

@Controller
@RequestMapping(value = "buyer/mypage/orderStatus")
public class BuyerDeliveryController {
		
		
		private static final Logger log = LoggerFactory.getLogger(BuyerDeliveryController.class);

		private final DeliveryService deliveryservice;
		
		public BuyerDeliveryController(DeliveryService deliveryservice) {
			this.deliveryservice = deliveryservice;
		}

	
		// 주문 목록 조회
		@GetMapping("/myorder_status_list")
		public String getOrderList(Model model
								  ,HttpSession session) {
			// 세션이 존재 하는 경우 세션에서 값을 가져와서 세팅: memberId
			//String memberId = session.getAttribute("SID");
			String memberId = "id002";
			List<Map<String, Object>> getOrderList = deliveryservice.getOrderList(memberId);
				model.addAttribute("title", "주문 리스트");
				model.addAttribute("getOrderList", getOrderList);
				
			return "buyer/mypage/orderStatus/myorder_status_list";
		}
		
		// 상세주문현황 조회
		@GetMapping("/myorder_delivery_detail")
		public String getOrderStatus(Model model
									,@RequestParam(value = "orderGroupCode") String orderGroupCode) {
			List<Map<String, Object>> getOrderDetailList = deliveryservice.getOrderStatus(orderGroupCode);
			Map<String, Object> getPaymentList = deliveryservice.getPaymentDetail(orderGroupCode);
			
				model.addAttribute("title", "상세 주문리스트");
				model.addAttribute("getOrderDetailList", getOrderDetailList);
				model.addAttribute("getPaymentList", getPaymentList);
				return "buyer/mypage/orderStatus/myorder_delivery_detail";
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
		public String getRefundExchangeList(Model model) {
			return null;
		}
		
}
