package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.OrderDiscount;
import ks44team02.dto.Review;
import ks44team02.service.ReviewService;

@Controller
@RequestMapping(value = "/admin")
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
	
	//회원 리뷰 목록 조회
	@GetMapping("/reviewManage/watchReview")
	public String getReviewList(Model model) {
		List<Review> reviewList = reviewService.getReviewList();
		model.addAttribute("title", "회원 리뷰 목록");
		model.addAttribute("reviewList", reviewList);
		return "/admin/reviewManage/watchReview";
	}

	//회원 리뷰 수정 폼
	@GetMapping("/reviewManage/modifyReview")
	public String ReviewModifyForm(@PathVariable(value = "reviewContents") String reviewContents
			,Model model) {
		Review reviewList = reviewService.getReviewInfo(reviewContents);
		return "admin/reviewManage/modifyReview";
	}
	
	//회원리뷰 수정처리
	@PostMapping("/reviewManage/modifyReview")
	public String ReviewModify() {
		return "admin/reviewManage/modifyReview";
	}
	
	//회원 리뷰 삭제 폼
	@GetMapping("/reviewManage/deleteReview")
	public String ReviewDeletForm(@PathVariable(value = "reviewContents") String reviewContents
			,Model model) {
		
		Review reviewInfo = reviewService.getReviewInfo(reviewContents);
		
		model.addAttribute("title", "회원리뷰 삭제");
		model.addAttribute("reviewInfo", reviewInfo);
		return "admin/reviewManage/deleteReview";
	}
	
	//회원리뷰 삭제처리
		@PostMapping("/reviewManage/deleteReview")
		public String ReviewDelet() {
			return "admin/reviewManage/deleteReview";
		}
		
	//회원 리뷰 답변 폼
	@GetMapping("/reviewManage/answerReview")
	public String ReviewAnsweForm(@PathVariable(value = "reviewContents") String reviewContents
			,Model model) {
		
		Review reviewInfo = reviewService.getReviewInfo(reviewContents);
		
		model.addAttribute("title", "회원리뷰 답변");
		model.addAttribute("reviewInfo", reviewInfo);
		
		
		return "admin/reviewManage/answerReview";
	}
	
	/*
	 * //회원리뷰 답변처리
	 * 
	 * @PostMapping("/reviewManage/deleteReview") public String ReviewAnswer() {
	 * return "admin/reviewManage/deleteReview"; }
	 */
		
	
	

}
