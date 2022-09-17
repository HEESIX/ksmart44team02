package ks44team02.mapper;

public interface ReviewMapper {
	
	//회원 리뷰 조회
		public String getReviewList();

		//회원 리뷰 수정
		public int ReviewModify();
		
		//회원 리뷰 수정
		public int ReviewDelete();
		
		//회원 리뷰 수정
		public int ReviewAnswer();
		

}
