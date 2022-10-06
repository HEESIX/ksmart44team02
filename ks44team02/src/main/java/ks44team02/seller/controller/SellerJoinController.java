package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.LoginService;

@Controller
@RequestMapping(value = "/seller/login")
public class SellerJoinController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerJoinController.class);
	
	private final LoginService loginService;
	
	public SellerJoinController (LoginService loginService) {
		this.loginService = loginService;
	}
	//판매자 회원가입
	@GetMapping("/sellerJoin")
	public String sellerJoin() {
		return "seller/login/sellerJoin";
	}

}
 