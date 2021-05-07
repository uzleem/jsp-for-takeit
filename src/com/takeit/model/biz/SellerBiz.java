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
	
	/**
	 * 로그인
	 */
	public void login(Seller seller) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try{
			dao.login(con, seller);
		} catch(CommonException e) {
			throw e; 
		} finally {
			JdbcTemplate.close(con);
		}
	}
	
	/**
	 * 아이디 찾기
	 */
	public void idFind(Seller seller) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try{
			dao.idFind(con, seller);
		} catch(CommonException e) {
			throw e; 
		} finally {
			JdbcTemplate.close(con);
		}
	}
	
	/**
	 * 비밀번호 찾기
	 */
	public void pwFind(String temporaryPw, Seller seller) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try{
			dao.pwFind(con, temporaryPw, seller);
			JdbcTemplate.commit(con);
		} catch(CommonException e) {
			JdbcTemplate.rollback(con);
			throw e; 
		} finally {
			JdbcTemplate.close(con);
		}
	}
	
	/**
	 * 아이디 중복체크
	 * @throws CommonException 
	 */
	public int idCheck(String sellerId) throws CommonException{
		Connection con = JdbcTemplate.getConnection();
		boolean result = dao.sellerIdChk(con, sellerId);
		JdbcTemplate.close(con);
		if (result) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 이메일 중복체크
	 * @throws CommonException 
	 */
	public int emailCheck(String email) throws CommonException{
		Connection con = JdbcTemplate.getConnection();
		boolean result = dao.sellerEmailChk(con, email);
		JdbcTemplate.close(con);
		if (result) {
			return 1;
		}
		return 0;
	}

	/**
	 * 아이디 중복체크
	 * @throws CommonException 
	 */
	public int sellerNoChk(String sellerNo) throws CommonException{
		Connection con = JdbcTemplate.getConnection();
		boolean result = dao.sellerNoChk(con, sellerNo);
		JdbcTemplate.close(con);
		if (result) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 상점명 중복체크
	 * @throws CommonException 
	 */
	public int shopNameChk(String shopName) throws CommonException{
		Connection con = JdbcTemplate.getConnection();
		boolean result = dao.shopNameChk(con, shopName);
		JdbcTemplate.close(con);
		if (result) {
			return 1;
		}
		return 0;
	}
}
