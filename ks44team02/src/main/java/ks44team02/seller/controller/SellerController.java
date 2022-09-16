package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {
	
	@GetMapping("/seller")
	public String sellerMain() {
		return "seller/sellerMain";
	}

}
