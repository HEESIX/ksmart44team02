package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.MemberInfoservice;

@Controller
@RequestMapping(value = "seller/login")
public class SellerRegController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerRegController.class);

	private final MemberInfoservice memberInfoservice;
	public SellerRegController (MemberInfoservice memberInfoservice) {
		this.memberInfoservice = memberInfoservice;
	}
	
	//판매 회원 정보 리스트 
	@GetMapping("seller_login_list")
	public String SellerInsertlist() {
		return "seller/login/seller_login_list";
	}
	
	//판매 회원 등록 폼
	@GetMapping("/seller_login_reg")
	public String addSellerForm() {
		return "seller/login/seller_login_reg";
	}

	//판매 회원 등록 처리
	@PostMapping("/seller_login_reg")
	public String addSellerInsert() {
		return "redirect:seller/login/seller_login_list";
	}
	
	//판매 회원 등록시 아이디 중복 체크
	@GetMapping("/seller_login_idcheck")
	public String CheckSellerId() {
		return "seller/login/seller_login_idcheck";
	}	
		
	//판매 회원 등록시 핸드폰 중복 체크
	@GetMapping("/seller_login_numcheck")
	public String CheckSellernum() {
		return "seller/login/seller_login_numcheck";
	}
		
	//판매 회원 수정 폼
	@GetMapping("/seller_login_update/{member_id}")
	public String getSellerInfomation(@PathVariable(value="member_id")String member_id) {
		return "seller/login/seller_login_update";
				}	
	
	//판매 회원 정보 수정 처리
	@GetMapping("/seller_login_update")
	public String modifySeller() {
		return "redirect:seller/login/seller_login_list";
				}	
		
}
