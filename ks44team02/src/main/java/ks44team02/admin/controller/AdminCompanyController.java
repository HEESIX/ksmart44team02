package ks44team02.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.Launching;
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
	public String companyInfoList	(Model model
									,@RequestParam(value = "sk", required = false) String sk
									,@RequestParam(value = "sv", required = false) String sv) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(sk, sv);
		List<Launching> sellerCompanyList = adminCompanyService.companyInfoList(map);
		log.info(">>>>>>>>>>>> {}", sellerCompanyList);
		model.addAttribute("title", "회원정보리스트");
		model.addAttribute("sellerCompanyList", sellerCompanyList);
		return "admin/companypage/sellerCompanyList";
	}
	
	//입점 업체 정보 수정
	@GetMapping("/sellerCompanyModify")
	public String companyInfoModify() {
		return "admin/companypage/sellerCompanyModify";
	}
	
	//업체 정보 삭제 승인 폼
	@GetMapping("/sellerCompanyDelete")
	public String companyRemoveSuccess() {
		return "admin/companypage/sellerCompanyDelete";
	}
	
	//업체 정보 삭제
	@GetMapping("/sellerCompanyRemove")
	public String companyInfoRemove() {
		return "admin/companypage/sellerCompanyRemove";
	}
		
	//입점 업체 탈퇴/승인 상세 정보
	@GetMapping("/sellerCompanyDetail")
	public String companyInfoDetail() {
		return "admin/companypage/sellerCompanyDetail";
	}
}
