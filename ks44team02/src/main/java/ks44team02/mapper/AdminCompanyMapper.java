package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminCompanyMapper {
	
	//업체 입점 승인 폼
	public String companySuccess();
	
	//입점 업체 정보 및 리스트
	public String companyInfoList();
	
	//업체 정보 삭제 승인 폼
	public String companyRemoveSuccess();
}
