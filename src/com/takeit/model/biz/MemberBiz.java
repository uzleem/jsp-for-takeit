package com.takeit.model.biz;

import java.sql.Connection;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.MemberDao;
import com.takeit.model.dto.Member;

/**
 * 회원가입 : 일반회원
 * @author 임우진
 * 
 */
public class MemberBiz {

	/**
	 * dao 객체 생성
	 */
	private MemberDao dao = new MemberDao();
	
	/**
	 * 회원가입 
	 */
	public void addMember(Member member) throws CommonException{
		Connection con = JdbcTemplate.getConnection();
		 try {
			dao.addMember(con, member);
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
	public void login(Member member) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try{
			dao.login(con, member);
		} catch(CommonException e) {
			throw e; 
		} finally {
			JdbcTemplate.close(con);
		}
	}
	
	/**
	 * 아이디 찾기
	 */
	public void idFind(Member member) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try{
			dao.idFind(con, member);
		} catch(CommonException e) {
			throw e; 
		} finally {
			JdbcTemplate.close(con);
		}
	}
	
	/**
	 * 비밀번호 찾기
	 */
	public void pwFind(String temporaryPw, Member member) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try{
			dao.pwFind(con, temporaryPw, member);
			JdbcTemplate.commit(con);
		} catch(CommonException e) {
			JdbcTemplate.rollback(con);
			throw e; 
		} finally {
			JdbcTemplate.close(con);
		}
	}
}
