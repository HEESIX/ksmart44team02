package ks44team02.buyer.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ks44team02.dto.Cart;
import ks44team02.dto.Criteria;
import ks44team02.dto.Goods;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.MenuInformation;
import ks44team02.dto.MenuOrganize;
import ks44team02.dto.PageMake;
import ks44team02.service.CartService;
import ks44team02.service.CommonService;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/buyer/goods")
public class BuyerGoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(BuyerGoodsController.class);

	private final GoodsService goodsService;
	private final CommonService commonService;
	private final CartService cartService;
	
	public BuyerGoodsController(GoodsService goodsService, CommonService commonService, CartService cartService) {
		this.goodsService = goodsService;
		this.commonService = commonService;
		this.cartService = cartService;
	}

	// 개인 맞춤 식단 생성 폼
	@GetMapping("/buyerMenu/regMyMenu")
	public String addbuyerMenuForm(Model model) {
		List<Map<String, Object>> goodsList = goodsService.getGoodsListForMenu();
		model.addAttribute("title", "개인 맞춤 식단 등록");
		model.addAttribute("goodsList", goodsList);
		return "buyer/goods/buyerMenu/regMyMenu";
	}

	// 개인 맞춤 식단 생성 처리
	@PostMapping("/buyerMenu/regMyMenu")
	@ResponseBody
	public boolean addbuyerMenu(@RequestParam(value = "myMenuName") String myMenuName
							   ,@RequestParam(value = "goodsItems") String goodsItems
							   ,HttpSession session) throws JsonMappingException, JsonProcessingException {
		log.info(">>>>>>>>>>{}", myMenuName);
		log.info(">>>>>>>>>>{}", goodsItems);
		
		String menuCode = commonService.getNewCode("tb_menu_information");
		
		goodsService.addMyMenu(menuCode, myMenuName, goodsItems, session);
		
		return true;
	}

	// 개인 맞춤 식단 목록 조회
	@GetMapping("/buyerMenu/myMenuList")
	public String getbuyerMenuList(Model model
								  ,HttpSession session
								  ,@RequestParam(value = "msg", required = false) String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String memberId = (String) session.getAttribute("SID");
		if(memberId == null) memberId = "id002";
		
		map.put("memberId", memberId);
		
		List<MenuInformation> buyerMenuList = goodsService.getBuyerMenuList(map);
		
		log.info("buyerMenuList :::::: {}", buyerMenuList);
		
		model.addAttribute("title", "개인 맞춤 식단 목록");
		model.addAttribute("buyerMenuList", buyerMenuList);
		model.addAttribute("msg", msg);
		
		return "buyer/goods/buyerMenu/myMenuList";
	}
	
	//개인 맞춤 식단 장바구니에 담기
	@PostMapping("/addMyMenuToCart")
	@ResponseBody
	public boolean addMyMenuToCart(@RequestParam(value = "menuCode") String menuCode
								  ,HttpSession session) {
		boolean result = true;
		
		String memberId = (String) session.getAttribute("SID");
		if(memberId == null) memberId = "id002";
		
		List<MenuOrganize> menuOrganizeList = goodsService.getMenuOrganizeList(menuCode);
		
		for(MenuOrganize menuOrganize : menuOrganizeList) {
			Cart cart = new Cart();
			Goods goods = new Goods();
			
			String goodsCode = menuOrganize.getGoodsOfMenuCode();
			goods = goodsService.getGoodsInfo(goodsCode);
			
			String cartCode = commonService.getNewCode("tb_cart_list");
			
			int discountedPrice = goods.getGoodsDiscountedPrice();
			int goodsAmount = menuOrganize.getMenuGoodsAmount();
			int subtotal = discountedPrice * goodsAmount;
			String enterCode = goods.getEnterCode();
			
			cart.setCartListCode(cartCode);
			cart.setMemberId(memberId);
			cart.setGoodsCode(goodsCode);
			cart.setRegularPrice(goods.getGoodsPrice());
			cart.setDiscountPrice(discountedPrice);
			cart.setOrderAmount(goodsAmount);
			cart.setPriceSubtotal(subtotal);
			if(enterCode != null) cart.setEnterCode(enterCode);
			
			boolean addCartResult = cartService.addCart(cart);
			if(!addCartResult) {
				result = false;
				break;
			}
		}
		
		return result;
	}

	// 개인 맞춤 식단 수정 폼
	@GetMapping("/buyerMenu/updateMyMenu/{menu_code}")
	public String modifyBuyerMenuForm(@PathVariable(value = "menu_code") String menuCode
									 ,HttpSession session
									 ,Model model) {
		String memberId = (String) session.getAttribute("SID");
		if(memberId == null) memberId = "id002";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("menuCode", menuCode);
		map.put("memberId", memberId);
		
		MenuInformation menuInformation = goodsService.getBuyerMenuInfo(map);
		List<Map<String, Object>> goodsList = goodsService.getGoodsListForMenu();
		
		model.addAttribute("title", "나만의 식단 수정");
		model.addAttribute("menuInformation", menuInformation);
		model.addAttribute("goodsList", goodsList);
		
		return "buyer/goods/buyerMenu/updateMyMenu";
	}

	// 개인 맞춤 식단 수정 처리
	@PostMapping("/buyerMenu/updateMyMenu")
	@ResponseBody
	public boolean modifyBuyerMenu(@RequestParam(value = "menuCode") String menuCode
								 ,@RequestParam(value = "myMenuName") String myMenuName
							     ,@RequestParam(value = "goodsItems") String goodsItems
							     ,HttpSession session) throws JsonMappingException, JsonProcessingException {
		
		boolean modifyMyMenuResult = goodsService.modifyMyMenu(menuCode, myMenuName, goodsItems, session);
		
		return modifyMyMenuResult;
	}

	// 개인 맞춤 식단 삭제 처리
	@PostMapping("/buyerMenu/removeMyMenu/{menu_code}")
	public String removebuyerMenu(@PathVariable(value = "menu_code") String menuCode
								 ,RedirectAttributes reAttr) {
		
		boolean result = goodsService.removeBuyerMenu(menuCode);
		
		String msg = "";
		
		if(result) {
			msg = "삭제가 정상적으로 완료되었습니다.";
		}else {
			msg = "삭제 실패";
		}
		
		reAttr.addAttribute("msg", msg);
		
		return "redirect:/buyer/goods/buyerMenu/myMenuList";
	}

	// 개인 맞춤 식단 개별 정보
	@GetMapping("/buyerMenu/myMenuDetail/{menu_code}")
	public String getbuyerMenuInfo(@PathVariable(value = "menu_code") String menu_code
								  ,Model model) {
		
		model.addAttribute("title", "개인 맞춤 식단 상세 정보");
		
		return "buyer/goods/buyerMenu/myMenuDetail";
	}

	// 판매 식단 목록 조회
	@GetMapping("/menu/menuList")
	public String getMenuList(Model model
							 ,HttpServletRequest request
							 ,Criteria cri
							 ,@RequestParam(value = "goodsCategoryCode", required = false) String goodsCategoryCode
							 ,@RequestParam(value = "priceRange", required = false) String priceRange
							 ,@RequestParam(value = "goodsNameValue", required = false) String goodsName) {
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		int isLocalhost = 0;
		 
		if ("localhost".equals(serverName)) { 
			isLocalhost = 1; 
		}

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("isLocalhost", isLocalhost);
		map.put("skip", cri.getSkip());
		map.put("amount", cri.getAmount());
		if(goodsCategoryCode != null) map.put("goodsCategoryCode", goodsCategoryCode);
		if(priceRange != null) map.put("priceRange", priceRange);
		if(goodsName != null) map.put("goodsName", goodsName);
		
		List<Goods> menuList = goodsService.getMenuList(map);
		log.info(">>>>>>>>>>>>>>>>>{}", menuList);
		
		List<GoodsCategory> menuCategoryList = goodsService.getMenuCategoryList();
		
		int total = goodsService.getMenuListCount(map);
		PageMake pageMake = new PageMake(cri, total);
		
		model.addAttribute("title", "식단 목록");
		model.addAttribute("menuList", menuList);
		model.addAttribute("menuCategoryList", menuCategoryList);
		model.addAttribute("pageMake", pageMake);
		
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
	public String getMenuInfo(@PathVariable(value = "menu_code") String menuCode
							 ,Model model) {
		
		Goods menuInfo = goodsService.getMenuInfo(menuCode);
		List<MenuOrganize> menuOrganizeInfo = goodsService.getMenuOrganizeList(menuCode);
		List<Goods> menuOrganizeGoods = goodsService.getMenuOrganizeGoodsInfo(menuCode);
		
		log.info(">>>>>>>>>>>>>>>>>{}", menuInfo);
		log.info(">>>>>>>>>>>>>>>>>{}", menuOrganizeGoods);
		
		model.addAttribute("title", "식단 상세 정보");
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrganizeGoods", menuOrganizeGoods);
		model.addAttribute("menuOrganizeInfo", menuOrganizeInfo);
		
		return "buyer/goods/menu/menuDetail";
	}
	
	//구매자 식단 상품으로 장바구니에 상품 넣기
	@PostMapping("/menu/addCart")
	@ResponseBody
	public boolean addMenuToCart(@RequestParam(value = "menuCode") String menuCode
								,@RequestParam(value = "orderAmount") String orderAmount
								,HttpSession session) {
		String memberId = (String) session.getAttribute("SID");
		if(memberId == null) memberId = "id002";
		
		log.info("addMenuToCart 실행");
		
		int amount = Integer.parseInt(orderAmount);
		
		boolean result = goodsService.addMenuToCart(menuCode, amount, memberId);
		return result;
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
