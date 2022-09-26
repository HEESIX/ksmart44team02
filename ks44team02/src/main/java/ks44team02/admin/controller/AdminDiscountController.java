package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.OrderDiscount;
import ks44team02.service.DiscountService;

@Controller
@RequestMapping(value = "/admin/orderDiscount")
public class AdminDiscountController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdminDiscountController.class);

	private final DiscountService discountService;
	
	public AdminDiscountController(DiscountService DiscountService) {
		this.discountService = DiscountService;
	}
	
	@PostConstruct
	public void adminDiscountControllerInit() {
		log.info("AdminDiscountController bean 생성");
	}
	//주문서별 할인혜택 목록 조회 폼
	@GetMapping("/order_discount_list")
	public String getOrderDiscountList(Model model) {
		List<OrderDiscount> orderDiscountList = discountService.getOrderDiscountList();
		model.addAttribute("title", "주문서별 할인혜택 목록");
		model.addAttribute("orderDiscountList", orderDiscountList);
		return "admin/orderDiscount/order_discount_list";
	}
	//주문서별 할인혜택 등록 폼
	@GetMapping("/add_order_discount")
	public String addOrderDiscount(Model model) {

		return "admin/orderDiscount/add_order_discount";
	}
	//주문서별 할인혜택 등록 처리
	@PostMapping("/add_order_discount")
	public String addOrderDiscount() {
		return "redirect:/admin/orderDiscont/order_discount_list";
	}
	//주문서별 할인혜택 수정 폼
	@GetMapping("/modify_order_discount/{orderDiscountCode}")
	public String modifyOrderDiscount(@PathVariable(value = "orderDiscountCode") String orderDiscountCode
									,Model model) {
		OrderDiscount orderdiscountList = discountService.getOrderDiscountInfo(orderDiscountCode);
		return "admin/orderDiscount/modify_order_discount";
	}
	//주문서별 할인혜택 수정 처리
	@PostMapping("/modify_order_discount")
	public String modifyOrderDiscount(OrderDiscount orderDiscount
			
			,RedirectAttributes reAttr) {
		boolean result = discountService.modifyOrderDiscount(orderDiscount);
		
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		return "redirect:/admin/orderDiscont/order_discount_list";
	}
	//주문서별 할인혜택 삭제 처리
	@PostMapping("/remove_order_discount/{order_discount_code}")
	public String removeOrderDiscount(@PathVariable(value = "order_discount_code") String order_discount_code) {
		return "redirect:/admin/orderDiscont/order_discount_list";
	}
}
