package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;
import com.takeit.util.Utility;

/**
 * 판매자회원 : DB접근
 * @author 임우진
 * 
 */
public class SellerDao {

	public void addSeller(Connection con, Seller seller) throws CommonException {
		
	String sql = "insert into seller values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	PreparedStatement stmt = null;
	
	String date = Utility.getCurrentDate("yyyy.MM.dd HH:mm:ss");
	
	try {
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, seller.getSellerId());
		stmt.setString(2, seller.getSellerPw());
		stmt.setString(3, seller.getName());
		stmt.setString(4, seller.getMobile());
		stmt.setString(5, seller.getEmail());
		stmt.setString(6, date);
		stmt.setString(7, seller.getPostNo());
		stmt.setString(8, seller.getAddress());
		stmt.setString(9, seller.getAddressDetail());
		stmt.setString(10, "S");
		stmt.setString(11, seller.getSellerNo());
		stmt.setString(12, seller.getShopMobile());
		stmt.setString(13, seller.getName());
		stmt.setDouble(14, 5.0);
		stmt.setString(15, seller.getShopKakaoId());
		stmt.setString(16, seller.getShopImg());
		stmt.setString(17, seller.getShopCategoryNo());
		stmt.setString(18, "AA");
		//throw new SQLException();
		stmt.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		
		MessageEntity message = new MessageEntity("error",0);
		message.setUrl("/sellerInput.jsp");
		message.setLinkTitle("로그인");
		throw new CommonException(message);
	}finally {
		JdbcTemplate.close(stmt);
	}
  }
}