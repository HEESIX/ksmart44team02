package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Gradeservice;

@Controller
@RequestMapping(value = "/admin/gradeDetails")
public class BuyerGradeController {
	
	private static final Logger log = LoggerFactory.getLogger(BuyerGradeController.class);

	private final Gradeservice gradeservice;

	public BuyerGradeController(Gradeservice gradeservice) {
		this.gradeservice = gradeservice;
	}
	// 구매자 등급 정의 등록 폼 
	@GetMapping("/buyer_gradeform")
	public String getbuyerGradeForm() {
		return "admin/gradeDetails/buyer_gradeform";
	}
	
	// 구매자 등급 정의 등록 처리 
	@PostMapping("/buyer_gradeform")
	public String getbuyerGrade() {
		return "redirect:admin/gradeDetails/buyer_gradelist";
	}	
	
	// 구매자 등급 정의 리스트
	@GetMapping("/buyer_gradelist")
	public String getbuyerGradeList() {
		return "admin/gradeDetails/buyer_gradelist";
	}
	
	//구매자 등급 정의 수정폼 
	@GetMapping("/buyer_modifylist/{consumer_level_states_code}")
	public String ModifybuyerGradeForm(@PathVariable(value = "consumer_level_states_code") 
			String consumer_level_states_code) {
				return "admin/gradeDetails/buyer_modifylist";
	}
	
	
	//구매자 등급 정의 수정 처리 
	@PostMapping("/buyer_modifylist")
	public String ModifybuyerGrade() {
		return "redirect:admin/gradeDetails/buyer_gradelist";
		}
	
	
	//구매자 등급 정의 삭제 처리
	@PostMapping("/buyer_removelist/{consumer_level_states_code}")
	public String RemovebuyerGrade(@PathVariable(value = "consumer_level_states_code") 
	String consumer_level_states_code) {
		return "redirect:admin/gradeDetails/buyer_gradelist";
			}
}
