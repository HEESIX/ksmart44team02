package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Launching;

@Mapper
public interface SellerCompanyMapper {
	
	//업체 정보 등록
	public boolean addCompany(Launching launching);
	
	//업체 정보 리스트
	public List<Launching> sellerCompanyInfoList();
	
	//업체 세부 정보 화면
	public String company_detail();
	
	//업체 정보 수정
	public String sellerCompanyModify();

	//업체 정보 삭제
	public String sellerCompanyRemove();
}
