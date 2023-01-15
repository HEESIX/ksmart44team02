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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.QnA;
import ks44team02.service.CommonService;
import ks44team02.service.QnAservice;

@Controller
@RequestMapping(value = "/admin/QnA")
public class AdminqnaController {

	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final QnAservice qnaService;

	private final CommonService commonService;
	public AdminqnaController(QnAservice qnaService,CommonService commonService) {
		this.qnaService = qnaService;
		this.commonService = commonService;
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
		
		
		return "admin/qnaManage/qna_list";
	}

	//회원 QnA 답글 등록 폼
	@GetMapping("/qnaManage/qnaAnswer")
	public String qnaAnswerForm(@PathVariable(value = "qnaAnswer") String qnaAnswer
			,Model model) {
		 QnA Answerqna = qnaService.getqnaInfo(qnaAnswer);
		return "admin/qnaManage/qnaAnswer";
	}
	
	//회원QnA 답글 등록 처리
	@PostMapping("/qnaManage/qnaAnswer")
	public String qnaAnswer(QnA qna, RedirectAttributes reAttr) {
		String qnaCode = commonService.getNewCode("tb_qna");
		qna.setQnaCode(qnaCode);
		boolean result = qnaService.qnaAnswer(qna);
		String msg = "";
		if (result) {
			msg = "답글 등록 성공";
		} else {
			msg = "답글 등록 실패";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:admin/qnaManage/qnaAnswer";
	}

}
