package ks44team02.buyer.controller;

import javax.annotation.PostConstruct;
import javax.management.relation.RelationService;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.admin.controller.AdminqnaController;
import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.Review;
import ks44team02.service.CommonService;
import ks44team02.service.ReviewService;

@Controller
@RequestMapping(value = "/buyer/review")
public class buyerReviewController {
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final ReviewService reviewService;
	
	private final CommonService commonService;

	public buyerReviewController(ReviewService reviewService,CommonService commonService) {
		this.reviewService = reviewService;
		this.commonService = commonService;
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	/*
	//구매자 리뷰 등록 폼
	@GetMapping("/regReview/{reviewContents}")
	public String regBuyerReviewForm(@PathVariable(value = "reviewTitle") String reviewTitle,
            @PathVariable(value = "reviewContents") String reviewContents
,Model model
,Model model1) {
		Review reviewInfo = reviewService.getReviewInfo(reviewTitle, reviewContents);
		System.out.println(reviewInfo.toString());
		return "buyer/review/regReview";
	}

	//구매자 리뷰 등록 처리
	@PostMapping("/regReview")
	public String regBuyerReview(Review review, RedirectAttributes reAttr) {
		String revCode = commonService.getNewCode("tb_review");
		review.setRevCode(revCode);
		boolean result = reviewService.regBuyerReview(review);
		String msg = "";
		if (result) {
			msg = "등록 성공";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg); 
		return "redirect:/buyer/review/regReview";
	}
	
	//구매자 리뷰 수정 폼
	@GetMapping("/modifyReview/{reviewContents}")
	public String buyerReviewModifyForm(@PathVariable(value = "reviewTitle") String reviewTitle,
            @PathVariable(value = "reviewContents") String reviewContents
,Model model
,Model model1) {
		Review reviewInfo = reviewService.getReviewInfo(reviewTitle, reviewContents);
		System.out.println(reviewInfo.toString());
		return "buyer/review/regReview";
	}
	
	//구매자 리뷰 수정 처리
	@PostMapping("/modifyReview")
	public String buyerReviewModify(Review review, RedirectAttributes reAttr) {
		String revCode = commonService.getNewCode("tb_review");
		review.setRevCode(revCode);
		boolean result = reviewService.regBuyerReview(review);
		String msg = "";
		if (result) {
			msg = "등록 성공";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg); 
		return "redirect:/buyer/review/modifyReview";
	}
	
	
	//구매자 리뷰 삭제 폼
		@GetMapping("/deleteReview")
		public String buyerReviewDeleteForm(@PathVariable(value = "revCode") String revCode,
				@PathVariable(value = "reviewContents") String reviewContents
		,Model model
		,Model model1) {
		Review reviewDelete = reviewService.getReviewInfo(revCode, reviewContents);
			return "/buyer/review/deleteReview";
		}
		
	//구매자 리뷰 삭제 처리
		@PostMapping("/deleteReview")
		public String buyerReviewDelete(@RequestParam(value = "revCode") String revCode,
				@RequestParam(value = "reviewContents") String reviewContents, HttpSession session, RedirectAttributes reAttr) {
				revCode = "rev_id001";
			boolean reviewDelete = commonService.buyerReviewDelete(revCode, reviewContents);
			if(reviewDelete) {
				//
				reviewService.buyerReviewDelete(revCode);
				reAttr.addAttribute("msg", "리뷰 삭제가 정상적으로 완료되었습니다.");
			}else {
				//아이디 비번 불일치
				reAttr.addAttribute("msg", "삭제 실패: 리뷰가 존재하지 않습니다.");
			}
			return "redirect:/buyer/review/deleteReview";
		}
		*/
}
