package ks44team02.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	// 상품 등록 신청 리스트
	public List<Map<String, Object>> getGoodsRegApplyList(){
		List<Map<String, Object>> goodsRegApplyList = goodsMapper.getGoodsRegApplyList();
		return goodsRegApplyList;
	}
	
	//상품 카테고리 등록
	public boolean addGoodsCategory(GoodsCategory goodsCategory) {
		boolean result = goodsMapper.addGoodsCategory(goodsCategory);
		return result;
	}
	
	//상품 카테고리 리스트: 사용 중지된 것도 포함
	public List<GoodsCategory> getGoodsCategoryList(){
		
		List<GoodsCategory> goodsCategoryList = goodsMapper.getGoodsCategoryList();
		
		return goodsCategoryList;
	}
	
	//상품 카테고리 리스트: 사용중인 것만
	public List<GoodsCategory> getGoodsCategoryListUser(){
		
		List<GoodsCategory> goodsCategoryList = goodsMapper.getGoodsCategoryListUser();
		
		return goodsCategoryList;
	}
	
	//기존 데이터 조회(상품 카테고리 수정 화면)
	public GoodsCategory getGoodsCategoryInfo(String goodsCategoryCode) {
		GoodsCategory goodsCategoryInfo = goodsMapper.getGoodsCategoryInfo(goodsCategoryCode);
		return goodsCategoryInfo;
	}
	
	//상품 카테고리 수정 처리
	public boolean modifyGoodsCategory(GoodsCategory goodsCategory) {
		boolean result = goodsMapper.modifyGoodsCategory(goodsCategory);
		return result;
	}
	
	//상품 카테고리 삭제
	public boolean removeGoodsCategory(String goodsCategoryCode) {
		boolean resultRemove = goodsMapper.removeGoodsCategory(goodsCategoryCode);
		return resultRemove;
	}
	
	//상품 등록 처리(관리자)
	public boolean addAdminGoods(Goods goods) {
		return false;
	}
	
	//상품 리스트
	public List<Goods> getAdminGoodsList(){
		List<Goods> goodsList = goodsMapper.getAdminGoodsList();
		return goodsList;
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
	public List<Map<String, Object>> getAdminMenuList(){
		List<Map<String, Object>> adminMenuList = goodsMapper.getAdminMenuList();
		return adminMenuList;
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
	public Map<String, Object> getGoodsInfo(String goodsCode) {
		Map<String, Object> goodsInfo = goodsMapper.getGoodsInfo(goodsCode);
		return goodsInfo;
	}
	
	//
	
	//개별 식단 정보
	public Goods getMenuInfo() {
		return null;
	}
	
	//상품별 할인 혜택 등록
	public int getGoodsDiscout() {
		return 0;
	}
	
	//상품별 할인 혜택 리스트(admin: admin이 등록한 할인혜택만)
	public List<GoodsDiscount> getGoodsDiscountListAdmin(){
		List<GoodsDiscount> goodsDiscountAdmin = goodsMapper.getGoodsDiscountListAdmin();
		return goodsDiscountAdmin;
	}
	
	//상품별 할인 혜택 리스트(seller: seller가 접속한 session id와 일치하는 목록 출력)
	public List<GoodsDiscount> getGoodsDiscountListSeller(HttpSession session){
		//세션의 아이디 조회
		//현재 없으므로 fix된 값 사용
		//String memberId = session.getAttribute("SID");
		String memberId = "id010";
		List<GoodsDiscount> goodsDiscountListSeller = goodsMapper.getGoodsDiscountListSeller(memberId);
		return goodsDiscountListSeller;
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
	
	//상품 목록(활성화 되어있는 것만), 식단 제외
	public List<Map<String, Object>> getGoodsList(){
		List<Map<String, Object>> goodsList = goodsMapper.getGoodsList();
		return goodsList;
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
