package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks44team02.dto.Grade;
import ks44team02.mapper.GradeMapper;

@Service
public class Gradeservice {
	private final GradeMapper gradeMapper;
	
	public Gradeservice (GradeMapper gradeMapper) {
		this.gradeMapper = gradeMapper;
	}
	
	//구매자 등급 정의 등록
	public String addbuyerGrade() {
		return null;
	}
	
	// 구매자 등급 정의 조회
	public List<Grade> getbuyerGradeList() {
		List<Grade> buyerGradeList = gradeMapper.getbuyerGradeList();
		return buyerGradeList;
	}
	
	// 구매자 등급 정의 수정
		public String ModifybuyerGrade() {
			return null;
		}
	
	// 구매자 등급 정의 삭제
		public String RemovebuyerGrade() {
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
	
	// 판매자 등급 정의 조회
		public String ModifySellerGrade() {
			return null;
		}	

	// 판매자 등급 정의 삭제
		public String RemoveSellerGrade() {
			return null;
		}	
		
	
}
