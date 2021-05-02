<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Take it</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">

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
					<img alt='매그넘' src="/takeit/img/item/item4.jpg" width="450" height="320">
			
				</div>
			
				<div id="meat_div" style="width: fit-content;">
					<h2>[매그넘]부드러운 클래식라인 아이스크림 바 3종 (4입팩)</h2>
					<div>
						<span style="color: red"> 3,271원</span> <span> (59%할인) </span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						 <span> 소비자 권장소매가: </span> <span>7,980원</span>
					</div>
					<hr class="line1">
					<div>
						<span> 카테고리 </span> &nbsp;
						<span> 아이스크림</span>
					</div>
					<div>
						<span> 판매단위 </span> &nbsp;
						<span> 4개입 </span>
					</div>
					<div>
						<span> 재고량 </span> &nbsp;
						<span> 10</span>
					</div>
					<div>
						<span> 원산지</span> &nbsp;
						<span>유럽</span>
					</div>
					<div>
						<span> 포장타입 </span>&nbsp;
						 <span>냉동포장</span>
					</div>
					<div>
						<span> 판매자</span> &nbsp;
						<span>매그넘</span>
					</div>
					<div>
						<span> 고객평점 </span> &nbsp;
						<span> 10점 </span>
					</div>
					<div>
						<span> 등록일자 </span> &nbsp;
						<span> 2021-05-01 </span>
					</div>
	
				</div>
		           <div style="width: fit-content;" >
						<input type="button" value="배송안내"  align='center'>
						<!-- style="width: 100%; height: 36px; background-color: #fff; border-radius: 5px; border: solid 1px purple; color: purple; "> -->
				   </div>
			</div>
		</div>

		<div id="signup" align='center'>
			<input type="submit" name="buy" id="buy" value="바로 구매"> <input
				type="submit" name="cart" id="cart" value="장바구니">
		</div>
	</form>

</body>
</html>