package com.takeit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.common.CommonException;
import com.takeit.model.biz.ReviewBiz;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Review;



/**
 * 후기 관리 controller
 */
@WebServlet("/item/reviewController")
public class FrontReviewServlet extends HttpServlet {
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
		case "reviewList":
			reviewList(request, response);
			break;
			//		case "enrollReviewForm":
			//			enrollReviewForm(request, response);
			//			break;
			//		case "enrollReview":
			//			enrollReview(request, response);
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
	 * 후기전체조회
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void reviewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("reviewList");
		ArrayList<Review> reviewList = new ArrayList<Review>();
		ReviewBiz bbiz = new ReviewBiz();
		try {
			bbiz.getReviewList(reviewList);
			System.out.println("reviewList"+reviewList);
			if(reviewList != null) {
				request.setAttribute("reviewList", reviewList);
				request.getRequestDispatcher("/review/reviewList.jsp").forward(request, response);
			}
		} catch (CommonException e) {
			MessageEntity message = new MessageEntity("error", 13);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}

	}

	/**
	 * 후기등록
	 */
	
}
