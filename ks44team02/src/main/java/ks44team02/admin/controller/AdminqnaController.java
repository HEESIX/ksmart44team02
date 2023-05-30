package ks44team02.admin.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.QnA;
import ks44team02.service.CommonService;
import ks44team02.service.MileageService;
import ks44team02.service.QnAservice;

@Controller
@RequestMapping(value = "/admin/qnaManage")
public class AdminqnaController {

	private static final Logger log = LoggerFactory.getLogger(AdminqnaController.class);

	private final QnAservice qnaService;

	
	public AdminqnaController(QnAservice qnaService) {
		this.qnaService = qnaService;
	}

	@PostConstruct
	public void adminqnaControllerInit() {
		log.info("adminqnaControllerInit bean 생성");
	}
	
	@GetMapping("/qnaList")
	@ResponseBody
	public QnA getMileageList(@RequestParam(name="memberId") String memberId){
		QnA qnaList = qnaService.getQnAListSearch(memberId);
		return qnaList;
	}
	
	//회원 적립금 조회 화면
	@GetMapping("/qna_list")
	public String getqnaList(Model model) {
		log.info("/mileageManage/mileage_management getMileageList AdminMileageController");
		System.out.println("/mileageManage/mileage_management getMileageList AdminMileageController");
		
		//처음에 아이디값 없다면 전체 조회
		
		//아이디가 있다면 아래 메서드 호출로 처리 하면 됩니다.
		
		// 또는 mapper 에서 select 쿼리 조건 처리 하면 쉽게 해결 됩니다. 
		
		QnA qnaList = qnaService.getqnaList();
		log.info("mileageList : ", qnaList);
		System.out.println(qnaList.toString());
		model.addAttribute("title", "회원 문의 현황");
		model.addAttribute("qnaList", qnaList);
		
		
		
		return "admin/qnaManage/qna_list";
	}
	
	//회원 적립금 조회
	@PostMapping("/qna_list")
	public String getQnAListSearch(Model model
									  ,@RequestParam(value = "memberId") String memberId) throws ParseException {
		log.info("PostMapping /mileage_management getMileageListSearch AdminMileageController");
		QnA qnaList = null;
		
		if(memberId == null || memberId.equals("")){
			qnaList = qnaService.getqnaList();

		}else {
			qnaList = qnaService.getQnAListSearch(memberId);
		}
			

		model.addAttribute("title","적립금 조회");
		model.addAttribute("mileageList", qnaList);
		
		return "admin/qnaManage/qna_list";
	}
	

}
