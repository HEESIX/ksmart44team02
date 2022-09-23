package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.Menus;
import ks44team02.mapper.GoodsMapper;

@Service
public class GoodsService {
	
	private final GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	//상품 카테고리 등록
	public int addGoodsCategory() {
		return 0;
	}
	
	//상품 카테고리 리스트: 사용 중지된 것도 포함
	public List<GoodsCategory> getGoodsCategoryList(){
		
		List<GoodsCategory> goodsCategoryList = goodsMapper.getGoodsCategoryList();
		
		return goodsCategoryList;
	}
	
	//상품 카테고리 리스트: 사용중인 것만
	public List<GoodsCategory> getGoodsCategoryListBuyer(){
		
		List<GoodsCategory> goodsCategoryList = goodsMapper.getGoodsCategoryListBuyer();
		
		return goodsCategoryList;
	}
	
	//기존 데이터 조회(상품 카테고리 수정 화면)
	public String getGoodsCategoryInfo() {
		return null;
	}
	
	//상품 카테고리 수정
	public int modifyGoodsCategory() {
		return 0;
	}
	
	//상품 카테고리 삭제
	public int removeGoodsCategory() {
		return 0;
	}
	
	//상품 리스트
	public List<Goods> getAdminGoodsList(){
		return null;
	}
	
	//상품 삭제
	public int removeAdminGoods() {
		return 0;
	}
	
	//식단 등록
	public int addAdminMenu() {
		return 0;
	}
	
	//식단 리스트
	public List<Goods> getAdminMenuList(){
		return null;
	}
	
	//식단 수정
	public int modifyAdminMenu() {
		return 0;
	}
	
	//식단 삭제
	public int removeAdminMenu() {
		return 0;
	}
	
	//개별 상품 정보
	public Goods getGoodsInfo() {
		return null;
	}
	
	//개별 식단 정보
	public Goods getMenuInfo() {
		return null;
	}
	
	//상품별 할인 혜택 등록
	public int getGoodsDiscout() {
		return 0;
	}
	
	//상품별 할인 혜택 리스트
	public List<GoodsDiscount> getGoodsDiscountList(){
		return null;
	}
	
	//상품별 할인 혜택 수정
	public int modifyGoodsDiscount() {
		return 0;
	}
	
	//상품별 할인 혜택 삭제
	public int removeGoodsDiscount() {
		return 0;
	}
	
	//상품 등록 신청
	public int applyGoodsRegister() {
		return 0;
	}
	
	//상품 리스트(판매자)
	public List<Goods> getSellerGoodsList(){
		return null;
	}
	
	//기존 데이터 조회(상품 수정화면 판매자)
	public Goods getSellerGoodsInfo() {
		return null;
	}
	
	//상품 수정
	public int modifySellerGoods() {
		return 0;
	}
	
	//상품 삭제
	public int removeSellerGoods() {
		return 0;
	}
	
	//개인 맞춤 식단 생성
	public int addBuyerMenu() {
		return 0;
	}
	
	//개인 맞춤 식단 목록 조회
	public List<Menus> getBuyerMenuList(){
		return null;
	}
	
	//개인 맞춤 식단 수정
	public int modifyBuyerMenu() {
		return 0;
	}
	
	//개인 맞춤 식단 삭제
	public int removeBuyerMenu() {
		return 0;
	}
	
	//개인 맞춤 식단 정보
	public Menus getBuyerMenuInfo() {
		return null;
	}
	
	//식단 목록
	public List<Menus> getMenuList(){
		return null;
	}
	
	//상품 목록
	public List<Goods> getGoodsList(){
		return null;
	}
	
	//개별 식단 정보
	/*
	 * public Menus getMenuInfo() { return null; }
	 */
	
	//개별 상품 정보
	/*
	 * public Goods getGoodsInfo() { return null; }
	 */
	
}
