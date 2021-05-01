<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="/takeit/js/slide.js"></script>
<!--카카오 javascript SDL 등록(kakao.min.js)  -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script> 

<script>
// SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
window.Kakao.init("");
window.Kakao.isInitialized();
// SDK 초기화 여부를 판단합니다.
console.log(Kakao.isInitialized());

function kakaoLogin() {
	window.Kakao.Auth.login({
        scope:'profile, account_email, birthday',
        success:function(authObj){
            console.log(authObj);
            window.Kakao.API.request({
                url:'/v2/user/me',
                success: function(response) {
                    const kakao_account = response.kakao_account;
                    console.log(kakao_account);
                    console.log(kakao_account.profile);
                    console.log(kakao_account.email);
                    console.log(kakao_account.birthday);
                    document.getElementById("memberId").value=kakao_account.email;
                    document.loginForm.submit();
                }
            });
        }
    });
}
</script>



<style>
	#contents_box {	
		margin: auto;
	}
		
	#contents_box > table {		
		font-size: 9px;
	}
		
		
	#contents_box > submit{
		width:100%;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		background-color: #7B977A;
		color: white;
	}

	#memberId{
		width:250px;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		border: 1px solid #7B977A;
		margin-bottom: 5px;
	}
	
	#memberPw{
		width:250px;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		margin-bottom: 10px;
		border: 1px solid #7B977A;
	}
	
	a{
		text-decoration: none;
		font-size: 9px;
	}

 	#normalLogin{
		width:100%;
		height:35px; 
		padding: 0px 19px;
		font-size: 9px;
		background-color: #7B977A;
		color: white;
		margin-top: 15px;
		border: 1px solid #7B977A;
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

<div id="contents_box" align="center">
<h3>로그인 </h3>
<form action="/takeit/member/myInfo.jsp" method="post" name="loginForm">
<table>
	<tr>
		<td><input type="text" placeholder="고객님의 아이디를 입력해주세요" id="memberId" name="memberId"/></td>
	</tr>
	<tr>
		<td><input type="password" placeholder="고객님의 비밀번호를 입력해주세요" id="memberPw" name="memberPw" /></td>
		
	</tr>
	<tr>
		<td id="find" align="right">
			<a href="find_Id.jsp">아이디찾기</a>
			<a href="find_Pw.jsp">비밀번호찾기</a>
		</td>
	</tr>
	<tr>
		<td><input type="button" value="일반 로그인" id="normalLogin"/></td>
	</tr>
	<tr>
		<td align="center"><a href="javascript:kakaoLogin();"><img src="/takeit/img/icon/kakao_login_medium_wide.png" alt="" id="kakaoLogin"/></a></td>
		<!-- <td><input type="button" value="카카오 로그인" id="kakaoLogin" onclick="kakaoLogin();"/></td> -->
	</tr>
</table>
</form>
</div>
</body>
</html> 