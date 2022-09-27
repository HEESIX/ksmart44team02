package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.MemberInfoservice;

@Controller
@RequestMapping(value = "buyer/login")
public class BuyerRegController {
	
	private static final Logger log = LoggerFactory.getLogger(BuyerRegController.class);

	private final MemberInfoservice memberInfoservice;
	
	public BuyerRegController (MemberInfoservice memberInfoservice) {
		this.memberInfoservice = memberInfoservice;
	}
	
	// 구매자 회원 리스트 
	@GetMapping("/buyer_login_list")
	public String BuyerInsertlist() {
		return "buyer/login/buyer_login_list";
	}

	//구매자 회원 등록 폼 
	@GetMapping("/buyer_login_reg")
	public String addBuyerInsertForm() {
		return "buyer/login/buyer_login_reg";
	}
	
	//구매자 회원 등록 처리
	@PostMapping("/buyer_login_reg")
	public String addBuyerInsert() {
		return "redirect:buyer/login/buyer_login_list";
	}
	//구매자 등록시 아이디 중복 체크 
	@GetMapping("/buyer_login_idcheck")
	public String CheckBuyerId() {
		return "buyer/login/buyer_login_idcheck";
	}
	//구매자 등록시 핸드폰 중복 체크 
	@GetMapping("/buyer_login_numcheck")
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
