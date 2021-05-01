<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Take it</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<style type="text/css">
img[src$="item/.jpg/"] {
	width: 30px;
	height: 30px;
}

table {
	width: 100%;
	border: 1px solid black;
}

.itemTable {
	border-collapse: collapse;
}

.itemTable th, .itemTable td {
	border: 1px solid black;
}

#enroll_total {
	border: 1px solid black;
	width : 1700px;
	height: 1000px;
	margin: 100px;
}

#goso_div {
	margin-left: 50px;
}
</style>
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
		<a href="">전체 카테고리</a> <a href="">신상품</a> <a href="">베스트</a> <a
			href="">IT거래</a> <a href="">공지사항</a>
	</div>

	<form>
	<div id="enroll_total">
		<div style="display: flex;">
			<div style="width: fit-content;">
				<img src="/takeit/img/item/item7.jpg" width="450" height="300">
		
			</div>
		
			<div id="goso_div" style="width: fit-content;">
				<h1>고소한 햇찹쌀</h1>
				<div>
					<span style="color: red"> 5820원 </span> <span> (3%할인) </span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					 <span> 소비자 권장소매가: </span> <span> 6000원 </span>
				</div>
				<hr class="line1">
				<div>
					<span> 판매단위 </span> &nbsp;
					<span> 1kg </span>
				</div>
				<div>
					<span> 재고량 </span> &nbsp;
					<span> 7 </span>
				</div>
				<div>
					<span> 원산지</span> &nbsp;
					<span> 국산 </span>
				</div>
				<div>
					<span> 포장타입 </span>&nbsp;
					 <span> 기타</span>
				</div>
				<div>
					<span> 판매자</span> &nbsp;
					<span> 김효원 </span>
				</div>
				<div>
					<span> 고객평점 </span> &nbsp;
					<span> 9.8 </span>
				</div>
				<div>
					<span> 등록일자 </span> &nbsp;
					<span> 2021-04-21 </span>
				</div>
           </div>
			</div>
			<div style="width: fit-content;">
				<input type="button" value="배송안내"
					style="width: 100%; height: 36px; background-color: #fff; border-radius: 5px; border: solid 1px purple; color: purple">
			</div>
		</div>

		<div id="signup" align='center'>
			<input type="submit" name="buy" id="buy" value="바로 구매"> <input
				type="submit" name="cart" id="cart" value="장바구니">
		</div>
	</form>

</body>
</html>