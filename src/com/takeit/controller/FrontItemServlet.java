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
import com.takeit.model.dto.Item;
import com.takeit.model.dto.MessageEntity;



/**
 * 상품관리를 위한 FrontController servlet
 */
@WebServlet("/itemController")
public class FrontItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서버구동시에 해당 어플리케이션당 한개의 한개의 환경설정 
		public ServletContext application;
		public String CONTEXT_PATH;
		
		public void init() {
			application = getServletContext();
			CONTEXT_PATH = application.getContextPath();
			System.out.println("[loadOnStartup]CONTEXT_PATH : " + CONTEXT_PATH);
			application.setAttribute("CONTEXT_PATH", CONTEXT_PATH);
		}
		
		
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		request.setCharacterEncoding("utf-8");
		switch(action) {
		case "itemEnrollForm":
			itemEnrollForm(request, response);
			break;
		case "itemEnroll":
			itemEnroll(request, response);
		break;
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
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	//상품등록 페이지 요청 서비스
	protected void itemEnroll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemCategoryName = request.getParameter("itemCategoryName");
		String sellerId = request.getParameter("sellerId");
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String itemOrigin = request.getParameter("itemOrigin");
		String itemStock = request.getParameter("itemStock");
		String itemImg = request.getParameter("itemImg");
		String itemTakeIt = request.getParameter("itemTakeIt");
		String packTypeName = request.getParameter("packTypeName");
		String expirationDate = request.getParameter("expirationDate");
		String notice = request.getParameter("notice");
		String freshPercent = request.getParameter("freshPercent");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/takeit/message.jsp");
		
		if (itemCategoryName == null || itemCategoryName.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("", 0);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		}    

		
		if (sellerId == null || sellerId.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("", 1);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		}   

		
		if (itemName == null || itemName.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("", 1);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		} 
		
		if (itemPrice == null || itemPrice.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("", 1);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		} 
		
		if (itemOrigin == null || itemOrigin.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("", 1);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
	        
		}
	  		if (itemStock == null || itemStock.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("", 1);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;   	
	          
	  		}
	  		if (itemImg == null ) {
				MessageEntity messageEntity = new MessageEntity("", 1);
					messageEntity.setLinkTitle("상품등록");
					messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
					request.setAttribute("messageEntity", messageEntity);
					dispatcher.forward(request, response);
					return;
	  		} 
			if (itemTakeIt == null || itemTakeIt.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("", 0);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}	
			if (packTypeName == null || packTypeName.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("", 0);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}    
			if (expirationDate == null || expirationDate.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("", 0);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}    
			if (notice == null || notice.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("", 0);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}    
			if (freshPercent == null || freshPercent.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("", 0);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}       
	          
//			   Item dto = new Item(itemCategoryName, sellerId, itemName, itemPrice, itemOrigin,itemStock,itemImg,
//					   itemTakeIt,packTypeName,expirationDate,notice,freshPercent);
//			       
//
//		ItemBiz biz = new ItemBiz();
//
//	      try {
//	          biz.addItem(dto);
//	          
//	          MessageEntity message = new MessageEntity("success", 0);
//	          message.setUrl("/exercise/exe02/teacher/login.html");
//	          message.setLinkTitle("");
//	          request.setAttribute("message", message);
//	          RequestDispatcher rd = request.getRequestDispatcher("/exe02/teacher/message.jsp");
//	          rd.forward(request, response);
//	       } catch (CommonException e) {
//	          MessageEntity message = e.getMessageEntity();
//	       
//	          message.setLinkTitle("상품등록");
//	          message.setUrl(CONTEXT_PATH + "/exe02/controller?action=enrollItemForm");
//	          request.setAttribute("message", message);
//	          request.getRequestDispatcher("/takeit/item/message.jsp").forward(request, response);
//	          
//	       }
//	       
//	    }
	}
	//상품등록요청
		protected void itemEnrollForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String url = CONTEXT_PATH + "/item/itemEnroll.jsp";
			response.sendRedirect(url); 
		}

}
