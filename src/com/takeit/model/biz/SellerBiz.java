package com.takeit.model.biz;

import java.sql.Connection;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.SellerDao;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.Seller;

/**
 * 회원가입 : 판매자회원
 * @author 임우진
 * 
 */
public class SellerBiz {

	/**
	 * dao 객체 생성
	 */
	private SellerDao dao = new SellerDao();
	
	/**
	 * 회원가입 
	 */
	public void addSeller(Seller seller) throws CommonException{
		Connection con = JdbcTemplate.getConnection();
		 try {
			dao.addSeller(con, seller);
			JdbcTemplate.commit(con);
		} catch (CommonException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(con);
			throw e;
		}finally {
			JdbcTemplate.close(con);
		}
	}
}
