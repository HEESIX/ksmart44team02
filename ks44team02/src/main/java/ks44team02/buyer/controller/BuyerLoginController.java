package ks44team02.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Loginservice;


@Controller
@RequestMapping(value = "buyer/login")
public class BuyerLoginController {
	
	private final Loginservice loginService;
	
	public BuyerLoginController (Loginservice loginService) {
		this.loginService = loginService;
	}
	
	
	//구매자 로그인
	@GetMapping("/buer_login")
	public String buyerLogin() {
		return "buyer/login/buer_login";
	}
	//구매자 로그아웃
	public String buyelogout() {
		return "buyer/login/buer_login_list";
	}

}
