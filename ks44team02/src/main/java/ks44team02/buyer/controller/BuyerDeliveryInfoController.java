package ks44team02.buyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/buyer/mypage/delivery_info")
public class BuyerDeliveryInfoController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BuyerDeliveryInfoController.class);

	
	
	// 등록한 배송지 리스트 조회
	@GetMapping("/delivery_info_list")
	public String getBuyerDeliveryInfoList() {
		return null;
	}
	
	// 배송지 등록 폼:구매자 개인 배송지 정보 등록
	@GetMapping("/delivery_info_add")
	public String addBuyerDeliveryInfo(Model model) {
		return null;
	}
	
	// 배송지 등록 처리
	@PostMapping("/delivery_info_add")
	public String addBuyerDeliveryInfo() {
		return null;
	}
	
	// 배송지 수정하는 폼: 구매자 개인 배송지 정보 수정
	@GetMapping("/delivery_info_modify")
	public String modifyBuyerDeliveryInfo(Model model) {
		return null;
	}
	
	// 배송지 수정 처리
	@PostMapping("/delivery_info_modify")
	public String modifyBuyerDeliveryInfo() {
		return null;
	}
	
	
	
}
