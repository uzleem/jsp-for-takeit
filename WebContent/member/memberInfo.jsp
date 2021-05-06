<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원 내 정보 조회 </title>
<link type="text/css" rel="stylesheet" href="/takeit/css/mypage/memberInfo.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">
	
</style>
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
<br>

	<h1 style="width:fit-content; margin: 0 auto;">내 정보 조회</h1>
	<br>
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
					<input id="memberInfo_button" type="button" value="비밀번호 변경" onclick="location.href='/takeit/member/mypageController?action=memberPwUpdateForm'">
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
					<input type="text" placeholder="우편번호 선택" id="postNo" name="postNo" readonly="readonly" value="${member.postNo }"/>
					<input type="button" id="memberInfo_button" name="zipNoBtn" onclick="goPopup();" value="우편번호"/>
				</td>
			</tr>
			
			<tr>
				<th>도로명주소</th>
				<td>
					<input type="text" placeholder="도로명주소" id="address" name="address" readonly="readonly" value="${ member.address}"/>
				</td>
			</tr>
			
			<tr>
				<th>상세주소</th>
				<td>
					<input type="text" placeholder="상세주소" id="addressDetail" name="addressDetail" value="${member.addressDetail }"/>
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
			
		</table>
		<br>
		<input class="link" type="submit" value="내 정보 수정">
	</form>


	<a href="/takeit/member/myPage.jsp" id="mypage_Btn">마이페이지로 이동</a>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>

</body>
</html>