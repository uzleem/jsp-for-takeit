package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;

/**
 * 
 * @author 심선경
 *
 */
public class MypageDao {
	
	private static MypageDao instance = new MypageDao();
	
	public static MypageDao getInstance() {
		return instance;
	}
	
	
	//일반회원 내 정보 조회 --- 일단 완성
	public void selectGeneral(Connection conn, Member dto) throws CommonException {
		
		String sql = "select * from general_member where member_id=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcTemplate.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setPoint(rs.getInt("point"));
				dto.setAddress(rs.getString("address"));
				dto.setPostNo(rs.getString("postno"));
				dto.setBirth(rs.getString("birth"));
				dto.setMemberLocNo(rs.getString("member_loc_no"));
				dto.setGrade(rs.getString("grade"));
				dto.setShopLocCode(rs.getString("shop_loc_code"));
				
			}
			
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",1);
			message.setUrl("/takeit/member/memberInfo.jsp");
			message.setLinkTitle("내 정보 보기");
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
	}
	
	/**
	 * 내 정보 수정 > 일반회원  --- 일단 완성
	 * 
	 */
	public void setGeneral(Connection conn, Member dto) throws CommonException{
		String sql = "update general_member set memberPw=? ,name=?,mobile=?,"
					 + "email=?, postno=?, address=?, birth=? where member_id=? ";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getPostNo());
			stmt.setString(6, dto.getAddress());
			stmt.setString(7, dto.getBirth());
			stmt.setString(8, dto.getMemberId());
			
			int rows = stmt.executeUpdate();
			
			if(rows == 0) {
				
				throw new Exception();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",2);
			throw new CommonException(message);
		}finally {
			JdbcTemplate.close(stmt);
		}
		
		
	}
	
	
	
	/**
	 * 판매자 정보 상세 조회
	 * 
	 */
	public void selectSeller(Connection conn, Seller dto) throws CommonException {
		
		String sql = "select * from seller_member where sellerId=?";
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcTemplate.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getSellerId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setSellerId(rs.getString("seller_id"));
				dto.setSellerPw(rs.getString("seller_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setPostNo(rs.getString("postno"));
				dto.setAddress(rs.getString("address"));
				dto.setGrade(rs.getString("grade"));
				dto.setSellerNo(rs.getString("seller_no"));
				dto.setShopMobile(rs.getString("shop_mobile"));
				dto.setShopName(rs.getString("shop_name"));
				dto.setCustScore(rs.getDouble("cust_score"));
				dto.setShopKakaoId(rs.getString("shop_kakao_id"));
				dto.setShopImg(rs.getString("shop_img"));
				dto.setShopCategoryNo(rs.getString("shop_category"));
				dto.setShopLocCode(rs.getString("shop_loc_code"));
				
				
			}
			
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",1);
			message.setUrl("/takeit/member/sellerInfo.jsp");
			message.setLinkTitle("내 정보 보기");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
	}
	
	/**
	 * 내 정보 수정 > 판매자
	 */
	
	public void setSeller(Connection conn, Seller dto) {
		String sql = "";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			
		}catch (Exception e) {
		
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
	}
	
	
	
	
	/**
	 * 회원탈퇴
	 * 
	 */
	public void RemoveMember(Connection conn, Seller dto) {
		String sql = "delete from general_member where member_id=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			
		}catch (Exception e) {
		
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
	}
	
	
	public void RemoveSeller() {
		
		
	}
	
	
	
	
	
}
