package ks44team02.buyer.controller;

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

import ks44team02.dto.Complain;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.Review;
import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "/buyer/complain")
public class buyerComplainController {

	
	private static final Logger log = LoggerFactory.getLogger(buyerComplainController.class);

	
	private final ComplainService complainService;
	
	public buyerComplainController(ComplainService complainService) {
		
	   this.complainService = complainService;
	}
	
	@PostConstruct
	public void buyerComplainControllerInit() {
		log.info("buyerComplainControllerInit bean 생성");
	}
	
	//구매자 신고 등록 폼
	@GetMapping("/regComplain")
	public String regBuyerComplainForm(@PathVariable(value = "complainContent") String complainContent,
										@PathVariable(value = "complainTitle") String complainTitle
			,Model model
			,Model model1) {
		
		Complain complainInfo = complainService.getComplainInfo(complainContent,complainTitle);
		
		model.addAttribute("title", "신고 내용 작성");
		model1.addAttribute("title", "신고제목 작성");
		model.addAttribute("complainInfo", complainInfo);
		return "/buyer/complain/regComplain";
		
	}
	
	//구매자 신고 등록 처리
	@PostMapping("/regComplain")
	public String regBuyerComplain(Complain complain, RedirectAttributes reAttr) {

		boolean result = complainService.regBuyerComplain(complain);

		if (result) {
			reAttr.addAttribute("msg", "신고 완료");
		} else {
			reAttr.addAttribute("msg", "신고 실패");
		}

		return "redirect:/buyer/complain/regComplain";
	}
	
	
}
