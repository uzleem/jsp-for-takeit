<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/takeit.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

</head>
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

<div class="takeit_detail">
	<div class="takeit_item-content takeit_detail_wrap">
		<div class="takeitImg-wrap" >
			<img id="itemImg" style="width:330px; height: 400px; " src="/takeit/img/item/${item.itemImg}">
		</div>
		<div class="desc takeit_detail_wrap">
			<fmt:formatNumber var="itemPrice" value="${item.itemPrice}" type="number"/>
			<fmt:formatNumber var="discPrice" value="${item.itemPrice * (100-takeitItem.discRate) / 100}" type="number"/>
			<fmt:parseNumber  var="intPrice" value="${(item.itemPrice * (100-takeitItem.discRate) / 100)/1000}" integerOnly="true"/>
			<fmt:formatNumber var="itemDiscRate" value="${item.discRate / 100}" type="percent"/>
			
			<ul class="takeit_info">
				<h2>${Item.itemName}</h2>
				<li style="list-style: none">
					<span style="color: grey; text-decoration: line-through;">${itemPrice}원</span>
					<span style="color: black; font-weight: 700;">${discPrice}원</span>
					<span>(할인 ${itemDiscRate})</span>
					<span style="color: red; font-size:20px; font-weight: 700;">${itemPrice}원</span>
					
				<hr>
				<span class="it_info"><b>카테고리</b>&emsp;${item.itemCategoryName}</span><br>
				<span class="it_info"><b>판매단위</b>&emsp;${item.salesUnit}</span><br>
				<span class="it_info"><b>재고량</b>&emsp;${item.salesUnit}</span><br>
				<span class="it_info"><b>원산지</b>&emsp;&emsp;${item.itemOrigin}</span><br>
				<span class="it_info"><b>포장타입</b>&emsp;${item.packTypeName}</span><br>
		        <span class="it_info"><b>고객평점</b>&emsp;${item.itemCustScore}</span><br>
				<span class="it_info"><b>유통기한</b>&emsp;${item.expirationDate}</span><br>
				<span class="it_info"><b>등록일자</b>&emsp;${item.itemInputDate}</span><br>
				<span class="it_info"><b>판매상점</b>&emsp;${takeitItem.shopName}</span><br>
				<span class="it_info"><b>판매자</b>&emsp;&emsp;${item.sellerName}</span><br>
				<span class="it_info"><b>안내사항</b>&emsp;${itemCategory.notice}</span><br>
			
			</ul>
		</div>
	</div>
	<div class="btn-area">
	<input type="button" class="link"  style="display: inline-block;" value="장바구니"/>
	<input type="button" class="link" style="display: inline-block;" value="구매"/>
	</div>
</div>	
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>