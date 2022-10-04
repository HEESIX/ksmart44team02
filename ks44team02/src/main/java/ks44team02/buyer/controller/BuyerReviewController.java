package ks44team02.buyer.controller;

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
@RequestMapping(value = "/buyer/review")
public class BuyerReviewController {
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final ReviewService reveiwService;

	public BuyerReviewController(ReviewService reveiwService) {
		this.reveiwService = reveiwService;
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	
	//구매자 리뷰 등록 폼
	@GetMapping("/regReview")
	public String regBuyerReviewForm() {
		return "/buyer/review/regReview";
	}
	//구매자 리뷰 등록 처리
	@PostMapping("/regReview")
	public String regBuyerReview() {
		return "/buyer/review/regReview";
	}
	
	//구매자 리뷰 수정 폼
	@GetMapping("/modifyReview")
	public String buyerReviewModifyForm() {
		return "/buyer/review/modifyReview";
	}
	
	//구매자 리뷰 수정 처리
	@PostMapping("/modifyReview")
	public String buyerReviewModify() {
		return "/buyer/review/modifyReview";
	}
	
	
	//구매자 리뷰 삭제 폼
		@GetMapping("/deleteReview")
		public String buyerReviewDeleteForm() {
			return "/buyer/review/deleteReview";
		}
		
	//구매자 리뷰 삭제 처리
		@PostMapping("/deleteReview")
		public String buyerReviewDelete() {
			return "/buyer/review/deleteReview";
		}
}
