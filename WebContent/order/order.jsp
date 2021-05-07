<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품주문 폼</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#receiveMethod1").click(function() {
		$("#recipientName").val("${order.recipientName}");
		$("#recipientMobile").val("${order.recipientMobile}");
		$("#recipientPostNo").val("${order.recipientPostNo}").attr("disabled", false);
		$("#recipientAddr").val("${order.recipientAddr}").attr("disabled", false);
		$("#recipientAddrDetail").val("${order.recipientAddrDetail}").attr("disabled", false);
		$("#shipRequest").val("${order.shipRequest}").attr("disabled", false);
	});
	$("#receiveMethod2").click(function() {
		$("#recipientName").val("");
		$("#recipientMobile").val("");
		$("#recipientPostNo").val("").attr("disabled", false);
		$("#recipientAddr").val("").attr("disabled", false);
		$("#recipientAddrDetail").val("").attr("disabled", false);
		$("#shipRequest").val("").attr("disabled", false);
	});
	$("#receiveMethod3").click(function() {
		$("#recipientPostNo").val("").attr("disabled", true);
		$("#recipientAddr").val("").attr("disabled", true);
		$("#recipientAddrDetail").val("").attr("disabled", true);
		$("#shipRequest").val("").attr("disabled", true);
	});
});
	
</script>
</head>
<body>

<!-- 상단 메뉴 -->
<c:if test="${empty memberId and empty sellerId}">
	<!-- 로그인 전 메뉴 -->
	<jsp:include page="/common/before_login_menu.jsp"/>
</c:if>
<c:if test="${not empty memberId or not empty sellerId}">
	<!-- 로그인 후 메뉴 -->
	<jsp:include page="/common/after_login_menu.jsp"/>	
</c:if>
<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>

	주문자<hr><br>
	${order.recipientName}<br>
	${order.recipientMobile}<br>
	${order.recipientAddr}, ${order.recipientAddrDetail} (${order.recipientPostNo}) <br>
	<br><br>
	
<form action="${CONTEXT_PATH}/order/orderController?action=order" method="post" id="orderForm">	
	<span>배송지 정보</span><hr>
	<span>배송지 선택 : </span>
	<span>
		<input type="radio" name="receiveMethod" id="receiveMethod1" value="배송" checked="checked">기본 배송지
		<input type="radio" name="receiveMethod" id="receiveMethod2" value="배송">신규 배송지
		<input type="radio" name="receiveMethod" id="receiveMethod3" value="직접수령">직접 수령
	</span><br>
	
	수령인 <input type="text" id="recipientName" name="recipientName" value="${order.recipientName}"><br>
	연락처 <input type="text" id="recipientMobile" name="recipientMobile" value="${order.recipientMobile}"><br>
	배송지 주소 <input type="text" id="recipientPostNo" name="recipientPostNo" value="${order.recipientPostNo}"><br>
	<input type="text" id="recipientAddr" name="recipientAddr" value="${order.recipientAddr}"><br>
	<input type="text" id="recipientAddrDetail" name="recipientAddrDetail" value="${order.recipientAddrDetail}"><br>
	배송요청사항 <input type="text" id="shipRequest" name="shipRequest" value="${order.shipRequest}"><br> 
	
	
<c:set var="totalPrice" value="0" scope="page"/>
	<div class="orderList-wrap">
	<h3>주문상품</h3>
		<c:forEach var="orderDetail" items="${order.orderDetails}">
		<br>
		<div class="order-detail">
			<img src="/takeit/img/item/${orderDetail.itemImg}" style="width:100px; height:150px;">
			<div  style="display:inline-block;">
				상품명 : ${orderDetail.itemName} <br>
				상품개수 : ${orderDetail.itemQty}개 <br>
				배송비 :
				<c:choose>
					<c:when test="${orderDetail.itemTakeit == 'T' }">무료(잇거래)<c:set var="totalPrice" value="${totalPrice + (orderDetail.itemQty*orderDetail.itemPayPrice) }"/></c:when>
					<c:when test="${orderDetail.itemPayPrice * orderDetail.itemQty >= 50000}">무료<c:set var="totalPrice" value="${totalPrice + (orderDetail.itemQty*orderDetail.itemPayPrice) }"/></c:when>
					<c:when test="${orderDetai.itemTakeit == 'F' and orderDetail.itemPayPrice * orderDetail.itemQty < 50000 }">3500원<c:set var="totalPrice" value="${totalPrice + (orderDetail.itemQty*orderDetail.itemPayPrice)+3500}"/></c:when>
				</c:choose><br>
				상품결제금액 : ${orderDetail.itemPayPrice * orderDetail.itemQty}원 <br> 
			</div><br>
		</div>
		
<input type="hidden" value="${orderDetail.itemNo}" name="itemNo"> 
<input type="hidden" value="${orderDetail.itemQty}" name="itemQty"> 
<input type="hidden" value="${orderDetail.itemPayPrice}" name="itemPayPrice" > 
<input type="hidden" value="${orderDetail.itemTakeit}" name="itemTakeit" > 
<input type="hidden" value="${orderDetail.sellerId}" name="sellerId" >
		</c:forEach>
		
	</div><br>
	<c:if test=""></c:if>
	총 주문금액 : ${totalPrice}
	<input type="submit" value="결제하기"/>
<input type="hidden" value="${totalPrice}" name="orderPrice">	
</form>

<!-- floating Banner -->
<jsp:include page="/common/floatingBanner.jsp"></jsp:include>
 <!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>

</body>
</html>