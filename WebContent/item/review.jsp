<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Take it</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
</head>
<body>
	<div align='right'>
			<!-- 로그인 후 메뉴 -->
		<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
	</div>
		<div  id=logo_menu align='center'>	
<jsp:include page="/common/logo.jsp"></jsp:include>
</div>

		<div align='center'> 
			<a href="">전체 카테고리</a> 
			<a href="">신상품</a> 
			<a href="">베스트</a> 
			<a href="">알뜰쇼핑</a> 
			<a href="">헤택상품</a> 
			<a href="">IT거래</a> 
			<a href="">공지사항</a>
</div>
	<h3 align="center">REVIEW</h3>
	<div align='center'>
		<table id="review_table">
			<tr>
					<td>[카프리썬]오렌지 200mL 10입 박스</td>
			</tr>
		     <tr>
					<td><input type="text" placeholder="제목을 입력해주세요"></td>
					
			</tr>
			<tr>
					<td><textarea name="contents" rows="20" cols="100"
						placeholder="자세한 후기작성은 저희에게 큰 도움이 됩니다.반품/환불문의는 카톡문의로 가능합니다. 
				          0자/최소10자"></textarea>
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
					
			
			</table>
			<div> 
				<img src="/takeit/img/picture.jfif">
	        </div>
	        <div class="img_notice" >
	        <span>구매한 상품이 아니거나 캡쳐사진은 첨부가 불가능합니다</span>
	        </div>
		
		
			<div id="signup" align='center'>
				<tr>
					<td colspan="2"><input type="submit" value="등록하기">
				</tr>	
			</div>
	</div>
	<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>