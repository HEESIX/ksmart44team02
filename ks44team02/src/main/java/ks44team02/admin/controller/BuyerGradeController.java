package ks44team02.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.Gradeservice;

@Controller
@RequestMapping (value = "/admin/gradeDetails")
public class BuyerGradeController {
	
	private final Gradeservice gradeservice;
	
	public BuyerGradeController (Gradeservice gradeservice) {
		this.gradeservice = gradeservice;
	}
	
	//구매자 등급 정의 등록 
	@GetMapping("/addgradelist")
	public String addbuyerGrade() {
		return "admin/gradeDetails/addgradelist";
	}
	
	//구매자 등급 정의 조회
	@GetMapping("/gradelist")
	public String getbuyerGradeList() {
		return "admin/gradeDetails/gradelist";
		}
	//구매자 등급 정의 수정
	@GetMapping("/modifylist")
	public String ModifybuyerGrade() {
		return "admin/gradeDetails/modifylist";
		}
	//구매자 등급 정의 삭제
	@GetMapping("/removelist")
	public String RemovebuyerGrade() {
		return "admin/gradeDetails/removelist";
			}
		
		
}
