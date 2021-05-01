$(document).ready(function() {
	
	/* 아이디 포커스 */
	$("#memberId").focus();
	$("#memberId").on('focus', function() {
		$("#memberId").css({
			'background' : "#E8F0FE"
		});
	});
	$("#memberId").on('focusout', function() {
		$("#memberId").css({
			'background' : "white"
		});
	});

	/* 비밀번호 포커스 */
	$("#memberPw").on('focus', function() {
		$("#memberPw").css({
			'background' : "#E8F0FE"
		});
	});
	$("#memberPw").on('focusout', function() {
		$("#memberPw").css({
			'background' : "white"
		});
	});

	/* 회원가입 이동 이벤트 */
	$("#input_button").click(function() {
		 location.href = "/takeit/member/memberInputForm.jsp"
	});
	
});