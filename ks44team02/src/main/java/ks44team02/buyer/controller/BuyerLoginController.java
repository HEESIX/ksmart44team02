package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.LoginService;


@Controller
@RequestMapping(value = "/buyer/login")
public class BuyerLoginController {

	private static final Logger log = LoggerFactory.getLogger(BuyerLoginController.class);

	private final LoginService loginService;
	
	public BuyerLoginController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	//구매자 로그인
	@GetMapping("/buyerLogin")
	public String buyerLogin() {
		return "buyer/login/buyerLogin";
	}
	//구매자 로그아웃
	public String buyeLogout() {
		return "redirect:buyer/login/buerLoginList";
	}

	//구매자 회원정도 
	@GetMapping ("/buyerLoginList")
	public String buyerLoginList (Model model
									,HttpSession session) {
		// 세션 있을 경우 변경 필요
		String memberId = "id002";
		return "buyer/login/buyerLoginList";
		
	}
}
