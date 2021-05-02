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
@WebServlet("/member/mypageController")
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
		case "memberInfoForm":
			memberInfoForm(request, response);
			break;
		case "setMemberInfo":
			setMemberInfo(request, response);
			break;
		case "sellerInfoForm":
			sellerInfoForm(request, response);
			break;
		case "setMemberSeller":
			setMemberSeller(request, response);
			break;
		case "removeMember":
			removeMember(request,response);
			break;
//			case "":
//			(request,response);
//			break;
//			case "":
//			(request,response);
//			break;
//			case "":
//			(request,response);
//			break;
//			case "":
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
	 * 일반 회원 내 정보 조회 
	 * 
	 */
	protected void memberInfoForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일반회원 내 정보 조회");
		
//		HttpSession session = request.getSession(false);
		
//		String memberId = (String)session.getAttribute("memberId");
//		String memberId = request.getParameter("memberId");
		String memberId = "user01";
		MypageBiz biz = new MypageBiz();
		
		Member dto = new Member();
		dto.setMemberId(memberId);
		try {
			biz.getMember(dto);
			request.setAttribute("member", dto);
			request.getRequestDispatcher("/member/memberInfo.jsp").forward(request, response);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	//판매자  정보 조회

	protected void sellerInfoForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("판매자 내 정보 조회");
		
//		HttpSession session = request.getSession(false);
		
//		String sellerId = (String)session.getAttribute("memberId");
		String sellerId = request.getParameter("memberId");
		
		Seller dto = new Seller();
		dto.setSellerId(sellerId);
		
		MypageBiz biz = new MypageBiz();
		
		
		try {
			biz.getSeller(dto);	
			request.setAttribute("seller", dto);
			request.getRequestDispatcher("/member/sellerInfo.jsp").forward(request, response);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 일반회원 내 정보 수정
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void setMemberInfo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일반회원 내 정보  수정");
		
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String postNo = request.getParameter("postNo");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String birth = request.getParameter("birth");
		
		MypageBiz biz = new MypageBiz();
		
		Member dto = new Member();
		dto.setMemberId(memberId);
		dto.setMemberPw(memberPw);
		dto.setName(name);
		dto.setMobile(mobile);
		dto.setEmail(email);
		dto.setPostNo(postNo);
		dto.setAddress(address);
		dto.setAddressDetail(addressDetail);
		dto.setBirth(birth);
		
		
		try {
			biz.setMember(dto);
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/member/mypageController?action=memberInfoForm").forward(request, response);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	protected void setMemberSeller (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 판매자  수정");
		
//		HttpSession session = request.getSession(false);
		
//		String sellerId = (String)session.getAttribute("memberId");
		String sellerId = request.getParameter("sellerId");
		String sellerPw = request.getParameter("sellerPw");
		String name = request.getParameter("name");
		String sellerNo = request.getParameter("sellerNo");
		String shopName = request.getParameter("shopName");
		String shopMobile = request.getParameter("shopMobile");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String shopCategoryNo = request.getParameter("shopCategoryNo");
		String shopKakaoId = request.getParameter("shopKakaoId");
		String postNo = request.getParameter("postno");
		String address = request.getParameter("address");
//		String addressDetail = request.getParameter("addressDetail");
		
		MypageBiz biz = new MypageBiz();
		
		Seller dto = new Seller();
		dto.setSellerId(sellerId);
		dto.setSellerPw(sellerPw);
		dto.setName(name);
		dto.setSellerNo(sellerNo);
		dto.setShopName(shopName);
		dto.setShopMobile(shopMobile);
		dto.setMobile(mobile);
		dto.setEmail(email);
		dto.setShopCategoryNo(shopCategoryNo);
		dto.setShopKakaoId(shopKakaoId);
		dto.setPostNo(postNo);
		dto.setAddress(address);
//		dto.setaddressDetail(addressDetail");
		
		try {
			
			biz.setSeller(dto);
			
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/member/mypageController?action=memberInfoForm").forward(request, response);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	} 
	
	
	//회원 삭제  > 일반회원
	protected void removeMember (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 탈퇴 요청");
		
//		HttpSession session = request.getSession(false);
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
//		String memberId = "user01";
//		String memberPw = "password01";
		
		
		MypageBiz biz = new MypageBiz();
		

		try {
			biz.removeMember(memberId,memberPw);
			response.sendRedirect("/takeit/index.jsp");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	} 
	
	//회원 삭제  > 일반회원
		protected void removeSeller (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("내 판매자  수정");
			
			HttpSession session = request.getSession(false);
			
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			
			
			MypageBiz biz = new MypageBiz();
			
			
			
			try {
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		} 
	
	
	
	//비밀번호 변경  > 일반회원
	protected void setMemberPw (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일반회원 > 비밀번호 변경 요청 서블릿 ㄴ");
		
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberPw2 = request.getParameter("memberPw2");
		
		
		MypageBiz biz = new MypageBiz();
		
		
		Member dto = new Member();
		dto.setMemberId(memberId);
		dto.setMemberPw(memberPw2);
		
		
		
		try {
			biz.setMemberPw(memberPw2, dto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	} 
	
	
	
	
}
