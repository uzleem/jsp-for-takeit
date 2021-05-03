<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상단메뉴 -->
<div id="top-menu" class="view-width">
	<%= session.getAttribute("memberId") %> 님
	<span id="pipe">|</span>
	<a href="#">로그아웃</a>
	<span id="pipe">|</span>
	<a href="/takeit/member/myPage.jsp">마이페이지</a>
	<span id="pipe">|</span>
	<a href="/takeit/board/customerCenter.jsp">고객센터</a>
</div>