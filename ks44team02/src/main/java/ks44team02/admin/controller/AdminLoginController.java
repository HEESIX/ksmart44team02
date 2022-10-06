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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	//관리자 로그인
	@PostMapping("/adminLogin")
	public String login(@RequestParam(name="memberId") String memberId
					   ,@RequestParam(name="memberPw") String memberPw
					   ,RedirectAttributes reAttr
					   ,HttpSession session) {
	
		log.info("로그인 memberId ::: {}", memberId);
		log.info("로그인 memberPw ::: {}", memberPw);
		
		Member member = loginService.getMemberInfoById(memberId);
		
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
		return "redirect:/admin/login/adminLogin";
	}

	@GetMapping("/adminLogin")
	public String login(Model model
					   ,@RequestParam(value="msg", required = false) String msg) {
			
		model.addAttribute("title", "로그인 화면");
		if(msg != null) model.addAttribute("msg", msg);
			
		return "/admin/login/adminLogin";
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
	
	@GetMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(name="memberId") String memberId) {
		boolean result = loginService.idCheck(memberId);
	
		return result;
	}
	
	
}
