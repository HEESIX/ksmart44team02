package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Joinservice;

@Controller
@RequestMapping(value = "buyer/login")
public class BuyerJoinController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BuyerJoinController.class);
	
	private final Joinservice joinservice;
	
	public BuyerJoinController (Joinservice joinservice) {
		this.joinservice = joinservice;
	}
	
	//구매자 회원가입
	@GetMapping("/BuyerJoin")
	public String BuyerJoin() {
		return null;
	}

}