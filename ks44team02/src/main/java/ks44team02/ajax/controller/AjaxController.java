package ks44team02.ajax.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ajax")
public class AjaxController {
	
	// 세션의 아이디와 비교하여 비밀번호 체크
	@PostMapping("/idCheck")
	public boolean idCheck(@RequestParam(value = "memberPw") String memberPw
						  ,HttpSession session) {
		return false;
	}
	
}
