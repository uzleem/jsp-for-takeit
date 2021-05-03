package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.CartDao;
import com.takeit.model.dto.Cart;

public class CartBiz {
	private CartDao dao = CartDao.getInstance();

	/**장바구니 리스트*/
	public void getCartList(String memberId, ArrayList<Cart> cart) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.getCartList(con, memberId, cart);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
		
	}

}
