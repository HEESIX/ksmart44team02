package ks44team02.vendor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendorController {
	
	@GetMapping("/vendor")
	public String vendorMain() {
		return "vendor/vendorMain";
	}

}
