package ks44team02.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.Member;
import ks44team02.service.LoginService;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminLoginController.class);
	
	private final LoginService loginService;
	

	public AdminLoginController (LoginService loginService) {
			this.loginService = loginService;
	}
	// 관리자 로그인
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "admin/login/adminLogin";
	}
	
	//관리자 로그아웃
	public String adminlogout() {
		return "redirect:admin/login/adminLoginList";
	}

	//관리자 회원 정보
	@GetMapping("/adminLoginList")
	public String adminLoginList(Model model
								,HttpSession session) {
		//세션 있을 경우 아래걸로 대체
		//String memberId = session.getAttribute("SID");
		String memberId = "id001";
		//Member memberInfo = loginService.getMemberListAdmin(memberId);
		//model.addAttribute("memberInfo", memberInfo);
		return "admin/login/adminLoginList";
	}
	
	
	//관리자가 전체 회원 정보 
	@GetMapping("/memberListAdmin")
	public String getMemberListAdmin (Model model
									 ,@RequestParam(value = "sk", required = false) String sk
									 ,@RequestParam(value = "sv", required = false) String sv) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(sk, sv);
		List<Member> memberListAdmin = loginService.getMemberListAdmin(map);
		log.info(">>>>>>>>>>>> {}", memberListAdmin);
		model.addAttribute("title","회원정보리스트");
		model.addAttribute("memberListAdmin", memberListAdmin);
		return "admin/login/memberListAdmin";
		
		
		
	}
	
	
	
}
