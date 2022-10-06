package ks44team02.seller.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks44team02.dto.Launching;
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
	@GetMapping("/companyInsert")
	public String addCompany(Model model
							,HttpSession session) {
		List<Launching> sellerCompanyInfoList = sellerCompanyService.sellerCompanyInfoList();
		
		model.addAttribute("title", "업체 정보 등록");
		model.addAttribute("sellerCompanyInfoList", sellerCompanyInfoList);	
		return "seller/companypage/companyInsert";
	}	
	
	/*
	//아이디 중복 체크
	@RequestMapping("/companyInsert")
	public String companyInsert(@RequestParam("member_id") String member_id) throws Exception
	{
		System.out.println("닉네임 중복 체크 확인하기");
			return us.companyInsert(member_id);
	}
	*/
	
	//업체 정보 검색 및 전체 리스트
	@GetMapping("/companyList")
	public String sellerCompanyInfo() {
		return "seller/companypage/companyList";
	}
	
	//업체 세부 정보 화면
	public String companyDetail() {
		return null;
	}
	
	//업체 정보 수정
	@GetMapping("/companyModify")
	public String sellerCompanyModify() {
		return "seller/companypage/companyModify";
	}
	
	//업체 정보 삭제
	@GetMapping("/companyDelete")
	public String sellerCompanyRemove() {
		return "seller/companypage/companyDelete";
	}
}