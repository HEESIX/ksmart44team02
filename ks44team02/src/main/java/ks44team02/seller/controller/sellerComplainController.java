package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "seller/complain")
public class sellerComplainController {
	
	private static final Logger log = LoggerFactory.getLogger(sellerInqueryController.class);
	
	private final ComplainService complainService;
	
	public sellerComplainController(ComplainService complainService) {
		this.complainService = complainService;
	}
	
	@PostConstruct
	public void sellerComplainControllerInit() {
		log.info("sellerComplainControllerInits bean 생성");
	}
	
	//판매자 신고내역 조회
	@GetMapping("/complainRefer")
	public String getSellerComplainList() {
		
		return "seller/complain/complainRefer";
	}
	

}
