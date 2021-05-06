<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 주문목록 조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/myPage.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/order.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
function orderCancelRequest(orderNo) {
	$.ajax({
		url:"/takeit/order/orderController?action=orderCancelRequest",
		type:"post",
		data:{
			"orderNo" : orderNo
		},
		success : function(data) {
			if (data == "success") {
				alert("성공");
				$("#"+orderNo).attr("disabled", true);
			} else {
				alert("실패");
			}
		}
	});
}
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

<div id="container" class="view-width">
	<div class="side-menu">
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
	</div>	
	<div class="orderList-wrap">
		<h1>주문내역</h1>
		<c:forEach var="order" items="${orderList}">
			<hr>
			<div>
				<div class="order-info">
					<span><b>주문번호 :</b> ${order.orderNo}</span> &emsp;
					<span><b>주문 상태 :</b></span>
					<c:choose>
						<c:when test="${order.orderCancel == 'F' and order.orderCancelReq == 'T'}">
							<span> ${order.shipStatus}(취소요청)</span>
						</c:when>
						<c:when test="${order.orderCancel == 'T'}">
							<span>주문취소완료</span>				
						</c:when>
						<c:otherwise>
							<span>${order.shipStatus}</span>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${order.orderCancelReq == 'T' and order.orderCancel == 'F'}">
							<input id="${order.orderNo}" class="cancle-btn" disabled="disabled" type="button" value="취소요청" onclick="orderCancelRequest('${order.orderNo}')">		
						</c:when>
						<c:when test="${order.orderCancelReq == 'F' and order.orderCancel == 'F'}">
							<input id="${order.orderNo}" class="cancle-btn" type="button" value="취소요청" onclick="orderCancelRequest('${order.orderNo}')">
						</c:when>
						<c:when test="${order.orderCancel == 'T' }"></c:when>
					</c:choose>
					 
				</div>
				<c:forEach var="orderDetail" items="${order.orderDetails}">
				<div class="order-detail-wrap">
					<div id="orderList-img">
					<img src="/takeit/img/item/${orderDetail.itemImg}" alt="${orderDetail.itemImg}" title="${orderDetail.itemImg}">
					</div>	
					<div class="order-detail">
						<span><b>상품명 :</b>&emsp;${orderDetail.itemName}</span><br>
						<span><b>상품 수량 :</b> &emsp;${orderDetail.itemQty}개</span><br>
						<span><b>결제금액 :</b> &emsp;${orderDetail.itemPayPrice * orderDetail.itemQty}원</span><br>
						<span><b>수령 방법 :</b> &emsp;${order.receiveMethod}</span>
					</div>
					<div class="order-detail-btn">
						<input type="button" value="상품 후기" class="order-btn"  style="margin-bottom: 5px;" >
						<input type="button" value="상품 문의" class="order-btn" onclick="location.href='/takeit/boardController?action=boardList&boardCategory=3'">
					</div>
				</div>
				<hr style=" border-top: 1px dashed grey;">
				</c:forEach>
			</div>
		</c:forEach>
		<hr>
	</div>
</div>

 <!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>

</body>
</html>