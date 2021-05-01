<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<style type="text/css">

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
}
li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}
h3.active {
    background-color: #4CAF50;
    color: white;
}
li a:hover:not(.active) {
    background-color: #555;
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
#sellerInfo{
	display: inline-block;
    padding: 0;
    width: 800px;
    height: 700px;
    float: left;
    margin-left: 50px;
	text-align: -webkit-center;
	margin-left: 130px;
}

#btn{
margin-right: 20px;}

#mypage_sellerInfo{
 	padding: 0;
    width: 1000px;
    height: 700px;
    float: left;
    margin-left: 130px;
	
}
#myInfo_table{
	width: 500px;
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
<h3 align="center">판매자 정보 수정</h3>

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
		
		
		<div id="mypage_sellerInfo">
			<h3>내 정보 수정</h3>
			<hr>
				<div id="sellerInfo">
					<table id="myInfo_table">
						<tr>
							<th>아이디</th>
							<td>
							<input type="text" id="member_id" name="member_id">
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
							<input type="text" id="" name="">
							</td>		
						</tr>
						<tr>
							<th>이름</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<th>사업자등록번호</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<th>상점명</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<th>상점연락처</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<th>휴대폰</th>
							<td>
							<input type="text" id="" name="">
							</td>		
						</tr>
						<tr>
							<th>이메일</th>
							<td>
							<input type="text" id="" name="">
							</td>		
						</tr>
						<tr>
							<th>가입일자</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<th>우편번호</th>
							<td>
							<input type="text" id="" name="">
							</td>		
						</tr>
						<tr>
							<th>주소</th>
							<td>
							<input type="text" id="" name="">
							</td>		
						</tr>
						<tr>
							<th>상세주소</th>
							<td>
							<input type="text" id="" name="">
							</td>		
						</tr>
						<tr>
							<th>상점구역코드</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<th>등급</th>	
							<td>
							<input type="text" id="" name="">
							</td>	
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input class="inline" type="button" value="수정하기"  onclick="location.href='/takeit/member/sellerInfo.jsp'">
						</tr>
					</table>
				</div>
		</div>

</div>
 
 <!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>