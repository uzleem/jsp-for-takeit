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
import com.takeit.model.dao.MemberDao;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;

/**
 * 회원관리 컨트롤러
 */
@WebServlet(urlPatterns = {"/member/controller"}, loadOnStartup = 1)
public class FrontMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContext application;
	public String CONTEXT_PATH;
	
	public void init() {
		application = getServletContext();
		CONTEXT_PATH = application.getContextPath();
		System.out.println("[loadOnStartup]CONTEXT_PATH : " + CONTEXT_PATH);
		application.setAttribute("CONTEXT_PATH", CONTEXT_PATH);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		switch(action) {
		case "memberInput":
			memberInput(request, response);
			break;
		case "memberLogin":
			memberLogin(request, response);
			break;
		case "memberLogout":
			memberLogout(request, response);
			break;
		case "memberFindId":
			memberFindId(request, response);
			break;
		case "memberFindPw":
			memberFindPw(request, response);
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
	 * 일반 회원가입 
	 */
	protected void memberInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/exe02/teacher/message.jsp");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String zipNo = request.getParameter("zipNo");
		String roadAddrPart1 = request.getParameter("roadAddrPart1");
		String addrDetail = request.getParameter("addrDetail");
		String birth = request.getParameter("birth");
				
		System.out.println(memberId);
		System.out.println(memberPw);
		System.out.println(name);
		System.out.println(mobile);
		System.out.println(email);
		System.out.println(zipNo);
		System.out.println(roadAddrPart1);
		System.out.println(addrDetail);
		System.out.println(birth);
		
		Member dto = new Member(memberId, memberPw, name, mobile, email, zipNo, roadAddrPart1, addrDetail, birth);
		
		MemberBiz biz = new MemberBiz();
				
		try {
			biz.addMember(dto);
			
			MessageEntity message = new MessageEntity("success", 0);
			message.setUrl("${COTEXT_PATH}/member/memberlogin.jsp");
			message.setLinkTitle("로그인");
			request.setAttribute("message", message);
			rd.forward(request, response);
		} catch (CommonException e) {
			e.printStackTrace();
			MessageEntity message = e.getMessageEntity();
			System.out.println(message);
		}
	}
	
	/**
	 * 로그인
	 */
	protected void memberLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/member/memberInfo.jsp").forward(request, response);

	}

	/**
	 * 로그아웃
	 */
	protected void memberLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
	
	/**
	 * 아이디 찾기
	 */
	protected void memberFindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
	
	/**
	 * 비밀번호 찾기
	 */
	protected void memberFindPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
	
}
