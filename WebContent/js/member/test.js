/* 이벤트 초기화 메서드*/
$(document).ready(function() {
	$("#member_id").change(function() {
		$("#id_message").html("");
		
	}).focusout(function() {
		if (isMemberId($("#member_id").val())) {
			$("#id_message").html("[사용 가능]").css("color","green");
		}
	});
	
	$("#member_pw1").change(function() {
		$("#pw1_message").html("");
	}).focusout(function() {
		if (isMemberPw()) {
			$("#pw1_message").html("[사용 가능]").css("color","green");
		}
	});
	
	$("#member_pw2").change(function() {
		$("#pw2_message").html("");
	}).focusout(function() {
		if (isMemberPwConfirm($("#member_pw2").val())) {
			$("#pw2_message").html("[ 일치 ]").css("color","green");
		}
	});
	

	$("#name").change(function() {
		$("#name_message").html("");
	}).focusout(function() {
		if (isName($("#name").val())) {
			$("#name_message").html("[사용 가능]").css("color","green");
		}
	});

	$("#email1, #email2").change(function() {
		$("#email_message").html("");
	}).focusout(function() {
		if (isEmail()) {
			$("#email_message").html("[사용 가능]").css("color","green");
		}
	});
	
	$("#email3").change(function() {
		var email3 = $("#email3").val();
		if (email3 == 'none') {
			$("#email2").attr("readonly", false).val("");
		} else {
			$("#email2").attr("readonly", true).val(email3);
		}
	});
	
	$("#mobile2, #mobile3").change(function() {
		$("#mobile_message").html("");
	});
	$("#mobile2, #mobile3").focusout(function() {
		if (isMobile($(this).val())) {
			$("#mobile_message").html("[사용 가능]").css("color","green");
		}
	});
	
	if ($(".ps_box input").prop('readonly')) {
		$(".ps_box input").parent().css('backgroundColor', "#f0f0f0");
	}
	
	$("#member_id_check").click(function() {
		open("/mms/member/memberController?action=idCheckForm","","_blank, width=400px, height=300px");
	});
	
});	

/* 회원가입 검증 메서드 */
function inputCheck() {
	if (!isMemberId()) {
		return false;
	} 
	
	if (!isMemberPw()) {
		return false;
	} 
	
	if (!isMemberPwConfirm()) {
		return false;
	} 
	
	if (!isName()) {
		return false;
	} 

	if (!isEmail()) {
		return false;
	} 
	
	if (!isMobile()) {
		return false;
	} 
	return true;
}

/* 휴대폰 입력검증 메서드*/
function isMobile() {
	var pattern = new RegExp(/\d{4}/);
	var mobile2 = $("#mobile2").val().trim();
	var mobile3 = $("#mobile3").val().trim();
	
	if (pattern.test(mobile2)) {
	} else {
		$("#mobile_message").html("휴대폰 형식이 일치하지 않습니다").css("color","red");
		return false;
	}
	if (pattern.test(mobile3)) {
		$("#mobile_message").html("[사용 가능]").css("color","green");
		return true;
	} else {
		$("#mobile_message").html("휴대폰 형식이 일치하지 않습니다").css("color","red");
		return false;
	}
}

/* 이메일 검증 메서드*/
function isEmail() {
	var pattern1 = new RegExp(/[a-zA-z0-9]+/);
	var pattern2 = new RegExp(/[a-zA-z0-9]+\.[a-zA-z0-9]+/);
	
	email1 = $("#email1").val().trim();
	email2 = $("#email2").val().trim();
	
	if(email1.length == 0){
		$("#email_message").html("이메일을 입력하세요").css("color","red");
		return false;
	}
	if (pattern1.test(email1)) {
	} else {
		$("#email_message").html("이메일 형식이 일치하지 않습니다").css("color","red");
		return false;
	}
	if (pattern2.test(email2)) {
		$("#email_message").html("[사용 가능]").css("color","green");
		return true;
	} else {
		$("#email_message").html("이메일 형식이 일치하지 않습니다").css("color","red");
		return false;
	}
	
}

/* 아이디 검증 메서드 */
function isMemberId(){
	var pattern = new RegExp(/[a-zA-Z][a-zA-Z0-9]{5,19}/);
	var memberId = $("#member_id").val();
	memberId = memberId.trim();
	
	if(memberId.length == 0){
		$("#id_message").html("아이디를 입력하세요").css("color","red");
		$("#member_id").focus();
		return false;
	}
	console.log("readonly"+$("#member_id").prop("readonly"));
	console.log("readonly"+$("#member_id").attr("readonly"));
	
	if ($("#member_id").prop("readonly")) {
		
		$("#id_message").html("[사용 가능]").css("color","green");
		
	} else {
		$("#id_message").html("아이디 중복확인이 필요합니다").css("color","red");
		return false;
	}
	if (pattern.test(memberId)) {
		$("#id_message").html("[사용 가능]").css("color","green");
		return true;
	} else {
		$("#id_message").html("아이디 형식이 일치하지 않습니다").css("color","red");
		return false;
	}
}

/* 비밀번호 검증 메서드*/
function isMemberPw(){
	var pattern = new RegExp(/[a-zA-Z0-9]{6,20}/);
	var memberPw = $("#member_pw1").val().trim();
	
	if (memberPw.length == 0) {
		$("#pw1_message").html("비밀번호를 입력하세요").css("color","red");
		return false;
	}
	if (pattern.test(memberPw)) {
		$("#pw1_message").html("[사용 가능]").css("color","green");
		return true;
	} else {
		$("#pw1_message").html("비밀번호형식은 영문대소문자와 숫자 6자리입니다").css("color","red");
		return false;
	}
}

/* 이름 검증 메서드 */
function isName() {
	var name = $("#name").val().trim();
	var pattern = new RegExp(/[a-zA-Z가-힣]{2,}/);
	
	if(name.length == 0){
		$("#name_message").html("이름을 입력하세요").css("color","red");
		return false;
	} 
	if (pattern.test(name)) {
		$("#name_message").html("[사용 가능]").css("color","green");
		return true;
	} else {
		$("#name_message").html("이름은 2글자 이상이어야 합니다").css("color","red");
		$("#name").focus();
		return false;
	}
}

/* 비밀번호 동일검증 메서드 */
function isMemberPwConfirm(){
	var memberPw1 = $("#member_pw1").val().trim();
	var memberPw2 = $("#member_pw2").val().trim();
	
	if (memberPw2.length == 0) {
		$("#pw2_message").html("비밀번호를 입력하세요").css("color","red");
		return false;
	}
	if (memberPw1 != memberPw2){
		$("#pw2_message").html("비밀번호가 동일하지 않습니다").css("color","red");
		return false;
	} else {
		$("#pw2_message").html("[일치]").css("color","green");
		return true;
	}
}