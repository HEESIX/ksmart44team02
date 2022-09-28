package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.Mileage;
import ks44team02.dto.QnA;
import ks44team02.service.QnAservice;

@Controller
@RequestMapping(value = "/admin/QnA")
public class AdminqnaController {

	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final QnAservice qnaService;

	public AdminqnaController(QnAservice qnaService) {
		this.qnaService = qnaService;
	}

	@PostConstruct
	public void adminqnaControllerInit() {
		log.info("adminqnaControllerInit bean 생성");
	}
	
	//회원 QnA 조회
	@GetMapping("/qnaManage/qna_list")
	public String getqnaList(Model model) {
		List<QnA> qnaList = qnaService.getqnaList();
		model.addAttribute("title", "회원 QnA 조회");
		model.addAttribute("qnaList", qnaList);
		
		
		return "/admin/qnaManage/qna_list";
	}

	//회원 QnA 답글 등록 폼
	@PostMapping("/qnaManage/qnaAnswer")
	public String qnaAnswer(@PathVariable(value = "qnaAnswer") String qnaAnswer
			,Model model) {
		 QnA Answerqna = qnaService.getqnaInfo(qnaAnswer);
		return "/admin/qnaManage/qnaAnswer";
	}

}
