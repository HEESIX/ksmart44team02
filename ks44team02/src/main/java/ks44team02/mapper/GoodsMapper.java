package ks44team02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.GoodsInfoImage;
import ks44team02.dto.MenuOrganize;
import ks44team02.dto.MenuInformation;

@Mapper
public interface GoodsMapper {
	
	//상품 등록 신청 리스트 조회
	public List<Map<String, Object>> getGoodsRegApplyList();
	//상품 카테고리 등록
	public boolean addGoodsCategory(GoodsCategory goodsCategory);
	
	//상품 카테고리 리스트 : 사용 중지중인 것까지 포함
	public List<GoodsCategory> getGoodsCategoryList();
	
	//상품 카테고리 리스트(사용중인 것만)
	public List<GoodsCategory> getGoodsCategoryListUser();
	
	//기존 데이터 조회(상품 카테고리 수정화면)
	public GoodsCategory getGoodsCategoryInfo(String goodsCategoryCode);
	
	//상품 카테고리 수정
	public boolean modifyGoodsCategory(GoodsCategory goodsCategory);
	
	//상품 카테고리 삭제
	public boolean removeGoodsCategory(String goodsCategoryCode);
	
	//상품 등록
	public boolean addGoods(Goods goods);
	
	//상품 리스트
	public List<Goods> getAdminGoodsList();
	
	//상품 삭제
	public int removeAdminGoods();
	
	//식단 등록
	public int addAdminMenu();
	
	//식단 정보 등록
	public boolean addMenuInformation(MenuInformation menuInformation);
	
	//식단 포함 상품 등록
	public boolean addMenuOrganize(MenuOrganize menuOrganize);
	
	//식단 리스트
	public List<Goods> getAdminMenuList();
	
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
	public List<GoodsDiscount> getGoodsDiscountList();
	
	//상품별 할인 혜택 수정
	public boolean modifyGoodsDiscount(GoodsDiscount goodsDiscount);
	
	//상품별 할인 혜택 삭제
	public boolean removeGoodsDiscount(String goodsDiscountCode);
	
	//개별 상품별 할인 혜택 조회
	public GoodsDiscount getGoodsDiscount(String goodsDiscountCode);
	
	//상품 등록 신청
	public int applyGoodsRegister();
	
	//상품 리스트(판매자) - 다른 권한이랑 합치는 방안 고민
	public List<Goods> getSellerGoodsList();
	
	//기존 데이터 조회(판매자 상품 수정화면)
	public Goods getSellerGoodsInfo();
	
	//상품 수정
	public int modifySellerGoods();
	
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
	public List<Map<String, Object>> getGoodsList();
	
	//개별 식단 정보
	/* public Menus getMenuInfo(); */
	
	//개별 상품 정보
	/* public Goods getGoodsInfo(); */
	
	//메뉴 코드로 어떤 상품이 몇개 포함되어있는지 조회
	public List<MenuOrganize> getMenuOrganizeList(String menuCode);
	
}