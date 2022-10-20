package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	
	public boolean sessionIdPwCheck(String memberId, String memberPw);
	
	//테이블 명을 입력하여 새로운 코드를 반환
	public String getNewCode(String tableName);
	
	//
	public int isExistEnterCode(String memberId);
	
	//회원 아이디로 입점업체코드 가져오기
	public String getEnterCodeOfMebmerId(String memberId);

	public boolean MileageExtinction(String mMileageCode);

	public boolean ComplainDelete(String complainCode);

	public boolean ReviewDelete(String revCode);

	public boolean buyerReviewDelete(String reviewContents);

	public boolean deleteBuyerInquery(String qnaCode);
}
