
package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.ItemDao;
import com.takeit.model.dto.Item;


/**
 * @author 김효원
 *
 */
public class ItemBiz {

private ItemDao dao = ItemDao.getInstance(); 
	
   /**
     * <pre>
	 * 상품등록
	 * -- 상품등록 입력 데이터 : 상품번호,상품카테고리이름,판매가,할인율,판매단위,재고량,원산지,포장타입,판매자,이미지,안내사항,유통기한,잇거래여부	 * -- 시스템 추가 데이터 : 상품 등록일
	 * </pre>
	 * @param dto 상품객체
     * @return 성공시 등록 미입력시 오류처리
	 */

public void enrollItem(Item dto) throws CommonException{
	Connection conn = JdbcTemplate.getConnection();
	try {
		
		dao.addItem(conn, dto);
	} catch(CommonException e) {
		throw e; 
	} finally {
		JdbcTemplate.close(conn);
	}
}

/** 
 * 등록상품 조회
 * @return ArrayList<Item>
 */
public void getItemList(ArrayList<Item> list) throws CommonException {
	
	Connection conn = JdbcTemplate.getConnection();
	
	try {
	
		dao.selectList(conn, list);
	} catch (CommonException e) {
		e.printStackTrace();
		throw e;
	} finally {
		JdbcTemplate.close(conn);
	}
}


}
	