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
	
	public String getNewCode(String tableName) {
		String newCode = commonMapper.getNewCode(tableName);
		return newCode;
	}
}
