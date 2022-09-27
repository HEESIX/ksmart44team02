package ks44team02.mapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "seller/salespage")
public class SellerSalesMapper {

	//판매자 매출 현황 화면
	@GetMapping("/seller_sales")
	public String getSaleList() {
		return "seller/salespage/seller_sales";
	}
	
	//판매자 매출 정산 확인 화면
	@GetMapping("/seller_sales_calculate")
	public String sellerSalesSuccess() {
		return "seller/salespage/seller_sales_calculate";	
	}
}