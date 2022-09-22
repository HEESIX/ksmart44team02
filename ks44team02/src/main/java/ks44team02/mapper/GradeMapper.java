package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeMapper {

	// 구매자 등급 정의 등록
	public String addbuyerGrade();
	
	// 구매자 등급 정의 조회
	public String getbuyerGradeList();
	
	// 구매자 등급 정의 수정
	public String ModifybuyerGrade();
	
	// 구매자 등급 정의 삭제
	public String RemovebuyerGrade();
	
	// 판매자 등급 정의 등록
	public String addVenderGrade();
	
	// 판매자 등급 정의 조회
	public String getVendeGradeList();
	
	// 판매자 등급 정의 수정
	public String ModifyVendeGrade();
	
	// 판매자 등급 정의 삭제
	public String RemoveVenderGrade();
	
}
