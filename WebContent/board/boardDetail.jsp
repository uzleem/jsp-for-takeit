<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::공지사항</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/board.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<c:choose>
	<c:when test="${empty memberId}">
		<!-- 로그인 전 메뉴 -->
		<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>
<div id="notice">
<%
	Board dto = (Board)request.getAttribute("board");
%>
<div id="title">
	<h3><%= dto.getBoardCategory() %> </h3>
</div>
<table class="notice-table">
	<tr>
		<th>글번호</th>
		<td><%= dto.getBoardNo() %></td>
		<th>글제목</th>
			<td><%= dto.getBoardTitle() %> </td>
		</tr>
	<tr>
		<th>조회수</th>
		<td><%= dto.getBoardViews()%></td>
		<th>추천수</th>
		<td><%= dto.getBoardPicks()%> </td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%= dto.getBoardWriter() %></td>
		<th>작성일자</th>
		<td><%= dto.getBoardDate() %></td>
	</tr>
	<tr>
		<th colspan="4">내용</th>
	</tr>
	<tr>
		<td colspan="4">
			<%= dto.getBoardContents() %>
		</td>
	</tr>
</table>
<a href="#" class="link">추천</a>
<a href="/takeit/boardController?action=boardList&board_category_no=1" class="link">목록</a>
</div>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>