package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.InqueryService;

@Controller
@RequestMapping(value = "/buyer/inquery")
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
	@GetMapping("/inqueryList")
	public String getBuyerInqueryList() {
		return "/buyer/inquery/inqueryList";
	}
	//구매자 문의 등록
	@GetMapping("/regInquery")
		public String regBuyerInqueryForm() {
			return "/buyer/inquery/regInquery";
		}
	
	
	//구매자 문의 등록 처리
	@PostMapping("/regInquery")
	public String regBuyerInquery() {
		return "/buyer/inquery/regInquery";
	}

	
		//구매자 문의 수정 폼
		@GetMapping("/modifyInquery")
		public String modifyBuyerInqueryForm() {
			return "/buyer/inquery/modifyInquery";
		}
		
		//구매자 문의 수정 처리
		 @PostMapping("/modifyInquery")
		 public String modifyBuyerInquery() {
				return "/buyer/inquery/modifyInquery";
			}
		 
		//구매자 문의 삭제 폼
		 @GetMapping("/deleteInquery")
		public String deleteBuyerInqueryForm() {
			return "/buyer/inquery/deleteInquery";
		}	
		 
		 //구매자 문의 삭제 처리
		 @PostMapping("/deleteInquery")
		 public String deleteBuyerInquery() {
				return "/buyer/inquery/deleteInquery";
			}	
}
