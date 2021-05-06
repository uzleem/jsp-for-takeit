package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.OrderDao;
import com.takeit.model.dto.Order;
import com.takeit.model.dto.Shipping;

/**
 * 주문 업무처리 위한 OrderBiz 클래스
 * @author 김태경
 */
public class OrderBiz {

	/**
	 * 주문 등록
	 * @param order 주문 객체
	 * @throws CommonException 
	 */
	public void addOrder(Order order) throws CommonException {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.insertOrder(conn, order);
			dao.selectOrderNo(conn, order);
			dao.insertOrderDetail(conn, order);
			
			JdbcTemplate.commit(conn);
		} catch (CommonException e) {
			JdbcTemplate.rollback(conn);
			throw e;
		} finally {
			JdbcTemplate.close(conn);
		}
	}

	/**
	 * 판매자 주문목록 조회
	 * @param sellerId 판매자아이디
	 * @param orderList 주문목록
	 */
	public void getSellerOrderList(String sellerId, ArrayList<Order> orderList) throws CommonException {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.selectSellerOrderList(conn, sellerId, orderList);
		} catch (CommonException e) {
			throw e;
		}
		finally {
			JdbcTemplate.close(conn);
		}
	}

	/**
	 * 일반회원 주문목록 조회
	 * @param memberId 회원아이디
	 * @param orderList 주문목록
	 */
	public void getMemberOrderList(String memberId, ArrayList<Order> orderList) throws CommonException {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.selectMemberOrderList(conn, memberId, orderList);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(conn);
		}
	}

	/**
	 * 주문취소요청
	 * @param orderNo 주문번호
	 */
	public void orderCancelRequest(String orderNo) throws CommonException {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.updateOrderCancelReq(conn, orderNo);
			JdbcTemplate.commit(conn);
		} catch (CommonException e) {
			JdbcTemplate.rollback(conn);
			throw e;
		} finally {
			JdbcTemplate.close(conn);
		}
	}

	/**
	 * 주문 취소 
	 * @param orderNo 주문번호
	 */
	public void orderCancel(String orderNo) throws CommonException {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.updateOrderCancel(conn, orderNo);
			JdbcTemplate.commit(conn);
		} catch (CommonException e) {
			JdbcTemplate.rollback(conn);
			throw e;
		} finally {
			JdbcTemplate.close(conn);
		}
		
	}

	/**
	 * 배송상태 목록 조회
	 * @param shippingList 배송상태리스트
	 */
	public void getShippingList(ArrayList<Shipping> shippingList) throws CommonException {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.selectShippingList(conn, shippingList);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(conn);
		}
	}
}
