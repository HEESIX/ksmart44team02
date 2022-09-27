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

public class SellerGradeController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerGradeController.class);

	private final Gradeservice gradeservice;
	
	public SellerGradeController (Gradeservice gradeservice) {
		this.gradeservice = gradeservice;
	}
	// 판매자 등급 정의 등록 폼 
	@GetMapping ("seller_addgradeform")
	public String addSellerGradeForm() {
		return "admin/gradeDetails/seller_addgradeform";
	}
		
	//판매자 등급 정의 등록 처리 
	@PostMapping("/seller_addgradeform")
	public String addSellerGrade () {
		return "redirect:admin/gradeDetails/seller_gradelist";
	}
	
	//판매자 등급 정의 조회
	@GetMapping("/seller_gradelist")
	public String getSellerGradeList () {
		return "admin/gradeDetails/seller_gradelist";
		}
	// 판매자 등급 정의 수정 폼 
	@GetMapping ("/seller_modifylist/{vendor_level_states_code}")
	public String ModifySellerGradeForm(@PathVariable
			(value = "vendor_level_states_code")String vendor_level_states_code) {
		return "admin/gradeDetails/seller_removelist";	
	}
		
		
	//판매자 등급 정의 수정 처리
	@PostMapping("/seller_modifylist")
	public String ModifySellerGrade () {
		return "redirect:admin/gradeDetails/seller_gradelist";
	}
		
		
	//판매자 등급 정의 삭제 처리  
	@PostMapping("/seller_removelist/{vendor_level_states_code}")
	public String RemoveSellerGrade(@PathVariable 
			(value = "vendor_level_states_code")String vendor_level_states_code){
		return "redirect:admin/gradeDetails/seller_gradelist";

	}

}
