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
<script>
function getTakeitTime() {
	var date = new Date();
	
	for (i = 0; i < $(".takeitTime").length; i++) {
		var takeitTimeElement = $(".takeitTime").get(i);
		var takeitTime = takeitTimeElement.dataset.takeittime;
		var takeitDate =new Date(takeitTime);
		var result = takeitDate - date;
		result = result + 604800000;
		var d1 = parseInt(result / 86400000);
		var h1 = Math.floor((result % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		var m1 = Math.floor((result % (1000 * 60 * 60)) / (1000 * 60));
		var s1 = Math.floor((result % (1000 * 60)) / 1000);
		
		takeitTimeElement.innerHTML = d1 + "일 "+ h1+"시간 "+m1+"분 "+s1 + "초"
	}
}
$(document).ready(function (){
	getTakeitTime();
	setInterval(getTakeitTime, 1000);
});
</script>
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
		<fmt:formatNumber var="itemPrice" value="${takeitItem.itemPrice}" type="number"/>
		<fmt:formatNumber var="discPrice" value="${takeitItem.itemPrice * (100-takeitItem.discRate) / 100}" type="number"/>
		<fmt:parseNumber  var="intPrice" value="${(takeitItem.itemPrice * (100-takeitItem.discRate) / 100)/1000}" integerOnly="true"/>
		<fmt:formatNumber var="takeitItemPrice" value="${intPrice*1000}" type="number"/>
		<fmt:formatNumber var="itemDiscRate" value="${takeitItem.discRate / 100}" type="percent"/>
		<fmt:formatNumber var="takeitDisc" value="${(takeitItem.itemPrice * (100-takeitItem.discRate) / 100) - intPrice*1000 }" type="number"/>
		${takeitItem.itemName}<br>
		${itemPrice}원
		${discPrice}원
		(할인 ${itemDiscRate})
		${takeitItemPrice}원
		(잔돈할인 ${takeitDisc}원)
		<hr>
		판매단위 ${takeitItem.salesUnit}<br>
		남은시간 <span class="takeitTime" data-takeittime="${takeitItem.takeitDate}"></span><br>
		원산지 ${takeitItem.itemOrigin}<br>
		포장타입 ${takeitItem.packTypeName}<br>
		판매자 [Item 도메인에 sellerName, shopName 추가할것]<br>
		고객평점 ${takeitItem.itemCustScore}<br>
		유통기한 ${takeitItem.expirationDate}<br>
		등록일자 ${takeitItem.itemInputDate}<br>
		구역번호 ${takeitItem.shopLocCode}-${takeitItem.memberLocNo } ([구역이름을 takeitItem 도메인에 추가하기])<br>
		<fmt:formatNumber var="takeitRate" type="percent" value="${takeitItem.takeitCurrPrice/takeitItem.takeitPrice}" />
		<fmt:formatNumber var="takeitCurrPrice" type="number" value="${takeitItem.takeitCurrPrice}" />
		<fmt:formatNumber var="takeitPrice" type="number" value="${takeitItem.takeitPrice}" />
		목표금액 달성률 ${takeitRate} (${takeitCurrPrice}원 / ${takeitPrice}원)<br>
		<input type="button" value="장바구니"/>
		<input type="button" value="구매"/>
	</div>
</div>	

<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>