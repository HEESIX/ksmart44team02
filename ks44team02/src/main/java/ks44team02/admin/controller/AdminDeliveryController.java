package ks44team02.admin.controller;

import java.util.List;

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

import ks44team02.dto.RefundExchangeReasons;
import ks44team02.service.AdminDeliveryeService;
import ks44team02.service.CommonService;

@Controller
@RequestMapping(value = "/admin/order")
public class AdminDeliveryController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdminDeliveryController.class);
	
	private final AdminDeliveryeService adminDeliveryeService;
	private final CommonService commonService;
	
	
	public AdminDeliveryController(AdminDeliveryeService adminDeliveryeService, CommonService commonService) {
		this.adminDeliveryeService = adminDeliveryeService;
		this.commonService = commonService;
	}
	
	
	//구매자의 배송현황 조회
	@GetMapping("/buyerOrderDeliveryStatus")
	public String getAdminOrderStatusList() {
		return null;
	}

	//환불 사유 카테고리 등록 폼
	@GetMapping("/refundExchangeReasonAdd")
	public String addRefundExchangeReason(Model model) {
		
		model.addAttribute("title", "사유 카테고리 등록");
		
		return "admin/order/refundExchangeReasonAdd";
	}

	//환불 사유 카테고리 등록 처리
	@PostMapping("/refundExchangeReasonAdd")
	public String addRefundExchangeReason(RefundExchangeReasons refundExchangeReasonList
										 ,RedirectAttributes reAttr) {
		String refundExchangeReasonsCode = commonService.getNewCode("tb_refund_exchange_reasons");
		refundExchangeReasonList.setRefundExchangeReasonsCode(refundExchangeReasonsCode);
		boolean result = adminDeliveryeService.addRefundExchangeReason(refundExchangeReasonList);
		String msg = "";
		if(result) {
			msg = "등록 성공";
		}else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:/admin/order/refundExchangeReasonList";
	}

	//환불 사유 카테고리 수정 폼
	@GetMapping("/refundExchangeReasonModify/{refundExchangeReasonsCode}")
	public String modifyRefundExchangeReason(@PathVariable(value = "refundExchangeReasonsCode") String refundExchangeReasonsCode
											,Model model) {
		
		RefundExchangeReasons refundExchangeReasonInfo = adminDeliveryeService.getRefundExchangeReasonsInfo(refundExchangeReasonsCode);
		model.addAttribute("title", "선택한 사유 수정");
		model.addAttribute("refundExchangeReasonInfo", refundExchangeReasonInfo);
		
		return "admin/order/refundExchangeReasonModify";
	}
	
	//환불 사유 카테고리 수정 처리
	@PostMapping("/refundExchangeReasonModify")
	public String modifyRefundExchangeReason(RefundExchangeReasons refundExchangeReasonList
											,RedirectAttributes reAttr) {
		boolean result = adminDeliveryeService.modifyRefundExchangeReason(refundExchangeReasonList);
		
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		
		return "redirect:/admin/order/refundExchangeReasonList";
	}
	
	//환불 사유 카테고리 삭제 폼
	@GetMapping("/refundExchangeReasonRemove/{refundExchangeReasonsCode}")
	public String removeRefundExchangeReason(@PathVariable(value = "refundExchangeReasonsCode") String refundExchangeReasonsCode
											,Model model) {
		RefundExchangeReasons refundExchangeReasonInfo = adminDeliveryeService.getRefundExchangeReasonsInfo(refundExchangeReasonsCode);
		System.out.println(refundExchangeReasonInfo.toString());
		model.addAttribute("title", "선택한 사유 카테고리 삭제");
		model.addAttribute("refundExchangeReasonInfo", refundExchangeReasonInfo);
		
		return "admin/order/refundExchangeReasonRemove";
	}
	
	//환불 사유 카테고리 삭제 처리
	@PostMapping("/refundExchangeReasonRemove")
	public String removeRefundExchangeReason(@RequestParam(value = "refundExchangeReasonsCode") String refundExchangeReasonsCode
											,@RequestParam(value = "memberPw") String memberPw 
											,HttpSession session
											,RedirectAttributes reAttr) {
		//session 저장하는 로그인 완성되면 이 부분 session 아이디 가져오게 교체
		//String memberId = session.getAttribute("SID");
		//null일 경우 체크(비정상적인 접근)
		//현재 없으므로 픽스된 값 입력
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		if(idCheckResult) {
			//아이디 비번일치
			adminDeliveryeService.removeRefundExchangeReason(refundExchangeReasonsCode);
			reAttr.addAttribute("msg", "정상 삭제 처리되었습니다.");
		}else {
			//아이디 비번 불일치
			reAttr.addAttribute("msg", "삭제 실패: 비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/admin/order/refundExchangeReasonList";
	}
	
	
	//환불 사유 카테고리 리스트
	@GetMapping("/refundExchangeReasonList")
	public String getRefundExchangeReasonList(Model model
											,@RequestParam(value = "msg", required = false) String msg) {
		List<RefundExchangeReasons> refundExchangeReasonList = adminDeliveryeService.getRefundExchangeReasonList();
		
		model.addAttribute("titele", "환불/교환사유 목록");
		model.addAttribute("refundExchangeReasonList", refundExchangeReasonList);
		if(msg!=null) model.addAttribute("msg", msg);
		
		return "admin/order/refundExchangeReasonList";
	}
}

