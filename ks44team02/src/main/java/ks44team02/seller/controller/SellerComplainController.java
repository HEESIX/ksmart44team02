package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "seller/complain")
public class SellerComplainController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerInqueryController.class);
	
	private final ComplainService complainService;
	
	public SellerComplainController(ComplainService complainService) {
		this.complainService = complainService;
	}
	
	@PostConstruct
	public void sellerComplainControllerInit() {
		log.info("sellerComplainControllerInits bean 생성");
	}
	
	//판매자 신고내역 조회
	public String getSellerComplainList() {
		return null;
	}
	

}
