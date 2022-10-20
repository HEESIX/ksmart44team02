package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.Review;
import ks44team02.mapper.ReviewMapper;

@Service
public class ReviewService {
	
	private final ReviewMapper reviewMapper;
	
	public ReviewService(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}
	

	
	
	//회원 리뷰 목록 조회
		public List<Review> getReviewList() {
			List<Review> reviewList = reviewMapper. getReviewList();
			return reviewList;
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

		public boolean ReviewModify(Review review) {
			boolean result = reviewMapper.ReviewModify(review);
			return result;
		}

		public boolean ReviewDelete(String revCode) {
			boolean resultRemove = reviewMapper.ReviewDelete(revCode);
			return resultRemove;
		}

		public boolean ReviewAnswer(Review reviewContents) {
			boolean resultAnswer = reviewMapper.ReviewAnswer(reviewContents);
			return resultAnswer;
		}
		
		public boolean regBuyerReviewForm(Review reviewContents) {
			boolean resultAnswer = reviewMapper.regBuyerReviewForm(reviewContents);
			return resultAnswer;
			
			
		}

		public boolean regBuyerReview(Review review) {
			boolean resultReg = reviewMapper.regBuyerReview(review);
			return resultReg;
	
		}
		
		public boolean buyerReviewDeleteForm(Review reviewContents) {
			boolean resultDelete = reviewMapper.buyerReviewDeleteForm(reviewContents);
			return resultDelete;
			
		}

		public boolean buyerReviewDelete(String revCode) {
			boolean resultDelete = reviewMapper.buyerReviewDelete(revCode);
			return resultDelete;
			
		}

		public Review getReviewInfo(String reviewContents) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Review> getReviewListSearch(String memberId) {
			List<Review> reviewList = reviewMapper.getReviewListSearch(memberId);
			return reviewList;
		}

		public List<Review> getReviewListSearchGcode(String gCode) {
			List<Review> reviewListByGcode = reviewMapper.getReviewListSearchGcode(gCode);
			return reviewListByGcode;
		}


		///회원 아이디,상품별 리뷰조회

		public List<Review> getReviewListByGcode() {
			List<Review> reviewListByGcode = reviewMapper.getReviewListByGcode();
			return reviewListByGcode;
		}
		
		public List<Review> getReviewListByGcode(String gCode) {
			List<Review> reviewListByGcode = reviewMapper.getReviewListByGcode(gCode);
			return reviewListByGcode;
		}
		
		public List<Review> getReviewListById() {
			List<Review> reviewList = reviewMapper.getReviewListById();
			return reviewList;
		}
		
		public List<Review> getReviewListById(String memberId) {
			List<Review> reviewList = reviewMapper.getReviewListById(memberId);
			return reviewList;
		}




	
		

}
