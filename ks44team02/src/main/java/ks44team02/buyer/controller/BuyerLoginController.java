package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Member;
import ks44team02.service.LoginService;


@Controller
@RequestMapping(value = "/buyer/login")
public class BuyerLoginController {

	private static final Logger log = LoggerFactory.getLogger(BuyerLoginController.class);

	private final LoginService loginService;
	
	public BuyerLoginController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	//구매자 로그인
		@PostMapping("/buyerLogin")
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
			return "redirect:/buyer/login/buyerLogin";
		}

		@GetMapping("/buyerLogin")
		public String login(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
				
			model.addAttribute("title", "로그인 화면");
			if(msg != null) model.addAttribute("msg", msg);
				
			return "/buyer/login/buyerLogin";
		}
	//구매자 로그아웃
	public String buyeLogout() {
		return "redirect:buyer/login/buerLoginList";
	}

	//구매자 회원 정보
	@GetMapping ("/buyerLoginList")
	public String buyerLoginList (Model model
									,HttpSession session) {
		// 세션 있을 경우 변경 필요
		String memberId = "id002";
		return "buyer/login/buyerLoginList";
		
	}
}
