package ks44team02.seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("/seller_order_delivery_all_list")
	public String getDelivery() {
		return "/seller/order/seller_order_delivery_all_list";
	}

	
	//구매자 주문배송처리 폼
	@GetMapping("/seller_order_status_deal")
	public String OrderDeal(Model model) {
		return null;
	}
	
	
	//구매자 주문배송 처리
	@PostMapping("/seller_order_status_deal")
	public String OrderDeal() {
		return null;
	}
}

