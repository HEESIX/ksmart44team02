package ks44team02.buyer.controller;


import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.Cart;
import ks44team02.service.OrderService;

@Controller
@RequestMapping(value = "/buyer")
public class BuyerOrderController {

	private static final Logger log = LoggerFactory.getLogger(BuyerOrderController.class);

	private final OrderService orderService;
	
	public BuyerOrderController(OrderService OrderService) {
		this.orderService = OrderService;
	}
	
	@PostConstruct
	public void buyerOrderControllerInit() {
		log.info("BuyerOrderController bean 생성");
	}
	//주문 화면
	@GetMapping("/order/order")
	public String order(Model model) {
		
		
		return "buyer/order/order";
	}

	//주문 성공 화면
	@GetMapping("/order/orderSuccess")
	public String orderSuccess(Model model) {
		return "buyer/order/orderSuccess";
	}
	//주문 성공 처리
	@PostMapping("/mypage/orderStatus/orderSuccess")
	public String orderSuccess() {
		return "buyer/mypage/orderStatus/orderSuccess";
	}
	//결제 성공 화면
	@GetMapping("/order/paymentSuccess")
	public String paymentSuccess(Model model) {
		return "buyer/order/paymentSuccess";
	}
	//결제 성공 처리
	@PostMapping("/order/paymentSuccess")
	public String paymentSuccess() {
		return "buyer/order/paymentSuccess";
	}
	//주문 취소 화면
	@GetMapping("/mypage/orderStatus/orderCancel")
	public String orderCancel(Model model) {
		return "buyer/mypage/orderStatus/orderCancel";
	}
	//주문 취소 처리
	@PostMapping("/mypage/orderStatus/orderCancel")
	public String orderCancel() {
		return "redirect:/buyer/mypage/orderStatus/myorder_status_list";
	}
}

