package com.takeit.model.biz;

import java.sql.Connection;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.MypageDao;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.Seller;


/**
 * 마이페이지 로직 담당 클래스 
 * 
 * @author 심선경
 *
 */

public class MypageBiz {
	
	
	private MypageDao dao = MypageDao.getInstance();
	
	//내 정보 조회 > 일반회원 --일단 완성
	public void getMemberGeneral(Member dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.selectGeneral(conn, dto);
		}catch (CommonException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
	}
	
	//내 정보 조회 > 판매자 회원
	public void getMemberSeller(Seller dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		
		try {
			dao.selectSeller(conn, dto);
		}catch (CommonException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
	}
	
	
	//내 정보 수정 > 일반회원 
	public void setMemberGeneral(Member dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.setGeneral(conn,dto);
			JdbcTemplate.commit(conn);
		}catch (CommonException e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
