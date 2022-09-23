package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.Menus;

@Mapper
public interface GoodsMapper {
	
	//상품 카테고리 등록
	public int addGoodsCategory();
	
	//상품 카테고리 리스트
	//Goods아님 변경 필요
	public List<GoodsCategory> getGoodsCategoryList();
	
	//기존 데이터 조회(상품 카테고리 수정화면)
	public String getModifyGoodsCategoryCode();
	
	//상품 카테고리 수정
	public int modifyGoodsCategory();
	
	//상품 카테고리 삭제
	public int removeGoodsCategory();
	
	//상품 리스트
	public List<Goods> getAdminGoodsList();
	
	//상품 삭제
	public int removeAdminGoods();
	
	//식단 등록
	public int addAdminMenu();
	
	//식단 리스트
	//Goods 아님 변경 필요
	public List<Goods> getAdminMenuList();
	
	//식단 수정
	public int modifyAdminMenu();
	
	//식단 삭제
	public int removeAdminMenu();
	
	//개별 상품 정보
	public Goods getGoodsInfo();
	
	//개별 식단 정보 
	//Goods 아님 변경 필요
	public Goods getMenuInfo();
	
	//상품별 할인 혜택 등록
	public int addGoodsDiscount();
	
	//상품별 할인혜택 리스트
	//Goods 아님 변경 필요
	public List<Goods> getGoodsDiscount();
	
	//상품별 할인 혜택 수정
	public int modifyGoodsDiscount();
	
	//상품별 할인 혜택 삭제
	public int removeGoodsDiscount();
	
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
	public List<Menus> getBuyerMenuList();
	
	//개인 맞춤 식단 수정
	public int modifyBuyerMenu();
	
	//개인 맞춤 식단 삭제
	public int removeBuyerMenu();
	
	//개인 맞춤 식단 정보
	public Menus getBuyerMenuInfo();
	
	//식단 목록
	public List<Menus> getMenuList();
	
	//상품 목록
	public List<Goods> getGoodsList();
	
	//개별 식단 정보
	/* public Menus getMenuInfo(); */
	
	//개별 상품 정보
	/* public Goods getGoodsInfo(); */
	
}