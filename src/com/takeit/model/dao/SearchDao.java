package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Board;
import com.takeit.model.dto.Item;
import com.takeit.model.dto.MessageEntity;

public class SearchDao {
	private static SearchDao instance = new SearchDao();
	private SearchDao() {}
	public static SearchDao getInstance() {
		return instance;
	}
	/**검색결과조회*/
	public void getSearchList(Connection con, ArrayList<Item> searchList, String searchInput) throws CommonException {
		System.out.println("[debug] 검색 결과 조회 dao 요청");
		String sql ="SELECT * "
				+ "FROM ITEM I FULL OUTER JOIN SELLER S ON(I.SELLER_ID = S.SELLER_ID) "
				+ "WHERE I.SELLER_ID LIKE %?% "
				+ "OR S.NAME LIKE %?% "
				+ "OR I.ITEM_NAME LIKE %?% "
				+ "OR I.ITEM_NO LIKE %?%";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchInput);
			pstmt.setString(2, searchInput);
			pstmt.setString(3, searchInput);
			pstmt.setString(4, searchInput);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
//				Board dto = new Board();
//				dto.setBoardNo(rs.getString("BOARD_NO"));
//				dto.setBoardTitle(rs.getString("BOARD_TITLE"));
//				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
//				dto.setBoardCategory(rs.getString("BOARD_CATEGORY_NO"));
//				dto.setBoardCategoryName(rs.getString("BOARD_CATEGORY"));
//				dto.setBoardViews(rs.getInt("BOARD_VIEWS"));
//				dto.setBoardPicks(rs.getInt("BOARD_PICKS"));
//				dto.setBoardDate(rs.getString("BOARD_DATE"));
//				
//				searchList.add(dto);
				System.out.println("[debug] 게시판 dao 목록 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 게시판 dao 목록 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",16);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		
		
	}
}
