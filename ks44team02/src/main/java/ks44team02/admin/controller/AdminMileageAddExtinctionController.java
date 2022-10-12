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
import ks44team02.service.CommonService;
import ks44team02.service.MileageService;

@Controller
@RequestMapping(value = "/admin/mileageManage")
public class AdminMileageAddExtinctionController {

	private static final Logger log = LoggerFactory.getLogger(AdminMileageAddExtinctionController.class);

	private final MileageService mileageService;

	private final CommonService commonService;

	public AdminMileageAddExtinctionController(MileageService mileageService, CommonService commonService) {
		this.mileageService = mileageService;
		this.commonService = commonService;
	}

	@PostConstruct
	public void adminMileageControllerInit() {
		log.info("adminMileageControllerInit bean 생성");
	}

	// 적립금 적립 폼
	/* @GetMapping("/mileage_give/{currentMileage}") */
	@GetMapping("/mileageGiveExtinct")
	public String giveMileageForm(Model model, MemberMileageAcc memberMileageAcc) {

		String memberId 	= memberMileageAcc.getMemberId();
		String mMileageCode = memberMileageAcc.getmMileageCode();
		int currentMileage 	= memberMileageAcc.getCurrentMileage();
		log.info("get mileageGiveExtinct giveMileageForm AdminMileageAddExtinctionController.java");
		log.info(mMileageCode + "<- mMileageCode");
		log.info(currentMileage + "<- currentMileage");
		log.info(memberId + "<- memberId");
		List<MemberMileageAcc> mileageList = null;
		
			if(memberId == null || memberId.equals("")) {
				
				mileageList = mileageService.getMileageList();
				
			}else {
				mileageList = mileageService.giveMileageForm(memberMileageAcc);
				
			}
		
		MemberMileageAcc memberMileageAccInfo = mileageService.getMileageInfo(memberMileageAcc);
		System.out.println(memberMileageAccInfo.toString());
		model.addAttribute("title", "회원 적립금 적립 폼");
		model.addAttribute("memberMileageAccInfo", memberMileageAccInfo);
		return "admin/mileageManage/mileageGiveExtinct";
	}
 /*
	// 적립금 적립 처리
	@PostMapping("/mileageGiveExtinct")
	public String giveMileage(MemberMileageAcc memberMileageAcc, RedirectAttributes reAttr) {
		log.info("get mileageGiveExtinct giveMileageForm AdminMileageAddExtinctionController.java");
		 log.info(mMileageCode + "<- mMileageCode");
		log.info(currentMileage + "<- currentMileage");
		log.info(memberId + "<- memberId"); 

	

	// 적립금 소멸 폼
	@GetMapping("/mileageGiveExtinct/{currentMileage}")
	public String MileageExtinctionForm(@PathVariable(value = "currentMileage") String currentMileage,
			@PathVariable(value = "mMileageCode") String mMileageCode, Model model, Model model1) {
		MemberMileageAcc mileageExtinct = mileageService.getMileageInfo(currentMileage, mMileageCode);
		model.addAttribute("title", "회원 적립금 소멸 폼");
		model.addAttribute("mileageExtinct", mileageExtinct);
		return "admin/mileageManage/mileage_giveExtinct";
	}

	// 적립금 소멸처리
	@PostMapping("/mileageGiveExtinct")
	public String MileageExtinction(@RequestParam(value = "mMileageCode") String mMileageCode,
			@RequestParam(value = "currentMileage") String currentMileage, HttpSession session,
			RedirectAttributes reAttr) {
		mMileageCode = "m_acc_id001";
		boolean mileageExtinct = commonService.MileageExtinction(mMileageCode, currentMileage);
		if (mileageExtinct) {
			//
			mileageService.MileageExtinction(mMileageCode);
			reAttr.addAttribute("msg", "적립금 소멸이 정상적으로 완료되었습니다.");
		} else {
			// 아이디 비번 불일치
			reAttr.addAttribute("msg", "소멸 실패: 적립금이 존재하지 않습니다.");
		}
		return "redirect:admin/mileageManage/mileageGiveExtinct";

	}*/

}
