package ks44team02.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import ks44team02.dto.Enterprise;
import ks44team02.dto.Launching;
import ks44team02.mapper.AdminCompanyMapper;

@Service
public class AdminCompanyService {
	
	private final AdminCompanyMapper adminCompanyMapper;
	
	public AdminCompanyService(AdminCompanyMapper adminCompanyMapper) {
		this.adminCompanyMapper = adminCompanyMapper;
		}
	
	//업체 입점 승인 폼
	public String companySuccess() {
		return "admin/companypage/sellerCompanyCheck";
	}
	
	//입점 업체 정보 및 리스트
	public List<Launching> companyInfoList(Map<String, Object> map) {
		List<Launching> sellerCompanyList = adminCompanyMapper.companyInfoList(map);
		return sellerCompanyList;
	}
	
	//입점 업체 정보 수정
	public String companyInfoModify() {
		return "admin/companypage/sellerCompanyModify";
	}
	
	//업체 정보 삭제 승인 폼
	public String companyRemoveSuccess() {
		return "admin/companypage/sellerCompanyDelete";
	}
	
	//업체 정보 삭제
	public String companyInfoRemove() {
		return "admin/companypage/sellerCompanyRemove";
	}
	
	//입점 업체 탈퇴/승인 상세 정보
	public List<Enterprise> companyInfoDetail(Map<String, Object> map) {
		List<Enterprise> sellerCompanyDetail = adminCompanyMapper.companyInfoDetail(map);
		return sellerCompanyDetail;
	}
}
