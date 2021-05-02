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
import com.takeit.model.dto.Category;
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
	
	/***
	 * 게시글 전체목록
	 * @param con
	 * @param boardList
	 * @throws CommonException
	 */
	public void getBoardList(Connection con, String categoryNo, ArrayList<Board> boardList) throws CommonException {
		System.out.println("[debug] 게시판 dao 목록 요청");
		String sql = "SELECT * FROM BOARD B, BOARD_CATEGORY BC "
				+ "WHERE B.BOARD_CATEGORY_NO=BC.BOARD_CATEGORY_NO "
				+ "AND B.BOARD_CATEGORY_NO = ? "
				+ "ORDER BY B.BOARD_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, categoryNo);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Board dto = new Board();
				dto.setBoardNo(rs.getString("BOARD_NO"));
				dto.setBoardTitle(rs.getString("BOARD_TITLE"));
				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
				dto.setBoardCategoryName(rs.getString("BOARD_CATEGORY"));
				dto.setBoardViews(rs.getInt("BOARD_VIEWS"));
				dto.setBoardPicks(rs.getInt("BOARD_PICKS"));
				dto.setBoardDate(rs.getString("BOARD_DATE"));
				
				boardList.add(dto);
				System.out.println("[debug] 게시판 dao 목록 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 게시판 dao 목록 요청 실패");
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
	
	/***
	 * 게시글 상세조회
	 * @param con
	 * @param board_no
	 * @param notice
	 * @throws CommonException
	 */
	public void boardDetail(Connection con, String boardNo, String boardCategory, Board notice) throws CommonException {
		System.out.println("[debug] 게시판 dao 상세조회 요청");
		String sql = "SELECT * FROM BOARD B, BOARD_CATEGORY BC "
				+ "WHERE B.BOARD_CATEGORY_NO=BC.BOARD_CATEGORY_NO "
				+ "AND B.BOARD_CATEGORY_NO = ? "
				+ "AND B.BOARD_NO=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardCategory);
			pstmt.setString(2, boardNo);
			rs= pstmt.executeQuery();
	
			if(rs.next()) {
				notice.setBoardNo(rs.getString("board_no"));
				notice.setBoardTitle(rs.getString("board_title"));
				notice.setBoardWriter(rs.getString("board_writer"));
				notice.setBoardCategory(rs.getString("board_category"));
				notice.setBoardViews(rs.getInt("board_views"));
				notice.setBoardPicks(rs.getInt("board_picks"));
				notice.setBoardDate(rs.getString("board_date"));
				notice.setBoardContents(rs.getString("board_contents"));
				
				System.out.println("[debug] 게시판 dao 목록 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 게시판 dao 목록 요청 실패");
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
	
	/**조회수 증가*/
	public int views(Connection con, String boardNo) {
		System.out.println("[debug] 게시판 dao 조회수 증가 요청");
		String sql = "UPDATE BOARD SET BOARD_VIEWS = BOARD_VIEWS+1 WHERE BOARD_NO=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			int view = pstmt.executeUpdate();
			
			
			System.out.println("[debug] 게시판 조회수 dao 증가 완료");
			return view;
		} catch (SQLException e) {
			System.out.println("[debug] 게시판 조회수 dao 증가 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",14);
			message.setLinkTitle("게시판 목록");
			message.setUrl("/takeit/boardController?action=boardList");
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return 0;
	}
	
	/**게시글 등록*/
	public void boardInput(Connection con, Board notice) throws CommonException {
		System.out.println("[debug] 게시판 dao 등록 요청");
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, 0, sysdate, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getBoardWriter());
			pstmt.setString(2, notice.getBoardTitle());
			pstmt.setString(3, notice.getBoardContents());
			pstmt.setString(4, notice.getBoardCategory());
			pstmt.setString(5, notice.getBoardItem());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",13);
			message.setLinkTitle("게시판 목록");
			message.setUrl("/takeit/boardController?action=boardList");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(pstmt);
		}
	}
	
	/**카테고리 리스트*/
	public void getCategoryList(Connection con, ArrayList<Category> category) throws CommonException {
		System.out.println("[debug] 게시판 dao 카테고리 리스트 요청");
		String sql = "SELECT * FROM BOARD_CATEGORY";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
	
			while(rs.next()) {
				Category dto = new Category();
				dto.setCategoryNo(rs.getString("board_category_no"));
				dto.setCategoryName(rs.getString("board_category"));
				
				category.add(dto);
				System.out.println("[debug] 게시판 dao 카테고리 리스트 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 게시판 dao 카테고리 리스트 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",13);
			message.setLinkTitle("게시판 목록");
			message.setUrl("/takeit/boardController?action=boardList");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
	}

}
