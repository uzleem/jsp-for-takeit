<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상점구역 등록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/myPage.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
var goPopup = function() {
	 var pop = window.open("${CONTEXT_PATH}/member/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");
 } 
var jusoCallBack = function(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo){
	 document.getElementById("postNo").value = zipNo; 
	 document.getElementById("address").value = roadAddrPart1; 
	 document.getElementById("addressDetail").value = addrDetail; 
	 if(addressDetail.length>30){ 
		alert('상세주소를 30자 이내로 입력하세요.'); 
		return; 
	} 
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


	<h3>상점구역 등록</h3>
	<form action="${CONTEXT_PATH}/takeit/takeitController?action=shopLocInput" method="post">
	<table>
		<tr>
			<td>우편번호</td>
			<td>
				<input type="text" placeholder="우편번호 선택" id="postNo" name="postNo" readonly="readonly"/>
				<input type="button" id="postNoBtn" name="postNoBtn" onclick="goPopup();" value="주소검색"/>
			</td>
		</tr>
		<tr>
			<td>도로명주소</td>
			<td>
				<input type="text" placeholder="도로명주소" id="address" name="address" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td>
				<input type="text" placeholder="상세주소" id="addressDetail" name="addressDetail"/>
			</td>
		</tr>
		<tr>
			<td>상점구역코드</td>
			<td>
				<input type="text" placeholder="상점구역코드" id="shopLocCode" name="shopLocCode"/>
			</td>
		</tr>
		<tr>
			<td>상점구역이름</td>
			<td>
				<input type="text" placeholder="상점구역이름" id="shopLocName" name="shopLocName"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록"/>
				<input type="reset" value="초기화"/>
			</td>
		</tr>
	</table>
	</form>
 <!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>

</body>
</html>