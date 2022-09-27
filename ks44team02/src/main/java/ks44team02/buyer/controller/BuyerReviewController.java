package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	//구매자 리뷰 등록
	public String regBuyerReview() {
		return null;
	}
	
	//구매자 리뷰 수정
	public int buyerReviewModify() {
		return 0;
	}
	
	//구매자 리뷰 삭제
		public int buyerReviewDelete() {
			return 0;
		}
		

}
