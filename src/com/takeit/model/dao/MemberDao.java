package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;

/**
 * 일반회원 : DB접근
 * @author 임우진
 * 
 */
public class MemberDao {

	/**
	 * 회원가입
	 */
	public void addMember(Connection con, Member member) throws CommonException {
		
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getMobile());
			stmt.setString(5, member.getEmail());
//			stmt.setString(6, member.getZipNo());
//			stmt.setString(7, member.getRoadAddrPart1());
//			stmt.setString(8, member.getAddrDetail());
			stmt.setString(9, member.getBirth());
			
			stmt.executeUpdate();
			throw new SQLException();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error",1);
			message.setUrl("/takeit/member/memberLogin.jsp");
			message.setLinkTitle("로그인");

			throw new CommonException(message);
			
		}finally {
			JdbcTemplate.close(stmt);
		}
		
		
		
	}
}
