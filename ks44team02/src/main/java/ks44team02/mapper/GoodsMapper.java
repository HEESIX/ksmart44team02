package ks44team02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsApply;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.GoodsInfoImage;
import ks44team02.dto.GoodsMainImage;
import ks44team02.dto.Ingredient;
import ks44team02.dto.MenuOrganize;
import ks44team02.dto.MenuInformation;

@Mapper
public interface GoodsMapper {
	
	//상품 등록 신청 리스트 조회
	public List<GoodsApply> getGoodsRegApplyList(Map<String, Object> map);
	
	//상품 등록 신청 내역 조회
	public List<GoodsApply> getGoodsRegApplyListForSeller(Map<String, Object> map);
	
	//상품 등록 신청 상세 정보
	public GoodsApply getGoodsRegApplyInfo(String goodsApplyCode);
	
	//상품 등록 신청 승인
	public boolean approveGoodsRegApply(String goodsApplyCode);
	
	//상품 등록 신청 정보 기반으로 상품테이블에 인서트
	public boolean addGoodsRegApplyToGoods(Goods goods);
	
	//상품 등록 신청 영양 정보 조회
	public Ingredient getGoodsApplyIngredient(String goodsApplyCode);
	
	//상품 영양 정보 등록
	public boolean addGoodsIngredient(Ingredient ingredient);
	
	//상품 등록 신청 거절
	public boolean refuseGoodsRegApply(Map<String, Object> map);
	
	//상품 카테고리 등록
	public boolean addGoodsCategory(GoodsCategory goodsCategory);
	
	//상품 카테고리 리스트 : 사용 중지중인 것까지 포함
	public List<GoodsCategory> getGoodsCategoryList();
	
	//상품 카테고리 리스트(사용중인 것만)
	public List<GoodsCategory> getGoodsCategoryListUser();
	
	//'식단'이 포함된 카테고리명 조회
	public List<GoodsCategory> getMenuCategoryList();
	
	//기존 데이터 조회(상품 카테고리 수정화면)
	public GoodsCategory getGoodsCategoryInfo(String goodsCategoryCode);
	
	//상품 카테고리 수정
	public boolean modifyGoodsCategory(GoodsCategory goodsCategory);
	
	//상품 카테고리 삭제
	public boolean removeGoodsCategory(String goodsCategoryCode);
	
	//상품 등록
	public boolean addGoods(Goods goods);
	
	//상품 리스트
	public List<Goods> getGoodsList(Map<String, Object> map);
	
	//구매자 상품 리스트
	public List<Goods> getGoodsListBuyer(Map<String, Object> map);
	
	//구매자 상품 리스트 페이징
	public int getGoodsListCount(Map<String, Object> map);
	
	//구매자 식단 리스트 페이징
	public int getMenuListCount(Map<String, Object> map);
	
	//상품 삭제
	public boolean removeGoods(String goodsCode);
	
	//메뉴 코드로 상품 삭제
	public boolean removeMenu(Map<String, Object> map);
	
	//상품 메인 이미지 정보 조회
	public GoodsMainImage getGoodsMainImageInfo(String mainImageIdx);
	
	//상품 소개 이미지 정보 조회
	public GoodsInfoImage getGoodsInfoImageInfo(String infoImageIdx);
	
	//상품 메인 이미지 삭제
	public boolean removeGoodsMainImage(String mainImageIdx);
	
	//상품 정보 이미지 삭제
	public boolean removeGoodsInfoImage(String infoImageIdx);
	
	//식단 등록
	public int addAdminMenu();
	
	//식단 정보 등록
	public boolean addMenuInformation(MenuInformation menuInformation);
	
	//식단 정보 수정 처리
	public boolean modifyMenuInformation(String menuCode, String menuName);
	
	//식단 정보 삭제 처리
	public boolean removeMenuInformation(String menuCode);
	
	//식단 포함 상품 정보 등록
	public boolean addMenuOrganize(MenuOrganize menuOrganize);
	
	//식단 포함 상품 정보 삭제
	public boolean removeMenuOragnize(String menuCode);
	
	//식단 리스트
	public List<Goods> getAdminMenuList(Map<String, Object> map);
	
	//식단 리스트: 구매자
	public List<Goods> getMenuList(Map<String, Object> map);
	
	//식단 수정
	public int modifyAdminMenu();
	
	//식단 삭제
	public int removeAdminMenu();
	
	//개별 상품 정보 + 메인이미지 정보
	public Goods getGoodsInfo(String goodsCode);
	
	//소개 이미지 정보
	public GoodsInfoImage getGoodsInfoImage(String goodsCode, int isLocal);
	
	//개별 식단 정보 
	public Goods getMenuInfo(String menuCode);
	
	//상품별 할인 혜택 등록
	public boolean addGoodsDiscount(GoodsDiscount goodsDiscount);
	
	//상품별 할인혜택 리스트(admin: admin이 등록한 것만)
	public List<GoodsDiscount> getGoodsDiscountListForReg();
	
	//상푸별 할인혜택 리스트(seller: seller의 세션의 아이디와 일치하는 부분, admin이 등록한 부분)
	public List<GoodsDiscount> getGoodsDiscountListSeller(String memberId);
	
	//상품별 할인혜택 리스트 제한 X
	public List<GoodsDiscount> getGoodsDiscountList(Map<String, Object> map);
	
	//상품별 할인 혜택 수정
	public boolean modifyGoodsDiscount(GoodsDiscount goodsDiscount);
	
	//상품별 할인 혜택 삭제
	public boolean removeGoodsDiscount(String goodsDiscountCode);
	
	//개별 상품별 할인 혜택 조회
	public GoodsDiscount getGoodsDiscount(String goodsDiscountCode);
	
	//상품 등록 신청
	public boolean addGoodsRegApply(GoodsApply goodsApply);
	
	//상품 등록 신청 영양 정보 등록
	public boolean addGoodsApplyIngredient(Ingredient ingredient);
	
	//기존 데이터 조회(판매자 상품 수정화면)
	public Goods getSellerGoodsInfo();
	
	//상품 수정
	public boolean modifyGoods(Goods goods);
	
	//상품 영양 정보 수정
	public boolean modifyIngredient(Ingredient ingredient);
	
	//상품 삭제
	public int removeSellerGoods();
	
	//개인 맞춤 식단 생성
	public int addBuyerMenu();
	
	//개인 맞춤 식단 목록 조회
	public List<MenuInformation> getBuyerMenuList();
	
	//개인 맞춤 식단 수정
	public int modifyBuyerMenu();
	
	//개인 맞춤 식단 삭제
	public int removeBuyerMenu();
	
	//개인 맞춤 식단 정보
	public MenuInformation getBuyerMenuInfo();
	
	//식단 목록
	public List<MenuInformation> getMenuList();
	
	//상품 목록(활성화 되어있는 것만)
	public List<Map<String, Object>> getGoodsListForMenu();
	
	//개별 식단 정보
	/* public Menus getMenuInfo(); */
	
	//개별 상품 정보
	/* public Goods getGoodsInfo(); */
	
	//메뉴 코드로 어떤 상품이 몇개 포함되어있는지 조회
	public List<MenuOrganize> getMenuOrganizeList(String menuCode);
	
}