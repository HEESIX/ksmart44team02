package ks44team02.buyer.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

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
	//주문 화면 조회
	@GetMapping("/order/order")
	public String order(Model model
					   ,HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		//세션이 생기면 아래 조건문은 주석처리 해야함
		if(sessionId == null)  sessionId = "id002";
		
		
		return "buyer/order/order";
	}
	//주문 처리
	@PostMapping("/order/order")
	public String order() {
		return "redirect:/buyer/order/orderSuccess";
	}
	//주문 성공 화면
	@GetMapping("/order/orderSuccess")
	public String orderSuccess(Model model) {
		return "buyer/order/orderSuccess";
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

