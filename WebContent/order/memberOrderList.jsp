<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 주문목록 조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/myPage.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
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
			if (data == "1") {
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

<div id="container">
<c:choose>
	<c:when test ="${grade == 'S'}">
 		<!-- 판매자 마이페이지 메뉴 -->
 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<!-- 일반회원 마이페이지 메뉴 -->
		<jsp:include page="/common/mypage_member_menu.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
	
	<div>
	<h3>주문내역</h3>
		<c:forEach var="order" items="${orderList}">
			<hr>
			<div>
				<div>
					주문번호 : ${order.orderNo} &emsp;
					주문 상태 : 
					<c:choose>
						<c:when test="${order.orderCancel == 'F' and order.orderCancelReq == 'T'}">
							${order.shipStatus}(취소요청)
						</c:when>
						<c:when test="${order.orderCancel == 'T'}">
							주문취소완료					
						</c:when>
						<c:otherwise>
							${order.shipStatus}
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${order.orderCancelReq == 'T' and order.orderCancel == 'F'}">
							<input id="${order.orderNo}" disabled="disabled" type="button" value="취소요청" onclick="orderCancelRequest('${order.orderNo}')">		
						</c:when>
						<c:when test="${order.orderCancelReq == 'F' and order.orderCancel == 'F'}">
							<input id="${order.orderNo}" type="button" value="취소요청" onclick="orderCancelRequest('${order.orderNo}')">
						</c:when>
						<c:when test="${order.orderCancel == 'T' }"></c:when>
					</c:choose>
					 
				</div>
				<c:forEach var="orderDetail" items="${order.orderDetails}">
				<div>
					<img src="/takeit/img/item/${orderDetail.itemImg}" alt="${orderDetail.itemImg}" title="${orderDetail.itemImg}" style="width:100px; height:150px;">	
					<div style="display:inline-block;">
						<div>상품명 : ${orderDetail.itemName}</div>
						<div>상품 수량 : ${orderDetail.itemQty}개</div>
						<div>결제금액 : ${orderDetail.itemPayPrice * orderDetail.itemQty}원</div>
						<div>수령 방법 : ${order.receiveMethod}</div>
					</div>
					<div style="display:inline-block;">
						<input type="button" value="상품 후기" >
						<input type="button" value="상품 문의" onclick="location.href='/takeit/boardController?action=boardList&boardCategory=3'">
					</div>
				</div>
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