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
	
	public void searchBoard(Connection con, ArrayList<Board> boardList) throws CommonException {
		System.out.println("[debug] 게시판 dao 목록 요청");
		String sql = "";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, );
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Board dto = new Board();
				System.out.println("[debug] 게시판 dao 목록 요청 완료");
			}
			
		} catch (SQLException e) {
			System.out.println("[debug] 게시판 dao 목록 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",4);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
	}
}
