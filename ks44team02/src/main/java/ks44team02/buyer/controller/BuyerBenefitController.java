package ks44team02.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks44team02.dto.BuyerBenefit;
import ks44team02.service.DiscountService;

@Controller
public class BuyerBenefitController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BuyerBenefitController.class);

	
	private final DiscountService discountService;
	
	public BuyerBenefitController(DiscountService discountService) {
		this.discountService = discountService;
	}
	
	// 구매자별 보유 혜택 목록 조회, 본인이 소지한 혜택만 조회 가능
	@GetMapping("/buyer/mypage/buyerBenefit/buyerBenefitList")
	public String getBenefitList(Model model
								,HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		//세션이 생기면 아래 조건문은 주석처리 해야함
		if(sessionId == null)  sessionId = "id002";
		List<BuyerBenefit> buyerBenefitList = discountService.getBuyerBenefitList(sessionId);
		System.out.println(buyerBenefitList.toString());
		model.addAttribute("title", "할인 혜택 조회");
		model.addAttribute("buyerBenefitList", buyerBenefitList);
		
		return "buyer/mypage/buyerBenefit/buyerBenefitList";
	}
	
}
