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

/**
 * @author 한소희
 *
 */
public class BoardBiz {
	private BoardDao dao = BoardDao.getInstance(); 
	
	public void getNoticeList(ArrayList<Board> noticeList) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.getNoticeList(con, noticeList);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
	}

	public void noticeDetail(String board_no, Board notice) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.noticeDetail(con, board_no, notice);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
		
	}

}
