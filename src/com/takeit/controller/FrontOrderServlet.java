package com.takeit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.model.biz.TakeitBiz;
import com.takeit.model.dto.TakeitItem;

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
		case "orderForm":
			orderForm(request, response);
			break;
		case "order":
			order(request, response);
			break;
			
		}
	}
	
	protected void orderForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] itemNos= request.getParameterValues("itemNo");
		String[] itemPrices = request.getParameterValues("itemPrices");
		
		
	}

	protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
