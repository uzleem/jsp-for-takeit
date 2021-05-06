<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.takeit.model.dto.Review"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 후기</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/review.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/board.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

</head>
<body>
	<!-- 상단 메뉴 -->
	<c:if test="${empty memberId }">
		<!-- 로그인 전 메뉴 -->
		<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
	</c:if>
	<c:if test="${not empty memberId }">
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>
	</c:if>
	<!-- logo.jsp 삽입 -->
	<jsp:include page="/common/logo.jsp"></jsp:include>
	<!-- 네비게이션 -->
	<jsp:include page="/common/navigation.jsp"></jsp:include>

	<div id="review_info" align='center'>
		<h3>작성 후기조회</h3>

		<div id="review">
			<form action="/takeit/item/reviewController?action=setReviewInfo&reviewNo=${review.reviewNo}" method="post">
				<table id="review_table">

					<tr>
						<th>후기번호</th>
						<td><input type="text" id="reviewNo" name="reviewNo"
							value="${review.reviewNo }" readonly="readonly"></td>


						<th>상품번호</th>
						<td><input type="text" id="itemNo" name="itemNo"
							value="${ review.itemNo}" readonly="readonly"></td>
					</tr>

					<tr>
						<th>조회수</th>
						<td><input type="text" id="reviewViews" name="reviewViews"
							value="${review.reviewViews}" readonly="readonly"></td>

						<th>상품평점</th>
						<td><input type="text" id="reviewScore" name="reviewScore"
							value="${review.reviewScore}"></td>
					</tr>


					<tr>
						<th>작성자</th>
						<td><input type="text" id="memberId" name="memberId"
							value="${review.memberId }" readonly="readonly"></td>


						<th>후기작성일</th>
						<td><input type="text" id="reviewDate" name="reviewDate"
							value="${review.reviewDate}" readonly="readonly"></td>
					</tr>

					<tr>
						<th>후기제목</th>
						<td><input type="text" id="reviewTitle" name="reviewTitle"
							value="${review.reviewTitle}"></td>
					</tr>
					<tr>
						<th colspan="4">후기내용</th>

					</tr>
					<tr>
					<td colspan="4"><textarea rows="5" cols="200" id="reviewContents" name="reviewContents" >${review.reviewContents}</textarea></td>
					</tr>

					<tr>
						<th>후기사진</th>
						<td><img src="/takeit/img/review/${review.reviewImg}"></td>
					</tr>

				</table>
			

			<div id="small-btn">
				<br> <input class="link" type="submit" value="내후기수정">
			</div>
           </form>
			
		</div>
	</div>
	     <a href="/takeit/member/myPage.jsp" id="small-btn">마이페이지로 이동</a>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>

