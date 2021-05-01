package com.takeit.model.dao;


/**
 * 
 * @author 심선경
 *
 */
public class MypageDao {
	
	private static MypageDao instance = new MypageDao();
	
	public static MypageDao getInstance() {
		return instance;
	}
	
	
	//일반회원 내 정보 조회
	public String selectGeneral(String memberId) {
		
		String sql = "select m.member_id, m.member_pw, m.name, m.mobile, m.email,m.entry_date" + 
					 " ,m.postno, m.address,m.grade , g.point, g.birth, g.member_loc_no, g.shop_loc_code" + 
					 " from member m, general_member g" + 
					 " where m.member_id = g.member_id" + 
					 " and m.member_id=?";
		
		
		
		
		return null;
	}
	
	
	public String selectSeller(String memberId) {
		
		String sql = "select m.member_id, m.member_pw, m.name, m.mobile, m.email,m.entry_date" + 
				     " ,m.postno, m.address,m.grade , s.seller_no, s.shop_mobile, s.shop_name,s.cust_score, s.shop_category_no,s.shop_loc_code" + 
				     " from member m, seller_member s" + 
				     " where m.member_id = s.member_id" + 
				     " and m.member_id=?";
		
		
		return null;
		
	}
	
	
}
