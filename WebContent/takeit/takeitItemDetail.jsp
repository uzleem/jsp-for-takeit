<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 상품 상세조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
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


<div class="takeit_item-content">
	<div class="image" >
		<img id="itemImg" src="/takeit/img/item/${takeitItem.itemImg}">
	</div>
	<div class="desc">
		${takeitItem.itemName}<br>
		${takeitItem.itemPrice}원 
		 ${takeitItem.itemPrice * (100-takeitItem.discRate) / 100}원  
		 ${takeitItem.itemName} 
		 (할인 ${takeitItem.discRate}%)
	</div>
</div>	


<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>