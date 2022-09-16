package ks44team02.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {
	
	@GetMapping("/vendor")
	public String vendorMain() {
		return "vendor/vendorMain";
	}

}
