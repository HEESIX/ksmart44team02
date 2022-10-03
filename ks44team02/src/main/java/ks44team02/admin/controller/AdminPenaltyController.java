package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.Penalty;
import ks44team02.service.CommonService;
import ks44team02.service.PenaltyService;

@Controller
@RequestMapping(value = "/admin")
public class AdminPenaltyController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final PenaltyService penaltyService;

	private final CommonService commonService;
	public AdminPenaltyController(PenaltyService penaltyService, CommonService commonService) 
	{
		this.penaltyService = penaltyService;
		this.commonService = commonService;
	}

	@PostConstruct
	public void adminPenaltyControllerInit() {
		log.info("adminqnaControllerInit bean 생성");
	}
	
	//패널티 부여 폼
	@GetMapping("/pernaltyManage/givePenalty/{penaltyStateCode}")
	public String givePenaltyForm(@PathVariable(value = "penaltyStateCode") String penaltyStateCode,
                         Model model) {
Penalty penaltyInfo = penaltyService.getPenaltyInfo(penaltyStateCode);
System.out.println(penaltyInfo.toString());
		return "admin/pernaltyManage/givePenalty";
	}
	
	//패널티 부여 처리
	@PostMapping("/pernaltyManage/givePenalty")
	public String givePenalty(Penalty penalty, RedirectAttributes reAttr) {
		String penaltyStateCode = commonService.getNewCode("tb_penalty_state");
		penalty.setPenaltyStateCode(penaltyStateCode);
		boolean result = penaltyService.givePenalty(penalty);
		String msg = "";
		if (result) {
			msg = "패널티 부여";
		} else {
			msg = "패널티 부여 불가";
		}
		reAttr.addAttribute("msg", msg);

		return"/admin/pernaltyManage/givePenalty";
	}

}
