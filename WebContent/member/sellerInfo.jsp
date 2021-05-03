<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/sellerInfo.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<!-- 상단 메뉴 -->
<c:choose>
	<c:when test="${empty seller.sellerId or empty seller.grade}">
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
<h3 align="center">내 정보 조회</h3>

<div id="container">
	<c:choose>
		<c:when test ="${seller.grade == 'S' }">
	 		<!-- 판매자 마이페이지 메뉴 -->
	 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<!-- 일반회원 마이페이지 메뉴 -->
			<jsp:include page="/common/mypage_member_menu.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
		
		
		<div id="mypage_sellerInfo">
			<h3>내 정보 조회</h3>
			<hr>
	<div id="sellerInfo">
		<form action="/takeit/member/mypageController?action=setMemberSeller" method="post">
			<table id="myInfo_table">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" id="sellerId" name="sellerId" value="${seller.sellerId }" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="text" id="sellerPw" name="sellerPw" value="${seller.sellerPw} ">
						<input id="infoUpdateBtn" type="button" value="비밀번호 변경" onclick="location.href='/takeit/member/mypageController?action=memberPwUpdateForm'">
					</td>		
				</tr>
				<tr>
					<th>이름</th>	
					<td>
						<input type="text" id="name" name="name" value="${seller.name}">
					</td>	
				</tr>
				<tr>
					<th>사업자등록번호</th>	
					<td>
						<input type="text" id="sellerNo" name="sellerNo" value="${seller.sellerNo}">
					</td>	
				</tr>
				<tr>
					<th>상점명</th>	
					<td>
						<input type="text" id="shopName" name="shopName" value="${seller.shopName}">
					</td>	
				</tr>
				<tr>
					<th>상점연락처</th>	
					<td>
						<input type="text" id="shopMobile" name="shopMobile" value="${seller.shopMobile}">
					</td>	
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>
						<input type="text" id="mobile" name="mobile" value="${seller.mobile}">
					</td>		
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" id="email" name="email" value="${seller.email}">
					</td>		
				</tr>
				<tr>
					<th>가입일자</th>	
					<td>
						<input type="text" id="entryDate" name="entryDate" value="${seller.entryDate}" readonly="readonly">
					</td>	
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" id="postNo" name="postNo" value="${seller.postNo}">
					</td>		
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" id="address" name="address" value="${seller.address}">
					</td>		
				</tr>
				<tr>
					<th>상세주소</th>
					<td>
						
						<input type="text" id="addressDetail" name="addressDetail">
					</td>		
				</tr>
				<tr>
					<th>등급</th>	
					<td>
						<input type="text" id="grade" name="grade" value="${seller.grade}" readonly="readonly">
					</td>	
				</tr>
				<tr>
					<th>주요제품</th>	
					<td>
						<input type="text" id="shopCategoryNo" name="shopCategoryNo" value="${seller.shopCategoryNo}">
					</td>	
				</tr>
				<tr>
					<th>카카오톡아이디</th>	
					<td>
						<input type="text" id="shopKaKaoId" name="shopKaKaoId" value="${seller.shopKakaoId}">
					</td>	
				</tr>
				<tr>
					<th>상점구역코드</th>	
					<td>
						<input type="text" id="shopLocCode" name="shopLocCode" value="${seller.shopLocCode}" readonly="readonly">
					</td>	
				</tr>
				<tr>
				<td colspan="2" align="center">
					<input type="submit" value="내 정보 수정">
				</td>
		</tr>
			</table>
		</form>
	</div>



</div>


</div>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>