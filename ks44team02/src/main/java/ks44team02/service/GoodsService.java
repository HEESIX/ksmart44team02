package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Goods;
import ks44team02.dto.GoodsDiscount;

@Service
public class GoodsService {
	
	//상품 카테고리 등록
	public int addGoodsCategory() {
		return 0;
	}
	
	//상품 카테고리 리스트
	//Goods아님 변경 필요
	public List<Goods> getGoodsCategoryList(){
		return null;
	}
	
	//기존 데이터 조회(상품 카테고리 수정 화면)
	public String getModifyGoodsCategoryCode() {
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

}
