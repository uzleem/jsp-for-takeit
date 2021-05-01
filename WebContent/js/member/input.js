$(document).ready(function() {
		
	/* 아이디 포커스 */
	$("#memberId").focus();
	
	$("#memberId").on('focus', function() {
		$("#memberId").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 아이디 포커스 아웃 */
	$("#memberId").on('focusout', function() {
		
		$("#memberId").css({
			'background' : "white"
		});

		var memberId = $("#memberId").val();
		var memberId_Valid = memberId_data(memberId)
		if(memberId_Valid) {
			$('#memberId_result').hide();	
			//$('#memberId_result').show().html("<h6>사용가능한 아이디입니다</h6>");
		}else {
			$('#memberId_result').show().html("<h6>최소4 ~ 최대12자리 영문+숫자만 사용가능</h6>");
			$('#memberId_result').css('color','red')
		} 
	});

	/* 비밀번호 포커스 */
	$("#memberPw").on('focus', function() {
		$("#memberPw").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 비밀번호 포커스 아웃 */
	$("#memberPw").on('focusout', function() {
		
		$("#memberPw").css({
			'background' : "white"
		});
		
		var memberPw = $("#memberPw").val();
		var memberPw_Valid = memberPw_data(memberPw)
		if(memberPw_Valid) {
			$('#memberPw_result').hide();	
			//$('#memberPw_result').show().html("<h6>사용가능한 비밀번호입니다</h6>");
			event.preventDefault();
		}else {
			$('#memberPw_result').show().html("<h6>최소  4 ~ 최대 12자리, 영문+숫자+특수문자 필수포함</h6>");
			$('#memberPw_result').css('color','red')
		} 
	});
	
	/* 비밀번호 확인 포커스 */
	$("#memberPw_Chk").on('focus', function() {
		$("#memberPw_Chk").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 비밀번호 확인 포커스 아웃 */
	$("#memberPw_Chk").on('focusout', function() {
		$("#memberPw_Chk").css({
			'background' : "white"
		});
	});
		
	/* 이름 포커스 */
	$("#name").on('focus', function() {
		$("#name").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 이름 포커스 아웃 */
	$("#name").on('focusout', function() {
		$("#name").css({
			'background' : "white"
		});
	/*
	var name = $("#name").val();
	var name_Valid = name_data(name)
	if(name_Valid) {
		$('#name').hide();	
		//$('#name_result').show().html("<h6>사용가능한 비밀번호입니다</h6>");
		//$('#name_result').css('color','blue')
		event.preventDefault();
	}else {
		$('#name_result').show().html("<h6>최소 2 ~ 최대 6자리 한글만가능</h6>");
		$('#name_result').css('color','red')
	}
	*/
	});

	
	/* 이메일 포커스 */
	$("#email").on('focus', function() {
		$("#email").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 이메일 포커스 아웃 */
	$("#email").on('focusout', function() {
		$("#email").css({
			'background' : "white"
		});
	});

	/* 휴대폰 포커스 */
	$("#mobile").on('focus', function() {
		$("#mobile").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 휴대폰 포커스 아웃 */
	$("#mobile").on('focusout', function() {
		$("#mobile").css({
			'background' : "white"
		});
	});
	
	/* 우편번호 포커스 */
	$("#zipCode").on('focus', function() {
		$("#zipCode").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 우편번호 포커스 아웃 */
	$("#zipCode").on('focusout', function() {
		$("#zipCode").css({
			'background' : "white"
		});
	});
	
	/* 주소 포커스 */
	$("#addr").on('focus', function() {
		$("#addr").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 주소 포커스 아웃 */
	$("#addr").on('focusout', function() {
		$("#addr").css({
			'background' : "white"
		});
	});

	/* 생년월일 포커스 */
	$("#entryDate").on('focus', function() {
		$("#entryDate").css({
			'background' : "#E8F0FE"
		});
	});
	
	/* 생년월일 포커스 아웃 */
	$("#entryDate").on('focusout', function() {
		$("#entryDate").css({
			'background' : "white"
		});
	});
	
	

 /* 아이디 : 생략불가, 중복불가,  최소  4 ~ 최대 12자리, 영문+숫자만 사용가능*/
 function memberId_data(take) {
 	var pattern = new RegExp(/^[a-zA-Z0-9]{4,12}$/);
 	return pattern.test(take);
 }

 /* 비밀번호 : 생략불가, 최소  4 ~ 최대 12자리, 영문+숫자+특수문자 필수포함*/
 function memberPw_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
 }

 /* 비밀번호 재확인 : 생략불가, 비밀번호와 값이 일치해야함 */
 function memberPw2_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
 }
 
 /* 비밀번호 표시 */
 function memberPw_Chkbox_Onclick() {
		
	var memberPw_ChkboxElement = document.getElementById("memberPw_Chkbox")
	var memberPwElement = document.getElementById("memberPw")
	
	if(memberPw_ChkboxElement.checked) {
		memberPwElement.type = "text"
	}else {
		memberPwElement.type = "password"
	}
}

});
