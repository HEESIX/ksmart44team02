package ks44team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Gradeservice;

@Controller
@RequestMapping(value = "/admin/gradeDetails")

public class SellerGradeController {
	
	private final Gradeservice gradeservice;
	
	public SellerGradeController (Gradeservice gradeservice) {
		this.gradeservice = gradeservice;
	}
	
	//판매자 등급 정의 등록
	@GetMapping("/seller_addgradelist")
	public String addVenderGrade () {
		return "admin/gradeDetails/seller_addgradelist";
	}
	//판매자 등급 정의 조회
		@GetMapping("/seller_gradelist")
		public String getVendeGradeList () {
			return "admin/gradeDetails/seller_gradelist";
		}
	//판매자 등급 정의 수정
		@GetMapping("/seller_removelist")
		public String ModifyVendeGrade () {
			return "admin/gradeDetails/seller_removelist";
				}
	//판매자 등급 정의 삭제
		@GetMapping("/seller_modifylist")
		public String RemoveVenderGrade () {
			return "admin/gradeDetails/seller_modifylist";

				}

}
