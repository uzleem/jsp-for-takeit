package com.takeit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 테이크잇
 */
@WebServlet("/takeit/takeitController")
public class FrontTakeitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		switch (action) {
		case "takeitItemList":
			takeitItemList(request, response);
			break;
		}
	}
	
	/**
	 * 테이크잇 상품목록 요청 서비스 
	 * 
	 * 1. 사용자의 아이디를 세션으로부터 받아옵니다
	 * 2. 테이크잇상품엔티티에는 구매자아이디, 회원구역번호, 상점구역코드, 상품목록,
	 * 3. 테이크잇 비즈 클래스사용 
	 * 4. 테이크잇 DAO 사용
	 * 5. 회원의 구역과 , 테이크잇의 구역이 일치하는곳이 있다면, 그잇거래가 alive인지 확인후,
	 * 5-1. 상품번호와 아이디를 전부 가져와서, 그 상품 중 잇거래여부를 
	 * 
	 * */
	protected void takeitItemList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}
	
}
