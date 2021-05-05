package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.MypageDao;
import com.takeit.model.dto.Item;
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
	 * 상점 카테고리 목록 조회
	 * @param dto
	 * @throws CommonException
	 */
	public void getshopCategoryList( ArrayList<Seller> shopCategoryList) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.getShopCategoryList(conn, shopCategoryList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	
	/**
	 * 상품 등록
	 * @param dto
	 * @throws CommonException
	 */
	public void addItem(Item dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.addItem(conn, dto);
			JdbcTemplate.commit(conn);
		}catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	
	/**
	 * 상품 포장 타입 목록 조회
	 * @param packTypeList
	 * @throws CommonException
	 */
		public void getpackTypeList(ArrayList<Item> packTypeList) throws CommonException{
			
			Connection conn = JdbcTemplate.getConnection(); 
			try {
				dao.getpackTypeList(conn, packTypeList);
				
			}catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				JdbcTemplate.close(conn);
			}
			
		} 
	
	/**
	 * 카테고리 목록 조회
	 * @param categoryList
	 * @throws CommonException
	 */
	public void getCategoryList(ArrayList<Item> categoryList) throws CommonException{
		
		Connection conn = JdbcTemplate.getConnection(); 
		try {
			dao.getCategotyList(conn, categoryList);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
		
	} 
	
	
	/**
	 * 내 정보 상세 조회 > 일반회원
	 * @param dto 일반회원 객체
	 */
	public void memberDetail(Member dto) throws CommonException{
		System.out.println("비즈 내 정보 조회 메서드");
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.selectMemberDetail(conn, dto);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}

	}
	
	/**
	 * 내 정보 상세 조회 > 판매자 
	 * @param dto
	 * @throws CommonException
	 */
	public void sellerDetail(Seller dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.searchSellerDetail(conn, dto);
		}catch (CommonException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
	}
	
	
	/**
	 * 내 정보 수정 > 일반회원
	 * @param dto 일반회원 객체
	 */
	public void memberInfoUpdate(Member dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		try {
			dao.memberInfoUpdate(conn,dto);
			JdbcTemplate.commit(conn);
		
		} catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	/**
	 * 내 정보 수정 > 판매자
	 * @param dto 일반회원 객체
	 */
	public void sellerInfoUpdate(Seller dto) throws CommonException{
		Connection conn = JdbcTemplate.getConnection();
		try {
			dao.sellerInfoUpdate(conn, dto);
			JdbcTemplate.commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	
	/**
	 * 비밀번호 변경 일반회원
	 * @param memberPw2 변경할 비밀번호
	 * @param dto 일반회원 객체
	 * @throws CommonException
	 */
	public void setMemberPw(String memberPw2, Member dto) throws CommonException{
		
		Connection conn = JdbcTemplate.getConnection();
		try {
			dao.memberPwUpdate(conn, memberPw2, dto);
			JdbcTemplate.commit(conn);
		}catch (Exception e) {
			e.printStackTrace();
			JdbcTemplate.rollback(conn);
			throw e;
		}finally {
			JdbcTemplate.close(conn);
		}
		
	}
	
	/**
	 * 비밀번호 변경 > 판매자
	 * @param SellerPw2 변경할 비밀번호
	 * @param dto 판매자 객체
	 * @throws CommonException
	 */
		public void setSellerPw(String sellerPw2, Seller dto) throws CommonException{
			
			Connection conn = JdbcTemplate.getConnection();
			try {
				dao.sellerPwUpdate(conn, sellerPw2, dto);
				JdbcTemplate.commit(conn);
			}catch (Exception e) {
				e.printStackTrace();
				JdbcTemplate.rollback(conn);
				throw e;
			}finally {
				JdbcTemplate.close(conn);
			}
			
		}
		
		/**
		 * 회원탈퇴 일반회원
		 * @param memberId 탈퇴할 아이디
		 * @param memberPw 탈퇴할 비밀번호
		 * @throws CommonException
		 */
		public void removeMember(String memberId, String memberPw) throws CommonException{
			
			Connection conn = JdbcTemplate.getConnection();
			try {
				dao.memberDelete(conn, memberId, memberPw);
				JdbcTemplate.commit(conn);
			}catch (Exception e) {
				e.printStackTrace();
				JdbcTemplate.rollback(conn);
				throw e;
			}finally {
				JdbcTemplate.close(conn);
			}
		}
		

		/**
		 * 회원 탈퇴 판매자
		 * @param sellerId 탈퇴할 아이디
		 * @param sellerPw 탈퇴할 비밀번호
		 * @throws CommonException
		 */
		public void removeSeller(String sellerId, String sellerPw) throws CommonException{
			
			Connection conn = JdbcTemplate.getConnection();
			try {
				
				dao.sellerDelete(conn,sellerId, sellerPw);
				JdbcTemplate.commit(conn);
			}catch (Exception e) {
				e.printStackTrace();
				JdbcTemplate.rollback(conn);
				throw e;
			}finally {
				JdbcTemplate.close(conn);
			}
			
		}
	
	
	
	
	
	

}
