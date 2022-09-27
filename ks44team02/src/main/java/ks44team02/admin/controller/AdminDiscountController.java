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
	@GetMapping("/orderDiscountList")
	public String getOrderDiscountList(Model model) {
		List<OrderDiscount> orderDiscountList = discountService.getOrderDiscountList();
		
		model.addAttribute("title", "주문서별 할인혜택 목록");
		model.addAttribute("orderDiscountList", orderDiscountList);
		
		return "admin/orderDiscount/orderDiscountList";
	}
	//주문서별 할인혜택 등록 폼
	@GetMapping("/addOrderDiscount")
	public String addOrderDiscount(Model model) {
		
		model.addAttribute("title", "주문서별 할인혜택 등록");

		return "admin/orderDiscount/addOrderDiscount";
	}
	//주문서별 할인혜택 등록 처리
	@PostMapping("/addOrderDiscount")
	public String addOrderDiscount(OrderDiscount orderDiscount
								  ,RedirectAttributes reAttr) {
		
		boolean result = discountService.addOrderDiscount(orderDiscount);
		String msg = "";
		if (result) {
			msg = "등록 성공";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg);
		
		return "redirect:/admin/orderDiscont/addOrderDiscount";
	}
	//주문서별 할인혜택 수정 폼
	@GetMapping("/modifyOrderDiscount/{orderDiscountCode}")
	public String modifyOrderDiscount(@PathVariable(value = "orderDiscountCode") String orderDiscountCode
									,Model model) {
		
		OrderDiscount orderdiscountList = discountService.getOrderDiscountInfo(orderDiscountCode);
		
		model.addAttribute("title","주문서별 할인혜택 수정");
		model.addAttribute("orderdiscountList", orderdiscountList);
		
		return "admin/orderDiscount/modifyOrderDiscount";
	}
	//주문서별 할인혜택 수정 처리
	@PostMapping("/modifyOrderDiscount")
	public String modifyOrderDiscount(OrderDiscount orderDiscount
			
			,RedirectAttributes reAttr) {
		boolean result = discountService.modifyOrderDiscount(orderDiscount);
		
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		
		return "redirect:/admin/orderDiscont/orderDiscountCode";
	}
	//주문서별 할인혜택 삭제 처리
	@PostMapping("/removeOrderDiscount/{order_discount_code}")
	public String removeOrderDiscount(@PathVariable(value = "order_discount_code") String order_discount_code) {
		
		return "redirect:/admin/orderDiscont/orderDiscountList";
	}
}
