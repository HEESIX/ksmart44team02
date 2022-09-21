package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.service.PenaltyService;

	@Controller
	@RequestMapping(value = "seller/penalty")
	public class SellerPenaltyController {
		
		private static final Logger log = LoggerFactory.getLogger(SellerPenaltyController.class);
		
		private final PenaltyService penaltyService;
		
		public SellerPenaltyController(PenaltyService penaltyService) {
			this.penaltyService = penaltyService;
		}
		
		@PostConstruct
		public void sellerPenaltyControllerInit() {
			log.info("sellerPenaltyControllerInits bean 생성");
		}
		
		//패널티 조회
		public String getPenaltyList() {
		  return null;
		}

	}	
