<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.takeit.model.dto.Review" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeit.model.dto.MessageEntity" %>

<%@ include file="/common/taglib_menu.jsp" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">

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

<!-- contents menu -->
<h3 class="title"><span class="seperator_title">|||</span>후기전체조회<span class="seperator_title">|||</span></h3>
<table>
	<!-- 제목행 -->
	<tr>	
		<th>후기번호</th>
		<th>회원아이디</th>
		<th>상품번호</th>
		<th>후기등록일자</th>
		<th>후기제목</th>
		<th>후기내용</th>
		<th>후기평점</th>
		<th>후기사진</th>
	
		
	</tr>
	
		<%
		ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
		for(Review dto : reviewList){
	%>
	<tr>
		<td><%= dto.getReviewNo() %></td>
		<td><%= dto.getMemberId() %></td>
		<td><%= dto.getItemNo() %></td>
		<td><%= dto.getReviewDate() %></td>
		<td><%= dto.getReviewTitle()%></td>
		<td><%= dto.getReviewContents()%></td>
		<td><%= dto.getReviewScore()%></td>
		<td><%= dto.getReviewImg()%></td>
	</tr>
	<%
		}
	%>
</table>
<a href="/takeit/index.jsp" class="link">홈으로이동</a>
	<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>