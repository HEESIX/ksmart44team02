package ks44team02.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.MemberInfoservice;

@Controller
@RequestMapping(value = "buyer/login")
public class BuyerRegController {
	
	private final MemberInfoservice memberInfoservice;
	
	public BuyerRegController (MemberInfoservice memberInfoservice) {
		this.memberInfoservice = memberInfoservice;
	}

	//구매자 회원 등록
	@GetMapping("/buyer_login_reg")
	public String addBuyerInsert() {
		return "buyer/login/buyer_login_reg";
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
		
	//구매자 회원정보 수정시 기존 데이터 불러오기 
				@GetMapping("/buyer_login_list")
				public String getBuyerInfomation() {
					return "buyer/login/buyer_login_list";
				}		
	
	//구매자 회원정보 수정 
				@GetMapping("/buyer_login_update")
				public String modifyBuyer() {
					return "buyer/login/buyer_login_update";
				}	
				
}
