/**
 * 
 */
package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Item;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Review;



/**
 * @author 김효원
 *
 */
public class ReviewDao {
	private static ReviewDao instance = new ReviewDao();
	private ReviewDao() {}
	public static ReviewDao getInstance() {
		return instance;
	}
	
	/**
	 * 후기 전체목록
	 * @param con
	 * @param ReviewList
	 * @throws CommonException
	 */
	public void getReviewList(Connection con, ArrayList<Review> reviewList) throws CommonException {
		String sql = "SELECT * FROM Review WHERE 1 = 1 ORDER BY REVIEW_DATE DESC";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs= stmt.executeQuery();
	
			while(rs.next()) {
				Review dto = new Review();
				System.out.println(dto);
				dto.setReviewNo(rs.getString("REVIEW_NO"));
				dto.setMemberId(rs.getString("MEMBER_ID"));
				dto.setItemNo(rs.getString("ITEM_NO"));
				dto.setReviewDate(rs.getString("REVIEW_DATE"));
				dto.setReviewTitle(rs.getString("REVIEW_TITLE"));
				dto.setReviewContents(rs.getString("REVIEW_CONTENTS"));
				dto.setReviewScore(rs.getInt("REVIEW_SCORE"));
				dto.setReviewImg(rs.getString("REVIEW_IMG"));
				
				reviewList.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",7);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(stmt);
	}
	
	/**
	 * 후기등록
	 * @param con
	 * @param EnrollReview
	 * @throws CommonException
	 */

	public void addReview(Connection conn, Review dto) throws CommonException {
		String sql = "insert into review values(?,?,?,?,?)";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcTemplate.getConnection();
		
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			if(rs.next()) {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getItemNo());
			stmt.setString(2, dto.getReviewTitle());
			stmt.setString(3, dto.getReviewContents());
			stmt.setInt(4, dto.getReviewScore());
			stmt.setString(5, dto.getReviewImg());

			
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		
			MessageEntity message = new MessageEntity("error", 2);
			message.setUrl("/takeit/item/login?action=reviewEnrollForm");
			message.setLinkTitle("후기등록");

			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(stmt);
	}	
	
}
