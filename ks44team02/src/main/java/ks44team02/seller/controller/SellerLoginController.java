package ks44team02.seller.controller;


import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Member;
import ks44team02.service.LoginService;

@Controller
@RequestMapping(value = "/seller/login")
public class SellerLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerLoginController.class);

	private final LoginService loginService;
	
	public SellerLoginController (LoginService loginService) {
		this.loginService = loginService;
	}
	//판매자 로그아웃 
	@GetMapping("/sellerLogout")
	public String logout(HttpSession session) {
		//세션 객체 초기화
		session.invalidate();
		
		return "redirect:/seller/login/sellerLogout";
	}
	//판매자 로그인
		@PostMapping("/sellerLogin")
		public String login(@RequestParam(name="memberId") String memberId
						   ,@RequestParam(name="memberPw") String memberPw
						   ,RedirectAttributes reAttr
						   ,HttpSession session) {
		
			log.info("로그인 memberId ::: {}", memberId);
			log.info("로그인 memberPw ::: {}", memberPw);
			
			Member member = loginService.getMemberInfoById(memberId);
			log.info("member {}");
			if(member != null) {
				String checkPw = member.getMemberPw();
				
				if(memberPw != null && checkPw.equals(memberPw)) {
					session.setAttribute("SID", memberId);
					session.setAttribute("SNAME", member.getMemberName());
					session.setAttribute("SLEVEL", member.getMemberLevelCode());
					// 회원의 정보가 일치하면
					return "redirect:/";
				}
			}	
			reAttr.addAttribute("msg", "회원의 정보가 일치하지 않습니다.");
			return "redirect:/seller/login/sellerLogin";
		}

		@GetMapping("/sellerLogin")
		public String login(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
				
			model.addAttribute("title", "로그인 화면");
			if(msg != null) model.addAttribute("msg", msg);
				
			return "/seller/login/sellerLogin";
		}
	
		//아이디 중복 체크 
		@GetMapping("/sellerLoginIdCheck")
		@ResponseBody
		public boolean idCheck(@RequestParam(name="memberId") String memberId) {
			boolean result = loginService.idCheck(memberId);
			return result;
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
