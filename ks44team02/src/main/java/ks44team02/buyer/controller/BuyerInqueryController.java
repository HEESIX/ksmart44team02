package ks44team02.buyer.controller;

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

import ks44team02.dto.MemberMileageAcc;
import ks44team02.dto.QnA;
import ks44team02.service.CommonService;
import ks44team02.service.QnAservice;

@Controller
@RequestMapping(value = "/buyer/inquery")
public class BuyerInqueryController {

	private static final Logger log = LoggerFactory.getLogger(BuyerInqueryController.class);

	private final QnAservice qnaService;
	
	private final CommonService commonService;

	public BuyerInqueryController(QnAservice qnaService, CommonService commonService) {
		this.qnaService = qnaService;
		this.commonService = commonService;
	}

	@PostConstruct
	public void adminInqueryControllerInit() {
		log.info("adminInqueryControllerInit bean 생성");
	}
	
	//구매자 문의 조회 화면
	@GetMapping("/inqueryList")
	public String getBuyerInqueryList(Model model) {
		log.info("/inquery/inqueryList getBuyerInqueryList BuyerInqueryController");
		System.out.println("/inquery/inqueryList getBuyerInqueryList BuyerInqueryController");
		List<QnA> qnaList = qnaService.getBuyerInqueryList();
		System.out.println(qnaList.toString());
		model.addAttribute("title", "회원 적립금 현황");
		model.addAttribute("mileageList", qnaList);
		return "buyer/inquery/inqueryList";
		
	}
	
	//구매자 문의 조회
	@PostMapping("/inqueryList")
	public String getBuyerInqueryListSearch(Model model
									  ,@RequestParam(value = "memberId") String memberId) {
		List<QnA> qnaList = qnaService.getBuyerInqueryList();

		model.addAttribute("title","적립금 조회");
		model.addAttribute("mileageList", qnaList);
		return "buyer/inquery/inqueryList";
	}
	
	
	//구매자 문의 등록 폼
	@GetMapping("/regInquery/{qnaContents}")
		public String regBuyerInqueryForm(@PathVariable(value = "qnaContents") String qnaContents,
                @PathVariable(value = "qnaTitle") String qnaTitle
,Model model
,Model model1) {

	QnA	qnaInfo = qnaService.getQnAInfo(qnaContents, qnaTitle);
System.out.println(qnaInfo.toString());
			return "buyer/inquery/regInquery";
		}
	
	
	//구매자 문의 등록 처리
	@PostMapping("/regInquery")
	public String regBuyerInquery(QnA qna, RedirectAttributes reAttr) {
		String qnaCode = commonService.getNewCode("tb_qna");
		qna.setQnaCode(qnaCode);
		boolean result = qnaService.regBuyerInquery(qna);
		String msg = "";
		if (result) {
			msg = "등록 완료";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:/buyer/inquery/regInquery";
	}

	
		//구매자 문의 수정 폼
		@GetMapping("/modifyInquery/{qnaContents}")
		public String modifyBuyerInqueryForm(@PathVariable(value = "qnaContents") String qnaContents,
                @PathVariable(value = "qnaTitle") String qnaTitle
				,Model model
				,Model model1) {
			QnA qnaInfo = qnaService.getQnAInfo(qnaContents, qnaTitle);
			System.out.println(qnaInfo.toString());
			return "buyer/inquery/modifyInquery";
		}
		
		//구매자 문의 수정 처리
		 @PostMapping("/modifyInquery")
		 public String modifyBuyerInquery(QnA qna, RedirectAttributes reAttr) {
				String qnaContents = commonService.getNewCode("tb_qna");
				qna.setQnaContents(qnaContents);
				boolean result = qnaService.modifyBuyerInquery(qna);
				String msg = "";
				if (result) {
					msg = "수정 완료";
				} else {
					msg = "수정 실패";
				}
				reAttr.addAttribute("msg", msg);
				return "redirect:/buyer/inquery/modifyInquery";
			}
		 
		//구매자 문의 삭제 폼
		 @GetMapping("/deleteInquery/{qnaContents}")
		public String deleteBuyerInqueryForm(@PathVariable(value = "qnaContents") String qnaContents,
				@PathVariable(value = "qnaCode") String qnaCode
,Model model
,Model model1) {
QnA qnaDelete = qnaService.getQnAInfo(qnaContents, qnaCode);
			return "buyer/inquery/deleteInquery";
		}	
		 
		 //구매자 문의 삭제 처리
		 @PostMapping("/deleteInquery")
		 public String deleteBuyerInquery(@RequestParam(value = "qnaContents") String qnaContents,
					@RequestParam(value = "qnaCode") String qnaCode, HttpSession session, RedirectAttributes reAttr) {
			 qnaCode = "qna_46549696";
			boolean qnaDelete = commonService.deleteBuyerInquery(qnaCode, qnaContents);
			if(qnaDelete) {
				//코드 일치
				qnaService.deleteBuyerInquery(qnaCode);
				reAttr.addAttribute("msg", "문의 삭제가 완료되었습니다.");
			}else {
				//코드불일치
				reAttr.addAttribute("msg", "삭제 실패: 문의가 존재하지 않습니다.");
			}
				return "buyer/inquery/deleteInquery";
			}	
}
