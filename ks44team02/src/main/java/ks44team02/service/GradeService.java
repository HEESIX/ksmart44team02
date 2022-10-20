package ks44team02.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ks44team02.dto.Grade;
import ks44team02.mapper.GradeMapper;

@Service
public class GradeService {

private final GradeMapper gradeMapper;

public GradeService(GradeMapper gradeMapper) {
	this.gradeMapper = gradeMapper;
 }
	// 판매자 등급 정의 리스트 조회  
	public List<Grade> getBuyerGradeList() {
		List<Grade> buyerGradeList = gradeMapper.getBuyerGradeList();
		return buyerGradeList;	
	}
	
	// 판매자 등급 정의 등록
	public List<Grade> addSellerGrade() {
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
	
	//구매자 등급 정의 리스트 조회  
	public List<Grade> getSellerGradeList(String buyerLevelCode) {
		List<Grade> sellerGradeList = gradeMapper.getSellerGradeList();
		return sellerGradeList;
	}
	
	//구매자 등급 정의 등록
	public boolean addBuyerGrade(Grade buyerGradeList) {
		boolean result = gradeMapper.addBuyerGrade(buyerGradeList);
		return result;
		}

	// 구매자 등급 정의 수정
	public boolean modifyBuyerGrade(Grade buyerGradeList) {  
		boolean result = gradeMapper.modifyBuyerGrade();
		return result;
	}
	// 구매자 등급 정의 삭제
	public boolean removeBuyerGrade(String buyerLevelCode) {
		boolean resultRemove = gradeMapper.removeBuyerGrade();
		return resultRemove;
				}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
			

}