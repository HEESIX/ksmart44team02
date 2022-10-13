package ks44team02.buyer.controller;

import java.util.List;

import javax.annotation.PostConstruct;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks44team02.dto.Cart;
import ks44team02.dto.OrderDiscount;
import ks44team02.service.CartService;

@Controller
@RequestMapping(value = "/buyer/mypage/cart")
public class BuyerCartController {

	
	private static final Logger log = LoggerFactory.getLogger(BuyerCartController.class);

	private final CartService cartService;
	
	public BuyerCartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostConstruct
	public void buyerCartController() {
		log.info("BuyerCartController bean 생성");
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
	public String removeCartGoods(@RequestParam(value = "cartListCode") String cartListCode
								 ,RedirectAttributes reAttr) {
		log.info(">>>>>>>>>삭제{}", cartListCode);
		
		boolean result = cartService.removeCartGoods(cartListCode);
		if(result) {
			reAttr.addAttribute("msg", "수정 완료");
		}else {
			reAttr.addAttribute("msg", "수정 실패");
		}
		return "redirect:/buyer/mypage/cart/cartList";
	}
	//장바구니에 담긴 상품 주문화면으로 선택 이동
	@PostMapping("/cartMove")
	public String moveCartGoods() {
		return "buyer/order/order";
	}
}
