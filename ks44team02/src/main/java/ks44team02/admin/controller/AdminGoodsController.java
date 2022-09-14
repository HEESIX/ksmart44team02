package ks44team02.admin.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/admin/goods")
public class AdminGoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);
	
	private final GoodsService goodsService;
	
	public AdminGoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@PostConstruct
	public void adminGoodsControllerInit() {
		log.info("AdminGoodsController bean 생성");
	}
	
	//상품 카테고리 등록
	@GetMapping("/category/goodscate_reg")
	public String addGoodsCategory() {
		return null;
	}
	
	//상품 카테고리 리스트
	public String getGoodsCategoryList() {
		return null;
	}
	
	//상품 카테고리 수정
	public String modifyGoodsCategory() {
		return null;
	}
	
	//상품 카테고리 삭제
	public String removeGoodsCategory() {
		return null;
	}
	
	//상품 등록
	public String addGoods() {
		return null;
	}
	
	//상품 리스트
	public String getAdminGoodsList() {
		return null;
	}
	
	//개별 상품 정보
	public String getGoodsInfo() {
		return null;
	}
	
	//상품 수정
	public String modifyGoods() {
		return null;
	}
	
	//상품 삭제
	public String removeAdminGoods() {
		return null;
	}
	
	//식단 등록
	public String addAdminMenu() {
		return null;
	}
	
	//식단 리스트
	public String getAdminMenuList() {
		return null;
	}
	
	//식단 수정
	public String modifyAdminMenu() {
		return null;
	}
	
	//식단 삭제
	public String removeAdminMenu() {
		return null;
	}
	
	//개별 식단 정보 
	public String getMenuInfo() {
		return null;
	}
	
	//상품별 할인 혜택 등록
	public String addGoodsDiscount() {
		return null;
	}
	
	//상품별 할인 혜택 리스트
	public String getGoodsDiscountList() {
		return null;
	}
	
	//상품별 할인 혜택 수정
	public String modifyGoodsDiscount() {
		return null;
	}
	
	//상품별 할인 혜택 삭제
	public String removeGoodsDiscount() {
		return null;
	}
}
