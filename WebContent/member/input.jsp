<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/member/member.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="../js/member/input.js"></script>
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

<!-- 내용 -->
<div id="contents_box" align="center">
<h3>회원가입</h3>
<form action="#" method="post">
<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" id="memberId"/></td>
			<td><input type="button" value="중복확인" id="memberId_button"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" placeholder="비밀번호를 입력해주세요" id="memberPw"/></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" placeholder="비밀번호를 한번 더 입력해주세요" id="memberPw_Chk"/></td>
			<td><input type="checkbox" id="memberPw_checkbox"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" placeholder="이름을 입력해주세요" id="name"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" placeholder="예:takeit@take.com" id="email"/></td>
			<td><input type="button" value="중복확인" id="email_button"/></td>
		</tr>
		<tr>
			<td>휴대폰</td>
			<td>
				<input type="text" id="mobile" placeholder="숫자만 입력해주세요" id="mobile"/>
			</td>
			<td><input type="button" value="인증번호" id="mobile_button"/></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" placeholder="변경예정" id="zipCode"/></td> 
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" placeholder="변경예정" id="addr"/></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" placeholder="YYYY / MM / DD" id="entryDate" /></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="submit" value="가입하기" id="submit_input" /></td>
		</tr>
	</table>
</form>
</div>
</body>
</html> 