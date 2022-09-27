package ks44team02.service;

import org.springframework.stereotype.Service;
import ks44team02.mapper.AdminCalculateMapper;

@Service
public class AdminCalculateService {
	
	private final AdminCalculateMapper adminCalculateMapper;
		
	public AdminCalculateService(AdminCalculateMapper adminCalculateMapper) {
		this.adminCalculateMapper =adminCalculateMapper;
	}
	
	//판매자 일일 정산금 확인
	public String sellerTodayCalculate() {
		return "admin/calculatepage/admin_seller_daily_calculate";
	}
			
	//관리자 수수료 확인
	public String adminFeeCheck() {
		return "admin/calculatepage/admin_fee_check";
	}
			
	//관리자 수수료 정산
	public String adminFeeCalculate() {
		return "admin/calculatepage/admin_fee_calculate";
	}
			
	//판매자 정산금 정산
	public String sellerCalculateSuccess() {
		return "admin/calculatepage/admin_seller_calculate";
	}
}
