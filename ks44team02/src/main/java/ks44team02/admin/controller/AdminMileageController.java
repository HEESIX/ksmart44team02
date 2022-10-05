package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.mapper.MileageMapper;
import ks44team02.service.CommonService;
import ks44team02.service.MileageService;

@Controller

@RequestMapping(value="/admin/mileageManage", method=RequestMethod.GET)
public class AdminMileageController<Mileage> {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);



	private final MileageService mileageService;


	private final CommonService commonService;


	public AdminMileageController(MileageService mileageService, CommonService commonService) {
		this.mileageService = mileageService;
		this.commonService = commonService;
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
	public String giveMileageForm(@PathVariable(value = "mMileageCode") String mMileageCode,
			                  @PathVariable(value = "currentMileage") String currentMileage
			,Model model
			,Model model1) {
     MemberMileageAcc memberMileageAccInfo = mileageService.getMileageInfo(mMileageCode, currentMileage);
     System.out.println(memberMileageAccInfo.toString());
     		return "admin/mileageManage/mileage_give";
	}
	
	//적립금 적립 처리
	@PostMapping("/mileage_give")
	public String giveMileage(MemberMileageAcc memberMileageAcc, RedirectAttributes reAttr) {
		String mMileageCode = commonService.getNewCode("tb_member_mileage_acc");
		memberMileageAcc.setmMileageCode(mMileageCode);
		boolean result = mileageService.giveMileage(memberMileageAcc);
		String msg = "";
		if (result) {
			msg = "적립 성공";
		} else {
			msg = "적립 실패";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:admin/mileageManage/mileage_give";
	}
	
	//적립금 소멸 폼
	@GetMapping("/mileage_extinct/{currentMileage}")
	public String MileageExtinctionForm(@PathVariable(value = "currentMileage") String currentMileage,
										@PathVariable(value = "mMileageCode") String mMileageCode
			,Model model
			,Model model1) {
		 MemberMileageAcc mileageExtinct = mileageService.getMileageInfo(currentMileage, mMileageCode);
		return "admin/mileageManage/mileage_extinct";
	}
	
	//적립금 소멸처리
	@PostMapping("/mileage_extinct")
	public String MileageExtinction(@RequestParam(value = "mMileageCode") String mMileageCode,
			@RequestParam(value = "currentMileage") String currentMileage, HttpSession session, RedirectAttributes reAttr) {
			mMileageCode = "m_acc_id001";
		boolean mileageExtinct = commonService.MileageExtinction(mMileageCode, currentMileage);
		if(mileageExtinct) {
			//
			mileageService.MileageExtinction(mMileageCode);
			reAttr.addAttribute("msg", "적립금 소멸이 정상적으로 완료되었습니다.");
		}else {
			//아이디 비번 불일치
			reAttr.addAttribute("msg", "소멸 실패: 적립금이 존재하지 않습니다.");
		}
		return "redirect:admin/mileageManage/mileage_extinct";
		
		
		
	
	}
	
}


