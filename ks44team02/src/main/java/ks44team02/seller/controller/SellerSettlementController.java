package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.SettlementService;

	@Controller
	@RequestMapping(value = "seller/settlemenet")
	public class SellerSettlementController {
		
		private static final Logger log = LoggerFactory.getLogger(SellerSettlementController.class);
		
		private final SettlementService settlementService;
		
		public SellerSettlementController(SettlementService settlemenetService) {
			this.settlementService = settlemenetService;
		}
		
		@PostConstruct
		public void sellerSettlemenetControllerInit() {
			log.info("sellerSettlemenetControllerInits bean 생성");
		}
		
		//매출현황 조회
		public String getSalesStateList() {
		  return null;
		}
		
		//매출 정산
		public int SalesSettlement() {
		  return 0;
		}
		
		//정산금 정산현황 조회
		public String getAddfareStateList() {
			return null;
		}
		
		//정산금 정산
		public int AddfareSettlement() {
			return 0;
		}
			
		

}
