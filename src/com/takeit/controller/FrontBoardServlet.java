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
import com.takeit.model.biz.BoardBiz;
import com.takeit.model.dto.Board;
import com.takeit.model.dto.Category;
import com.takeit.model.dto.MessageEntity;

/**
 * 게시판 관리 컨트롤러
 */
@WebServlet("/boardController")
public class FrontBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//서버 구동시에 해당 어플리케이션당 한 개의 환경설정, 모든 서블릿(jsp)공유객체, 서버 종료시까지 사용
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
		case "boardList":
			boardList(request, response);
			break;
		case "boardInputForm":
			boardInputForm(request, response);
			break;
		case "boardDetail":
			boardDetail(request, response);
			break;
		case "boardInput":
			boardInput(request, response);
			break;
//		case "":
//			(request,response);
//			break;
//		case "":
//			(request,response);
//			break;
//		case "":
//			(request,response);
//			break;
//		case "":
//			(request,response);
//			break;
//		case "":
//			(request,response);
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

	/**게시글 전체 목록*/
	protected void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[debug]게시글 전체 조회 요청");
		String categoryNo = request.getParameter("board_category_no");
		System.out.println("[debug]categoryNo:"+categoryNo);
		
		ArrayList<Board> boardList = new ArrayList<Board>();
		BoardBiz bbiz = new BoardBiz();
		try {
			bbiz.getBoardList(categoryNo, boardList);
			if(boardList != null) {
				request.setAttribute("boardList", boardList);
				request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
			}
		} catch (CommonException e) {
			MessageEntity message = new MessageEntity("error", 14);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	}
	
	/**게시글 상세조회*/
	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[debug]게시글 상세 조회 요청");
		
		String boardNo = request.getParameter("board_no");
		String boardCategory = request.getParameter("board_category");
		
		BoardBiz bbiz = new BoardBiz();
		Board board = new Board();
		try {
			bbiz.boardDetail(boardNo, boardCategory, board);
			if(board != null) {
				request.setAttribute("board", board);
				request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
			}
		} catch (CommonException e) {
			MessageEntity message = new MessageEntity("error", 14);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	}
	
	/**카테고리*/
	private void boardInputForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[debug]게시글 등록 페이지 요청");
		BoardBiz bbiz = new BoardBiz();
		ArrayList<Category> category = new ArrayList<Category>();
		try {
			bbiz.getCategoryList(category);
			if(category != null) {
				request.setAttribute("category", category);
				request.getRequestDispatcher("/board/boardInput.jsp").forward(request, response);
			}
		} catch (CommonException e) {
			MessageEntity message = new MessageEntity("error", 13);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	
	/**게시글 등록*/
	private void boardInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[debug]게시글 등록 요청");
		
		String boardTitle = request.getParameter("boardTitle");
		String boardContents = request.getParameter("boardContents");
		String boardCategory = request.getParameter("boardCategory");
		String boardItemNo = request.getParameter("itemNo");
		boardItemNo = boardItemNo.trim();
		boardTitle = boardTitle.trim();
		boardContents = boardContents.trim();
		boardCategory = boardContents.trim();
		/*session적용 후 바뀔 내용*/
		String boardWriter = request.getParameter("boardWriter");
		boardWriter = boardWriter.trim();
		
		System.out.println("[debug] " + boardTitle + boardContents);
		BoardBiz bbiz = new BoardBiz();
		Board notice = new Board(boardWriter, boardTitle, boardContents, boardCategory, boardItemNo);
		
		try {
			bbiz.boardInput(notice);
			request.getRequestDispatcher("/boardContrller?action=boardList").forward(request, response);;
		} catch (CommonException e) {
			MessageEntity message = new MessageEntity("error", 13);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	
}
