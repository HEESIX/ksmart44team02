package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks44team02.service.LoginService;



@Controller
@RequestMapping(value = "seller/login")
public class SellerRegController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerRegController.class);

	private final LoginService loginService;
	public SellerRegController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	//판매 회원 등록 폼
	@GetMapping("/sellerLoginReg")
	public String addSellerForm() {
		return "seller/login/sellerLoginReg";
	}

	//판매 회원 등록 처리
	@PostMapping("/sellerLoginReg")
	public String addSellerInsert() {
		return "redirect:seller/login/sellerLoginReg";
	}
	
	//판매 회원 등록시 아이디 중복 체크
	@GetMapping("/sellerLoginCheck")
	@ResponseBody
	public boolean CheckSellerId(@RequestParam(name="memberId")String memberId) {
		boolean result = loginService.idCheck(memberId);
		return result;
	}	
		
	//판매 회원 등록시 핸드폰 중복 체크
	@GetMapping("/sellerLoginNumcheck")
	public String CheckSellernum() {
		return "seller/login/sellerLoginNumcheck";
	}
		
	//판매 회원 수정 폼
	@GetMapping("/sellerLoginUpdate/{member_id}")
	public String getSellerInfomation(@PathVariable(value="member_id")String member_id) {
		return "seller/login/sellerLoginUpdate";
				}	
	
	//판매 회원 정보 수정 처리
	@GetMapping("/sellerLoginUpdate")
	public String modifySeller() {
		return "redirect:seller/login/sellerLoginUpdate";
				}	
		
}
