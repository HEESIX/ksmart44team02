package ks44team02.buyer.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Cart;
import ks44team02.dto.Goods;
import ks44team02.dto.OrderDiscount;
import ks44team02.service.CartService;
import ks44team02.service.CommonService;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/buyer/mypage/cart")
public class BuyerCartController {

	
	private static final Logger log = LoggerFactory.getLogger(BuyerCartController.class);

	private final CartService cartService;
	private final CommonService commonService;
	private final GoodsService goodsService;
	
	public BuyerCartController(CartService cartService, CommonService commonService, GoodsService goodsService) {
		this.cartService = cartService;
		this.commonService = commonService;
		this.goodsService = goodsService;
	}
	
	@PostConstruct
	public void buyerCartController() {
		log.info("BuyerCartController bean 생성");
	}
	
	//장바구니에 상품 담는 처리
	@PostMapping("/addCart")
	@ResponseBody
	public boolean addCart(@RequestParam(value = "goodsCode") String goodsCode
						 ,@RequestParam(value = "orderAmount") int orderAmount
						 ,HttpSession session) {
		
		//session 저장하는 로그인 완성되면 이 부분 session 아이디 가져오게 교체
		//String memberId = session.getAttribute("SID");
		//null일 경우 체크(비정상적인 접근)
		//현재 없으므로 픽스된 값 입력
		String memberId = "id002";
		
		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		
		int regularPrice = goodsInfo.getGoodsPrice();
		int discountPrice = goodsInfo.getGoodsDiscountedPrice();
		int priceSubtotal = (orderAmount * discountPrice);
		String enterCode = goodsInfo.getEnterCode();
		
		Cart cart = new Cart();
		String cartListCode = commonService.getNewCode("tb_cart_list");
		
		cart.setCartListCode(cartListCode);
		cart.setMemberId(memberId);
		cart.setGoodsCode(goodsCode);
		cart.setRegularPrice(regularPrice);
		cart.setDiscountPrice(discountPrice);
		cart.setOrderAmount(orderAmount);
		cart.setPriceSubtotal(priceSubtotal);
		if(enterCode != null) cart.setEnterCode(enterCode);
		
		boolean addCartResult = cartService.addCart(cart);
		if(!addCartResult) return false;
		
		return true;
	}
	
	//장바구니에 담긴 상품 목록 조회
	@GetMapping("/cartList")
	public String getCartList(Model model
							 ,HttpSession session
							 ,@RequestParam(value = "msg", required = false) String msg) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		//세션이 생기면 아래 조건문은 주석처리 해야함
		if(sessionId == null)  sessionId = "id002";
		
		List<Cart> cartList = cartService.getCartList(sessionId);
		
		System.out.println(cartList.toString());
		
		model.addAttribute("title","장바구니 목록 조회");
		model.addAttribute("cartList",cartList);
		
		if (msg != null)
			model.addAttribute("msg", msg);
		
		return "buyer/mypage/cart/cartList";
	}

	//장바구니에 담긴 상품 삭제 처리
	@PostMapping("/removeCart")
	@ResponseBody
	public boolean removeCartGoods(@RequestParam(value = "cartListCode") String cartListCode ) {
		log.info(">>>>>>>>>삭제{}", cartListCode);
		
		boolean result = cartService.removeCartGoods(cartListCode);
		
		return result;
	}
	
	//장바구니에 담긴 상품 주문화면으로 선택 이동
	@PostMapping("/cartMove")
	public String moveCartGoods() {
		return "buyer/order/order";
	}
}
