package ks44team02.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {
	
	@GetMapping("/buyer")
	public String buyerMain() {
		return "buyer/buyerMain";
	}
}
