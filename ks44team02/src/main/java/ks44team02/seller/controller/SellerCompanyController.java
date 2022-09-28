package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ks44team02.service.SellerCompanyService;

@Controller
@RequestMapping(value = "/seller/companypage")
public class SellerCompanyController {

	private static final Logger log = LoggerFactory.getLogger(SellerCompanyController.class);
	
	private final SellerCompanyService sellerCompanyService;
	
	public SellerCompanyController(SellerCompanyService sellerCompanyService) {
		this.sellerCompanyService = sellerCompanyService;
	}
	
	//업체 정보 등록
	@GetMapping("/company_insert")
	public String addCompany() {
		return "seller/companypage/company_insert";
	}
		
	//업체 정보 검색 및 전체 리스트
	@GetMapping("/company_list")
	public String sellerCompanyInfo() {
		return "seller/companypage/company_list";
	}
		
	//업체 세부 정보 화면
	public String company_detail() {
		return null;
	}
		
	//업체 정보 수정
	@GetMapping("/company_modify")
	public String sellerCompanyModify() {
		return "seller/companypage/company_modify";
	}
		
	//업체 정보 삭제
	@GetMapping("/company_delete")
	public String sellerCompanyRemove() {
		return "seller/companypage/company_delete";
	}
}