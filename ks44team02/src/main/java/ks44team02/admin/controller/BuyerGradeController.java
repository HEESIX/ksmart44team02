package ks44team02.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ks44team02.dto.Grade;
import ks44team02.service.GradeService;

@Controller
@RequestMapping(value = "/admin/gradeDetails")
public class BuyerGradeController {
	
	private static final Logger log = LoggerFactory.getLogger(BuyerGradeController.class);

	private final GradeService gradeService;

	public BuyerGradeController(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	// 구매자 등급 정의 등록 폼 
	@GetMapping("/buyerGradeForm")
	public String getBuyerGradeForm() {
		return "admin/gradeDetails/buyerGradeForm";
	}
	
	// 구매자 등급 정의 등록 처리 
	@PostMapping("/buyerGradeForm")
	public String getBuyerGrade() {
		return "redirect:admin/gradeDetails/buyerGradeForm";
	}	
	
	// 구매자 등급 정의 리스트
	@GetMapping("/buyerGradeList")
	public String getbuyerGradeList(Model model) {
		List<Grade> buyerGradeList = gradeService.getBuyerGradeList();
		model.addAttribute("title", "구매자 등급 리스트");
		model.addAttribute("buyerGradeList", buyerGradeList);
		return "admin/gradeDetails/buyerGradeList";
	}
	
	//구매자 등급 정의 수정폼 
	@GetMapping("/buyerModifyList/{consumer_level_states_code}")
	public String ModifybuyerGradeForm(@PathVariable(value = "consumer_level_states_code") 
			String consumer_level_states_code) {
				return "admin/gradeDetails/buyerModifyList";
	}
	
	
	//구매자 등급 정의 수정 처리 
	@PostMapping("/buyerModifylist")
	public String ModifybuyerGrade() {
		return "redirect:admin/gradeDetails/buyerGradeList";
		}
	
	
	//구매자 등급 정의 삭제 처리
	@PostMapping("/buyerRemoveList/{consumer_level_states_code}")
	public String RemovebuyerGrade(@PathVariable(value = "consumer_level_states_code") 
	String consumer_level_states_code) {
		return "redirect:admin/gradeDetails/buyerGradeList";
			}
}
