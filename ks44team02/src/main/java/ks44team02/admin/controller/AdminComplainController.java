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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Complain;
import ks44team02.dto.GoodsCategory;
import ks44team02.service.CommonService;
import ks44team02.service.ComplainService;

@Controller
@RequestMapping(value = "/admin")
public class AdminComplainController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final ComplainService complainService;

	private final CommonService commonService;

	public AdminComplainController(ComplainService complainService, CommonService commonService) {
		this.complainService = complainService;
		this.commonService = commonService;
	}

	@PostConstruct
	public void adminComplainControllerInit() {
		log.info("adminComplainControllerInit bean 생성");
	}
	
	//회원 신고내역 조회
	@GetMapping("/complainManage/complainList")
	public String getComplainList(Model model) {
		log.info("/complainManage/complainList getComplainList AdminComplainController");
		System.out.println("/complainManage/complainList getComplainList AdminComplainController");
		List<Complain> complainList = complainService.getComplainList();
		System.out.println(complainList.toString());
		model.addAttribute("title", "회원 신고내역 현황");
		model.addAttribute("complainList", complainList);
		return "admin/complainManage/complainList";
	}

	//회원 신고내역 삭제 폼
	@GetMapping("/complainManage/complainDelete")
	public String ComplainDeleteForm(@PathVariable(value = "complainCode") String complainCode,
			Model model) {
		Complain complainInfo  = complainService.getComplainInfo(complainCode);
		System.out.println(complainInfo.toString());
		model.addAttribute("title", "회원 신고내역 삭제");
		model.addAttribute("goodsCategoryInfo", complainInfo);
		return "admin/complainManage/complainDelete";
	}
	
	//회원 신고내역 삭제처리
	@PostMapping("/complainManage/complainDelete/{complainCode}")
	public String ComplainDelete(@RequestParam(value = "complainCode") String complainCode,
									HttpSession session, RedirectAttributes reAttr) {
		// session 저장하는 로그인 완성되면 이 부분 session 아이디 가져오게 교체
		// String memberId = session.getAttribute("SID");
		// null일 경우 체크(비정상적인 접근)
		// 현재 없으므로 픽스된 값 입력
		complainCode = "Complain_15";
		boolean complainCodeCheck = commonService.ComplainDelete(complainCode);
		if (complainCodeCheck) {
			// 코드 일치
			complainService.ComplainDelete(complainCode);
			reAttr.addAttribute("msg", "신고가 정상적으로 삭제되었습니다.");
		} else {
			// 코드 불일치
			reAttr.addAttribute("msg", "삭제 실패: 코드가 일치하지 않습니다.");
		}
		return "admin/complainManage/complainDelete";
	}
}
