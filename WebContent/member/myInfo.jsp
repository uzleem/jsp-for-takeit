
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">

.myPage_menu_aside ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
}
.myPage_menu_aside li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}
.myPage_menu_aside h3.active {
    background-color: #5a7d59;
    color: white;
}
.myPage_menu_aside li a:hover:not(.active) {
    background-color: #5a7d59;
    color: white;
}

#container{
	height: 700px;
}
.myPage_menu_aside {
	width: 200px;
	height: 500px;
	float: left;
	margin-left: 200px;
	margin-top: 100px;
}


#myInfo{
	display: inline-block;
    padding: 0;
    width: 800px;
    height: 500px;
    float: left;
    margin-left: 50px;
	text-align: -webkit-center;
	margin-left: 60px;
}

#myInfo_btn{
margin-top: 30px;
margin-left: 30px;	
}
#btn{
margin-right: 20px;}

#mypage_info{
 padding: 0;
    width: 800px;
    height: 700px;
    float: left;
    margin-left: 130px;
}

#myInfo_table{
	width: 500px;
}

#mypage_btn{
		width:30%;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		background-color: #7B977A;
		color: white;
		margin-top: 15px;
		border: 1px solid #7B977A;
		margin-right: 20px;
}
</style>
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
<h3 align="center">내 정보 조회</h3>

<div id="container">
	<c:choose>
		<c:when test ="${grade == 'S' }">
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
	<table id="myInfo_table">
		<tr>
			<th>아이디</th>
			<td>
			<input type="text" id="memberId" name="memberId">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
			<input type="password" id="memberPw" name="memberPw">
			</td>		
		</tr>
		<tr>
			<th>이름</th>	
			<td>
			<input type="text" id="name" name="name">
			</td>	
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>
			<input type="text" id="mobile" name="mobile">
			</td>		
		</tr>
		<tr>
			<th>이메일</th>
			<td>
			<input type="text" id="email" name="email">
			</td>		
		</tr>
		<tr>
			<th>가입일자</th>	
			<td>
			<input type="text" id="enrtyDate" name="enrtyDate">
			</td>	
		</tr>
		<tr>
			<th>포인트</th>
			<td>
			<input type="text" id="point" name="point">
			</td>		
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
			<input type="text" id="postno" name="postno">
			</td>		
		</tr>
		<tr>
			<th>주소</th>
			<td>
			<input type="text" id="address" name="address">
			</td>		
		</tr>
		<tr>
			<th>상세주소</th>
			<td>
			<input type="text" id="addressDetali" name="addressDetail">
			</td>		
		</tr>
		<tr>
			<th>생일</th>	
			<td>
			<input type="text" id="birth" name="birth">
			</td>	
		</tr>
		<tr>
			<th>구역번호</th>	
			<td>
			<input type="text" id="" name="">
			</td>	
		</tr>
		<tr>
			<th>등급</th>	
			<td>
			<input type="text" id="grade" name="grade">
			</td>	
		</tr>
	
	
	
	</table>
	<div id="myInfo_btn">
			<input id = "mypage_btn" class="inline" type="button" value="홈으로 이동" onclick="location.href='/takeit/member/index.jsp'">
			<input id = "mypage_btn" class="inline" type="button" value="판매자 전환" onclick="location.href='/takeit/member/sellerJoin.jsp'">
	</div>
</div>

</div>


</div>

 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>

</html>