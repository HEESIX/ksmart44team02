package ks44team02.seller.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.service.ReviewService;

@Controller
@RequestMapping(value = "seller/review")
public class SellerReviewController {
	
	private static final Logger log = LoggerFactory.getLogger(SellerReviewController.class);
	
	private final ReviewService reviewService;
	
	public SellerReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@PostConstruct
	public void sellerReviewControllerInit() {
		log.info("sellerReviewControllerInits bean 생성");
	}
	
	//리뷰 조회
	@GetMapping("/reviewRefer")
	public String getReviewList() {
	  return "seller/review/reviewRefer";
	}
	
	//리뷰 답변 폼
	@GetMapping("/reviewAnswer")
	public String ReviewAnswerForm() {
	  return "seller/review/reviewAnswer";
	}
	
	//리뷰답변 처리
	@PostMapping("/reviewAnswer")
	public String ReviewAnswer() {
		  return "seller/review/reviewAnswer";
		}

}
