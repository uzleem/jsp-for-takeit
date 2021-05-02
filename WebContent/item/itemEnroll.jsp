<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit2/css/item.css">

</head>
<body>
	<div align='right'>
		<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>
	</div>
	<div id=logo_menu align='center'>
		<jsp:include page="/common/logo.jsp"></jsp:include>
	</div>

	<div align='center'>
		<a href="">전체 카테고리</a> <a href="">신상품</a> <a href="">베스트</a> <a
			href="">알뜰쇼핑</a> <a href="">헤택상품</a> <a href="">IT거래</a> <a href="">공지사항</a>
	</div>

	<h3 align="center">판매상품 등록</h3>
	<div align='center'>
	  <form name="form1" method="post" enctype="multipart/form-data"> 
		<table class="enroll_table" id="enroll_table">

			<tr>
				<td>상품카테고리이름</td>
				<td><input type="text" name="title" placeholder="상품카테고리이름">
				</td>
			</tr>

			<tr>
				<td>판매자</td>
				<td><input type="text" name="title" placeholder="판매자">
				</td>
			</tr>

			<tr>
				<td>상품</td>
				<td><input type="text" name="title" placeholder="상품번호">
				</td>
			</tr>


			<tr>
				<td>판매가</td>
				<td><input type="text" name="title" placeholder="판매가">
				</td>
			</tr>

			<tr>
				<td>원산지</td>
				<td><input type="text" name="title" placeholder="원산지">
				</td>
			</tr>

			<tr>
				<td>재고량</td>
				<td><input type="text" name="title" placeholder="재고량">
				</td>
			</tr>
          
			<tr>
				<td>상품이미지</td>
				<td><input type="file" name="file1" placeholder="상품이미지">
				</td>
			</tr>
	

			<tr>
				<td>잇거래여부</td>
				<td><select onchange="takeIt">
						<option value="">==잇거래 여부==</option>
						<option value="">True(등록)</option>
						<option value="">False(등록안함)</option>
				</select></td>
			</tr>

			<tr>
				<td>포장타입</td>
				<td><input type="text" name="title" placeholder="포장타입">
				</td>
			</tr>

			<tr>
				<td>유통기한</td>
				<td><input type="text" name="title" placeholder="유통기한">
				</td>
			</tr>

			<tr>
				<td>안내사항</td>
				<td><input type="text" name="title" placeholder="안내사항">
				</td>
			</tr>

			<tr>
				<td>신선도</td>
				<td><input type="text" name="title" placeholder="신선도">
				</td>
			</tr>
			<br>

		</table>
		</form>
		<div id="signup" align='center'>
			<tr>
				<br>
				<input type="submit" value="상품등록">
				<input type="reset" value="취소">
			</tr>
		</div>
	</div>
	<!-- scroll function -->
	<jsp:include page="/common/back_to_top.jsp"></jsp:include>
	<!-- footer 구역 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
