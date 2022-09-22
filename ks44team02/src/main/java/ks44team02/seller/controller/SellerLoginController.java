package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/seller/login")
public class SellerLoginController {
	
	//판매자 로그인
	@GetMapping("/seller_login_lis")
	public String sellerLogin() {
		return "seller/login/seller_login_list";
	}
	//판매자 로그아웃
	public String sellerlogout() {
		return "seller/login/seller_login_list";
	}
}
