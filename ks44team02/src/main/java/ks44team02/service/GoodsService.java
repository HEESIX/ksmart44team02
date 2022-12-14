package ks44team02.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ks44team02.dto.Cart;
import ks44team02.dto.Goods;
import ks44team02.dto.GoodsApply;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.GoodsInfoImage;
import ks44team02.dto.GoodsMainImage;
import ks44team02.dto.Ingredient;
import ks44team02.dto.MenuOrganize;
import ks44team02.dto.MenuInformation;
import ks44team02.mapper.CartMapper;
import ks44team02.mapper.CommonMapper;
import ks44team02.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsService.class);

	private final GoodsMapper goodsMapper;
	private final CommonMapper commonMapper;
	private final CartMapper cartMapper;

	public GoodsService(GoodsMapper goodsMapper, CommonMapper commonMapper, CartMapper cartMapper) {
		this.goodsMapper = goodsMapper;
		this.commonMapper = commonMapper;
		this.cartMapper = cartMapper;
	}
	
	//식단 장바구니에 추가
	public boolean addMenuToCart(String menuCode, int orderAmount, String memberId) {
		
		boolean result = true;
		
		List<MenuOrganize> menuOrganizeList = goodsMapper.getMenuOrganizeList(menuCode);
		
		for(MenuOrganize menuOrganize : menuOrganizeList) {
			String goodsCode = menuOrganize.getGoodsOfMenuCode();
			
			int goodsAmount = menuOrganize.getMenuGoodsAmount();
			
			int cartAmount = goodsAmount * orderAmount;
			
			Goods goods = goodsMapper.getGoodsInfo(goodsCode);
			
			int discountedPrice = goods.getGoodsDiscountedPrice();
			
			Cart cart = new Cart();
			
			cart.setMemberId(memberId);
			cart.setGoodsCode(goodsCode);
			cart.setOrderAmount(cartAmount);
			cart.setPriceSubtotal((cartAmount * discountedPrice));
			
			int overlapCheck = cartMapper.cartOverlapCheck(cart);
			
			//update처리
			if(overlapCheck > 0) {
				
				cartMapper.plusCartOrderAmount(cart);
			}else {
				
				String cartCode = commonMapper.getNewCode("tb_cart_list");
				
				cart.setCartListCode(cartCode);
				cart.setRegularPrice(goods.getGoodsPrice());
				cart.setDiscountPrice(discountedPrice);
				cart.setEnterCode(goods.getEnterCode());
				
				boolean addCartResult = cartMapper.addCart(cart);
				if(!addCartResult) {
					result = false;
					break;
				}
			}
			
			
		}
		
		return result;
	}
	
	// 상품 등록 신청 리스트
	public List<GoodsApply> getGoodsRegApplyList(Map<String, Object> map) {
		List<GoodsApply> goodsRegApplyList = goodsMapper.getGoodsRegApplyList(map);
		return goodsRegApplyList;
	}
	
	//상품 등록 신청 내역
	public List<GoodsApply> getGoodsRegApplyListForSeller(Map<String, Object> map){
		List<GoodsApply> goodsRegApplyListForSeller = goodsMapper.getGoodsRegApplyListForSeller(map);
		return goodsRegApplyListForSeller;
	}
	
	// 상품 등록 신청 상세 정보
	public GoodsApply getGoodsRegApplyInfo(String goodsApplyCode) {
		GoodsApply goodsRegApplyInfo = goodsMapper.getGoodsRegApplyInfo(goodsApplyCode);
		return goodsRegApplyInfo;
	}
	
	//상품 등록 신청 승인
	public boolean approveGoodsRegApply(String goodsApplyCode, String goodsCode) {
		
		//상품 등록 신청 DB의 값을 승인으로 update
		boolean result = goodsMapper.approveGoodsRegApply(goodsApplyCode);
		if(!result) return false;
		
		//상품 등록 신청한 정보를 기반으로 상품테이블에 INSERT
		GoodsApply goodsApply = goodsMapper.getGoodsRegApplyInfo(goodsApplyCode);
		System.out.println(goodsApply.toString());
		
		Goods goods = new Goods();
		
		goods.setGoodsCode(goodsCode);
		goods.setEnterCode(goodsApply.getEnterCode());
		goods.setGoodsCateCode(goodsApply.getGoodsCategoryCode());
		goods.setGoodsName(goodsApply.getGoodsApplyName());
		goods.setGoodsPrice(goodsApply.getGoodsApplyPrice());
		goods.setGoodsDiscountCode(goodsApply.getGoodsDiscountCode());
		goods.setGoodsDiscountedPrice(goodsApply.getGoodsApplyDiscount());
		goods.setGoodsNetWeight(goodsApply.getGoodsApplyNetWeight());
		goods.setGoodsNetWeightUnit(goodsApply.getGoodsApplyNetWeightUnit());
		goods.setGoodsProduce(goodsApply.getGoodsApplyProduce());
		goods.setGoodsProductionExpirationInfo(goodsApply.getGoodsApplyProductionExpirationInfo());
		goods.setGoodsMainImageCode(goodsApply.getGoodsApplyMainImage());
		goods.setGoodsInfoImageCode(goodsApply.getGoodsApplyInfoImage());
		goods.setGoodsStock(goodsApply.getGoodsApplyStock());
		goods.setGoodsDeliveryCharge(goodsApply.getGoodsApplyDeliveryCharge());
		goods.setGoodsActivation(1);
		
		boolean goodsRegApplyToGoodsResult = goodsMapper.addGoodsRegApplyToGoods(goods);
		if(!goodsRegApplyToGoodsResult) return false;
		
		return true;
	}
	
	//상품 영양 정보 상품 신청 영양 정보 기반으로 INSERT
	public boolean addIngredient(Ingredient ingredient, String goodsApplyCode) {
		
		//상품 등록 신청 코드로 해당 상품의 영양 정보 조회
		Ingredient goodsApplyIngredient = goodsMapper.getGoodsApplyIngredient(goodsApplyCode);
		
		goodsApplyIngredient.setIngredientCode(ingredient.getIngredientCode());
		goodsApplyIngredient.setGoodsCode(ingredient.getGoodsCode());
		
		boolean result = goodsMapper.addGoodsIngredient(goodsApplyIngredient);
		
		return result;
	}
	
	//상품 등록 신청 거절
	public boolean refuseGoodsRegApply(Map<String, Object> map) {
		boolean result = goodsMapper.refuseGoodsRegApply(map);
		return result;
	}

	// 상품 카테고리 등록
	public boolean addGoodsCategory(GoodsCategory goodsCategory) {
		boolean result = goodsMapper.addGoodsCategory(goodsCategory);
		return result;
	}
	

	// 상품 카테고리 리스트: 사용 중지된 것도 포함
	public List<GoodsCategory> getGoodsCategoryList() {

		List<GoodsCategory> goodsCategoryList = goodsMapper.getGoodsCategoryList();

		return goodsCategoryList;
	}

	// 상품 카테고리 리스트: 사용중인 것만
	public List<GoodsCategory> getGoodsCategoryListUser() {

		List<GoodsCategory> goodsCategoryList = goodsMapper.getGoodsCategoryListUser();

		return goodsCategoryList;
	}
	
	//'식단'이 포함된 카테고리 명 목록
	public List<GoodsCategory> getMenuCategoryList(){
		List<GoodsCategory> menuCategoryList = goodsMapper.getMenuCategoryList();
		return menuCategoryList;
	}
	
	// 기존 데이터 조회(상품 카테고리 수정 화면)
	public GoodsCategory getGoodsCategoryInfo(String goodsCategoryCode) {
		GoodsCategory goodsCategoryInfo = goodsMapper.getGoodsCategoryInfo(goodsCategoryCode);
		return goodsCategoryInfo;
	}

	// 상품 카테고리 수정 처리
	public boolean modifyGoodsCategory(GoodsCategory goodsCategory) {
		boolean result = goodsMapper.modifyGoodsCategory(goodsCategory);
		return result;
	}

	// 상품 카테고리 삭제
	public boolean removeGoodsCategory(String goodsCategoryCode) {
		boolean resultRemove = goodsMapper.removeGoodsCategory(goodsCategoryCode);
		return resultRemove;
	}

	// 상품 등록 처리
	public boolean addGoods(Goods goods) {
		boolean result = goodsMapper.addGoods(goods);
		return result;
	}

	// 상품 리스트
	public List<Goods> getGoodsList(Map<String, Object> map) {
		List<Goods> goodsList = goodsMapper.getGoodsList(map);
		return goodsList;
	}
	
	//구매자 상품 리스트
	public List<Goods> getGoodsListBuyer(Map<String, Object> map){
		List<Goods> goodsListBuyer = goodsMapper.getGoodsListBuyer(map);
		return goodsListBuyer;
	}
	
	//구매자 상품 리스트 페이징
	public int getGoodsListCount(Map<String, Object> map) {
		int goodsListCount = goodsMapper.getGoodsListCount(map);
		return goodsListCount;
	}
	
	//구매자 식단 리스트 페이징
	public int getMenuListCount(Map<String, Object> map) {
		int menuListCount = goodsMapper.getMenuListCount(map);
		return menuListCount;
	}

	// 상품 삭제
	public boolean removeGoods(String goodsCode) {
		boolean result = goodsMapper.removeGoods(goodsCode);
		return result;
	}
	
	//메뉴 코드로 상품 삭제
	public boolean removeMenu(String menuCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuCode", menuCode);
		boolean result = goodsMapper.removeMenu(map);
		return result;
	}
	
	//상품 메인 이미지 정보 조회
	public GoodsMainImage getGoodsMainImageInfo(String mainImageIdx) {
		GoodsMainImage goodsMainImageInfo = goodsMapper.getGoodsMainImageInfo(mainImageIdx);
		return goodsMainImageInfo;
	}
	
	//상품 소개 이미지 정보 조회
	public GoodsInfoImage getGoodsInfoImageInfo(String infoImageIdx) {
		GoodsInfoImage goodsInfoImageInfo = goodsMapper.getGoodsInfoImageInfo(infoImageIdx);
		return goodsInfoImageInfo;
	}
	
	//상품 메인 이미지 삭제
	public boolean removeGoodsMainImage(String mainImageIdx) {
		boolean result = goodsMapper.removeGoodsMainImage(mainImageIdx);
		return result;
	}
	
	//상품 정보 이미지 삭제
	public boolean removeGoodsInfoImage(String infoImageIdx) {
		boolean result = goodsMapper.removeGoodsInfoImage(infoImageIdx);
		return result;
	}

	// 식단 등록
	public int addAdminMenu() {
		return 0;
	}
	
	//식단 정보 등록
	public boolean addMenuInformation(MenuInformation menuInformation) {
		boolean result = goodsMapper.addMenuInformation(menuInformation);
		return result;
	}
	
	//식단 포함 상품  정보 등록
	public boolean addMenuOrganize(MenuOrganize menuOrganize) {
		boolean result = goodsMapper.addMenuOrganize(menuOrganize);
		return result;
	}
	
	//식단 포함 상품 정보 삭제
	public boolean removeMenuOrganize(String menuCode) {
		boolean result = goodsMapper.removeMenuOragnize(menuCode);
		return result;
	}

	// 식단 리스트
	public List<Goods> getAdminMenuList(Map<String, Object> map) {
		List<Goods> adminMenuList = goodsMapper.getAdminMenuList(map);

		return adminMenuList;
	}
	
	//식단 리스트: 구매자
	public List<Goods> getMenuList(Map<String, Object> map){
		List<Goods> result = goodsMapper.getMenuList(map);
		return result;
	}

	// 식단 정보 수정 처리
	public boolean modifyMenuInformation(String menuCode, String menuName) {
		boolean result = goodsMapper.modifyMenuInformation(menuCode, menuName);
		return result;
	}
	
	//식단 정보 삭제 처리
	public boolean removeMenuInformation(String menuCode) {
		boolean result = goodsMapper.removeMenuInformation(menuCode);
		return result;
	}

	// 식단 삭제
	public int removeAdminMenu() {
		return 0;
	}

	// 개별 상품 정보
	public Goods getGoodsInfo(String goodsCode) {
		Goods goodsInfo = goodsMapper.getGoodsInfo(goodsCode);
		return goodsInfo;
	}

	// 개별 식단 정보(식단이 포함하는 상품들의 개수 정보)조회
	public List<MenuOrganize> getMenuOrganizeList(String menuCode){
		List<MenuOrganize> menuOrganizeList = goodsMapper.getMenuOrganizeList(menuCode);
		return menuOrganizeList;
	}

	// 개별 식단 정보(식단이 포함하는 상품들의 정보)조회
	public List<Goods> getMenuOrganizeGoodsInfo(String menuCode) {
		List<Goods> menuOrganizeGoodsInfo = new ArrayList<Goods>();
		
		List<MenuOrganize> menuOrganizeList = goodsMapper.getMenuOrganizeList(menuCode);
		
		for (MenuOrganize menuOrganize : menuOrganizeList) {
			
			String goodsCode = menuOrganize.getGoodsOfMenuCode();
			
			menuOrganizeGoodsInfo.add(goodsMapper.getGoodsInfo(goodsCode));
			
			System.out.println(menuOrganizeGoodsInfo.toString());
		}
		return menuOrganizeGoodsInfo;
	}
	
	//개별 식단 정보(식단 자체의 정보)
	public Goods getMenuInfo(String menuCode){
		Goods menuInfo = goodsMapper.getMenuInfo(menuCode);
		return menuInfo;
	}

	// 상품별 할인 혜택 등록
	public boolean addGoodsDiscount(GoodsDiscount goodsDiscount) {
		boolean result = goodsMapper.addGoodsDiscount(goodsDiscount);
		return result;
	}
	
	//상품별 할인 헤택 조회
	public GoodsDiscount getGoodsDiscount(String goodsDiscountCode) {
		GoodsDiscount goodsDiscount = goodsMapper.getGoodsDiscount(goodsDiscountCode);
		return goodsDiscount;
	}

	// 상품별 할인 혜택 리스트(admin: admin이 등록한 할인혜택만)
	public List<GoodsDiscount> getGoodsDiscountListForReg() {
		List<GoodsDiscount> goodsDiscountAdmin = goodsMapper.getGoodsDiscountListForReg();
		return goodsDiscountAdmin;
	}

	// 상품별 할인 혜택 리스트(seller: 상품 등록 신청에 필요한 판매자가 정의한 상품별 할인혜택과 관리자가 정의한 상품별할인혜택 모두 GET)
	public List<GoodsDiscount> getGoodsDiscountListSeller(HttpSession session) {
		// 세션의 아이디 조회
		// 현재 없으므로 fix된 값 사용
		// String memberId = (String) session.getAttribute("SID");
		String memberId = "id010";
		List<GoodsDiscount> goodsDiscountListSeller = goodsMapper.getGoodsDiscountListSeller(memberId);
		return goodsDiscountListSeller;
	}
	
	// 상품별 할인 혜택 리스트(seller: 판매자가 등록한 상품별 할인헤택만 GET)
	public List<GoodsDiscount> getSellerGoodsDiscount(String memberId){
		List<GoodsDiscount> sellerGoodsDiscount = goodsMapper.getSellerGoodsDiscount(memberId);
		return sellerGoodsDiscount;
	}
	
	//상품 별 할인 혜택 리스트(모든 리스트)
	public List<GoodsDiscount> getGoodsDiscountList(Map<String, Object> map){
		List<GoodsDiscount> goodsDiscountList = goodsMapper.getGoodsDiscountList(map);
		return goodsDiscountList;
	}

	// 상품별 할인 혜택 수정 폼
	public GoodsDiscount modifyGoodsDiscountForm(String goodsDiscountCode) {
		GoodsDiscount goodsDiscountInfo = goodsMapper.getGoodsDiscount(goodsDiscountCode);
		return goodsDiscountInfo;
	}
	
	//상품별 할인 혜택 수정 처리
	public boolean modifyGoodsDiscount(GoodsDiscount goodsDiscount) {
		boolean result = goodsMapper.modifyGoodsDiscount(goodsDiscount);
		return result;
	}

	// 상품별 할인 혜택 삭제 폼
	public GoodsDiscount removeGoodsDiscountForm(String goodsDiscountCode) {
		GoodsDiscount goodsDiscountInfo = goodsMapper.getGoodsDiscount(goodsDiscountCode);
		return goodsDiscountInfo;
	}
	
	// 상품별 할인 헤택 삭제 처리
	public boolean removeGoodsDiscount(String goodsDiscountCode) {
		boolean result = goodsMapper.removeGoodsDiscount(goodsDiscountCode);
		return result;
	}

	// 상품 등록 신청
	public boolean addGoodsRegApply(GoodsApply goodsApply) {
		boolean result = goodsMapper.addGoodsRegApply(goodsApply);
		return result;
	}
	
	//상품 등록 신청 영양 정보 등록
	public boolean addGoodsApplyIngredient(Ingredient ingredient) {
		boolean result = goodsMapper.addGoodsApplyIngredient(ingredient);
		return result;
	}

	// 기존 데이터 조회(상품 수정화면 판매자)
	public Goods getSellerGoodsInfo() {
		return null;
	}

	// 상품 수정
	public boolean modifyGoods(Goods goods) {
		boolean result = goodsMapper.modifyGoods(goods);
		return result;
	}
	
	//상품 영양 정보 수정
	public boolean modifyIngredient(Ingredient ingredient) {
		boolean result = goodsMapper.modifyIngredient(ingredient);
		return result;
	}

	// 상품 삭제
	public int removeSellerGoods() {
		return 0;
	}

	// 개인 맞춤 식단 등록
	public boolean addMyMenu(String menuCode, String myMenuName, String goodsItems, HttpSession session) throws JsonMappingException, JsonProcessingException {
		
		boolean result = true;
		
		MenuInformation menuInformation = new MenuInformation();
		
		String memberId = (String) session.getAttribute("SID");
		if(memberId == null) memberId = "id002";
		
		menuInformation.setMenuCode(menuCode);
		menuInformation.setMenuName(myMenuName);
		menuInformation.setMenuRegId(memberId);
		
		boolean addMenuInfomationResult = goodsMapper.addMenuInformation(menuInformation);
		if(!addMenuInfomationResult) result = false;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Map<String, Object>> maps = objectMapper.readValue(goodsItems, new TypeReference<List<Map<String, Object>>>() {});

		for(Map<String, Object> map : maps) {
			String goodsOfMenuCode = (String) map.get("goodsOfMenuCode");
			
			int menuGoodsAmount = Integer.parseInt((String) map.get("menuGoodsAmount"));
			String menuGoodsCode = commonMapper.getNewCode("tb_menu_organize");
			
			MenuOrganize menuOrganize = new MenuOrganize();
			
			menuOrganize.setMenuGoodsCode(menuGoodsCode);
			menuOrganize.setMenuCode(menuCode);
			menuOrganize.setGoodsOfMenuCode(goodsOfMenuCode);
			menuOrganize.setMenuGoodsAmount(menuGoodsAmount);
			
			boolean addMenuOrganizeResult = goodsMapper.addMenuOrganize(menuOrganize);
			if(!addMenuOrganizeResult) {
				result = false;
				break;
			}
		}
		return result;
	}

	// 개인 맞춤 식단 목록 조회
	public List<MenuInformation> getBuyerMenuList(Map<String, Object> map) {
		List<MenuInformation> buyerMenuList = goodsMapper.getBuyerMenuList(map);
		return buyerMenuList;
	}
	
	//개인 맞춤 식단 수정
	public boolean modifyMyMenu(String menuCode
							   ,String myMenuName
							   ,String goodsItems
							   ,HttpSession session) throws JsonMappingException, JsonProcessingException {
		
		boolean result = true;
		
		String memberId = (String) session.getAttribute("SID");
		if(memberId == null) memberId = "id002";
		
		boolean addMenuInfomationResult = goodsMapper.modifyMenuInformation(menuCode, myMenuName);
		if(!addMenuInfomationResult) return false;
		
		//새로 INSERT 전 DELETE 작업 필요
		boolean removeMenuOrganizeResult = goodsMapper.removeMenuOragnize(menuCode);
		if(!removeMenuOrganizeResult) return false;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Map<String, Object>> maps = objectMapper.readValue(goodsItems, new TypeReference<List<Map<String, Object>>>() {});

		for(Map<String, Object> map : maps) {
			String goodsOfMenuCode = (String) map.get("goodsOfMenuCode");
			
			int menuGoodsAmount = Integer.parseInt((String) map.get("menuGoodsAmount"));
			String menuGoodsCode = commonMapper.getNewCode("tb_menu_organize");
			
			MenuOrganize menuOrganize = new MenuOrganize();
			
			menuOrganize.setMenuGoodsCode(menuGoodsCode);
			menuOrganize.setMenuCode(menuCode);
			menuOrganize.setGoodsOfMenuCode(goodsOfMenuCode);
			menuOrganize.setMenuGoodsAmount(menuGoodsAmount);
			
			boolean addMenuOrganizeResult = goodsMapper.addMenuOrganize(menuOrganize);
			if(!addMenuOrganizeResult) {
				result = false;
				break;
			}
			if(!result) return false;
		}
		return result;
	}
	

	// 개인 맞춤 식단 삭제
	public boolean removeBuyerMenu(String menuCode) {
		boolean removeMenuOrganizeResult = goodsMapper.removeMenuOragnize(menuCode);
		if(!removeMenuOrganizeResult) return false;
		
		boolean removeMenuInformationResult = goodsMapper.removeMenuInformation(menuCode);
		if(!removeMenuInformationResult) return false;
		
		return true;
	}

	// 개인 맞춤 식단 정보
	public MenuInformation getBuyerMenuInfo(Map<String, Object> map) {
		MenuInformation menuInformation = goodsMapper.getBuyerMenuInfo(map);
		return menuInformation;
	}

	// 식단 목록
	public List<MenuInformation> getMenuList() {
		return null;
	}

	// 상품 목록(활성화 되어있는 것만), 식단 제외
	public List<Map<String, Object>> getGoodsListForMenu() {
		List<Map<String, Object>> goodsList = goodsMapper.getGoodsListForMenu();
		return goodsList;
	}

	// 개별 식단 정보
	/*
	 * public Menus getMenuInfo() { return null; }
	 */

	// 개별 상품 정보
	/*
	 * public Goods getGoodsInfo() { return null; }
	 */

}
