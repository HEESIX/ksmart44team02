package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.ReviewMapper;

@Service
public class ReviewService {
	
	private final ReviewMapper reviewMapper;
	
	public ReviewService(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}
	
	//회원 리뷰 조회
		public String getReviewList() {
			return null;
		}

		//회원 리뷰 수정
		public int ReviewModify() {
			return 0;
		}
		//회원 리뷰 삭제
		public int ReviewDelete() {
			return 0;
		}
		//회원 리뷰 답변
		public int ReviewAnswer() {
			return 0;
		}
		
		//구매자 리뷰 등록
		public String regBuyerReview() {
			return null;
		}
		
		//구매자 리뷰 수정
		public int buyerReviewModify() {
			return 0;
		}
	
		// 구매자 리뷰 삭제
		public int buyerReviewDelete() {
			return 0;
		}

}
