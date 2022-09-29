package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Loginservice;

@Controller
@RequestMapping(value = "/seller/login")
public class SellerLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerLoginController.class);

	private final Loginservice loginService;
	
	public SellerLoginController (Loginservice loginService) {
		this.loginService = loginService;
	}
	
	//판매자 로그인
	@GetMapping("/seller_login")
	public String sellerLogin() {
		return "seller/login/seller_login";
	}
	//판매자 로그아웃
	public String sellerlogout() {
		return null;
	}
	

	
}
