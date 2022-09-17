package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.ReviewService;

@Controller
@RequestMapping(value = "/admin/review")
public class AdminReviewController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final ReviewService reviewService;

	public AdminReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostConstruct
	public void adminReviewControllerInit() {
		log.info("adminqnaControllerInit bean 생성");
	}
	
	//회원 리뷰 조회
	public String getReviewList() {
		return null;
	}

	//회원 리뷰 수정
	public int ReviewModify() {
		return 0;
	}
	//회원 리뷰 수정
	public int ReviewDelete() {
		return 0;
	}
	//회원 리뷰 수정
	public int ReviewAnswer() {
		return 0;
	}

}
