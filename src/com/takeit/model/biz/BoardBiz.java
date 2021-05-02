/**
 * 
 */
package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.BoardDao;
import com.takeit.model.dto.Board;
import com.takeit.model.dto.Category;

/**
 * @author 한소희
 *
 */
public class BoardBiz {
	private BoardDao dao = BoardDao.getInstance(); 
	
	/**게시글 전체조회*/
	public void getBoardList(String categoryNo, ArrayList<Board> noticeList) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.getBoardList(con, categoryNo, noticeList);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
	}

	/**게시글상세조회*/
	public void boardDetail(String boardNo, String boardCategory, Board board) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			int view = dao.views(con, boardNo);
			JdbcTemplate.commit(con);
			if(view != 0) {
				dao.boardDetail(con, boardNo, boardCategory, board);
			}
		} catch (CommonException e) {
			JdbcTemplate.rollback(con);
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
		
	}
	
	/**게시글 등록*/
	public void boardInput(Board notice) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.boardInput(con, notice);
		} catch (CommonException e) {
			JdbcTemplate.rollback(con);
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
	}
	
	/**카테고리 리스트*/
	public void getCategoryList(ArrayList<Category> category) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.getCategoryList(con, category);
		} catch (CommonException e) {
			JdbcTemplate.rollback(con);
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
		
	}

}
