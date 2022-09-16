package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "seller/login")
public class SellerLoginController {
	
	@GetMapping("/seller_login_list")
	public String sellerLogin() {
		return "seller/login/seller_login_list";
	}
}
