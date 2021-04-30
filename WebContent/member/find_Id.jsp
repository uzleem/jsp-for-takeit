<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/member.css">
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/member/find_Id.js"></script>
<!-- 상단 메뉴 -->
<c:choose>
	<c:when test="${empty memberId or empty grade}">
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
</head>


<body>
<div id="contents_box" align="center">
<form action="#">
<h3>아이디 찾기</h3>
<table>
	<tr>
		<td>이름</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="고객님의 이름을 입력해주세요" id="name"/></td>
	</tr>
	<tr>
		<td>이메일</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="가입 시 등록하신 이메일 주소를 입력해주세요" id="email"/></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="찾기" id="check_submit"/></td>
	</tr>
</table>
</form>
</div>
</body>
</html> 