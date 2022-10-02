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

public class SellerGradeController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerGradeController.class);

	private final GradeService gradeService;
	
	public SellerGradeController (GradeService gradeService) {
		this.gradeService = gradeService;
	}
	// 판매자 등급 정의 등록 폼 
	@GetMapping ("sellerAddGradeForm")
	public String addSellerGradeForm() {
		return "admin/gradeDetails/sellerAddGradeForm";
	}
		
	//판매자 등급 정의 등록 처리 
	@PostMapping("/sellerAddgradeForm")
	public String addSellerGrade () {
		return "redirect:admin/gradeDetails/sellerAddgradeForm";
	}
	
	//판매자 등급 정의 리스트
	@GetMapping("/sellerGradeList")
	public String getSellerGradeList (Model model) {
		List<Grade> sellerGradeList = gradeService.getSellerGradeList();
		model.addAttribute("title", "판매자 등급 리스트");
		model.addAttribute("sellerGradeList", sellerGradeList);
		return "admin/gradeDetails/sellerGradeList";
	}
	
	// 판매자 등급 정의 수정 폼 
	@GetMapping ("/sellerModifyList/{vendor_level_states_code}")
	public String ModifySellerGradeForm(@PathVariable
			(value = "vendor_level_states_code")String vendor_level_states_code) {
		return "admin/gradeDetails/sellerModifyList";	
	}
		
		
	//판매자 등급 정의 수정 처리
	@PostMapping("/sellerModifyList")
	public String ModifySellerGrade () {
		return "redirect:admin/gradeDetails/sellerGradeList";
	}
		
		
	//판매자 등급 정의 삭제 처리  
	@PostMapping("/sellerRemoveList/{vendor_level_states_code}")
	public String RemoveSellerGrade(@PathVariable 
			(value = "vendor_level_states_code")String vendor_level_states_code){
		return "redirect:admin/gradeDetails/sellerGradeList";

	}

}
