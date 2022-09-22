package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	
	public int addGoodsCategory();

	//구매자 로그인
	public int buyerLogin();

	//구매자 로그아웃
	public int buyerlogout();	
	
	//판매자 로그인
	public int sellerLogin();

	//구매자 로그아웃
	public int sellerlogout();	
	
	//구매자 로그인
	public int adminLogin();

	//구매자 로그아웃
	public int adminlogout();	
	
}
