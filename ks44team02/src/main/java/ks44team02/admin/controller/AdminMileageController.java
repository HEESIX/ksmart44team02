package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.service.MileageService;

@Controller
@RequestMapping(value = "/admin/mileageManage")
public class AdminMileageController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final MileageService mileageService;

	public AdminMileageController(MileageService mileageService) {
		this.mileageService = mileageService;
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	
	//회원 적립금 조회 화면
	@GetMapping("/mileage_management")
	public String getMileageList(Model model) {
		log.info("/mileageManage/mileage_management getMileageList AdminMileageController");
		System.out.println("/mileageManage/mileage_management getMileageList AdminMileageController");
		List<MemberMileageAcc> mileageList = mileageService.getMileageList();
		System.out.println(mileageList.toString());
		model.addAttribute("title", "회원 적립금 현황");
		model.addAttribute("mileageList", mileageList);
		return "admin/mileageManage/mileage_management";
	}
	
	//회원 적립금 조회
	@PostMapping("/mileage_management")
	public String getMileageListSearch(Model model
									  ,@RequestParam(value = "memberId") String memberId) {
		List<MemberMileageAcc> mileageList = mileageService.getMileageList();

		model.addAttribute("title","적립금 조회");
		model.addAttribute("mileageList", mileageList);
		return "admin/mileageManagement/mileage_management";
	}
	
	//적립금 적립 폼
	@GetMapping("/mileage_give/{currentMileage}")
	public String giveMileageForm(@PathVariable(value = "earndMileage") String earndMileage,
			                  @PathVariable(value = "currentMileage") String currentMileage
			,Model model
			,Model model1) {
     MemberMileageAcc mileageAdd = mileageService.getMileageInfo(earndMileage);
     MemberMileageAcc mileageAdd1 = mileageService.getMileageInfo(currentMileage);
		return "admin/mileageManage/mileage_give";
	}
	
	//적립금 적립 처리
	@PostMapping("/mileage_give")
	public String giveMileage() {
		return "admin/mileageManage/mileage_give";
	}
	
	//적립금 소멸 폼
	@GetMapping("/mileage_extinct/{currentMileage}")
	public String MileageExtinctionForm(@PathVariable(value = "currentMileage") String currentMileage
			,Model model) {
		 MemberMileageAcc mileageExtinct = mileageService.getMileageInfo(currentMileage);
		return "admin/mileageManage/mileage_extinct";
	}
	
	//적립금 소멸처리
	@PostMapping("/mileage_extinct")
	public String MileageExtinction() {
		return "admin/mileageManage/mileage_extinct";
	}
	}


