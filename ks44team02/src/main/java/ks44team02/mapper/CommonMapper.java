package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	
	public boolean sessionIdPwCheck(String memberId, String memberPw);
}
