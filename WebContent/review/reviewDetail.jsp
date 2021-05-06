<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.takeit.model.dto.Review"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>takeit::후기상세조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/board.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancle").on("click", function() {
			history.back();
		});
	});
</script>
</head>
<body>
	<!-- 상단 메뉴 -->
	<c:if test="${empty memberId and empty sellerId}">
		<!-- 로그인 전 메뉴 -->
		<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
	</c:if>
	<c:if test="${not empty memberId or not empty sellerId}">
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>
	</c:if>
	<!-- logo.jsp 삽입 -->
	<jsp:include page="/common/logo.jsp"></jsp:include>
	<!-- 네비게이션 -->
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<div id="reviews">

		<div id="title">
			<h3>${review.reviewTitle}</h3>
		</div>

		<table class="review-table" align='center'>
			<tr>
				<th>후기번호</th>
				<td>${review.reviewNo}</td>
				<th>상품번호</th>
				<td>${review.itemNo}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${review.reviewViews}</td>
				<th>상품평점</th>
				<td>${review.reviewScore}점</td>
			<tr>
				<th>작성자</th>
				<td>${review.memberId}</td>
				<th>작성일자</th>
				<td>${review.reviewDate}</td>
			</tr>
			<tr>
				<th>후기제목</th>
				<td>${review.reviewTitle}</td>
			</tr>
			<tr>
				<th colspan="4">내용</th>
			</tr>

			<tr>
				<td colspan="6">${review.reviewContents}</td>
			</tr>
			<tr>
				<th>후기이미지</th>

				<td><img src="/takeit/img/review/${review.reviewImg}"></td>
			</tr>
			<!--<td><img alt='후기' src="/takeit/img/review/${review.reviewImg}"width="450" height="310"></td>-->

		</table>
		<div>
			<div class="btn-area" align='center'>
				<input type="button" class="link" style="display: inline-block;"
					value="목록" /> <input type="button" class="link"
					style="display: inline-block;" value="상품보러가기" />
			</div>
		</div>
	</div>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>