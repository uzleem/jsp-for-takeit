package com.takeit.model.biz;

import com.takeit.model.dao.MypageDao;

/**
 * 마이페이지 로직 담당 클래스 
 * 
 * @author 심선경
 *
 */

public class MypageBiz {
	
	
	private MypageDao dao = MypageDao.getInstance();
	
	//내 정보 조회 > 일반회원
	public String getMember_General(String memberId) {
		
		return dao.selectGeneral(memberId);
	}
	
	//내 정보 조회
	public String getMember_Seller(String memberId) {
		
		return dao.selectSeller(memberId);
	}
	
	

}
