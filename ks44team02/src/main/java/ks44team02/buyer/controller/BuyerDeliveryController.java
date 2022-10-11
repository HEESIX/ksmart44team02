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
		@GetMapping("/myOrderStatusList")
		public String getOrderList(Model model
								  ,HttpSession session) {
			// 세션이 존재 하는 경우 세션에서 값을 가져와서 세팅: memberId
			//String memberId = session.getAttribute("SID");
			String memberId = "id002";
			List<Map<String, Object>> getOrderList = deliveryservice.getOrderList(memberId);
				model.addAttribute("title", "주문 리스트");
				model.addAttribute("getOrderList", getOrderList);
				
			return "buyer/mypage/orderStatus/myOrderStatusList";
		}
		
		// 상세주문현황 조회
		@GetMapping("/myOrderDeliveryDetail")
		public String getOrderStatus(Model model
									,@RequestParam(value = "orderGroupCode") String orderGroupCode) {
			List<Map<String, Object>> getOrderDetailList = deliveryservice.getOrderDetailList(orderGroupCode);
			Map<String, Object> getPaymentList = deliveryservice.getPaymentDetail(orderGroupCode);
			Map<String, Object> getDeliveryinfo = deliveryservice.getDeliveryinfo(orderGroupCode);
			
				model.addAttribute("title", "상세 주문리스트");
				model.addAttribute("getOrderDetailList", getOrderDetailList);
				model.addAttribute("getPaymentList", getPaymentList);
				model.addAttribute("getDeliveryinfo", getDeliveryinfo);
				return "buyer/mypage/orderStatus/myOrderDeliveryDetail";
		}

		
		
		// 환불 신청 폼
		@GetMapping("/myRefundApply")
		public String addRefundRequest(Model model) {
			return null;
		}
		
		// 환불 신청 제출 처리
		@PostMapping("/myRefundApply")
		public String addRefundRequest() {
			return null;
		}
		
		// 교환 신청 폼
		@GetMapping("/myExchangeApply")
		public String addExchangeRequest(Model model) {
			return null;
		}
		
		// 교환 신청 제출 처리
		@PostMapping("/myExchangeApply")
		public String addExchangeRequest() {
			return null;
		}
		
		// 취소/교환/환불 조회
		@GetMapping("/myOrderApplyList")
		public String getRefundExchangeList(Model model) {
			return null;
		}
		
}
