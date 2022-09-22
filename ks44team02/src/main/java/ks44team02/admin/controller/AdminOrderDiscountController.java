package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.OrderDiscountService;

@Controller
@RequestMapping(value = "/admin/orderDiscount")
public class AdminOrderDiscountController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdminOrderDiscountController.class);

	private final OrderDiscountService orderDiscountService;
	
	public AdminOrderDiscountController(OrderDiscountService orderDiscountService) {
		this.orderDiscountService = orderDiscountService;
	}
	
	@PostConstruct
	public void adminOrderDiscountControllerInit() {
		log.info("AdminOrderDiscountController bean 생성");
	}
	//주문별 할인혜택 목록 조회
	@GetMapping("/order_discount_list")
	public String getOrderdiscountList() {
		return null;
	}
	//주문별 할인혜택 등록
	@GetMapping("/add_order_discount")
	public String addOrderDiscount(Model model) {
		return null;
	}
	@PostMapping("/add_order_discount")
	public String addOrderDiscount() {
		return null;
	}
	//주문별 할인혜택 수정
	@GetMapping("/modify_order_discount")
	public String modifyOrderDiscount(Model model) {
		return null;
	}
	@PostMapping("/modify_order_discount")
	public String modifyOrderDiscount() {
		return null;
	}
	//주문별 할인혜택 삭제
	@PostMapping("/remove_order_discount")
	public String removeOrderDiscount() {
		return null;
	}
}
