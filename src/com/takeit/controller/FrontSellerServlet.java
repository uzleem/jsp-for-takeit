package com.takeit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원관리 컨트롤러
 */
@WebServlet(urlPatterns = {"/seller/controller"})
public class FrontSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContext application;
	public String CONTEXT_PATH;
	
	public void init() {
		application = getServletContext();
		CONTEXT_PATH = (String) application.getAttribute("CONTEXT_PATH");	
	}	 
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		switch(action) {
		case "sellerInput":
			sellerInput(request, response);
			break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * 판매자 회원가입
	 */
	protected void sellerInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
	}
	
	
}
