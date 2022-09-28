package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.InqueryService;

@Controller
@RequestMapping(value = "/buyer/Inquery")
public class BuyerInqueryController {

	private static final Logger log = LoggerFactory.getLogger(BuyerInqueryController.class);

	private final InqueryService inqueryService;

	public BuyerInqueryController(InqueryService inqueryService) {
		this.inqueryService = inqueryService;
	}

	@PostConstruct
	public void adminInqueryControllerInit() {
		log.info("adminInqueryControllerInit bean 생성");
	}
	
	//구매자 문의 조회
	public String getBuyerInqueryList() {
		return null;
	}
	//구매자 문의 등록
		public int regBuyerInquery() {
			return 0;
		}
		//구매자 문의 수정
		public int modifyBuyerInquery() {
			return 0;
		}
		//구매자 문의 삭제
		public int deleteBuyerInquery() {
			return 0;
		}	
}
