package ks44team02.buyer.controller;


import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/buyer")
public class BuyerOrderController {

	private static final Logger log = LoggerFactory.getLogger(BuyerOrderController.class);

	private final OrderService OrderService;
	
	public BuyerOrderController(OrderService OrderService) {
		this.OrderService = OrderService;
	}
	
	@PostConstruct
	public void buyerOrderControllerInit() {
		log.info("BuyerOrderController bean 생성");
	}
	//주문 화면
	@GetMapping("/order/order")
	public String order
	//주문 성공 화면
	@GetMapping("/mypage/orderStatus/order_success")
	public String orderSuccess(Model model) {
		return "buyer/mypage/orderStatus/order_success";
	}
	//주문 성공 처리
	@PostMapping("/mypage/orderStatus/order_success")
	public String orderSuccess() {
		return "buyer/mypage/orderStatus/order_success";
	}
	
	
}
