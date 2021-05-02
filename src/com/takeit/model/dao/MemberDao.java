package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.util.Utility;

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
		
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;
		
		String date = Utility.getCurrentDate("yyyy.MM.dd HH:mm:ss");
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getMobile());
			stmt.setString(5, member.getEmail());
			stmt.setString(6, date);
			stmt.setString(7, member.getPostNo());
			stmt.setString(8, member.getAddress());
			stmt.setString(9, member.getAddressDetail());
			stmt.setString(10, "G");
			stmt.setInt(11, 1000); 
			stmt.setString(12, "1995-12-12");
			stmt.setString(13, "29");
			stmt.setString(14, "AA");
			//throw new SQLException();
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error",1);
			message.setUrl("/memberLogin.jsp");
			message.setLinkTitle("로그인");

			throw new CommonException(message);
			
		}finally {
			JdbcTemplate.close(stmt);
		}
	}
	
	/**
	 * 로그인
	 */
	public void login(Connection con, Member member) throws CommonException {
		
		String sql = "select * from member where member_Id = ? and member_Pw = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			
			rs = stmt.executeQuery();

			if(rs.next()) {
				member.setMemberId(rs.getString("member_Id"));
				member.setMemberPw(rs.getString("member_Pw"));
				member.setName(rs.getString("name"));
				member.setMobile(rs.getString("mobile"));
				member.setEmail(rs.getString("email"));
				member.setEntryDate(rs.getString("entry_date"));
				member.setPostNo(rs.getString("postno"));
				member.setAddress(rs.getString("address"));
				member.setAddressDetail(rs.getString("address_detail"));
				member.setGrade(rs.getString("grade"));
				member.setPoint(rs.getInt("point"));
				member.setBirth(rs.getString("birth"));
				member.setMemberLocNo(rs.getString("member_loc_no"));
				member.setShopLocCode(rs.getString("shop_loc_code"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error",5);
			message.setUrl("/takeit/member/memberLogin.jsp");
			message.setLinkTitle("뒤로가기");

			throw new CommonException(message);
			
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
	}
	
	/**
	 * 아이디 찾기
	 */
	public void idFind(Connection con, Member member) throws CommonException {
		
		String sql = "select member_id from member where name = ? and email = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			
			rs = stmt.executeQuery();

			if(rs.next()) {
				member.getMemberId();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error",6);
			message.setUrl("/takeit/member/memberFindId.jsp");
			message.setLinkTitle("뒤로가기");

			throw new CommonException(message);
			
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
	}
	
	/**
	 * 비밀번호 찾기
	 */
	public void pwFind(Connection con, Member member) throws CommonException {
		
		String sql = "update member set member_pw = ? where member_id = ? and name = ? and email = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String pp = Utility.getSecureString(10, false);
		
		Member dto = null;
		try {
			dto = new Member();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, pp);
			stmt.setString(2, member.getMemberId());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getEmail());
			
			int rows = stmt.executeUpdate();
			
			if(rows == 1) {
				dto.setMemberPw(pp);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error",6);
			message.setUrl("/takeit/member/memberFindPw.jsp");
			message.setLinkTitle("뒤로가기");

			throw new CommonException(message);
			
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
	}
	
	
	
	
}
