package com.takeit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.model.biz.OrderBiz;

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
		
		String[] itemNos= request.getParameterValues("itemNo");
		String[] itemPrices = request.getParameterValues("itemPrice");
		String[] itemQty = request.getParameterValues("itemQty");
		
		String receiveMethod = request.getParameter("receiveMethod");
		String recipientName = request.getParameter("recipientName");
		String recipientPostNo = request.getParameter("recipientPostNo");
		String recipientAddr = request.getParameter("recipientAddr");
		String recipientMobile = request.getParameter("recipientMobile");
		String shipRequest = request.getParameter("shipRequest");
		String shipStatusCode = request.getParameter("shipStatusCode");
		
		OrderBiz biz = new OrderBiz();
		for (int index = 0; index < itemNos.length; index++) {
		}
		//biz.getItem();
		
	}
}
