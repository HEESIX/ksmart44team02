package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;
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

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.OrderDiscount;
import ks44team02.dto.Penalty;
import ks44team02.dto.Review;
import ks44team02.service.CommonService;
import ks44team02.service.ReviewService;

@Controller
@RequestMapping(value = "/admin")
public class AdminReviewController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final ReviewService reviewService;
	
	private final CommonService commonService;

	public AdminReviewController(ReviewService reviewService, CommonService commonService) {
		this.reviewService = reviewService;
		this.commonService = commonService;
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
	@PostMapping("/reviewManage/modifyReview/{revCode}")
	public String ReviewModify(Review review, RedirectAttributes reAttr) {
		String revCode = commonService.getNewCode("tb_review");
		review.setRevCode(revCode);
		boolean result = reviewService.ReviewModify(review);
		String msg = "";
		if (result) {
			msg = "수정 완료";
		} else {
			msg = "수정 실패";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:admin/reviewManage/modifyReview";
	}
	
	//회원 리뷰 삭제 폼
	@GetMapping("/reviewManage/deleteReview/{revCode}")
	public String ReviewDeletForm(@PathVariable(value = "reviewContents") String reviewContents
			,Model model) {
		
		Review reviewInfo = reviewService.getReviewInfo(reviewContents);
		
		model.addAttribute("title", "회원리뷰 삭제");
		model.addAttribute("reviewInfo", reviewInfo);
		return "admin/reviewManage/deleteReview";
	}
	
	//회원리뷰 삭제처리
		@PostMapping("/reviewManage/deleteReview")
		public String ReviewDelete(@RequestParam(value = "revCode") String revCode,
								HttpSession session, RedirectAttributes reAttr) {
			revCode = "m_acc_id001";
			boolean ReviewDelete = commonService.ReviewDelete(revCode);
			if(ReviewDelete) {
				//
				reviewService.ReviewDelete(revCode);
				reAttr.addAttribute("msg", "적립금 소멸이 정상적으로 완료되었습니다.");
			}else {
				//아이디 비번 불일치
				reAttr.addAttribute("msg", "소멸 실패: 적립금이 존재하지 않습니다.");
			}
			return "admin/reviewManage/deleteReview";
		}
		
	//회원 리뷰 답변 폼
	@GetMapping("/reviewManage/answerReview/{reviewContents}")
	public String ReviewAnsweForm(@PathVariable(value = "reviewContents") String reviewContents
			,Model model) {
		
		Review reviewInfo = reviewService.getReviewInfo(reviewContents);
		
		model.addAttribute("title", "회원리뷰 답변");
		model.addAttribute("reviewInfo", reviewInfo);
		
		
		return "admin/reviewManage/answerReview";
	}
	
	
	  //회원리뷰 답변처리
	  
	  @PostMapping("/reviewManage/answerReview") 
	  public String ReviewAnswer(Review review, RedirectAttributes reAttr) {
			String reviewContents = commonService.getNewCode("tb_review");
			review.setReviewContents(reviewContents);
			boolean result = reviewService.ReviewAnswer(review);
			String msg = "";
			if (result) {
				msg = "답변 완료";
			} else {
				msg = "답변 실패";
			}
			reAttr.addAttribute("msg", msg);

	 return "redirect:admin/reviewManage/answerReview"; 
	  }
		
	
	

}
