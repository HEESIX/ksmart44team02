package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	
	public boolean sessionIdPwCheck(String memberId, String memberPw);
	
	//테이블 명과 컬럼명을 입력하여 새로운 코드를 반환
	public String getNewCode(String tableName);
}
