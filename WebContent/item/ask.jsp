<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품문의</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">

</head>
<body>
	<div align='right'>
	<!-- 로그인 후 메뉴 -->
	<jsp:include page="/common/after_login_menu.jsp"></jsp:include>	
	</div>
<div align='center'>	
<jsp:include page="/common/logo.jsp"></jsp:include>
</div>

		<div align='center'>
			<a href="">전체 카테고리</a> <a href="">신상품</a> <a href="">베스트</a> <a
				href="">알뜰쇼핑</a> <a href="">헤택상품</a> <a href="">IT거래</a> <a href="">공지사항</a>
		</div>
	
	<h3 align="center">1:1문의</h3>
	<div align='center'>
		<table class="ask_table" id="ask_table">
			<tr>	
				<td>문의유형</td>
				<td><select onchange="orderTypeChange(value)">
			      		<option value="">==문의유형을 선택해주세요==</option>
						<option value="">배송지연/불만</option>
						<option value="">반품문의</option>
						<option value="">A/S문의</option>
						<option value="">환불문의</option>
						<option value="">주문결제문의</option>
						<option value="">취소문의</option>
						<option value="">교환문의</option>
						<option value="">상품정보문의</option>
						<option value="">기타문의</option>
						<option value="">교환문의</option>
						<option value="">회원정보문의</option>
	        		</select>
	        	</td>
			</tr>	
		 	<tr>	
				<td>주문번호</td>
				<td><select onchange="orderNoChange(value)">
			    		<option value="">==주문번호를 선택해주세요==</option>
	            		<option value="">[서울우유]삼각커피우유 외5건</option>
	            		<option value="">[테이트]브리또 외2종</option>
	            		<option value="">[탄단지]가벼운 한식 도시락 외3종</option>
	            		<option value="">[금미]쌀 떡볶이 외3건</option>
	        		</select>
	        	</td>
			</tr>
			<tr>	
				<td>제목</td>
				<td>
					<input type="text" name="title" placeholder="제목을 입력해주세요">
				</td>
			</tr>
	        <tr>
				<td colspan="2">
					<textarea name="contents" rows="10" cols="80" placeholder="문의하실 내용을 입력해주세요"></textarea>
				</td>		
			</tr>	
		</table>
	    <div id="signup" align='center'>
	    	<tr>
				<input type="button" value="등록">
			</tr>
		</div>
</div>
<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
</body>
</html>
