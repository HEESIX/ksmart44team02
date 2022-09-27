package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;


import ks44team02.mapper.MemberInfoMapper;
import ks44team02.dto.MemberInfo;

@Service
public class MemberInfoservice {
	
	private final MemberInfoMapper memberInfomapper;
	
	public MemberInfoservice(MemberInfoMapper MemberInforMapper) {
		this.memberInfomapper = MemberInforMapper;
	}
	
	//구매 회원 등록
	public String addBuyerInsert() {
		return null;
	}
	
	// 구매 회원 등록시 아이디 중복 체크 
	public String CheckBuyerId() {
		return null;
	}
	
	// 구매 회원 등록시 핸드폰 중복 체크 
	public String CheckBuyerNum() {
			return null;
		}
		
	// 구매 회원 수정시 기존 데이터 불러오기 
	public List<MemberInfo> getBuyerInfomation() {
		return null;
		}
	
	// 구매 회원 정보 수정
		public String modifyBuyer() {
			return null;
			}
		
	// 판매 회원 등록
		public String addVenderInsert() {
			return null;
			}
		
	// 판매 회원 아이디 중복 체크 
		public String CheckVenderId() {
			return null;
			}
		
	// 판매 회원 핸드폰 중복 체크 
		public String CheckVenderInum() {
					return null;
					}
	
	// 판매 회원 회원 정보 수정시 기존 데이터 가져오기 
		public List<MemberInfo> getVenderInfomation() {
					return null;
					}
		
	// 판매 회원 회원 정보 수정
		public String modifyVender() {
							return null;
							}
				
	// 관리자 회원 등록
		public String addAdminInsert() {
							return null;
							}
	
}
