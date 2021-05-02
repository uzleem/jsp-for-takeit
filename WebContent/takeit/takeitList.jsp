<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 상품 목록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<style>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
	function getTakeitTime() {
		var date = new Date();
		
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		month = month < 10 ? "0" + month: month ;
		var day = date.getDate();
		day = day < 10 ? "0" + day: day ;
		var hour = date.getHours();
		hour = hour < 10 ? "0" + hour: hour ;
		var minute = date.getMinutes();
		minute = minute < 10 ? "0" + minute: minute ;
		var second = date.getSeconds();
		second = second < 10 ? "0" + second: second ;
		
		var time = ""+ year + "-"+ month + "-" + day +" "+ hour +":"+ minute +":"+ second; 	
		
		for (i = 0; i < $(".takeitTime").length; i++) {
			var takeitTimeElement = $(".takeitTime").get(i);
			var takeitTime = takeitTimeElement.dataset.takeittime;
			
			takeitTimeElement.innerHTML = "남은시간 : "+time +" - " + takeitTime + "   <br>(연산 할줄모름)";
			
		}
	}
	$(document).ready(function (){
		getTakeitTime();
		setInterval(getTakeitTime, 1000);
	});
</script>
</head>
<body>
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

<h3 style="width:fit-content; margin: 20px auto; font-size: 30px;">잇거래</h3>
<div id="item-recomm" class="view-width">
	<c:forEach items="${takeitItemList}" var="dto">
	<div class="takeit_item">
		<span class="takeitTime" data-takeittime="${dto.takeitDate}"></span><br>
		<ul>
			<li>
				<a href="/takeit/takeit/takeitController?action=takeitItemDetail&itemNo=${dto.itemNo }">
					<img id="itemImg" alt="${dto.itemImg}" src="/takeit/img/item/${dto.itemImg}">
				</a>
			</li>
			<li id="itemTitle">${dto.itemName}</li>
			<li id="discRate">${dto.discRate}%</li>
			<li id="salePrice">${dto.itemPrice * (100-dto.discRate) / 100}원</li>
			<li id="price">${dto.itemPrice}원</li>
		</ul>
	</div>
	</c:forEach>
</div>


<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
