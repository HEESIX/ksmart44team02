package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "/buyer/complain")
public class BuyerComplainController {

	
	private static final Logger log = LoggerFactory.getLogger(BuyerComplainController.class);

	
	private final ComplainService complainService;
	
	public BuyerComplainController(ComplainService complainService) {
		
	   this.complainService = complainService;
	}
	
	@PostConstruct
	public void buyerComplainControllerInit() {
		log.info("buyerComplainControllerInit bean 생성");
	}
	
	//구매자 신고 등록
	public int regBuyerComplain() {
		return 0;
		
	}
}
