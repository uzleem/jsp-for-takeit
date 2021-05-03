package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Cart;
import com.takeit.model.dto.MessageEntity;

public class CartDao {
	private static CartDao instance = new CartDao();
	private CartDao() {}
	public static CartDao getInstance() {
		return instance;
	}
	
	/**장바구니 전체 목록 조회*/
	public void getCartList(Connection con, String memberId, ArrayList<Cart> cart) throws CommonException {
		System.out.println("[debug] 장바구니 전체 목록 dao 요청");
		String sql = "SELECT I.ITEM_NAME AS ITEM_NAME, S.NAME AS SELLER_NAME, "
				+ "C.CART_ITEM_QTY AS CART_ITEM_QTY, (I.ITEM_PRICE * C.CART_ITEM_QTY) AS TOTAL_PRICE "
				+ "FROM CART C, ITEM I, SELLER S "
				+ "WHERE C.ITEM_NO = I.ITEM_NO "
				+ "AND I.SELLER_ID = S.SELLER_ID "
				+ "AND C.MEMBER_ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Cart dto = new Cart();
				dto.setItemName(rs.getString("ITEM_NAME"));
				dto.setSellerName(rs.getString("SELLER_NAME"));
				dto.setCartItemQty(rs.getInt("CART_ITEM_QTY"));
				dto.setTotalPrice(rs.getInt("TOTAL_PRICE"));
				
				cart.add(dto);
			}
			System.out.println("[debug] 장바구니 전체 목록 dao 요청 완료");
			
		} catch (SQLException e) {
			System.out.println("[debug] 장바구니 전체 목록 dao 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",21);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
	}

	
}
