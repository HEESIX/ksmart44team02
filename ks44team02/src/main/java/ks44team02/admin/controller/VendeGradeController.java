package ks44team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Gradeservice;

@Controller
@RequestMapping(value = "/admin/gradeDetails")

public class VendeGradeController {
	
	private final Gradeservice gradeservice;
	
	public VendeGradeController (Gradeservice gradeservice) {
		this.gradeservice = gradeservice;
	}
	
	//판매자 등급 정의 등록
	@GetMapping("/addgradelist")
	public String addVenderGrade () {
		return "admin/gradeDetails/addgradelist";
	}
	//판매자 등급 정의 조회
		@GetMapping("/gradelist")
		public String getVendeGradeList () {
			return "admin/gradeDetails/gradelist";
		}
	//판매자 등급 정의 수정
		@GetMapping("/modifylist")
		public String ModifyVendeGrade () {
			return "admin/gradeDetails/modifylist";
				}
	//판매자 등급 정의 삭제
		@GetMapping("/removelist")
		public String RemoveVenderGrade () {
			return "admin/gradeDetails/removelist";
				}

}
