package ks44team02.admin.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.Member;
import ks44team02.service.Loginservice;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminLoginController.class);
	
	private final Loginservice loginservice;
	

	public AdminLoginController (Loginservice loginservice) {
			this.loginservice = loginservice;
	}
	// 판매자 로그인
	@GetMapping("admin_login")
	public String adminLogin() {
		return "admin/login/admin_login";
	}
	
	//판매자 로그아웃
	public String adminlogout() {
		return "redirect:admin/login/admin_login_list";
	}

	//판매자 회원 정보
		@GetMapping("admin_login_list")
		public String adminLoginList(Model model
									,HttpSession session) {
			//세션 있을 경우 아래걸로 대체
			//String memberId = session.getAttribute("SID");
			String memberId = "id001";
			Member memberInfo = loginservice.getAdminMemberList(memberId);
			model.addAttribute("memberInfo", memberInfo);
			return "admin/login/admin_login_list";
		}
	
}
