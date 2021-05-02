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
	
	/**
	 * 내 정보 상세 조회 > 일반회원
	 * @param dto 일반회원 객체
	 */
	public void getMember(Member dto){
		System.out.println("비즈 내 정보 조회 메서드");
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.getMemberDetail(conn, dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(conn);
		}
		
			
		
			JdbcTemplate.close(conn);
	}
	
	//내 정보 조회 > 판매자 회원
	public void getSeller(Seller dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.getSellerDetail(conn, dto);
		}catch (CommonException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(conn);
		}
	}
	
	
	/**
	 * 내 정보 수정 > 일반회원
	 * @param dto 일반회원 객체
	 */
	public void setMember(Member dto){
		Connection conn = JdbcTemplate.getConnection();
		try {
			dao.setMemberInfo(conn,dto);
			JdbcTemplate.commit(conn);
			System.out.println("커밋완료");
		
		} catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	/**
	 * 내 정보 수정 > 판매자
	 * @param dto 일반회원 객체
	 */
	public void setSeller(Seller dto){
		Connection conn = JdbcTemplate.getConnection();
		try {
			dao.setSeller(conn,dto);
			JdbcTemplate.commit(conn);
		
		} catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	
	//비밀번호 변경  >일반회원
	public void setMemberPw(String memberPw2, Member dto){
		
		Connection conn = JdbcTemplate.getConnection();
		try {
			dao.setMemberPw(conn, memberPw2, dto);
			JdbcTemplate.commit(conn);
		}catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	//비밀번호 변경 > 판매자
		public void setSellerrPw(String SellerPw2, Seller dto){
			
			Connection conn = JdbcTemplate.getConnection();
			try {
				dao.setSellerPw(conn, SellerPw2, dto);
				JdbcTemplate.commit(conn);
			}catch (Exception e) {
				e.printStackTrace();
				JdbcTemplate.rollback(conn);
			}finally {
				JdbcTemplate.close(conn);
			}
			
		}
		
	//회원 탈퇴 > 일반회원
			public void removeMember(String memberId, String memberPw){
				
				Connection conn = JdbcTemplate.getConnection();
				try {
					dao.removeMember(conn, memberId, memberPw);
					JdbcTemplate.commit(conn);
				}catch (Exception e) {
					e.printStackTrace();
					JdbcTemplate.rollback(conn);
				}finally {
					JdbcTemplate.close(conn);
				}
				
			}

	//회원 탈퇴 > 판매자
			public void removeSeller(Seller dto){
				
				Connection conn = JdbcTemplate.getConnection();
				try {
					dao.removeSeller(conn,dto);
					JdbcTemplate.commit(conn);
				}catch (Exception e) {
					e.printStackTrace();
					JdbcTemplate.rollback(conn);
				}finally {
					JdbcTemplate.close(conn);
				}
				
			}
	
	
	
	
	
	

}
