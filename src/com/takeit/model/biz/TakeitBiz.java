package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.TakeitDao;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.TakeitItem;

public class TakeitBiz {
	
	
	/**
	 * 1. memberDto에서 꺼낸 상점구역이 null이라면
	 * 2. 회원의 상점구역과 판매자테이블의 상점구역이 일치하는 
	 * 
	 * N. 세션에 회원정보 전체를 담을것인지? 맞다면 회원dto에서 받아오고, 아니라면 query를 통해 얻어옴
	 * 
	 */
	public void getTakeitItemList(Member member, ArrayList<TakeitItem> takeitItemList) {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		dao.searchTakeitItemList(conn, member, takeitItemList);
		
		JdbcTemplate.close(conn);
	}
	
	/**
	 * takeit 상품 상세조회
	 * 상품번호를 받아와서 조회후 
	 * 
	 * 필요한것 : 잇거래여부, 판매자 위치, 
	 * 
	 */
	public void getTakeitItem(TakeitItem takeitItem) {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		dao.searchTakeitItem(conn, takeitItem);
		
		JdbcTemplate.close(conn);
	}
	
}
