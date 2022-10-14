package ks44team02.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import ks44team02.dto.BuyerBenefit;
import ks44team02.dto.OrderDiscount;
import ks44team02.service.DiscountService;
import ks44team02.service.CommonService; 

@Controller
@RequestMapping(value = "/admin/orderDiscount")
public class AdminDiscountController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AdminDiscountController.class);

	private final DiscountService discountService;
	private final CommonService commonService;
	
	public AdminDiscountController(DiscountService DiscountService, CommonService commonService) {
		this.discountService = DiscountService;
		this.commonService = commonService;
	}
	
	@PostConstruct
	public void adminDiscountControllerInit() {
		log.info("AdminDiscountController bean 생성");
	}
	//주문서별 할인혜택 목록 조회 화면
	@GetMapping("/orderDiscountList")
	public String getOrderDiscountList(Model model
									  ,@RequestParam(value = "msg", required = false) String msg) {
		

		List<OrderDiscount> orderDiscountList = discountService.getOrderDiscountList(null);
		orderDiscountList = discountService.getOrderDiscountList(null);
		log.info("할인혜택 목록 조회 :::: {}", orderDiscountList);
		
		model.addAttribute("title", "주문서별 할인혜택 목록 전체 조회");
		model.addAttribute("orderDiscountList", orderDiscountList);
		if(msg!=null) model.addAttribute("msg", msg);
		
		return "admin/orderDiscount/orderDiscountList";
	}
	//주문서별 할인혜택 목록 검색 처리
	@PostMapping("/orderDiscountList")
	public String getSearchOrderDiscountList(@RequestParam(name="searchKey", defaultValue = "discountName") String sk
			 ,@RequestParam(name="searchValue", required = false, defaultValue = "") String sv
			 ,Model model) {
		
		//1. searchKey -> memberId, memberName _____ -> db에 있는 컬럼 및 매칭 처리
		if("discountName".equals(sk)) {
		sk = "discount_name";
		}else if("discountRate".equals(sk)) {
		sk = "discount_rate";
		}else if("discountPrice".equals(sk)) {
		sk = "discount_price";
		}else {
		sk = "g_production_reg_datetime";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sk",sk);
		paramMap.put("sv",sv);
		
		//2. ${} vs #{}	-> ${searchKey} LIKE ${searchValue} : ex) memberId LIKE 'id001'
		List<OrderDiscount> orderDiscountList = discountService.getOrderDiscountList(paramMap);
		
		//3. model 검색된 리스트를 출력하면 된다.
		model.addAttribute("title", "판매자목록조회");
		model.addAttribute("orderDiscountList", orderDiscountList);
		return "admin/orderDiscount/orderDiscountList";
	}
	//주문서별 할인혜택 등록 화면
	@GetMapping("/addOrderDiscount")
	public String addOrderDiscount(Model model
								  ,@RequestParam(value = "msg", required = false) String msg) {
		
		List<OrderDiscount> orderDiscountList = discountService.getOrderDiscountList(null);
		
		model.addAttribute("title", "하나의 주문서별 할인혜택 등록");
		model.addAttribute("title", "주문서별 할인혜택 목록 전체 조회");
		model.addAttribute("orderDiscountList", orderDiscountList);
		if(msg!=null) model.addAttribute("msg", msg);
		
		return "admin/orderDiscount/addOrderDiscount";
	}
	//주문서별 할인혜택 등록 처리
	@PostMapping("/addOrderDiscount")
	public String addOrderDiscount(OrderDiscount orderDiscount
								  ,RedirectAttributes reAttr
								  ,@RequestParam(value = "selectRatePrice") String selectRatePrice
								  ,@RequestParam(value = "discountNumber") int discountNumber
								  ) {
		
		if("rate".equals(selectRatePrice)) {
			orderDiscount.setDiscountRate(discountNumber);
			orderDiscount.setDiscountPrice(0);
		}else if("price".equals(selectRatePrice)) {
			orderDiscount.setDiscountPrice(discountNumber);
			orderDiscount.setDiscountRate(0);
		}
		String newCode = commonService.getNewCode("tb_order_discount_management");
		orderDiscount.setOrderDiscountCode(newCode);
		log.info(">>>>>>>>>>>{}",orderDiscount);
		
		boolean result = discountService.addOrderDiscount(orderDiscount);
		String msg = "";
		
		if (result) {
			msg = "등록 성공";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:/admin/orderDiscount/orderDiscountList";
	}
	//주문서별 할인혜택 수정 화면
	@GetMapping("/modifyOrderDiscount/{orderDiscountCode}")
	public String modifyOrderDiscount(@PathVariable(value = "orderDiscountCode") String orderDiscountCode
									,Model model) {
		
		OrderDiscount orderDiscountInfo = discountService.getOrderDiscountInfo(orderDiscountCode);
		
		List<OrderDiscount> orderDiscountList = discountService.getOrderDiscountList(null);
		
		model.addAttribute("title","선택한 주문서별 할인혜택 수정");
		model.addAttribute("orderDiscountInfo", orderDiscountInfo);
		model.addAttribute("orderDiscountList", orderDiscountList);
		return "admin/orderDiscount/modifyOrderDiscount";
	}
	//주문서별 할인혜택 수정 처리
	@PostMapping("/modifyOrderDiscount")
	public String modifyOrderDiscount(OrderDiscount orderDiscount
									 ,RedirectAttributes reAttr) {
		
		boolean result = discountService.modifyOrderDiscount(orderDiscount);
		
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		
		return "redirect:/admin/orderDiscount/orderDiscountList";
	}
	//주문서별 할인혜택 삭제 화면
	@GetMapping("/removeOrderDiscount/{orderDiscountCode}")
	public String removeOrderDiscount(@PathVariable(value = "orderDiscountCode") String orderDiscountCode
												   ,Model model) {
		
		OrderDiscount orderDiscountInfo = discountService.getOrderDiscountInfo(orderDiscountCode); 
		System.out.println(orderDiscountInfo.toString());
		model.addAttribute("title", "선택한 주문서별 할인혜택 삭제");
		model.addAttribute("orderDiscountInfo", orderDiscountInfo);
		
		return "admin/orderDiscount/removeOrderDiscount";
	}
	//주문서별 할인혜택 삭제 처리
	@PostMapping("/removeOrderDiscount")
	public String removeOrderDiscount(@RequestParam(value = "orderDiscountCode") String orderDiscountCode
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
			//아이디 비번 일치
			boolean result2 = discountService.removeOrderDiscount(orderDiscountCode);
			if(result2) {
				reAttr.addAttribute("msg", "삭제가 정상적으로 완료되었습니다");
			}else {
				reAttr.addAttribute("msg", "삭제 실패 : DiscountMapper 확인");
			}
		}else {
			reAttr.addAttribute("msg", "삭제 실패: 비밀번호를 확인해주세요.");
		}
		return "redirect:/admin/orderDiscount/orderDiscountList"; 
	}
	//전체 회원의 할인 혜택 보유 현황 조회
	@GetMapping("/allBuyerBenefitList")
	public String getAllBuyerBenefitList(Model model
									  ,@RequestParam(value = "msg", required = false) String msg) {
		

		List<BuyerBenefit> allBuyerBenefitList = discountService.getAllBuyerBenefitList(null);
		log.info("할인혜택 보유 현황 조회 :::: {}", allBuyerBenefitList);
		
		model.addAttribute("title", "주문서별 할인혜택 목록 전체 조회");
		model.addAttribute("allBuyerBenefitList", allBuyerBenefitList);
		if(msg!=null) model.addAttribute("msg", msg);
		
		return "admin/orderDiscount/allBuyerBenefitList";
	}
	//전체 회원의 할인 혜택 보유 현황 조회 처리
	@PostMapping("/allBuyerBenefitList")
	public String getAllBuyerBenefitList(@RequestParam(name="searchKey", defaultValue = "discountName") String sk
			 ,@RequestParam(name="searchValue", required = false, defaultValue = "") String sv
			 ,Model model) {
		
		//1. searchKey -> memberId, memberName _____ -> db에 있는 컬럼 및 매칭 처리
		if("memberId".equals(sk)) {
		sk = "member_id";
		}else if("discountName".equals(sk)) {
			sk = "discount_name";
		}else if("discountRate".equals(sk)) {
		sk = "discount_rate";
		}else if("discountPrice".equals(sk)) {
		sk = "discount_price";
		}else if("benefitIssueDate".equals(sk)) {
			sk = "benefit_issue_date";
		}else {
		sk = "benefit_expiration_date";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sk",sk);
		paramMap.put("sv",sv);
		
		//2. ${} vs #{}	-> ${searchKey} LIKE ${searchValue} : ex) memberId LIKE 'id001'
		List<BuyerBenefit> allBuyerBenefitList = discountService.getAllBuyerBenefitList(paramMap);
		//3. model 검색된 리스트를 출력하면 된다.
		model.addAttribute("title", "전체 회원의 할인 혜택 보유 현황 조회");
		model.addAttribute("allBuyerBenefitList", allBuyerBenefitList);
		return "admin/orderDiscount/allBuyerBenefitList";
	}
	//주문서별 할인혜택 회원한테 부여 화면
	@GetMapping("/giveOrderDiscount")
	public String giveOrderDiscount(Model model) {
		
		model.addAttribute("title", "할인혜택 부여");
		
		return "admin/orderDiscount/giveOrderDiscount";
	}
	//주문서별 할인혜택 회원한테 부여 처리
	@PostMapping("/giveOrderDiscount")
	public String giveOrderDiscount(OrderDiscount orderDiscount
			  					   ,RedirectAttributes reAttr) {
		
		boolean result = discountService.giveOrderDiscount(orderDiscount);
		String msg = "";
		if (result) {
		msg = "부여 성공";
		} else {
		msg = "부여 실패";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:/admin/orderDiscount/orderDiscountList";
		}
}
