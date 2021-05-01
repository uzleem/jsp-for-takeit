<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::공지사항 작성 페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">
	table, tr, th,td {
		border: solid 1px #8D959C;
		margin: 0 auto;
		border-collapse: collapse;
		padding: 5px;
		width: 1050px;
		margin-top: 30px;
		margin-bottom: 20px;
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
<br>
<form action="#" method="post">
<h1 style="width:fit-content; margin: 0 auto;">게시글 입력</h1>
<br>
<table>
	<tr>
		<th>글제목</th>
		<td><input type="text" name="noticeTitle" placeholder="제목을 입력하세요.."> </td>
		<th>카테고리</th>
		<td>
			<select name="noticeCategory">
				<option>==선택==</option>
				<option value="1">공지사항</option>
				<option value="2">자주하는 질문</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" value="" readonly="readonly"></td>
		<th>작성일자</th>
		<td></td>
	</tr>
	<tr>
		<th colspan="4">내용</th>
	</tr>
	<tr>
		<td colspan="4">
			<textarea rows="30" cols="100" placeholder="내용을 입력하세요.."></textarea>
		</td>
	</tr>
</table>
<input type="submit" value="등록" class="link">
</form>
<a href="/takeit/board/noticeList.jsp" class="link">취소</a>
</body>
</html>