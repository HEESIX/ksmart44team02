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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.BuyerLevel;
import ks44team02.dto.Grade;
import ks44team02.service.CommonService;
import ks44team02.service.GradeService;

@Controller
@RequestMapping(value = "/admin/gradeDetails")
public class BuyerGradeController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BuyerGradeController.class);


	private final GradeService gradeService;
	private final CommonService commonService;
	
	public BuyerGradeController(GradeService gradeService, CommonService commonService) {
		this.gradeService = gradeService;
		this.commonService = commonService;
	}
	// 구매자 등급 정의 등록 폼 
	@GetMapping("/buyerGradeForm")
	public String getBuyerGradeForm(Model model) {
		model.addAttribute("title","구매자 등급 정의 등록");
		return "admin/gradeDetails/buyerGradeForm";
	}
	
	// 구매자 등급 정의 등록 처리 
	@PostMapping("/buyerGradeForm")
	public String getBuyerGrade(Grade buyerGradeList
								,RedirectAttributes reAttr) {
		String buyerGradeCode = commonService.getNewCode("tb_buyer_level");
		BuyerLevel buyerLevel = buyerGradeList.getBuyerLevel();
		buyerLevel.setBuyerLevelCode(buyerGradeCode);
		boolean result = gradeService.addBuyerGrade(buyerGradeList);
		String msg = "";
		if(result) {
			msg="등록성공";
		}else {
			msg="등록 실패";
		}
		reAttr.addAttribute("msg",msg);
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
