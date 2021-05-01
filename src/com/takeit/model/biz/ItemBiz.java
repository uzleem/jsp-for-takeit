/**
 * 
 */
package com.takeit.model.biz;

import com.takeit.util.Utility;

/**
 * @author 김효원
 *
 */
//public class ItemBiz {

		//private ItemDao dao = ItemDao.getInstance(); 
	
//	/**
//	 * <pre>
//	 * 상품등록
//	 * -- 회원 입력 데이터 : 상품번호,상품카테고리이름,판매가,할인율,판매단위,재고량,원산지,포장타입,판매자,이미지,안내사항,유통기한,잇거래여부
//	 * -- 시스템 추가 데이터 : 상품 등록일
//	 * </pre>
//	 * @param dto 회원객체
//	 * @return 성공시 true, 실패시 false
//	 */
//	public boolean addItem(Item dto) {
//		dto.setEntryDate(Utility.getCurrentDate());
//		int rows = dao.inserMember(dto);
//		if (rows == 1) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	/** 
//	 * 상품페이지 조회
//	 * @return ArrayList<Member>
//	 */
//	public void getMemberList(ArrayList<Member> list) throws CommonException {
//		// dao에서 사용하기 위한 Connection 객체 생성
//		Connection conn = JdbcTemplate.getConnection();
//		
//		try {
//			// dao에게 Connection 객체와 controller에서 전달받은 요청결과 담기위한 객체 아규먼트 전달
//			// 성공
//			dao.selectList(conn, list);
//		} catch (CommonException e) {
//			e.printStackTrace();
//			// 실패 : 예외발생 controller에서 다시 예외 던짐
//			throw e;
//		} finally {
//			// Connection 자원 biz에서 해제 시킴
//			JdbcTemplate.close(conn);
//		}
//	}