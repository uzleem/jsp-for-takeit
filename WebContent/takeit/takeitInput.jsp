<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 등록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/myPage.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
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

<div id="container">
<c:choose>
	<c:when test ="${not empty sellerId}">
 		<!-- 판매자 마이페이지 메뉴 -->
 		<jsp:include page="/common/mypage_seller_menu.jsp"/>
	</c:when>
	<c:when test="${not empty memberId}">
		<!-- 일반회원 마이페이지 메뉴 -->
		<jsp:include page="/common/mypage_member_menu.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="/member/memberLogin.jsp"/>
	</c:otherwise>
</c:choose>

<div>
	<h3>잇거래 등록</h3>
	<form action="${CONTEXT_PATH}/takeit/takeitController?action=takeitInput" method="post">
		<table>
			<td>상점구역선택</td>
			<td>
			<select id="shopLocCode" name="shopLocCode">
				<c:forEach items="${shopLocList}" var="shopLoc">
					<option value="${shopLoc.shopLocCode}">${shopLoc.shopLocName}</option>
				</c:forEach>
			</select>
			</td>	
			<tr>
				<td>모집금액</td>
				<td><input type="number" required="required" name="takeitPrice" />
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"/>
					<input type="reset" value="초기화"/>
				</td>
			</tr>
		</table>
	</form>
</div>

 <!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>