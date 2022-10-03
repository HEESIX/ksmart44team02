package ks44team02.service;

import org.springframework.stereotype.Service;
import ks44team02.mapper.AdminCompanyMapper;

@Service
public class AdminCompanyService {
	
	private final AdminCompanyMapper adminCompanyMapper;
	
	public AdminCompanyService(AdminCompanyMapper adminCompanyMapper) {
		this.adminCompanyMapper = adminCompanyMapper;
		}
	
	//업체 입점 승인 폼)
	public String companySuccess() {
		return "admin/companypage/sellerCompanyCheck";
	}
	
	//입점 업체 정보 및 리스트
	public String companyInfoList() {
		return "admin/companypage/sellerCompanyList";
	}
	
	//업체 정보 삭제 승인 폼
	public String companyRemoveSuccess() {
		return "admin/companypage/sellerCompanyDelete";
	}
}
