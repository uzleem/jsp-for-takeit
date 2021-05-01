package com.takeit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeit.model.biz.MypageBiz;

/**
 * Servlet implementation class FrontMypageServlet
 */
@WebServlet("/mypageController")
public class FrontMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public ServletContext application;
	public String CONTEXT_PATH;
	
	public void init() {
		application = getServletContext();
		CONTEXT_PATH = (String) application.getAttribute("CONTEXT_PATH");	
	}	
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		request.setCharacterEncoding("utf-8");
		switch(action) {
		case "myInfoForm_General":
			myInfoForm_General(request, response);
			break;
//		case "":
//			(request, response);
//			break;
//		case "":
//			(request, response);
//			break;
//		case "":
//			(request, response);
//			break;
//		case "":
//			(request,response);
//			break;
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	
	//일반 회원 정보 조회
	protected void myInfoForm_General(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일반회원 내 정보 조회");
		
		HttpSession session = request.getSession(false);
		
		String memberId = (String)session.getAttribute("memberId");
		
		MypageBiz biz = new MypageBiz();
		
		biz.getMember_General(memberId);
		
		
	}
	
	//판매자  정보 조회
		protected void myInfoForm_Seller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("판매자 내 정보 조회");
			
			HttpSession session = request.getSession(false);
			
			String memberId = (String)session.getAttribute("memberId");
			
			MypageBiz biz = new MypageBiz();
			
			biz.getMember_Seller(memberId);
			
			
		}
	
	
	
	
	
}
