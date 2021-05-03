
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/memberInfo.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<!-- 상단 메뉴 -->
<c:choose>
	<c:when test="${empty member.memberId or empty member.grade}">
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
		<c:when test ="${member.grade == 'S' }">
	 		<!-- 판매자 마이페이지 메뉴 -->
	 		<jsp:include page="/common/mypage_seller_menu.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<!-- 일반회원 마이페이지 메뉴 -->
			<jsp:include page="/common/mypage_member_menu.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
		
		<div id="mypage_info">
			<h3>내 정보 조회</h3>
			<hr>
<div id="myInfo">
	<form action ="/takeit/member/mypageController?action=setMemberInfo" method="post">
	<table id="myInfo_table">
		<tr>
			<th>아이디</th>
			<td>
			<input type="text" id="memberId" name="memberId" value="${member.memberId }" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
			<input type="password" id="memberPw" name="memberPw" value="${member.memberPw }">
			<input id="infoUpdateBtn" type="button" value="비밀번호 변경" onclick="location.href='/takeit/member/mypageController?action=memberPwUpdateForm'">
			</td>		
		</tr>
		<tr>
			<th>이름</th>	
			<td>
			<input type="text" id="name" name="name" value="${ member.name}">
			</td>	
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>
			<input type="text" id="mobile" name="mobile" value="${member.mobile }">
			</td>		
		</tr>
		<tr>
			<th>이메일</th>
			<td>
			<input type="text" id="email" name="email" value="${ member.email}">
			</td>		
		</tr>
		<tr>
			<th>가입일자</th>	
			<td>
			<input type="text" id="entryDate" name="entryDate" value="${ member.entryDate}" readonly="readonly">
			</td>	
		</tr>
		<tr>
			<th>포인트</th>
			<td>
			<input type="text" id="point" name="point" value="${member.point }" readonly="readonly">
			</td>		
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
			<input type="text" id="postNo" name="postNo" value="${member.postNo }">
			</td>		
		</tr>
		<tr>
			<th>주소</th>
			<td>
			<input type="text" id="address" name="address" value="${ member.address}">
			</td>		
		</tr>
		<tr>
			<th>상세주소</th>
			<td>
			<input type="text" id="addressDetail" name="addressDetail" value="${member.addressDetail }">
			</td>		
		</tr>
		<tr>
			<th>생일</th>	
			<td>
			<input type="text" id="birth" name="birth" value="${member.birth }">
			</td>	
		</tr>
		<tr>
			<th>구역번호</th>	
			<td>
			<input type="text" id="memberLocNo" name="memberLocNo" value="${member.memberLocNo }" readonly="readonly">
			</td>	
		</tr>
		<tr>
			<th>등급</th>	
			<td>
			<input type="text" id="grade" name="grade" value="${member.grade}" readonly="readonly">
			</td>	
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="내 정보 수정">
			</td>
		</tr>
	</table>
</form>
	<div id="myInfo_btn">
			<input id = "mypage_btn" class="inline" type="button" value="홈으로 이동" onclick="location.href='/takeit/member/index.jsp'">
	</div>
</div>
</div>
</div>

 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>