<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기 페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="/takeit/js/slide.js"></script>
<style>
	#contents_box {	
		margin: auto;
	}
		
	#contents_box > table {		
		font-size: 9px;
	}
		
	#check_submit{
		width:100%;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		background-color: #7B977A;
		color: white;
		border: 1px solid #7B977A;
	}
		
	#name{
		width:250px;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		border: 1px solid #7B977A;
	}
	
	#email{
		width:250px;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		margin-bottom: 10px;
		border: 1px solid #7B977A;
	}

</style>
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
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>

<div id="contents_box" align="center">
<h3>아이디 찾기</h3>
<form action="#" method="post">
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