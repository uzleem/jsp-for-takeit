<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇거래 관리</title>
</head>
<body>



만료된 잇거래 목록<br>
구역이름 구역코드, 회원번호  시작일자 종료일자 금액 삭제하기 <input type="button" value="전체삭제">
<br><hr>
<div class = "scroll" style="height:300px;overflow:scroll;">
<c:forEach var="takeit" items="${takeitList}">
${takeit.shopLocName}
, ${takeit.shopLocCode}
, ${takeit.memberLocNo}
, ${takeit.takeitDate}
, ${takeit.takeitEndDate}
, ${takeit.takeitCurrPrice}
, ${takeit.takeitPrice}
, ${takeit.takeitAlive}
, <input type="button" value="삭제">
<br>
</c:forEach>
</div>

만료된 잇거래 목록<br>
구역이름 구역코드, 회원번호  시작일자 종료일자 금액 삭제하기 <input type="button" value="전체삭제">
<br><hr>
<div class = "scroll" style="height:300px;overflow:scroll;width:800px">
<c:forEach var="takeit" items="${takeitList}">
${takeit.shopLocName}
, ${takeit.shopLocCode}
, ${takeit.memberLocNo}
, ${takeit.takeitDate}
, ${takeit.takeitEndDate}
, ${takeit.takeitCurrPrice}
, ${takeit.takeitPrice}
, ${takeit.takeitAlive}
, <input type="button" value="삭제">
<br>
</c:forEach>
</div>




</body>
</html>