package ks44team02.seller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Delivery;
import ks44team02.dto.OrderDetail;
import ks44team02.dto.OrderStatus;
import ks44team02.dto.OrderStatusStandard;
import ks44team02.service.DeliveryService;

@Controller
@RequestMapping(value = "/seller/order")
public class SellerDeliveryController {
	
	
	private static final Logger log = LoggerFactory.getLogger(SellerDeliveryController.class);
	private final DeliveryService deliveryservice;
	
	public SellerDeliveryController(DeliveryService deliveryservice) {
		this.deliveryservice = deliveryservice;
	}
	
	//신규 주문 및 배송 현황 조회(구매자 전체)
	@GetMapping("/sellerOrderDeliveryAllList")
	public String sellerOrderList(Model model
								 ,HttpSession session
								 ,@RequestParam(value = "msg", required = false) String msg) {
		// 세션이 존재 하는 경우 세션에서 값을 가져와서 세팅: memberId
		//String memberId = session.getAttribute("SID");
		String memberId = "id010";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("memberId", memberId);
		List<OrderDetail> sellerOrderList = deliveryservice.sellerOrderList(paramMap);
		
		if(msg!=null) model.addAttribute("msg", msg);
		
		model.addAttribute("title", "주문 관리");
		model.addAttribute("sellerOrderList", sellerOrderList);
		log.info(">>>>>>>>>>>>>>>>>>>>{}", sellerOrderList);
		
		return "seller/order/sellerOrderDeliveryAllList";
	}
	
	//주문서 상세정보
	@GetMapping("/sellerOrderDetail")
	public String getSellerOrderDetail(Model model
									 ,@RequestParam(value = "orderDetailCode") String orderDetailCode) {
		Map<String, Object> getSellerOrderDetail = deliveryservice.getSellerOrderDetail(orderDetailCode);
		
		model.addAttribute("title", "상세주문정보");
		model.addAttribute("getSellerOrderDetail", getSellerOrderDetail);
		return "seller/order/sellerOrderDetail";
		
	}
	

	
	//주문서 상태별 조회 처리
	@PostMapping("/sellerOrderDeliveryAllList")
	public String sellerOrderList(@RequestParam(name = "searchKey", defaultValue = "goodsName") String sk
								 ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String sv
								 ,Model model
								 ,HttpSession session){
		
		//1. searchKey -> memberId, memberName _____ -> db에 있는 컬럼 및 매칭 처리	
		if("goodsName".equals(sk)) {
			sk = "g_name";
		}else if("orderStatusStandardDetails".equals(sk)){
			sk = "order_status_standard_details";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sk", sk);
		paramMap.put("sv", sv);
		
		//String memberId = session.getAttribute("SID");
		String memberId = "id010";
		
		paramMap.put("memberId", memberId);
		
		
		List<OrderDetail> sellerOrderList = deliveryservice.sellerOrderList(paramMap);
		
		model.addAttribute("title", "주문서 현황 조회");
		model.addAttribute("sellerOrderList", sellerOrderList);
		return "seller/order/sellerOrderDeliveryAllList";
	
	}
	
	
	//들어온 주문서 주문상태 수정 폼
	@GetMapping("/sellerOrderDeliveryModify/{orderDetailCode}")
	public String modifyOrderStatus(@PathVariable(value = "orderDetailCode") String orderDetailCode
									,Model model){
		OrderDetail orderDetailInfo = deliveryservice.getOrderStatusInfo(orderDetailCode);	
		List<OrderStatusStandard> standardList = deliveryservice.getOrderStatusStandard();
		OrderStatus getOrderStatusInfo = deliveryservice.getOrderStatus(orderDetailCode);
		log.info(">>>>>>>>>>>>>>>{}", orderDetailInfo);
		log.info(">>>>>>>>>>>>>>>{}", standardList);
		log.info(">>>>>>>>>>>>>>>{}", getOrderStatusInfo);
		
		model.addAttribute("title", "선택한 주문서 주문상태 변경");
		model.addAttribute("orderDetailInfo", orderDetailInfo);
		model.addAttribute("standardList", standardList);
		model.addAttribute("getOrderStatusInfo", getOrderStatusInfo);
		
		return "seller/order/sellerOrderDeliveryModify";
	}
	
	
	//주문서 주문상태 업데이트 처리
	@PostMapping("/sellerOrderDeliveryModify")
	public String modifyOrderStatus(@RequestParam(value = "orderDetailCode") String orderDetailCode
								   ,@RequestParam(value = "orderStatusStandardCode") String orderStatusStandardCode
								   ,RedirectAttributes reAttr) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderDetailCode", orderDetailCode);
		map.put("orderStatusStandardCode", orderStatusStandardCode);
		
		boolean result = deliveryservice.modifyOrderStatus(map);
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		
		return "redirect:/seller/order/sellerOrderDeliveryAllList";
	}
	
	
	
	//주문서 운송장번호 등록
	@PostMapping("/addDeliNumber")
	@ResponseBody
	public String addDeliNumber(Delivery delivery,RedirectAttributes reAttr) {
		log.info(">>>>>>>>>검색{}", delivery);
		
		boolean result = deliveryservice.addDeliNumber(delivery);
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		return  "redirect:/seller/order/sellerOrderDeliveryAllList";
	}
	

}

