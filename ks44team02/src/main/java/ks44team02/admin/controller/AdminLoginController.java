package ks44team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Loginservice;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminLoginController {
	
	private final Loginservice loginservice;
	
	public AdminLoginController (Loginservice loginservice) {
			this.loginservice = loginservice;
	}
	
	@GetMapping("admin_login_list")
	public String adminLogin() {
		return "admin/login/admin_login_list";
	}
	public String adminlogout() {
		return "admin/login/admin_login_list";
	}

	
}
