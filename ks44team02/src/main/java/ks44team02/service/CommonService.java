package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.CommonMapper;

@Service
public class CommonService {
	
	private final CommonMapper commonMapper;
	
	public CommonService(CommonMapper commonMapper) {
		this.commonMapper = commonMapper;
	}
	
	//세션의 아이디와 입력받은 비밀번호 일치 체크
	public boolean sessionIdPwCheck(String memberId, String memberPw) {
		
		boolean result = commonMapper.sessionIdPwCheck(memberId, memberPw);

		return result;
	}
	
	//새로운 코드 발행
	public String getNewCode(String tableName) {
		String newCode = commonMapper.getNewCode(tableName);
		return newCode;
	}
	
	//세션의 아이디로 입점업체 코드 조회
	public int isExistEnterCode(String memberId) {
		int result = commonMapper.isExistEnterCode(memberId);
		return result;
	}
	
	//회원 아이디로 입점업체코드 가져오기
	public String getEnterCodeOfMebmerId(String memberId) {
		String enterCode = commonMapper.getEnterCodeOfMebmerId(memberId);
		return enterCode;
	}
	
	//회원 마일리지 부여
	public boolean giveMileage(String mMileageCode) {
		boolean result =commonMapper.getNewCode(mMileageCode) != null;
		return result;
	}
	
	//회원 마일리지 소멸
	public boolean MileageExtinction(String mMileageCode, String currentMileage) {
		boolean result = commonMapper.MileageExtinction(mMileageCode);
		return result;
	}
	
	//회원 신고내역 삭제
	public boolean ComplainDelete(String complainCode) {
		boolean result = commonMapper.ComplainDelete(complainCode);
		return result;
	}

	public boolean ReviewDelete(String revCode) {
		boolean result = commonMapper.ReviewDelete(revCode);
		return result;
	}

	public boolean buyerReviewDelete(String revCode, String reviewContents) {
		boolean result = commonMapper.buyerReviewDelete(reviewContents);
		return result;
	}

	public boolean deleteBuyerInquery(String qnaCode, String qnaContents) {
		boolean result = commonMapper.deleteBuyerInquery(qnaCode);
		return result;
	};
	
	

}
