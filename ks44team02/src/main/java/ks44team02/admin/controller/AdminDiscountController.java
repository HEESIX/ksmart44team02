package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.DiscountService;

@Controller
@RequestMapping(value = "/admin/orderDiscount")
public class AdminDiscountController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdminDiscountController.class);

	private final DiscountService DiscountService;
	
	public AdminDiscountController(DiscountService DiscountService) {
		this.DiscountService = DiscountService;
	}
	
	@PostConstruct
	public void adminDiscountControllerInit() {
		log.info("AdminDiscountController bean 생성");
	}
	//주문서별 할인혜택 목록 조회 폼
	@GetMapping("/order_discount_list")
	public String getOrderDiscountList() {
		return "admin/orderDiscount/order_discount_list";
	}
	//주문서별 할인혜택 등록 폼
	@GetMapping("/add_order_discount")
	public String addOrderDiscount(Model model) {
		return null;
	}
	//주문서별 할인혜택 등록 처리
	@PostMapping("/add_order_discount")
	public String addOrderDiscount() {
		return null;
	}
	//주문서별 할인혜택 수정 폼
	@GetMapping("/modify_order_discount")
	public String modifyOrderDiscount(Model model) {
		return null;
	}
	//주문서별 할인혜택 수정 처리
	@PostMapping("/modify_order_discount")
	public String modifyOrderDiscount() {
		return null;
	}
	//주문서별 할인혜택 삭제 처리
	@PostMapping("/remove_order_discount")
	public String removeOrderDiscount() {
		return null;
	}
}
