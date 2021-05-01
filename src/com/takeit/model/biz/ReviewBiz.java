///**
// * 
// */
//package com.takeit.model.biz;
//
//import com.takeit.util.Utility;
//
///**
// * @author 김효원
// *
// */
//public class ReviewBiz {
//
//		//private ItemDao dao = ItemDao.getInstance(); 
//	
//	
//	/**
//	 * <pre>
//	 * 상품후기등록
//	 * -- 회원 입력 데이터 : 
//	 * -- 시스템 추가 데이터 : 후기작성일
//	 * </pre>
//	 * @param dto 
//	 * @return 성공시 true, 실패시 false
//	 */
//	public boolean addReview(Review dto) {
//		dto.setEntryDate(Utility.getCurrentDate());
//		int rows = dao.enrollReview(dto);
//		if (rows == 1) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	}


