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
 * 마이페이지 관리 컨트롤러
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
		case "removeMemberForm":
			removeMemberForm(request,response);
			break;
		case "removeSeller":
			removeSeller(request,response);
			break;
		case "memberPwUpdateForm":
			memberPwUpdateForm(request,response);
			break;
		case "setMemberPw":
			setMemberPw(request,response);
			break;
		case "setSellerPw":
			setSellerPw(request,response);
			break;
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
	 * 일반회원 내 정보 조회
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void memberInfoForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일반회원 내 정보 조회");
		
		HttpSession session = request.getSession();
		
		MessageEntity message = null;
		
		String memberId = (String)session.getAttribute("memberId");
		
		if(memberId == null || memberId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("마이페이지로 이동");
			message.setUrl("/takeit/member/myPage.jsp");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		memberId = memberId.trim();
		
		MypageBiz biz = new MypageBiz();
		
		Member dto = new Member();
		dto.setMemberId(memberId);
		
		
		try {
			biz.getMember(dto);
			session.setAttribute("member", dto);
			request.getRequestDispatcher("/member/memberInfo.jsp").forward(request, response);
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}
	}
	
	/**
	 * 판매자 정보 조회 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sellerInfoForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("판매자 내 정보 조회");
		
		HttpSession session = request.getSession();
		
		
		MessageEntity message = null;
//		String sellerId = (String)session.getAttribute("sellerId");
//		String sellerId = request.getParameter("memberId");
		String sellerId = "seller01";
		
		
		if(sellerId == null || sellerId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("마이페이지로 이동");
			message.setUrl("/takeit/member/myPage.jsp");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		sellerId = sellerId.trim();
		
 		Seller dto = new Seller();
		dto.setSellerId(sellerId);
		
		MypageBiz biz = new MypageBiz();
		
		
		try {
			biz.getSeller(dto);	
			session.setAttribute("seller", dto);
			request.getRequestDispatcher("/member/sellerInfo.jsp").forward(request, response);
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
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
		
		HttpSession session = request.getSession();
		
		MessageEntity message = null;
		
		String memberId = (String)session.getAttribute("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String postNo = request.getParameter("postNo");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String birth = request.getParameter("birth");
		
		if(memberId == null || memberId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(memberPw == null || memberPw.trim().length() == 0  ) {


			message = new MessageEntity("validation",1);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(name == null || name.trim().length() ==0) {


			message = new MessageEntity("validation",2);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(postNo == null || postNo.trim().length() == 0) {


			message = new MessageEntity("validation",3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(address == null || address.trim().length() ==0) {
			message = new MessageEntity("validation",3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(addressDetail == null || addressDetail.trim().length() ==0) {

			message = new MessageEntity("validation",3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(mobile == null || mobile.trim().length() > 10
				|| email == null || email.trim().length() == 0
				|| birth == null || birth.trim().length() == 0) {


			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(email == null || email.trim().length() == 0) {
			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(birth == null || birth.trim().length() == 0) {
			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		memberId = memberId.trim();
		memberPw = memberPw.trim();
		name = name.trim();
		mobile = mobile.trim();
		email = email.trim();
		postNo = postNo.trim();
		address = address.trim();
		addressDetail = addressDetail.trim();
		birth = birth.trim();
	
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
			
			if(session != null) {
				if(session.getAttribute("member") != null) {
					session.removeAttribute("member");
				}
			}
			
			session.setAttribute("member", dto);
			message = new MessageEntity("success", 3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	
	/**
	 * 판매자 정보 수정 ok
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void setMemberSeller (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 판매자  수정");
		
		HttpSession session = request.getSession();
		
		MessageEntity message = null;
		
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
		
		
		if(sellerId == null || sellerId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(sellerPw == null || sellerPw.trim().length() == 0  ) {


			message = new MessageEntity("validation",1);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(name == null || name.trim().length() ==0) {


			message = new MessageEntity("validation",2);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		
		if(postNo == null || postNo.trim().length() == 0) {

			message = new MessageEntity("validation",3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(address == null || address.trim().length() ==0) {

			message = new MessageEntity("validation",3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
//		if(addressDetail == null || addressDetail.trim().length() ==0) {
//				
//
//			message = new MessageEntity("validation",3);
//			message.setLinkTitle("내 정보 보러가기");
//			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
//			
//			request.setAttribute("message", message);
//			request.getRequestDispatcher("/message.jsp").forward(request, response);
//			return;
//		}
		if(mobile == null || mobile.trim().length() > 10) {


			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(email == null || email.trim().length() ==0) {


			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		
		if(sellerNo == null || sellerNo.trim().length() ==0) {

			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(shopName == null || shopName.trim().length() ==0) {

			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(shopMobile == null || shopMobile.trim().length() ==0) {

			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(shopCategoryNo == null || shopCategoryNo.trim().length() ==0) {

			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(shopKakaoId == null || shopKakaoId.trim().length() ==0) {

			message = new MessageEntity("validation",4);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		sellerId = sellerId.trim();
		sellerPw = sellerPw.trim();
		name = name.trim();
		mobile = mobile.trim();
		email = email.trim();
		postNo = postNo.trim();
		address = address.trim();
//		addressDetail = addressDetail.trim();
		shopKakaoId = shopKakaoId.trim();
		shopCategoryNo = shopCategoryNo.trim();
		shopMobile = shopMobile.trim();
		shopName = shopName.trim();
		sellerNo = sellerNo.trim();
		
		
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
			if(session.getAttribute("seller") != null) {
				session.removeAttribute("seller");
			}
			
			session.setAttribute("seller", dto);
			message = new MessageEntity("success", 3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	} 
	
	/**
	 * 회원 탈퇴 요청 페이지
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
		protected void removeMemberForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("회원 탈퇴 요청 페이지 ");
			
			HttpSession session = request.getSession(false);
			
			try {
				session.getAttribute("member");
				session.getAttribute("seller");
				request.getRequestDispatcher("/member/memberRemove.jsp").forward(request, response);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		} 

	/**
	 * 회원 탈퇴 일반회원
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void removeMember (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 탈퇴 요청");
		
		HttpSession session = request.getSession(false);
		MessageEntity message = null;
		
		String memberId = (String)session.getAttribute("memberId");
		String memberPw = request.getParameter("memberPw");
		
		if(memberId == null || memberId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(memberPw == null || memberPw.trim().length() == 0  ) {


			message = new MessageEntity("validation",1);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		memberId = memberId.trim();
		memberPw = memberPw.trim();
		
		MypageBiz mybiz = new MypageBiz();
		
		

		try {
			mybiz.removeMember(memberId,memberPw);
			
			message = new MessageEntity("success", 4);
			message.setLinkTitle("메인화면으로");
			message.setUrl("/takeit/index.jsp");
			
			
			if(session != null) {
				if(session.getAttribute("member") != null) {
					session.removeAttribute("member");
				}
				if(session.getAttribute("memberId") != null) {
					session.removeAttribute("memberId");
				}
				if(session.getAttribute("dto") != null) {
					session.removeAttribute("dto");
				}
				
				session.invalidate();
			
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	} 
	
	/**
	 * 회원 탈퇴 판매자 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void removeSeller (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("판매자 탈퇴");
		
		HttpSession session = request.getSession();
		
		MessageEntity message = null;
		
		String sellerId = request.getParameter("sellerId");
		String sellerPw = request.getParameter("sellerPw");
		
		if(sellerId == null || sellerId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(sellerPw == null || sellerPw.trim().length() == 0  ) {


			message = new MessageEntity("validation",1);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		sellerId = sellerId.trim();
		sellerPw = sellerPw.trim();
		
		MypageBiz biz = new MypageBiz();
		
		
		try {
			biz.removeSeller(sellerId,sellerPw);
			
			if(session != null) {
				if(session.getAttribute("seller") != null) {
					session.removeAttribute("seller");
				}
//				if(session.getAttribute("sellerId") != null) {
//					session.removeAttribute("sellerId");
//				}
//				if(session.getAttribute("dto") != null) {
//					session.removeAttribute("dto");
//				}
			
				session.invalidate();
			
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	} 
	
		/**
		 * 비밀번호 변경 요청 페이지
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void memberPwUpdateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("비밀번호 변경 요청 페이지 ");
			
			HttpSession session = request.getSession(false);

			try {
				session.getAttribute("member");
				session.getAttribute("seller");
				request.getRequestDispatcher("/member/memberPwUpdate.jsp").forward(request, response);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		} 
	
	
	//비밀번호 변경  > 일반회원
	/**
	 * 비밀번호 변경 일반회원
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void setSellerPw (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sellerId = request.getParameter("sellerId");
		String sellerPw = request.getParameter("sellerPw");
		String sellerPw2 = request.getParameter("sellerPw2");
		
		MessageEntity message = null;
		
		if(sellerId == null || sellerId.trim().length()  == 0 ) {


			message = new MessageEntity("validation",0);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if(sellerPw == null || sellerPw.trim().length() == 0  ) {


			message = new MessageEntity("validation",1);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		if(sellerPw2 == null || sellerPw2.trim().length() == 0  ) {


			message = new MessageEntity("validation",1);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		sellerId = sellerId.trim();
		sellerPw = sellerPw.trim();
		sellerPw2= sellerPw2.trim();
		
		MypageBiz biz = new MypageBiz();
		
		
		Seller dto = new Seller();
		dto.setSellerId(sellerId);
		dto.setSellerPw(sellerPw);
		
		
		try {
			biz.setSellerPw(sellerPw2, dto);
			
			message = new MessageEntity("success", 3);
			message.setLinkTitle("내 정보 보러가기");
			message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
			
			
		}catch (CommonException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			message = e.getMessageEntity();
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	} 
	
	/**
	 * 비밀번호 변경 일반회원
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
		protected void setMemberPw (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
//			HttpSession session = request.getSession();
			MessageEntity message = null;
			
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			String memberPw2 = request.getParameter("memberPw2");
			
			
			if(memberId == null || memberId.trim().length()  == 0 ) {


				message = new MessageEntity("validation",0);
				message.setLinkTitle("내 정보 보러가기");
				message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			if(memberPw == null || memberPw.trim().length() == 0  ) {


				message = new MessageEntity("validation",1);
				message.setLinkTitle("내 정보 보러가기");
				message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			if(memberPw2 == null || memberPw2.trim().length() == 0  ) {


				message = new MessageEntity("validation",1);
				message.setLinkTitle("내 정보 보러가기");
				message.setUrl("/takeit/member/mypageController?action=memberInfoForm");
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			
			memberId = memberId.trim();
			memberPw = memberPw.trim();
			memberPw2 = memberPw2.trim();
			
			
			MypageBiz biz = new MypageBiz();
			
			
			Member dto = new Member();
			dto.setMemberId(memberId);
			dto.setMemberPw(memberPw);
			
			try {
				biz.setMemberPw(memberPw2, dto);
				
				
				message = new MessageEntity("success", 3);
				message.setLinkTitle("내 정보 보러가기");
				message.setUrl("/takeit/member/mypageController?action=sellerInfoForm");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				
				
			}catch (CommonException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				message = e.getMessageEntity();
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
			
		} 
	
	
	
	
}
