package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.service.InqueryService;


	@Controller
	@RequestMapping(value = "seller/inquery")
	public class SellerInqueryController {
		
		private static final Logger log = LoggerFactory.getLogger(SellerInqueryController.class);
	
		private final InqueryService inqueryService;
		
		public SellerInqueryController(InqueryService inqueryService) {
			this.inqueryService = inqueryService;
		}
		
		@PostConstruct
		public void sellerInqueryControllerInit() {
			log.info("sellerInqueryControllerInits bean 생성");
		}
		
		//문의 조회
		public String getSellerInqueryList() {
			return null;
		}
		
		//문의 답변
		public int answerInquery() {
			return 0;
		}
		
		
		
	}