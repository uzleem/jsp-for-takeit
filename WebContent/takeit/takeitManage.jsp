<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 관리</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet"
	href="/takeit/css/mypage/myPage.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/takeit.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".takeitRange").click(function() {
		$("#takeitListForm").submit();
	});
	$("#takeitRange${takeitRange}").attr("checked", true);
});
	
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

	<div id="takeitMgr-view-width">
		<div class="side-menu">
			<c:choose>
				<c:when test="${not empty sellerId}">
					<!-- 판매자 마이페이지 메뉴 -->
					<jsp:include page="/common/mypage_seller_menu.jsp" />
				</c:when>
				<c:when test="${not empty memberId}">
					<!-- 일반회원 마이페이지 메뉴 -->
					<jsp:include page="/common/mypage_member_menu.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="/member/memberLogin.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
		<div id="takeitManage-wrap">
			<div>
				<h1>잇거래 목록</h1>
				
				<form action="/takeit/takeit/takeitController?action=takeitManageForm" method="post" id="takeitListForm">
				
					<input type="radio" class="takeitRange" id="takeitRangeall" value="all" name="takeitRange" >전체 
					<input type="radio" class="takeitRange" id="takeitRangelive" value="live" name="takeitRange">진행중
					<input type="radio" class="takeitRange" id="takeitRangeexpired" value="expired" name="takeitRange">만료
					<input type="radio" class="takeitRange" id="takeitRangedead" value="dead" name="takeitRange">삭제
				</form>
					<input type="button" class="takeitMgr-del-btn" value="전체삭제">
					<table>
						<tr>
							<th>구역이름</th>
							<th>구역코드</th>
							<th>회원번호</th>
							<th>시작일자</th>
							<th>종료일자</th>
							<th>현재금액</th>
							<th>목표금액</th>
							<th>잇거래여부</th>
							<th>삭제하기</th>
						</tr>
					</table>
				<div class="takeitMgr-scroll">
					<table>
						<c:forEach var="takeit" items="${takeitList}">
							<tr>
								<td>${takeit.shopLocName}</td>
								<td>${takeit.shopLocCode}</td>
								<td>${takeit.memberLocNo}</td>
								<td>${takeit.takeitDate}</td>
								<td>${takeit.takeitEndDate}</td>
								<td>${takeit.takeitCurrPrice}</td>
								<td>${takeit.takeitPrice}</td>
								<td>${takeit.takeitAlive}</td>
								<td><input type="button" value="삭제"></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- scroll function -->
	<jsp:include page="/common/back_to_top.jsp"></jsp:include>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>