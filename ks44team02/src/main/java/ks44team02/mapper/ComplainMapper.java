package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import ks44team02.dto.Complain;

@Mapper
public interface ComplainMapper {
	
	
  // 회원 Complain 내역 조회
  public List<Complain> getComplainList();
	
  // 회원 Complain 삭제
  public int ComplainDelete();
  
  //판매자 신고내역 조회
  public String getSellerComplainList();
	

  //구매자 신고 등록
  public int regBuyerComplain();

public Complain getComplainInfo();
		
	

}
