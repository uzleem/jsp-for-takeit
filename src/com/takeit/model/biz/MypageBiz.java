//package com.takeit.model.biz;
//
//import java.sql.Connection;
//
//import com.takeit.model.dao.JdbcTemplate;
//import com.takeit.model.dao.MypageDao;
//import com.takeit.model.dto.MypageMember;
//import com.takeit.model.dto.MypageSeller;
//
///**
// * 마이페이지 로직 담당 클래스 
// * 
// * @author 심선경
// *
// */
//
//public class MypageBiz {
//	
//	
//	private MypageDao dao = MypageDao.getInstance();
//	
//	//내 정보 조회 > 일반회원
//	public void getMemberGeneral(MypageMember dto) {
//		Connection conn = JdbcTemplate.getConnection();
//		
//		try {
//			dao.selectGeneral(conn, dto);
//		}catch (Exception e) {
//
//		}finally {
//			JdbcTemplate.close(conn);
//		}
//	}
//	
//	//내 정보 조회 > 판매자 회원
//	public void getMemberSeller(MypageSeller dto) {
//		Connection conn = JdbcTemplate.getConnection();
//		
//		
//		try {
//			dao.selectSeller(conn, dto);
//		}catch (Exception e) {
//			
//		}finally {
//			JdbcTemplate.close(conn);
//		}
//	}
//	
//	
//	//내 정보 수정 > 일반회원 
//	public void setMemberGeneral(MypageMember dto) {
//		Connection conn = JdbcTemplate.getConnection();
//		
//		try {
//			dao.setGeneral(conn,dto);
//			JdbcTemplate.commit(conn);
//		}catch (Exception e) {
//			e.printStackTrace();
//			JdbcTemplate.rollback(conn);
//			
//		}finally {
//			JdbcTemplate.close(conn);
//		}
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
