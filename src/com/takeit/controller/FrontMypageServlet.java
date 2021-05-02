package com.takeit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.takeit.common.CommonException;
import com.takeit.model.biz.MypageBiz;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;

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
		case "myInfoFormGeneral":
			myInfoFormGeneral(request, response);
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
	
	
	/**
	 * 일반 회원 내 정보 조회 -- 일단 완성
	 * 
	 */
	protected void myInfoFormGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일반회원 내 정보 조회");
		
		HttpSession session = request.getSession(false);
		
		String memberId = request.getParameter("memberId");

		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String postNo = request.getParameter("postno");
		String address = request.getParameter("address");
		String birth = request.getParameter("birth");
		
		
		MypageBiz biz = new MypageBiz();
		
		Member dto = new Member();
		dto.setMemberId(memberId);
		
		MessageEntity message = null;
		
		try {
			biz.getMemberGeneral(dto);
			message = new MessageEntity();
		}catch (Exception e) {
//			message = e.getMessage();

		}
		
	}
	
	//판매자  정보 조회

	protected void myInfoFormSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("판매자 내 정보 조회");
		
		HttpSession session = request.getSession(false);
		
		String sellerId = (String)session.getAttribute("memberId");
		
		Seller dto = new Seller();
		
		dto.setSellerId(sellerId);
		
		
		MypageBiz biz = new MypageBiz();
		
		MessageEntity message = null;
		
		try {
			biz.getMemberSeller(dto);	
			message = new MessageEntity();
		}catch (Exception e) {
			
//			message = e.getMessage();
		}
		
		
		
		
		
	}
	
	
	//내 정보 변경
	
	protected void setMemberGeneral (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 판매자  수정");
		
		HttpSession session = request.getSession(false);
		
		String sellerId = request.getParameter("seller");
		String sellerPw = request.getParameter("sellerPws");
		String name = request.getParameter("name");
		String shopName = request.getParameter("shopName");
		String shopMobile = request.getParameter("shopMobile");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String shopCategoryNo = request.getParameter("shopCategoryNo");
		String shopKaKaoId = request.getParameter("shopKaKaoId");
		String postNo = request.getParameter("postno");
		String address = request.getParameter("address");
		
		MypageBiz biz = new MypageBiz();
		
//		Seller dto = new Seller(sellerId, sellerPw, shopName, mobile, email, postNo, address, grade, sellerNo, shopMobile, shopName, shopKakaoId, shopImg, shopCategoryNo)
		MessageEntity message = null;
		
		
		try {
			
//			biz.setMemberGeneral(dto);
			message = new MessageEntity();
			
		}catch (Exception e) {
//			message = e.getMessage()
		}
		
		
		
	}
	
	
	
	protected void setMemberSeller (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 판매자  수정");
		
		HttpSession session = request.getSession(false);
		
		String sellerId = (String)session.getAttribute("memberId");
		String sellerPw = request.getParameter("sellerPws");
		String name = request.getParameter("name");
		String shopName = request.getParameter("shopName");
		String shopMobile = request.getParameter("shopMobile");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String shopCategoryNo = request.getParameter("shopCategoryNo");
		String shopKaKaoId = request.getParameter("shopKaKaoId");
		String postNo = request.getParameter("postno");
		String address = request.getParameter("address");
		
		MypageBiz biz = new MypageBiz();
		
//		Seller dto = new Seller(sellerId, sellerPw, shopName, mobile, email, postNo, address, grade, sellerNo, shopMobile, shopName, shopKakaoId, shopImg, shopCategoryNo)
		MessageEntity message = null;
		
		
		try {
			
//			biz.setMemberGeneral(dto);
			message = new MessageEntity();
			
		}catch (Exception e) {
//			message = e.getMessage();
		}
		
	} 
	
	
	//회원 삭제  > 일반회원
	protected void remobeMemberSeller (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 판매자  수정");
		
		HttpSession session = request.getSession(false);
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		
		MypageBiz biz = new MypageBiz();
		
//		Seller dto = new Seller(sellerId, sellerPw, shopName, mobile, email, postNo, address, grade, sellerNo, shopMobile, shopName, shopKakaoId, shopImg, shopCategoryNo)
		MessageEntity message = null;
		
		
		try {
			
//			biz.setMemberGeneral(dto);
			message = new MessageEntity();
			
		}catch (Exception e) {
//			message = e.getMessage();
		}
		
	} 
	
	
	
	
	
	
	
	
	

	
	
	
}
