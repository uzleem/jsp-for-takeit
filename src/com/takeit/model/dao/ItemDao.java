package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Item;
import com.takeit.model.dto.MessageEntity;



/**
 * @author 김효원
 */
public class ItemDao {
	
	private static ItemDao instance = new ItemDao();
	
	/**
	 * 상품등록
	 * @param dto 상품
	 * @return 상품목록
	 */
	private ItemDao() {}
	public static ItemDao getInstance() {
		return instance;
	}
	//상품등록
	public void addItem(Connection conn, Item dto) throws CommonException {
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcTemplate.getConnection();
		
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			if(rs.next()) {	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getItemCategoryName());
			stmt.setString(2, dto.getSellerId());
			stmt.setString(3, dto.getItemName());
			stmt.setInt(4, dto.getItemPrice ());
			stmt.setString(5, dto.getItemOrigin());
			stmt.setInt(6, dto.getItemStock());
			stmt.setString(7, dto.getItemImg());
			stmt.setString(8, dto.getItemTakeit());
			stmt.setString(9, dto.getPackTypeName());
			stmt.setString(10, dto.getExpirationDate());
			stmt.setString(11, dto.getNotice());
			stmt.setInt(12, dto.getFreshPercent());
			
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		
			MessageEntity message = new MessageEntity("error", 2);
			message.setUrl("/takeit/item/login?action=itemEnrollForm");
			message.setLinkTitle("상품등록");

			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(stmt);
	}
	/**
	 * 전체상품조회
	 * @return ArrayList<Item>
	 */
	public void ItemList(Connection conn, ArrayList<Item> itemList) throws CommonException {
	
		String sql = "select * from packing p ,item_category c ,item i " + 
				"where p.pack_type_no =c.pack_type_no" + 
				"and  c.ITEM_CATEGORY_NO =i.ITEM_CATEGORY_NO";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			Item dto = null;
			
			while(rs.next()) {
				dto = new Item();
				dto.setPackTypeNo(rs.getString("PACK_TYPE_NO"));
				dto.setPackTypeName(rs.getString("PACK_TYPE_NAME"));
				
				dto.setItemCategoryNo(rs.getString("ITEM_CATEGORY_NO"));
				dto.setItemCategoryName(rs.getString("ITEM_CATEGORY_NAME"));
				dto.setExpirationDate(rs.getString("EXPIRATION_DATE"));
				dto.setNotice(rs.getString("NOTICE"));
				dto.setFreshPercent(rs.getInt("FRESH_PERCENT"));
				dto.setItemNo(rs.getString("ITEM_NO"));
				
				dto.setSellerId(rs.getString("SELLER_ID"));
				dto.setItemName(rs.getString("ITEM_NAME "));
				dto.setItemPrice(rs.getInt("ITEM_PRICE"));
				dto.setItemOrigin(rs.getString("ITEM_ORIGIN"));
				dto.setItemStock(rs.getInt("ITEM_STOCK"));
				dto.setItemImg(rs.getString("ITEM_IMG"));
				dto.setItemCustScore(rs.getDouble("ITEM_CUST_SCORE"));
				dto.setItemInputDate(rs.getString("ITEM_INPUT_DATE"));
				dto.setDiscRate(rs.getInt("DISC_RATE"));
				dto.setItemTakeit(rs.getString("ITEM_TAKEIT"));
		
                
				itemList.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",7);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index.jsp");
			throw new CommonException(message);
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(stmt);
	}
	
/**
 * 상품삭제
 */
	public void deleteItem(Connection conn, Item dto) {
		
		String sql = "delete from Item where seller_id=? and Item_no=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getSellerId());
			stmt.setString(2, dto.getItemNo());
			
			stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}		
	}
}