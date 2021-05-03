package com.takeit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.biz.ReviewBiz;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Review;


@MultipartConfig(
		//location="/tmp",
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*50,
		maxRequestSize=1024*1024*50*5
)


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
			//	case "enrollReviewForm":
			//		enrollReviewForm(request, response);
			//			break;
			//	case "enrollReview":
			//	enrollReview(request, response);
			//			break;
			//		case "deleteReview":
			//			deleteReview(request, response);
			//			break;
					case "updateReviewForm":
						updateReviewForm(request,response);
						break;
				//	case "setReviewInfo":
				//		setReviewInfo(request,response);
				//		break;
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
	 * 후기등록요청서비스
	 */
	protected void enrollReviewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/takeit/review/review.jsp";
		response.sendRedirect(url);
	}
	
	/**후기등록*/
	private void enrollReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberId = request.getParameter("memberId");
	String itemNo = request.getParameter("itemNo");
	String reviewTitle = request.getParameter("reviewTitle");
		String reviewContents = request.getParameter("reviewContents");
		String reviewScore = request.getParameter("reviewScore");
	String reviewImg = request.getParameter("reviewImg");
         Part filePart= request.getPart("file");
         filePart.getInputStream();
         
         String realPath =request.getServletContext().getRealPath("/upload");
	}

	//	  if (memberId == null || memberId.trim().length() == 0){
	//	         MessageEntity message = new MessageEntity("validation", 0);
	//         message.setUrl("takeit/review/enrollReviewForm");
	//	         message.setLinkTitle("상품등록");
		         
	//         request.setAttribute("message", message);
	//	         rd.forward(request, response);
	//         return;   
	//	      }

//	  if (itemNo == null || itemNo.trim().length() == 0){
//		         MessageEntity message = new MessageEntity("validation", 0);
//		         message.setUrl("takeit/review/enrollReviewForm");
//		         message.setLinkTitle("상품등록");
//		         
//		         request.setAttribute("message", message);
//		         RequestDispatcher rd = request.getRequestDispatcher("/review/reviewList.jsp");
//		         rd.forward(request, response);
//		         return;   
//		      }
//		  if (reviewTitle   == null || reviewTitle.trim().length() == 0){
//		         MessageEntity message = new MessageEntity("validation", 0);
//		         message.setUrl("takeit/review/enrollReviewForm");
//		         message.setLinkTitle("상품등록");
//		         
//		         request.setAttribute("message", message);
//		         RequestDispatcher rd = request.getRequestDispatcher("/review/reviewList.jsp");
//		         rd.forward(request, response);
//		         return;   
//		      }
//		  
//		  if (reviewContents == null || reviewContents.trim().length() == 0){
//		         MessageEntity message = new MessageEntity("validation", 0);
//		         message.setUrl("takeit/review/enrollReviewForm");
//		         message.setLinkTitle("상품등록");
//		         
//		         request.setAttribute("message", message);
//		         RequestDispatcher rd = request.getRequestDispatcher("/review/reviewList.jsp");
//		         rd.forward(request, response);
//		         return;   
//		      }
//		  
//		  if (reviewScore == null || reviewScore.trim().length() == 0){
//		         MessageEntity message = new MessageEntity("validation", 0);
//		         message.setUrl("takeit/review/enrollReviewForm");
//		         message.setLinkTitle("상품등록");
//		         
//		         request.setAttribute("message", message);
//		         RequestDispatcher rd = request.getRequestDispatcher("/review/reviewList.jsp");
//		         rd.forward(request, response);
//		         return;   
//		      }
//		  
//			ReviewBiz bbiz = new ReviewBiz();
//			Review dto = new Review(memberId, itemNo, reviewTitle,reviewContents, reviewScore,reviewImg);
//		
//	}
//}
//}
	/**
	 * 후기삭제
	 * @param conn
	 * @param dto
	 */
	public void deleteReview(Connection conn, Review dto) {
		
		String sql = "delete from Review where member_id=? and review_title=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			stmt.setString(2, dto.getReviewTitle());
			
			stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}		
	}	
	/**
	 * 작성 후기조회요청
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateReviewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession(false);
		
//		String memberId = (String)session.getAttribute("memberId");
//		String memberId = request.getParameter("memberId");
		String memberId = "user01";
		ReviewBiz biz = new ReviewBiz();
		
		Review dto = new Review();
		dto.setMemberId(memberId);
		try {
			biz.getReview(dto);
			request.setAttribute("review", dto);
			request.getRequestDispatcher("/review/reviewInfo.jsp").forward(request, response);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
//	/**
//	 * 작성후기 수정
//	 * @param request
//	 * @param response
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	protected void setReviewInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String reviewTitle = request.getParameter("reviewTitle");
//		String reviewContents = request.getParameter("reviewContents");
//		String reviewScore = request.getParameter("reviewScore");
//		String reviewImg = request.getParameter("reviewImg");
//	
//
//		
//		ReviewBiz biz = new ReviewBiz();
//		
//		Review dto = new Review();
//		dto.setReviewTitle(reviewTitle);
//		dto.setReviewContents(reviewContents);
//		dto.setReviewScore(reviewScore);
//		dto.setReviewImg(reviewImg);
//
//		
//		try {
//			biz.setReview(dto);
//			request.setAttribute("dto", dto);
//			request.getRequestDispatcher("/review/reviewController?action=updateReviewForm").forward(request, response);
//			
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		
//	}
	
		
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

