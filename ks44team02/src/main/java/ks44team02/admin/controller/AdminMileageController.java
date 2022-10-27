package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.service.MileageService;

@Controller

@RequestMapping(value="/admin/mileageManage")
public class AdminMileageController<Mileage> {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);



	private final MileageService mileageService;


	

	public AdminMileageController(MileageService mileageService) {
		this.mileageService = mileageService;
		
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}
	
	@GetMapping("/mileageList")
	@ResponseBody
	public List<MemberMileageAcc> getMileageList(@RequestParam(name="memberId") String memberId){
		List<MemberMileageAcc> mileageList = mileageService.getMileageListSearch(memberId);
		return mileageList;
	}
	
	//회원 적립금 조회 화면
	@GetMapping("/mileageManagement")
	public String getMileageList(Model model) {
		log.info("/mileageManage/mileage_management getMileageList AdminMileageController");
		System.out.println("/mileageManage/mileage_management getMileageList AdminMileageController");
		
		//처음에 아이디값 없다면 전체 조회
		
		//아이디가 있다면 아래 메서드 호출로 처리 하면 됩니다.
		
		// 또는 mapper 에서 select 쿼리 조건 처리 하면 쉽게 해결 됩니다. 
		
		List<MemberMileageAcc> mileageList = mileageService.getMileageList();
		log.info("mileageList : ", mileageList);
		System.out.println(mileageList.toString());
		model.addAttribute("title", "회원 적립금 현황");
		model.addAttribute("mileageList", mileageList);
		
		
		
		return "admin/mileageManage/mileageManagement";
	}
	
	//회원 적립금 조회
	@PostMapping("/mileageManagement")
	public String getMileageListSearch(Model model
									  ,@RequestParam(value = "memberId") String memberId) throws ParseException {
		log.info("PostMapping /mileage_management getMileageListSearch AdminMileageController");
		List<MemberMileageAcc> mileageList = null;
		
		if(memberId == null || memberId.equals("")){
			mileageList = mileageService.getMileageList();

		}else {
			mileageList = mileageService.getMileageListSearch(memberId);
		}
			

		model.addAttribute("title","적립금 조회");
		model.addAttribute("mileageList", mileageList);
		
		return "admin/mileageManage/mileageManagement";
	}
	
	
}


