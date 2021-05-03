package com.takeit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.common.CommonException;
import com.takeit.model.biz.MemberBiz;
import com.takeit.model.biz.SellerBiz;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;

/**
 * 판매자 회원관리 컨트롤러
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
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * 판매자 회원가입
	 */
	protected void sellerInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동확인 : sellerInput");
		
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");

		String sellerId = request.getParameter("sellerId");
		String sellerPw = request.getParameter("sellerPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String postNo = request.getParameter("postNo");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String sellerNo = request.getParameter("sellerNo");
		String shopMobile = request.getParameter("shopMobile");
		String shopName = request.getParameter("shopName");
		String shopKakaoId = request.getParameter("shopKakaoId");
		String shopImg = request.getParameter("shopImg");
		String shopCategoryNo = request.getParameter("shopCategoryNo");

		System.out.println(sellerId);
		System.out.println(sellerPw);
		System.out.println(name);
		System.out.println(mobile);
		System.out.println(email);
		System.out.println(postNo);
		System.out.println(address);
		System.out.println(addressDetail);
		System.out.println(shopMobile);
		System.out.println(shopName);
		System.out.println(shopKakaoId);
		System.out.println(shopImg);
		System.out.println(shopCategoryNo);
		
		Seller dto = new Seller(sellerId, sellerPw, name, mobile, email, postNo, address, addressDetail, sellerNo, shopMobile, shopName, shopKakaoId, shopImg, shopCategoryNo);
		
		SellerBiz biz = new SellerBiz();
		
		try {
			biz.addSeller(dto);
			if(dto.getSellerId() != null) {
				MessageEntity message = new MessageEntity("success", 0);
				message.setUrl("/takeit/member/memberLogin.jsp");
				message.setLinkTitle("로그인");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}else {
				MessageEntity message = new MessageEntity("error", 0);
				message.setLinkTitle("뒤로가기");
				message.setUrl(CONTEXT_PATH + "/seller/sellerInput.jsp");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}
		} catch (CommonException e) {
			//e.printStackTrace();
			//MessageEntity message = e.getMessageEntity();
			MessageEntity message = new MessageEntity("error", 0);
			message.setLinkTitle("뒤로가기");
			message.setUrl(CONTEXT_PATH + "/seller/sellerInput.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}
}
