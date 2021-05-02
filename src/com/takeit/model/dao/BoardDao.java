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
import com.takeit.model.dto.Board;
import com.takeit.model.dto.MessageEntity;

/**
 * @author 한소희
 *
 */
public class BoardDao {
	private static BoardDao instance = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return instance;
	}
	
	public void getNoticeList(Connection con, ArrayList<Board> boardList) throws CommonException {
		System.out.println("[debug] 공지사항 dao 목록 요청");
		String sql = "SELECT * FROM BOARD WHERE BOARD_CATEGORY_NO = '1' ORDER BY BOARD_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Board dto = new Board();
				dto.setBoardNo(rs.getString("board_no"));
				dto.setBoardTitle(rs.getString("board_title"));
				dto.setBoardWriter(rs.getString("board_writer"));
				dto.setBoardViews(rs.getInt("board_views"));
				dto.setBoardPicks(rs.getInt("board_picks"));
				dto.setBoardDate(rs.getString("board_date"));
				
				boardList.add(dto);
				System.out.println("[debug] 공지사항 dao 목록 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 공지사항 dao 목록 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",13);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
	}
	public void noticeDetail(Connection con, String board_no, Board notice) throws CommonException {
		System.out.println("[debug] 공지사항 dao 상세조회 요청");
		String sql = "SELECT * FROM BOARD WHERE BOARD_CATEGORY_NO = '1' AND BOARD_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board_no);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				notice.setBoardNo(rs.getString("board_no"));
				notice.setBoardTitle(rs.getString("board_title"));
				notice.setBoardWriter(rs.getString("board_writer"));
				notice.setBoardViews(rs.getInt("board_views"));
				notice.setBoardPicks(rs.getInt("board_picks"));
				notice.setBoardDate(rs.getString("board_date"));
				notice.setBoardContents(rs.getString("board_contents"));
				
				System.out.println("[debug] 공지사항 dao 목록 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 공지사항 dao 목록 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",13);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
	}

}
