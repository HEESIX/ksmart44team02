package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "seller/login")
public class SellerRegController {
	
	//판매 회원 등록
	@GetMapping("/seller_login_reg")
	public String addVenderInsert() {
		return "seller/login/seller_login_reg";
	}
	
	//판매 회원 등록시 아이디 중복 체크
		@GetMapping("/seller_login_idcheck")
		public String CheckVenderId() {
			return "seller/login/seller_login_idcheck";
		}	
		
	//판매 회원 등록시 핸드폰 중복 체크
		@GetMapping("/seller_login_numcheck")
		public String CheckVendernum() {
			return "seller/login/seller_login_numcheck";
		}
		
	//판매 회원 수정시 기존 데이터 불러오기
		@GetMapping("/seller_login_list")
		public String getVenderInfomation() {
				return "seller/login/seller_login_list";
				}	
	
	//판매 회원 정보 수정
		@GetMapping("/seller_login_update")
		public String modifyVender() {
				return "seller/login/seller_login_update";
				}	
		
}
