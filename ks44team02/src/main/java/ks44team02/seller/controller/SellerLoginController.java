package ks44team02.seller.controller;


import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.LoginService;

@Controller
@RequestMapping(value = "/seller/login")
public class SellerLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerLoginController.class);

	private final LoginService loginService;
	
	public SellerLoginController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	//판매자 로그인
	@GetMapping("/sellerLogin")
	public String sellerLogin() {
		return "seller/login/sellerLogin";
	}

	//판매자 로그아웃
	
	/* @GetMapping("/sellerLogout")
	public String sellerlogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication  = 
				SecurityContextHolder.getContext().getAuthentication();

		if(authentication != null){
			new SecurityContextLogoutHandler().logout(request,response,authentication);
			        }
		return "redirect:/";
	}
	
	*/
	
	//관리자 회원 정보
		@GetMapping("/sellerLoginList")
		public String adminLoginList(Model model
									,HttpSession session) {
			//세션 있을 경우 아래걸로 대체
			//String memberId = session.getAttribute("SID");
			String memberId = "id005";
			//Member memberInfo = loginService.getMemberListAdmin(memberId);
			//model.addAttribute("memberInfo", memberInfo);
			return "seller/login/sellerLoginList";
		}
	
}
