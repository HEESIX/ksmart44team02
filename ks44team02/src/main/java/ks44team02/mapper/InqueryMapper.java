package ks44team02.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InqueryMapper {
	
	
	//문의 조회
	public String getSellerInqueryList();
				
	//문의 답변
	public int answerInquery();

}
