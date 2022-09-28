package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Review;

@Mapper
public interface ReviewMapper {
	
	//특정 회원 리뷰 조회
	public Review getReviewInfo();
	
	//회원 리뷰목록 조회
		public List<Review> getReviewList();

		//회원 리뷰 수정
		public int ReviewModify();
		
		//회원 리뷰 수정
		public int ReviewDelete();
		
		//회원 리뷰 답변
		public int ReviewAnswer();
		
		//구매자 리뷰 등록
		public String regBuyerReview();
		
		//구매자 리뷰 수정
		public int buyerReviewModify();
		
		//구매자 리뷰 삭제
		public int buyerReviewDelete();
     
		//특정회원리뷰 조회
		public Review getReviewInfo(String reviewContents);
		
		

}
