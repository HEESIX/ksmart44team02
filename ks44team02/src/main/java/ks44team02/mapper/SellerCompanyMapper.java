package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerCompanyMapper {
	
	//업체 정보 등록
	public String addCompany();
	
	//업체 정보 검색 및 전체 리스트
	public String sellerCompanyInfo();
	
	//업체 세부 정보 화면
	public String company_detail();
	
	//업체 정보 수정
	public String sellerCompanyModify();

	//업체 정보 삭제
	public String sellerCompanyRemove();
}
