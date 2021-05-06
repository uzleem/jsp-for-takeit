<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송상태 변경</title>
</head>
<body>
<h2 align="center">배송상태 변경</h2>
<form action="${CONTEXT_PATH}/order/orderController?action=updateShipStatus" method="post">
<div align="center" style="width:content-fit;margin: 150px 0 0 auto;">
	<div>
		주문번호 : ${param.orderNo}, 배송상태코드:${param.shipStatusCode}
	</div>
	<select style="width:150px;height:50px; text-align: center; box-sizing: border-box;">
		<c:forEach items="${shippingList}" var="shipping">
			<c:choose>
				<c:when test="${shipping.shipStatusCode == param.shipStatusCode}">
					<option selected="selected" value="${shipping.shipStatusCode}">${shipping.shipStatus}</option>
				</c:when>
				<c:otherwise>
					<option value="${shipping.shipStatusCode}">${shipping.shipStatus}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<input type="submit" value="변경하기" style="height:47px;width:100px;box-sizing: border-box;">
</div>
</form>
</body>
</html>