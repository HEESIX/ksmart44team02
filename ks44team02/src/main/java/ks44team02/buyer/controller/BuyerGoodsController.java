package ks44team02.buyer.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks44team02.dto.Criteria;
import ks44team02.dto.Goods;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.PageMake;
import ks44team02.service.CommonService;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/buyer/goods")
public class BuyerGoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(BuyerGoodsController.class);

	private final GoodsService goodsService;
	private final CommonService commonService;
	
	public BuyerGoodsController(GoodsService goodsService, CommonService commonService) {
		this.goodsService = goodsService;
		this.commonService = commonService;
	}

	// 개인 맞춤 식단 생성 폼
	@GetMapping("/buyerMenu/regMenu")
	public String addbuyerMenuForm() {
		return "buyer/goods/buyerMenu/regMenu";
	}

	// 개인 맞춤 식단 생성 처리
	@PostMapping("/buyerMenu/regMenu")
	public String addbuyerMenu() {
		return "redirect:/buyer/goods/buyerMenu/myMenuList";
	}

	// 개인 맞춤 식단 목록 조회
	@GetMapping("/buyerMenu/myMenuList")
	public String getbuyerMenuList() {
		return "buyer/goods/buyerMenu/myMenuList";
	}

	// 개인 맞춤 식단 수정 폼
	@GetMapping("/buyerMenu/updateMyMenu/{menu_code}")
	public String modifybuyerMenuForm(@PathVariable(value = "menu_code") String menu_code) {
		// 세션 SID와 불러오는 식단 정보의 memberId 유효성 검사 필요

		return "buyer/goods/buyerMenu/updateMyMenu";
	}

	// 개인 맞춤 식단 수정 처리
	@PostMapping("/buyerMenu/updateMyMenu")
	public String modifybuyerMenu() {
		return "redirect:/buyer/goods/buyerMenu/myMenuList";
	}

	// 개인 맞춤 식단 삭제 처리
	@PostMapping("/buyerMenu/removeMyMenu/{menu_code}")
	public String removebuyerMenu(@PathVariable(value = "menu_code") String menu_code) {
		return "redirect:/buyer/goods/buyerMenu/myMenuList";
	}

	// 개인 맞춤 식단 개별 정보
	@GetMapping("/buyerMenu/myMenuDetail/{menu_code}")
	public String getbuyerMenuInfo(@PathVariable(value = "menu_code") String menu_code) {
		
		return "buyer/goods/buyerMenu/myMenuDetail";
	}

	// 판매 식단 목록 조회
	@GetMapping("/menu/menuList")
	public String getMenuList(Model model) {
		return "buyer/goods/menu/menuList";
	}

	// 판매 상품 목록 조회
	@GetMapping("/goodsList")
	public String getGoodsList(Model model
							  ,HttpServletRequest request
							  ,Criteria cri
							  ,@RequestParam(value = "goodsCategoryCode", required = false) String goodsCategoryCode
							  ,@RequestParam(value = "priceRange", required = false) String priceRange
							  ,@RequestParam(value = "goodsNameValue", required = false) String goodsName) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		int isLocalhost = 0;
		 
		if ("localhost".equals(serverName)) { 
			isLocalhost = 1; 
		}
		
		map.put("isLocalhost", isLocalhost);
		map.put("skip", cri.getSkip());
		map.put("amount", cri.getAmount());
		if(goodsCategoryCode != null) map.put("goodsCategoryCode", goodsCategoryCode);
		if(priceRange != null) map.put("priceRange", priceRange);
		if(goodsName != null) map.put("goodsName", goodsName);
		
		List<Goods> goodsList = goodsService.getGoodsListBuyer(map);
		log.info(">>>>>>>>>>>>>>>>>>>>>{}", goodsList);
		
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListUser();
		
		int total = goodsService.getGoodsListCount(map);
		PageMake pageMake = new PageMake(cri, total);
		
		model.addAttribute("title", "상품 목록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("pageMake", pageMake);
		
		return "buyer/goods/goodsList";
	}

	// 개별 식단 정보
	@GetMapping("/menu/menuDetail/{menu_code}")
	public String getMenuInfo(@PathVariable(value = "menu_code") String menu_code) {
		return "buyer/goods/menu/menuDetail";
	}

	// 개별 상품 정보
	@GetMapping("/goodsDetail/{goodsCode}")
	public String getGoodsInfo(@PathVariable(value = "goodsCode") String goodsCode
							  ,Model model) {
		
		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		
		model.addAttribute("title", "상품 상세 정보");
		model.addAttribute("goodsInfo", goodsInfo);	
		return "buyer/goods/goodsDetail";
	}

}
