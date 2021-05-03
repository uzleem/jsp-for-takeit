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
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Review;
import com.takeit.model.dto.Seller;



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

	public void enrollReview(Connection conn, Review dto) throws CommonException {
		String sql = "insert into review values(?,?,?,?,?,?)";

		PreparedStatement stmt = null;
	
	try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, dto.getMemberId());
			stmt.setString(2, dto.getItemNo());
			stmt.setString(3, dto.getReviewTitle());
			stmt.setString(4, dto.getReviewContents());
			stmt.setInt(5, dto.getReviewScore());
			stmt.setString(6, dto.getReviewImg());
			stmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		
			MessageEntity message = new MessageEntity("error", 7);
		//	message.setUrl("/takeit/reviewController?action=reviewEnrollForm");
		//	message.setLinkTitle("후기등록");

			throw new CommonException(message);
		   } finally {
		         JdbcTemplate.close(stmt);
		      }
		   }
	
	/**
	 * 내가 쓴 후기 상세조회
	 * @param conn
	 * @param dto 후기
	 */
	public void ReviewDetail(Connection conn, Review dto){
		String sql = "select * from review where member_id=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
	
				dto.setReviewNo(rs.getString("REVIEW_NO"));
				dto.setMemberId(rs.getString("MEMBER_ID"));
				dto.setItemNo(rs.getString("ITEM_NO"));
				dto.setReviewDate(rs.getString("REVIEW_DATE"));
				dto.setReviewTitle(rs.getString("REVIEW_TITLE"));
				dto.setReviewContents(rs.getString("REVIEW_CONTENTS"));
				dto.setReviewScore(rs.getInt("REVIEW_SCORE"));
				dto.setReviewImg(rs.getString("REVIEW_IMG"));			
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
	}
		/**
		 * 후기내용 변경
		 * @param conn
		 * @param dto 후기
		 */
		public void updateReview (Connection conn,Review dto){
			String sql = "update review set  REVIEW_TITLE=? ,REVIEW_CONTENTS=?,REVIEW_SCORE=?,"
						 + "REVIEW_IMG=? where member_id=? ";
			
			PreparedStatement stmt = null;
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, dto.getReviewTitle());
				stmt.setString(2, dto.getReviewContents());
				stmt.setInt(3, dto.getReviewScore());
				stmt.setString(4, dto.getReviewImg());
	
				
				stmt.executeUpdate();
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(stmt);
			}
			
	}
	
//	/**
//	 * 후기삭제
//	 * @param conn
//	 * @param dto
//	 */
//     public void deleteReview(Connection conn, String memberId,String reviewTitle) {
//		
//		String sql = "delete from review where member_id=? and review_title=?";
//		
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, memberId());
//			stmt.setString(2, reviewTitle());
//			
//			stmt.executeUpdate();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}finally {
//			JdbcTemplate.close(rs);
//			JdbcTemplate.close(stmt);
//		}		
//	}		
}
