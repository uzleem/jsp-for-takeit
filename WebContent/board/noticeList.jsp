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
<div id="title">
	<h3>공지사항</h3>
</div>
<%-- <c:if test="${grade == 'A' }"> --%>
	<div id="small-btn">
		<a href="/takeit/board/noticeInput.jsp">등록</a>
	</div>
<%-- </c:if> --%>
<table id="notice-tbl" class="notice-table">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>추천수</th>
		<th>작성일자</th>
	</tr>
	<%
		ArrayList<Board> noticeList = (ArrayList<Board>)request.getAttribute("noticeList");
		for(Board dto : noticeList){
	%>
	<tr>
		<td><%= dto.getBoardNo() %></td>
		<td>
		<a href="/takeit/boardController?action=noticeDetail&board_no=<%= dto.getBoardNo() %>" id="boardLink"><%= dto.getBoardTitle()%></a>
		</td>
		<td><%= dto.getBoardWriter() %></td>
		<td><%= dto.getBoardViews() %></td>
		<td><%= dto.getBoardPicks()%></td>
		<td><%= dto.getBoardDate()%></td>
	</tr>
	<%
		}
	%>
</table>
<a href="/takeit/index.jsp" class="link">홈으로이동</a>
</div>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>