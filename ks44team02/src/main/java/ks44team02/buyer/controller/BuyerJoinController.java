package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.Member;
import ks44team02.service.JoinService;

@Controller
@RequestMapping(value = "/buyer/login")
public class BuyerJoinController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BuyerJoinController.class);
	
	private final JoinService joinService;
	
	public BuyerJoinController (JoinService joinService) {
		this.joinService = joinService;
	}
	
	//구매자 회원가입
	@GetMapping("/buyerJoin")
	public String buyerJoin() {
		return "buyer/login/buyerJoin";
	}
	
	@PostMapping("/buyerJoin")
	public String adminJoin(Member member) {
		log.info("member {}", member);
		joinService.adminJoin(member);
		return "redirect:/buyer/login/buyerLogin";
	}

				
		
	}
	

	
	