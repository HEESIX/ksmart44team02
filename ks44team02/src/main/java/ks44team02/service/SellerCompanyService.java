package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import ks44team02.dto.Launching;
import ks44team02.mapper.SellerCompanyMapper;

@Service
public class SellerCompanyService {

	private final SellerCompanyMapper sellerCompanyMapper;
		
	public SellerCompanyService(SellerCompanyMapper sellerCompanyMapper) {
		this.sellerCompanyMapper = sellerCompanyMapper;
		}
	
	//업체 정보 등록
	public boolean addCompany(Launching launching) {
		boolean result = sellerCompanyMapper.addCompany(launching);
		return result;
		/*
		return "seller/companypage/companyInsert";
		*/
	}
	
	
	//브랜드 중복체크
	public boolean BrandCheck(String sellerBrand) {
		boolean result = sellerCompanyMapper.BrandCheck(sellerBrand);
		return result;
	}
	
	
	//업체 정보 검색 및 전체 리스트
	public List<Launching> sellerCompanyInfoList() {
		List<Launching> sellerCompanyInfoList = sellerCompanyMapper.sellerCompanyInfoList();
		return sellerCompanyInfoList;
	}
	
	//업체 세부 정보 화면
	public String company_detail() {
		return null;
	}
	
	//업체 정보 수정
	public String sellerCompanyModify() {
		return "seller/companypage/companyModify";
	}
	
	//업체 정보 삭제
	public String sellerCompanyRemove() {
		return "seller/companypage/companyDelete";
	}
}
