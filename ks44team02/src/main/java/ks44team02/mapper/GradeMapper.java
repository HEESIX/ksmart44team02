package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.Grade;

@Mapper
public interface GradeMapper {

	// 구매자 등급 정의 등록
	public String addBuyerGrade();
	
	// 구매자 등급 정의 조회
	public List<Grade> getBuyerGradeList();
	
	// 구매자 등급 정의 수정
	public String modifyBuyerGrade();
	
	// 구매자 등급 정의 삭제
	public String removeBuyerGrade();
	
	// 판매자 등급 정의 등록
	public String addSellerGrade();
	
	// 판매자 등급 정의 조회
	public List<Grade> getSellerGradeList();
	
	// 판매자 등급 정의 수정
	public String modifySellerGrade();
	
	// 판매자 등급 정의 삭제
	public String removeSellerGrade();
	
}
