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

public List<Grade> getBuyerGradeList() {
	
	return null;
}

public List<Grade> getSellerGradeList() {
	// TODO Auto-generated method stub
	return null;
}
}