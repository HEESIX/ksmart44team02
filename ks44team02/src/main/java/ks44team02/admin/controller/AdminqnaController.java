package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String getqnaList() {
		return null;
	}

	//회원 QnA 답글 등록
	public int qnaAnswer() {
		return 0;
	}

}
