package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Grade;
import ks44team02.mapper.GradeMapper;

@Service
public class GradeService {
	private final GradeMapper gradeMapper;
	
	public GradeService (GradeMapper gradeMapper) {
		this.gradeMapper = gradeMapper;
	}
	
	//구매자 등급 정의 등록
	public String addBuyerGrade() {
		return null;
	}
	
	// 구매자 등급 정의 조회
	public List<Grade> getBuyerGradeList() {
		List<Grade> buyerGradeList = gradeMapper.getBuyerGradeList();
		return buyerGradeList;
	}
	
	// 구매자 등급 정의 수정
		public String modifyBuyerGrade() {
			return null;
		}
	
	// 구매자 등급 정의 삭제
		public String removeBuyerGrade() {
			return null;
		}
		
	// 판매자 등급 정의 등록
		public List<Grade> addSellerGrade() {
			List<Grade> sellerGradeList = gradeMapper.getSellerGradeList();
			return sellerGradeList;
		}
	
	// 판매자 등급 정의 조회
		public List<Grade> getSellerGradeList() {
			List<Grade> sellerGradeList = gradeMapper.getSellerGradeList();
			return sellerGradeList;
		}
	
	// 판매자 등급 정의 수정
		public String modifySellerGrade() {
			return null;
		}	

	// 판매자 등급 정의 삭제
		public String removeSellerGrade() {
			return null;
		}	
		
	
}
