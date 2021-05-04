package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Order;

public class OrderDao {
	private static OrderDao instance = new OrderDao();
	
	public static OrderDao getInstance() {
		return instance;
	}
	

	
	public void insertOrder(Connection conn, Order order) throws CommonException {
		String sql = 
				"INSERT INTO Orders VALUES(? || TO_CHAR(SYSDATE,'yyyymmdd') || LPAD(ORDER_SEQ.NEXTVAL, 6, '0') "
				+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, order.getItemTakeit());
			stmt.setString(2, order.getReceiveMethod());
			stmt.setString(3, order.getRecipientName());
			stmt.setString(4, order.getRecipientPostNo());
			stmt.setString(5, order.getRecipientAddr());
			stmt.setString(6, order.getRecipientMobile());
			stmt.setString(7, order.getShipRequest());
			stmt.setInt(8, order.getOrderPrice());
			stmt.setString(9, order.getShipStatusCode());
			stmt.setString(10, order.getMemberId());
			
			int row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}	
	}
	
	public void selectOrderNo(Connection conn, Order order) throws CommonException {
		String sql = 
				"SELECT ORDER_NO FROM ORDERS WHERE ROWNUM = 1 ORDER BY 1 DESC ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				order.setOrderNo(rs.getString("Order_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
	}
	
	public void insertOrderDetail(Connection conn, Order order) throws CommonException {
		String sql = 
				"INSERT INTO Order_Detail VALUES(?, ?, ?, ?) ";
		
		PreparedStatement stmt = null;
		try {
			
			for (int index = 0; index < order.getItemNos().length; index++) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, order.getItemNos()[index]);
				stmt.setString(2, order.getOrderNo());
				stmt.setInt(3, order.getItemQtys()[index]);
				stmt.setInt(4, order.getItemPayPrices()[index]);
				
				int row = stmt.executeUpdate();
				if (row == 0) {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}	
	}
}
