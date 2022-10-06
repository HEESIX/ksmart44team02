package ks44team02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Launching;

@Mapper
public interface AdminCompanyMapper {
	
	//업체 입점 승인 폼
	public String companySuccess();
	
	//입점 업체 정보 및 리스트
	public List<Launching> companyInfoList(Map<String, Object> map);
	
	//업체 정보 삭제 승인 폼
	public String companyRemoveSuccess();
}
