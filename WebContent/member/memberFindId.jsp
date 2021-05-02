<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/link.css">
<link type="text/css" rel="stylesheet" href="${CONTEXT_PATH}/css/member/findId.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${CONTEXT_PATH}/js/member/findId.js"></script>
</head>
  
  
<body>
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
<jsp:include page="/common/navigation.jsp"></jsp:include>

<!-- 내용 -->
<div id="contents_box" align="center">
<h1>아이디 찾기</h1>
<form action="${CONTEXT_PATH}/member/controller?action=memberFindId" method="post">
<table>
	<tr>
		<td>이름</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="고객님의 이름을 입력해주세요" id="name" name="name" required="required"/></td>
	</tr>
	<tr>
		<td>이메일</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="가입 시 등록하신 이메일 주소를 입력해주세요" id="email" name="email" required="required"/></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="찾기" id="check_submit"/></td>
	</tr>
</table>
</form>
</div>
</body>
</html> 