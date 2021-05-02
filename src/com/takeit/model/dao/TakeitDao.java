package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.TakeitItem;

public class TakeitDao {
	private static TakeitDao instance = new TakeitDao();
	
	public static TakeitDao getInstance() {
		return instance;
	}

	public void searchTakeitItemList(Connection conn, Member member, ArrayList<TakeitItem> takeitItemList) {
		String sql = 
				"SELECT * "
				+ "FROM ITEM JOIN ITEM_CATEGORY USING (ITEM_CATEGORY_NO) JOIN PACKING USING (PACK_TYPE_NO) JOIN SELLER USING (SELLER_ID) JOIN TAKEIT USING(SHOP_LOC_CODE) "
				+ "WHERE SELLER_ID IN ( "
				+ "		SELECT SELLER_ID "
				+ "		FROM SELLER "
				+ "		WHERE SHOP_LOC_CODE = ( "
				+ "			SELECT SHOP_LOC_CODE "
				+ "			FROM TAKEIT "
				+ "			WHERE TAKEIT_ALIVE = 'T' AND SHOP_LOC_CODE = ? AND MEMBER_LOC_NO = ? "
				+ "			) "
				+ "		) "
				+ "AND ITEM_TAKEIT = 'T' ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getShopLocCode());
			stmt.setString(2, member.getMemberLocNo());
			rs = stmt.executeQuery();
			
			TakeitItem takeitItem = null;
			while (rs.next()) {
				takeitItem = new TakeitItem();
				//상품
				takeitItem.setItemNo(rs.getString("item_No"));
				takeitItem.setSellerId(rs.getString("seller_Id"));
				takeitItem.setItemName(rs.getString("item_Name"));
				takeitItem.setItemPrice(rs.getInt("item_Price")); //int
				takeitItem.setItemImg(rs.getString("item_Img"));
				takeitItem.setItemCustScore((int)rs.getDouble("item_Cust_Score")); //int 인데 double로 바꾸길 권장
				takeitItem.setItemInputDate(rs.getString("item_Input_Date"));
				takeitItem.setDiscRate(rs.getInt("disc_Rate")); //int
				takeitItem.setItemTakeit(rs.getString("item_TakeIt"));
				//잇거래
				takeitItem.setTakeitNo(rs.getString("takeit_No"));
				takeitItem.setTakeitPrice(rs.getInt("takeit_Price")); //int
				takeitItem.setTakeitCurrPrice(rs.getInt("takeit_Curr_Price")); //int
				takeitItem.setTakeitDate(rs.getString("takeit_date"));
				takeitItem.setTakeitCustScore(rs.getDouble("takeit_Cust_Score")); //double
				takeitItem.setTakeitAlive(rs.getString("takeit_Alive"));
				takeitItem.setMemberLocNo(rs.getString("member_Loc_No"));
				takeitItem.setShopLocCode(rs.getString("shop_Loc_Code"));
				
				takeitItemList.add(takeitItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
//			MessageEntity message = new MessageEntity("error", 4);
//			message.setLinkTitle("교수 로그인");
//			message.setUrl("/exercise/exe02/teacher/main.jsp");
//			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}		
	}

	public void searchTakeitItem(Connection conn, TakeitItem takeitItem) {
		String sql = 
				"SELECT * "
				+ "FROM ITEM JOIN ITEM_CATEGORY USING (ITEM_CATEGORY_NO) JOIN PACKING USING (PACK_TYPE_NO) JOIN SELLER USING (SELLER_ID) JOIN TAKEIT USING(SHOP_LOC_CODE) "
				+ "WHERE ITEM_NO = ? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, takeitItem.getItemNo());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				//포장타입
				takeitItem.setPackTypeNo(rs.getString("pack_Type_No"));
				takeitItem.setPackTypeName(rs.getString("pack_Type_Name"));
				//카테고리
				takeitItem.setItemCategoryNo(rs.getString("item_Category_No"));
				takeitItem.setItemCategoryName(rs.getString("item_Category_Name"));
				takeitItem.setExpirationDate(rs.getString("expiration_Date"));
				takeitItem.setNotice(rs.getString("notice"));
				takeitItem.setFreshPercent(rs.getInt("fresh_Percent")); // int
				//상품
				takeitItem.setItemNo(rs.getString("item_No"));
				takeitItem.setSellerId(rs.getString("seller_Id"));
				takeitItem.setItemName(rs.getString("item_Name"));
				takeitItem.setItemPrice(rs.getInt("item_Price")); //int
				takeitItem.setSalesUnit(rs.getString("sales_Unit"));
				takeitItem.setItemOrigin(rs.getString("item_Origin"));
				takeitItem.setItemStock(rs.getInt("item_Stock")); //int
				takeitItem.setItemImg(rs.getString("item_Img"));
				takeitItem.setItemCustScore((int)rs.getDouble("item_Cust_Score")); //double
				takeitItem.setItemInputDate(rs.getString("item_Input_Date"));
				takeitItem.setDiscRate(rs.getInt("disc_Rate")); //int
				takeitItem.setItemTakeit(rs.getString("item_TakeIt"));
				//잇거래
				takeitItem.setTakeitNo(rs.getString("takeit_No"));
				takeitItem.setTakeitPrice(rs.getInt("takeit_Price")); //int
				takeitItem.setTakeitCurrPrice(rs.getInt("takeit_Curr_Price")); //int
				takeitItem.setTakeitDate(rs.getString("takeit_date"));
				takeitItem.setTakeitCustScore(rs.getDouble("takeit_Cust_Score")); //double
				takeitItem.setTakeitAlive(rs.getString("takeit_Alive"));
				takeitItem.setMemberLocNo(rs.getString("member_Loc_No"));
				takeitItem.setShopLocCode(rs.getString("shop_Loc_Code"));
			}
		} catch (Exception e) {
			e.printStackTrace();
//			MessageEntity message = new MessageEntity("error", 4);
//			message.setLinkTitle("교수 로그인");
//			message.setUrl("/exercise/exe02/teacher/main.jsp");
//			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
	}
}
