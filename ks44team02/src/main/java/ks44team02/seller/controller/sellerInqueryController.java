package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.service.QnAservice;


	@Controller
	@RequestMapping(value = "seller/inquery")
	public class sellerInqueryController {
		
		private static final Logger log = LoggerFactory.getLogger(sellerInqueryController.class);
	
		private final QnAservice qnaService;
		
		public sellerInqueryController(QnAservice qnaService) {
			this.qnaService = qnaService;
		}
		
		@PostConstruct
		public void sellerInqueryControllerInit() {
			log.info("sellerInqueryControllerInits bean 생성");
		}
		
		//문의 조회
		@GetMapping("/inqueryRefer")
		public String getSellerInqueryList() {
			return "/seller/inquery/inqueryRefer";
		}
		
		
		//문의 답변 폼
		@GetMapping("/inqueryAnswer")
		public String answerInquerForm() {
			return "/seller/inquery/inqueryAnswer";
		}
		
		//문의 답변 처리
		@PostMapping("/inqueryAnswer")
		public String answerInquer() {
			return "/seller/inquery/inqueryAnswer";
		}
		
		
		
	}
