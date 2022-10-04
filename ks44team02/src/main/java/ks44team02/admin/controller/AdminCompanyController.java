package ks44team02.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.AdminCompanyService;

@Controller
@RequestMapping(value = "/admin/companypage")
public class AdminCompanyController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminCompanyController.class);
	
	private final AdminCompanyService adminCompanyService;
	
	public AdminCompanyController(AdminCompanyService adminCompanyService) {
		this.adminCompanyService = adminCompanyService;
	}
	
	//업체 입점 승인 폼
	@GetMapping("/sellerCompanyCheck")
	public String companySuccess() {
		return "admin/companypage/sellerCompanyCheck";
	}
	
	//입점 업체 정보 및 리스트
	@GetMapping("/sellerCompanyList")
	public String companyInfoList() {
		return "admin/companypage/sellerCompanyList";
	}
	
	//업체 정보 삭제 승인 폼
	@GetMapping("/sellerCompanyDelete")
	public String companyRemoveSuccess() {
		return "admin/companypage/sellerCompanyDelete";
	}
}
