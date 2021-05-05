<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp"%>
<%@page import="com.takeit.model.dto.Review"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기상세조회</title>
<link type="text/css" rel="stylesheet" href="/takeit/css/link.css">
<link type="text/css" rel="stylesheet" href="/takeit/css/item.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

</head>
<!-- 상단 메뉴 -->
<c:if test="${empty memberId }">
	<!-- 로그인 전 메뉴 -->
	<jsp:include page="/common/before_login_menu.jsp"></jsp:include>
</c:if>
<c:if test="${not empty memberId }">
	<!-- 로그인 후 메뉴 -->
	<jsp:include page="/common/after_login_menu.jsp"></jsp:include>
</c:if>

<!-- logo.jsp 삽입 -->
<jsp:include page="/common/logo.jsp"></jsp:include>
<!-- 네비게이션 -->
<jsp:include page="/common/navigation.jsp"></jsp:include>
<form>
	<div id="enroll_total">
		<div style="display: flex;" align='center'>


			<div id="detail_div" style="width: fit-content;" align='center'>
				<h1>${review.reviewTitle}</h1>
				<hr class="line1">
				<span class="it_info"><b>후기번호</b>&emsp;${review.reviewNo}</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<span class="it_info"><b>작성자</b>&emsp;${review.memberId}</span><br>
				<span class="it_info"><b>상품번호</b>&emsp;${review.itemNo}</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<span class="it_info"><b>작성일</b>&emsp;&emsp;${review.reviewDate}</span><br>
				<span class="it_info"><b>조회수</b>&emsp;${review.reviewViews}</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				 <span class="it_info"><b>고객평점</b>&emsp;${review.reviewScore}</span><br>

				<hr class="line1">
				<div style="width: fit-content;">
					<img alt='후기' src="/takeit/img/review/${review.reviewImg}"
						width="450" height="310">
				</div>
				<span class="it_info"><b>후기내용</b>&emsp;${review.reviewContents}</span><br>

			</div>
		</div>
	</div>

	<div class="btn-area" align='center'>
		<input type="button" class="link" style="display: inline-block;"
			value="목록" /> <input type="button" class="link"
			style="display: inline-block;" value="상품보러가기" />
	</div>
</form>

<!-- scroll function -->
<jsp:include page="/common/back_to_top.jsp"></jsp:include>
<!-- footer 구역 -->
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>