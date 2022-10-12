package ks44team02.buyer.controller;

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
@RequestMapping(value = "/buyer/login")
public class BuyerRegController {
	
	private static final Logger log = LoggerFactory.getLogger(BuyerRegController.class);

	private final LoginService loginService;
	
	public BuyerRegController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	

	//구매자 회원 등록 폼 
	@GetMapping("/buyerLoginReg")
	public String addBuyerInsertForm() {
		return "buyer/login/buyerLoginReg";
	}
	
	//구매자 회원 등록 처리
	@PostMapping("/buyerLoginReg")
	public String addBuyerInsert() {
		return "redirect:buyer/login/buyerLoginReg";
	}
	//구매자 아이디 중복 체크 
	@GetMapping("/buyerLoginIdcheck")
	@ResponseBody
	public boolean CheckBuyerId(@RequestParam(name="memberId")String memberId) {
		boolean result = loginService.idCheckBuyer(memberId);
		return result;
	}
	//구매자 등록시 핸드폰 중복 체크 
	@GetMapping("/buyerLoginNumcheck")
	public String CheckBuyerNum() {
		return "buyer/login/buyer_login_numcheck";
		}
		
	//구매자 회원정보 수정 폼
	@GetMapping("/buyer_login_update/{member_id}")
	public String getBuyerInfomation(@PathVariable(value="member_id")String member_id) {
		return "buyer/login/buyer_login_update";
				}		
	
	//구매자 회원정보 수정 처리
	@GetMapping("/buyer_login_update")
	public String modifyBuyer() {
		return "redirect:buyer/login/buyer_login_list";
				}	
				
}
