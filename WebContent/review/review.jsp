<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Take it</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
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

	<h3 align="center">REVIEW</h3>
	<form method="post" action="inputreview" enctype="multipart/form-data"></form>
		<div align='center'>
			<table id="review_table">
	
				<tr>
						<td><input type="text" placeholder="상품번호"></td>
				</tr>
			     <tr>
						<td><input type="text" placeholder="제목을 입력해주세요"></td>
						
				</tr>
				<tr>
						<td><textarea name="contents" rows="13" cols="80"
							placeholder="자세한 후기작성은 저희에게 큰 도움이 됩니다.반품/환불문의는 카톡문의로 가능합니다."></textarea>
						</td>
				</tr>
	
		 		<tr>	
					<td>상품평점 :
						<select onchange="reviewChange(value)">
				    		<option value="">==평점선택==</option>
		            		<option value="">1점</option>
		            		<option value="">2점</option>
		            		<option value="">3점</option>
		            		<option value="">4점</option>
		            		<option value="">5점</option>
		            		<option value="">6점</option>
		            		<option value="">7점</option>
		            		<option value="">8점</option>
		            		<option value="">9점</option>
		            		<option value="">10점</option>
		        		</select>
		      
		        	</td>
				</tr>
			
				<tr>
					<td>상품이미지 :
					<input type="file" name="file1" placeholder="상품이미지">
					</td>
				</tr>
		    </table><br>
	    </div>	
	    <div class="img_notice" align='center'>
	        <span>구매한 상품이 아니거나 캡쳐사진은 첨부가 불가능합니다</span>
	    </div>

		
	    <br> <div id="signup" align='center'>
			<tr>
			<td><input type="submit" value="상품등록"></td>
			<td><input type="reset" value="취소"></td>
			</tr>
		  </div>
<!--	</div> -->
	<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>