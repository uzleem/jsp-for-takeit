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
	
	
	/**
	 * 일반 회원 내 정보 상세 조회
	 * @param conn
	 * @param dto 회원 객체
	 */
	public void getMemberDetail(Connection conn, Member dto){
		String sql = "select * from member where member_id=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
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
				dto.setAddressDetail(rs.getString("address_detail"));
				dto.setPostNo(rs.getString("postno"));
				dto.setBirth(rs.getString("birth"));
				dto.setMemberLocNo(rs.getString("member_loc_no"));
				dto.setGrade(rs.getString("grade"));
				dto.setShopLocCode(rs.getString("shop_loc_code"));
				System.out.println(dto);
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
	 * 일반회원 내 정보 수정 
	 * @param conn
	 * @param dto 일반회원 객체
	 */
	public void setMemberInfo (Connection conn, Member dto){
		String sql = "update member set member_pw=? ,name=?,mobile=?,"
					 + "email=?, postno=?, address=?, address_detail=?, birth=? where member_id=? ";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getPostNo());
			stmt.setString(6, dto.getAddress());
			stmt.setString(7, dto.getAddressDetail());
			stmt.setString(8, dto.getBirth());
			stmt.setString(9, dto.getMemberId());
			
			stmt.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(stmt);
		}
		
	}
	
	
	
	/**
	 * 판매자 정보 상세 조회  x
	 * 
	 */
	public void getSellerDetail(Connection conn, Seller dto) throws CommonException {
		
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
				//dto.setAddressDetail(rs.getString("address_detail"));
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
	 * 내 정보 수정 > 판매자      x
	 */
	
	public void setSeller(Connection conn, Seller dto) {
		String sql = "update seller set seller_pw=? ,name=?,mobile=?,"
				 + "email=?, postno=?, address=?, address_detail=?, seller_no=? ,"
				 + " shop_mobile=? , shop_name=?, shop_kakao_id=?, "
				 + "shop_category_no=? where member_id=? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getSellerPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getPostNo());
			stmt.setString(6, dto.getAddress());
			//stmt.setString(7, dto.getAddressDetail());
			stmt.setString(8, dto.getSellerNo());
			stmt.setString(9, dto.getShopMobile());
			stmt.setString(10, dto.getShopName());
			stmt.setString(11, dto.getShopKakaoId());
			stmt.setString(12, dto.getShopCategoryNo());
			stmt.setString(13, dto.getSellerId());
			
			stmt.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(stmt);
		}
		
	}
	
	//비밀번호 변경 > 일반회원 
	public void setMemberPw(Connection conn , String memberPw2, Member dto) {
		String sql = "update member set member_pw=? where member_id=? and member_pw=?";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, memberPw2);
			stmt.setString(2, dto.getMemberPw());
			stmt.setString(3, dto.getMemberId());
			
			stmt.executeQuery();
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(stmt);
		}
		
	}
	
	//비밀번호 변경 > 판매자  
		public void setSellerPw(Connection conn , String sellerPw2, Seller dto) {
			String sql = "update seller set seller_pw=? where seller_id=? and seller_pw=?";
			
			PreparedStatement stmt = null;
			
			try {
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, sellerPw2);
				stmt.setString(2, dto.getSellerPw());
				stmt.setString(3, dto.getSellerId());
				
				stmt.executeQuery();
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(stmt);
			}
			
		}
	
		/**
		 * 회원탈퇴      x
		 * 
		 */
		public void removeMember(Connection conn, String memberId, String memberPw) {
			String sql = "delete from member where member_id=? and member_pw=?";
			
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			System.out.println("회원 탈퇴 요청");
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, memberId);
				stmt.setString(2, memberPw);
				
				stmt.executeUpdate();
				System.out.println("탈퇴 성공");
				
			}catch (Exception e) {
				System.out.println("탈퇴 실패");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(stmt);
			}
		}
		
		
		/**
		 * 회원 탈퇴 >판매잔
		 * @param conn
		 * @param dto
		 */
		public void removeSeller(Connection conn, Seller dto) {
			
			String sql = "delete from seller where seller_id=? and seller_pw=?";
			
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, dto.getSellerId());
				stmt.setString(2, dto.getSellerPw());
				
				stmt.executeUpdate();
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(stmt);
			}
		}
		
		
		/**
		 * 주문 상세 조회
		 * @param conn
		 */
		public void orderDetail(Connection conn) {
			
			
			
			
			
		}
		
		
		
		
		
		
		
	
	
}
