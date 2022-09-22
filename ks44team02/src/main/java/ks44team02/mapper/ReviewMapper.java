package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	
	//회원 리뷰 조회
		public String getReviewList();

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
		
		

}
