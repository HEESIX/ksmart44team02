package ks44team02.seller.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.dto.OrderDetail;
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
								 ,HttpSession session) {
			// 세션이 존재 하는 경우 세션에서 값을 가져와서 세팅: memberId
			//String memberId = session.getAttribute("SID");
			String memberId = "id010";
			List<OrderDetail> sellerOrderList = deliveryservice.sellerOrderList(memberId);
				model.addAttribute("title", "주문 관리");
				model.addAttribute("sellerOrderList", sellerOrderList);
				log.info(">>>>>>>>>>>>>>>>>>>>{}", sellerOrderList);
		
		return "seller/order/sellerOrderDeliveryAllList";
	}
	
	
	
	

	
	//구매자 주문배송처리 폼
	@GetMapping("/sellerOrderStatusDeal/")
	public String OrderDeal(Model model) {
		return null;
	}
	
	
	//구매자 주문배송 처리
	@PostMapping("/sellerOrderStatusDeal")
	public String OrderDeal() {
		return null;
	}
}

