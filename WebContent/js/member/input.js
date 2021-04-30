$(document).ready(function() {
		
	// 아이디
	$("#memberId").focus();
	$("#memberId").on('focus', function() {
		$("#memberId").css({
			'background' : "#E8F0FE"
		});
	});
	$("#memberId").on('focusout', function() {
		var memberId = $("#memberId").val();
		var memberId_Valid = memberId_data(memberId)
		if(memberId_Valid) {
			$('#memberId_result').hide();	
			//$('#memberId_result').show().html("<h6>사용가능한 아이디입니다</h6>");
			$('#memberId_result').css('background','white')
		}else {
			$('#memberId_result').show().html("<h6>최소4 ~ 최대12자리 영문+숫자만 사용가능</h6>");
			$('#memberId_result').css('color','red')
		} 
	});
	
	// 비밀번호
	$("#memberPw").on('focus', function() {
		$("#memberPw").css({
			'background' : "E8F0FE"
		});
	});
	$("#memberPw").on('focusout', function() {
	var memberPw = $("#memberPw").val();
	var memberPw_Valid = memberPw_data(memberPw)
	if(memberPw_Valid) {
		$('#memberId_result').hide();	
		//$('#memberPw_result').show().html("<h6>사용가능한 비밀번호입니다</h6>");
		$('#memberId_result').css('background','white')
		event.preventDefault();
	}else {
		$('#memberPw_result').show().html("<h6>최소  4 ~ 최대 12자리, 영문+숫자+특수문자 필수포함</h6>");
		$('#memberPw_result').css('color','red')
	} });

	// 이름
	$("#name").on('focus', function() {
		$("#name").css({
			'background' : "E8F0FE"
		});
	});
	$("#name").on('blur', function() {
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
	} });
	
	// 휴대폰번호
	$("#mobile").on('focus', function() {
		$("#mobile").css({
			'background' : "E8F0FE"
		});
	});
	$("#mobile").on('blur', function() {
	var mobile = $("#mobile").val();
	var mobile_Valid = mobile_data(mobile)
	if(mobile_Valid) {
		$('#mobile_result').hide();	
		//$('#mobile_result').show().html("<h6>사용가능한 휴대폰번호입니다</h6>");
		//$('#mobile_result').css('color','blue')
		event.preventDefault();
	}else {
		$('#mobile_result').show().html("<h6>'-' 포함 13자리만 입력 가능 하도록함</h6>");
		$('#mobile_result').css('color','red')
	} });

	// 이메일
	$("#email").on('focus', function() {
		$("#email").css({
			'background' : "E8F0FE"
		});
	});
	$("#email").on('blur', function() {
	var email = $("#email").val();
	var email_Valid = email_data(email)
	if(email_Valid) {
		$('#email_result').hide();	
		//$('#email_result').show().html("사용가능한 이메일입니다");
		//$('#email_result').css('color','blue')
		event.preventDefault();	
	}else {
		$('#email_result').show().html("<h6>최소 4 ~ 최대 12자리, 영문+숫자만 사용가능</h6>");
		$('#email_result').css('color','red')
	}});
	
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


