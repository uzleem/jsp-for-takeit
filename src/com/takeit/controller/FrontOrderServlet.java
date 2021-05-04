package com.takeit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.model.biz.OrderBiz;
import com.takeit.model.dto.Order;

/**
 * Servlet implementation class FrontOrderServlet
 */
@WebServlet("/order/orderController")
public class FrontOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		switch (action) {
		case "order":
			order(request, response);
			break;
		}
	}
	
	protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = (String)request.getSession(false).getAttribute("memberId"); 
		memberId = "user01";
		//상품
//		String itemTakeit = request.getParameter("itemTakeit");
//		//주문상세
//		String[] itemNos= request.getParameterValues("itemNo");
//		String[] _itemQtys = request.getParameterValues("itemQty");
//		String[] _itemPayPrices = request.getParameterValues("itemPayPrice");
		//주문
//		String _orderPrice = request.getParameter("orderPrice");
//		//배송
//		String shipStatusCode = request.getParameter("shipStatusCode");
//		//수령인
//		String receiveMethod = request.getParameter("receiveMethod");
//		String recipientName = request.getParameter("recipientName");
//		String recipientPostNo = request.getParameter("recipientPostNo");
//		String recipientAddr = request.getParameter("recipientAddr");
//		String recipientMobile = request.getParameter("recipientMobile");
//		String shipRequest = request.getParameter("shipRequest");

		//상품
		String itemTakeit = "T";
		//주문
		String _orderPrice = "21000";		
		//주문상세
		String[] itemNos= {"FR000002", "BF000003"};
		
		String[] _itemQtys = {"2", "3"};
		String[] _itemPayPrices = {"3000", "5000"};	
		//수령인
		String receiveMethod = "배송";
		String recipientName = "홍길동";
		String recipientPostNo = "12345";
		String recipientAddr = "경기도";
		String recipientMobile = "010-1234-1231";
		String shipRequest = "보내주세요";		
		//배송
		String shipStatusCode = "O-GET";
		
		int[] itemQtys = new int[itemNos.length];
		int[] itemPayPrices = new int[itemNos.length];
		for (int index = 0; index < itemNos.length; index++) {
			itemQtys[index] = Integer.valueOf(_itemQtys[index]);
			itemPayPrices[index] = Integer.valueOf(_itemPayPrices[index]);
		}
		int orderPrice = Integer.valueOf(_orderPrice);
		
		Order order = new Order();
		order.setItemTakeit(itemTakeit);
		
		order.setItemNos(itemNos);
		order.setItemQtys(itemQtys);
		order.setItemPayPrices(itemPayPrices);
		
		order.setOrderPrice(orderPrice);
		order.setMemberId(memberId);
		order.setReceiveMethod(receiveMethod);
		order.setRecipientName(recipientName);
		order.setRecipientPostNo(recipientPostNo);
		order.setRecipientAddr(recipientAddr);
		order.setRecipientMobile(recipientMobile);
		
		order.setShipRequest(shipRequest);
		order.setShipStatusCode(shipStatusCode);		
		
		OrderBiz biz = new OrderBiz();
		biz.addOrder(order);
		
	}
}
