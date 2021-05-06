$(document).ready(function() {
/* 회원가입 폼 : 라디오 버튼 */
/* 일반 회원가입 버튼 이벤트 */
$("#normalInputFrom").click(function() {
	 location.href = "/takeit/member/memberInput.jsp"
});

/* 판매자 회원가입 버튼 이벤트 */
$("#sellerInputForm").click(function() {
	location.href = "/takeit/seller/controller?action=sellerInputForm"
});
/* 일반회원 시작 */
/* 아이디 포커스 */
$("#memberId").on('focus', function() {
	$("#memberId").css({
		'background' : "#E8F0FE"
	});
		$('#memberIdResult1').show().html("* 6~20자 영문 혹은 영문+숫자를 조합<br>");
		$('#memberIdResult2').show().html("* 아이디 중복확인");
});	
/* 아이디 포커스 아웃 */
$("#memberId").on('focusout', function() {
	$("#memberId").css({
		'background' : "white"
	});
});
/* 아이디 키다운 */
$("#memberId").on('keyup', function() {
	var memberId = $("#memberId").val();
	var memberId_Valid = memberId_data(memberId)
	if(memberId_Valid) {
		$('#memberIdResult1').show().html("o 6~20자 영문 혹은 영문+숫자를 조합<br>");
		$('#memberIdResult1').css('color','#0F851A')
	}else {
		$('#memberIdResult1').show().html("x 6~20자 영문 혹은 영문+숫자를 조합<br>");
		$('#memberIdResult1').css('color','#B3575A')
	}
});
/* 아이디 : 6~20자 영문+숫자를 조합, 중복확인*/
function memberId_data(take) {
 	var pattern = new RegExp(/^[a-z]+[a-z0-9]{5,19}$/);
	//var pattern = new RegExp(/^[가-힣]{2,6}$/); 
  	return pattern.test(take);
}
/* 비밀번호 포커스 */
$("#memberPw").on('focus', function() {
	$("#memberPw").css({
		'background' : "#E8F0FE"
	});
	$('#memberPwResult1').show().html("* 8~20자 영문대소문자+숫자 조합");
});	
/* 비밀번호 포커스 아웃 */
$("#memberPw").on('focusout', function() {
	$("#memberPw").css({
		'background' : "white"
	});
});
/* 비밀번호 키다운 */
$("#memberPw").on('keyup', function() {
	var memberPw = $("#memberPw").val();
	var memberPw_Valid = memberPw_data(memberPw)
	if(memberPw_Valid) {
		$('#memberPwResult1').show().html("o 8~20자 영문대소문자+숫자+특수문자 조합");
		$('#memberPwResult1').css('color','#0F851A')
	}else {
		$('#memberPwResult1').show().html("x 8~20자 영문대소문자+숫자+특수문자 조합");
		$('#memberPwResult1').css('color','#B3575A')
	} 
});
/* 비밀번호 : 8~20자 영대소문자+숫자 조합 */
 function memberPw_data(take) {
 	var pattern = new RegExp(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/);

 	return pattern.test(take);
}
/* 비밀번호 확인 포커스 */
$("#pwChk").on('focus', function() {
	$("#pwChk").css({
		'background' : "#E8F0FE"
	});
	$('#pwChkResult1').show().html("* 동일한 비밀번호를 입력해주세요.");
});	
/* 비밀번호 확인 포커스 아웃 */
$("#pwChk").on('focusout', function() {
	$("#pwChk").css({
		'background' : "white"
	});
});
/* 비밀번호확인 키다운 */
$("#pwChk").on('keyup', function() {
	 var memberPw = $("#memberPw").val();
	 var pwChk = $("#pwChk").val();
	 
	 if(memberPw == pwChk) {
			$('#pwChkResult1').show().html("o 동일한 비밀번호를 입력해주세요.");
			$('#pwChkResult1').css('color','#0F851A')
	 }else {
			$('#pwChkResult1').show().html("x 동일한 비밀번호를 입력해주세요.");
			$('#pwChkResult1').css('color','#B3575A')
	 }
});

/* 비밀번호 표시 */
function pwCheckbox_onclick() {
		
	var pwCheckboxElement = document.getElementById("pwCheckbox")
	var memberPwElement = document.getElementById("memberPw")
	var pwChk_Element = document.getElementById("pwChk")
	
	if(pwCheckboxElement.checked) {
		memberPwElement.type = "text"
		pwChk_Element.type = "text"
	}else {
		memberPwElement.type = "password"
		pwChk_Element.type = "password"
	}
}	

/* 이름 포커스 */
$("#name").on('focus', function() {
	$("#name").css({
		'background' : "#E8F0FE"
	});
	$('#nameResult1').show().html("* 2~6자 한글입력");
});	
/* 이름 포커스 아웃 */
$("#name").on('focusout', function() {
	$("#name").css({
		'background' : "white"
	});
});
/* 이름 키다운 */
$("#name").on('keyup', function() {
	var name = $("#name").val();
	var name_Valid = name_data(name)
	if(name_Valid) {
		$('#nameResult1').show().html("o 2~6자 한글입력");
		$('#nameResult1').css('color','#0F851A')
	}else {
		$('#nameResult1').show().html("x 2~6자 한글입력");
		$('#nameResult1').css('color','#B3575A')
	} 
});
/* 이름 : 최소 2 ~ 최대 6자리 */
 function name_data(take) {
 	var pattern = new RegExp(/^[가-힣]{2,6}$/); 
 	return pattern.test(take);
}

/* 휴대폰 포커스 */
$("#mobile").on('focus', function() {
	$("#mobile").css({
		'background' : "#E8F0FE"
	});
	$('#mobileResult1').show().html("* -포함 13자리를 입력하세요.");
});	
/* 휴대폰 포커스 아웃 */
$("#mobile").on('focusout', function() {
	$("#mobile").css({
		'background' : "white"
	});
});
/* 휴대폰 키다운 */
$("#mobile").on('keyup', function() {
	var mobile = $("#mobile").val();
	var mobile_Valid = mobile_data(mobile)
	if(mobile_Valid) {
		$('#mobileResult1').show().html("o -포함 13자리를 입력하세요.");
		$('#mobileResult1').css('color','#0F851A')
	}else {
		$('#mobileResult1').show().html("x -포함 13자리를 입력하세요.");
		$('#mobileResult1').css('color','#B3575A')
	} 
});
/* 휴대폰  : 010-0000-0000 형식에 맞춰 입력 */
 function mobile_data(take) {
 	var pattern = new RegExp(/^\d{3}-\d{4}-\d{4}$/); 
 	return pattern.test(take);
}

/* 인증번호 포커스 */
$("#mobileNum").on('focus', function() {
	$("#mobileNum").css({
		'background' : "#E8F0FE"
	});
	$('#mobileNumResult1').show().html("* 인증번호를 받아주세요.");
});	
/* 인증번호 포커스 아웃 */
$("#mobileNum").on('focusout', function() {
	$("#mobileNum").css({
		'background' : "white"
	});
});

/* 이메일 포커스 */
$("#email").on('focus', function() {
	$("#email").css({
		'background' : "#E8F0FE"
	});
	$('#emailNumResult1').show().html("* 예:takeit@take.com<br>");
	$('#emailNumResult2').show().html("* 이메일 중복확인");
});	
/* 이메일 포커스 아웃 */
$("#email").on('focusout', function() {
	$("#email").css({
		'background' : "white"
	});
});
/* 이메일 키다운 */
$("#email").on('keyup', function() {
	var email = $("#email").val();
	var email_Valid = email_data(email)
	if(email_Valid) {
		$('#emailNumResult1').show().html("o 예:takeit@take.com<br>");
		$('#emailNumResult1').css('color','#0F851A')
	}else {
		$('#emailNumResult1').show().html("x 예:takeit@take.com<br>");
		$('#emailNumResult1').css('color','#B3575A')
	} 
});
/* 이메일 : takeit@takeit.com 형식에 맞게 입력 */
 function email_data(take) {
 	var pattern = new RegExp(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i)
 	return pattern.test(take);
}

/* 우편번호 포커스 */
$("#postNo").on('focus', function() {
	$("#postNo").css({
		'background' : "#E8F0FE"
	});
});
/* 우편번호 포커스 아웃 */
$("#postNo").on('focusout', function() {
	$("#postNo").css({
		'background' : "white"
	});
});

/* 주소 포커스 */
$("#address").on('focus', function() {
	$("#address").css({
		'background' : "#E8F0FE"
	});
});
/* 주소 포커스 아웃 */
$("#address").on('focusout', function() {
	$("#address").css({
		'background' : "white"
	});
});

/* 상세주소 포커스 */
$("#addressDetail").on('focus', function() {
	$("#addressDetail").css({
		'background' : "#E8F0FE"
	});
});
/* 상세주소 포커스 아웃 */
$("#addressDetail").on('focusout', function() {
	$("#addressDetail").css({
		'background' : "white"
	});
});

/* 생년월일 포커스 */
$("#brith").on('focus', function() {
	$("#brith").css({
		'background' : "#E8F0FE"
	});
});
/* 생년월일 포커스 아웃 */
$("#brith").on('focusout', function() {
	$("#brith").css({
		'background' : "white"
	});
});
/* 판매자회원 시작*/
/* 아이디 포커스 */
$("#sellerId").on('focus', function() {
	$("#sellerId").css({
		'background' : "#E8F0FE"
	});
	$('#sellerIdResult1').show().html("* 6~20자 영문 혹은  영문+숫자를 조합<br>");
	$('#sellerIdResult2').show().html("* 아이디 중복확인");
});
/* 아이디 포커스 아웃*/
$("#sellerId").on('focusout', function() {
	$("#sellerId").css({
		'background' : "white"
	});
});
/* 아이디 키다운 */
$("#sellerId").on('keyup', function() {
	var sellerId = $("#sellerId").val();
	var sellerId_Valid = sellerId_data(sellerId)
	if(sellerId_Valid) {
		$('#sellerIdResult1').show().html("o 6~20자 영문 혹은 영문+숫자를 조합<br>");
		$('#sellerIdResult1').css('color','#0F851A')
	}else {
		$('#sellerIdResult1').show().html("x 6~20자 영문 혹은 영문+숫자를 조합<br>");
		$('#sellerIdResult1').css('color','#B3575A')
	} 
});
/* 아이디 : 6~20자 영문+숫자를 조합, 중복확인*/
function sellerId_data(take) {
 	var pattern = new RegExp(/^[a-z]+[a-z0-9]{5,19}$/g);
 	return pattern.test(take);
}

/* 비밀번호 포커스 */
$("#sellerPw").on('focus', function() {
	$("#sellerPw").css({
		'background' : "#E8F0FE"
	});
	$('#sellerPwResult1').show().html("* 8~20자 영문대소문자+숫자 조합");
});
/* 비밀번호 포커스 아웃*/
$("#sellerPw").on('focusout', function() {
	$("#sellerPw").css({
		'background' : "white"
	});
});
/* 비밀번호 키다운 */
$("#sellerPw").on('keyup', function() {
	var sellerPw = $("#sellerPw").val();
	var sellerPw_Valid = sellerPw_data(sellerPw)
	if(sellerPw_Valid) {
		$('#sellerPwResult1').show().html("o 8~20자 영문대소문자+숫자 조합");
		$('#sellerPwResult1').css('color','#0F851A')
	}else {
		$('#sellerPwResult1').show().html("x 8~20자 영문대소문자+숫자 조합");
		$('#sellerPwResult1').css('color','#B3575A')
	} 
});
/* 비밀번호 : 8~20자 영대소문자+숫자 조합 */
 function sellerPw_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
}
/* 비밀번호확인 포커스 */
$("#sellerPw_chk").on('focus', function() {
	$("#sellerPw_chk").css({
		'background' : "#E8F0FE"
	});
});
/* 비밀번호확인 포커스 아웃*/
$("#sellerPw_chk").on('focusout', function() {
	$("#sellerPw_chk").css({
		'background' : "white"
	});
});

/* 상점구역 포커스 */
$("#shopLocCode").on('focus', function() {
	$("#shopLocCode").css({
		'background' : "#E8F0FE"
	});
});
/* 상점구역 포커스 */
$("#shopLocCode").on('focusout', function() {
	$("#shopLocCode").css({
		'background' : "white"
	});
});

/* 사업자등록번호 포커스 */
$("#sellerNo").on('focus', function() {
	$("#sellerNo").css({
		'background' : "#E8F0FE"
	});
	$('#sellerNoResult1').show().html("* -포함 12자리를 입력하세요.");
});
/* 사업자등록번호 포커스 아웃*/
$("#sellerNo").on('focusout', function() {
	$("#sellerNo").css({
		'background' : "white"
	});
});
/* 사업자등록번호 키다운 */
$("#sellerNo").on('keyup', function() {
	var sellerNo = $("#sellerNo").val();
	var sellerNo_Valid = sellerNo_data(sellerNo)
	if(sellerNo_Valid) {
		$('#sellerNoResult1').show().html("o -포함 12자리를 입력하세요.");
		$('#sellerNoResult1').css('color','#0F851A')
	}else {
		$('#sellerNoResult1').show().html("x -포함 12자리를 입력하세요.");
		$('#sellerNoResult1').css('color','#B3575A')
	} 
});
/* 비밀번호 : 8~20자 영대소문자+숫자 조합 */
 function sellerNo_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
}
 
/* 싱잠연락처 포커스 */
$("#shopMobile").on('focus', function() {
	$("#shopMobile").css({
		'background' : "#E8F0FE"
	});
	$('#shopMobileResult1').show().html("* 형식에 맞게 입력하세요");
});
/* 싱잠연락처 포커스 아웃*/
$("#shopMobile").on('focusout', function() {
	$("#shopMobile").css({
		'background' : "white"
	});
});
/* 싱잠연락처 키다운 */
$("#shopMobile").on('keyup', function() {
	var shopMobile = $("#shopMobile").val();
	var shopMobile_Valid = shopMobile_data(shopMobile)
	if(shopMobile_Valid) {
		$('#shopMobileResult1').show().html("o 8~20자 영문대소문자+숫자 조합");
		$('#shopMobileResult1').css('color','#0F851A')
	}else {
		$('#shopMobileResult1').show().html("x 8~20자 영문대소문자+숫자 조합");
		$('#shopMobileResult1').css('color','#B3575A')
	} 
});
/* 비밀번호 : 8~20자 영대소문자+숫자 조합 */
 function shopMobile_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
}
/* 싱잠명 포커스 */
$("#shopName").on('focus', function() {
	$("#shopName").css({
		'background' : "#E8F0FE"
	});
	$('#shopNameResult1').show().html("* 형식에 맞게 입력하세요");
});
/* 상점명 포커스 아웃*/
$("#shopName").on('focusout', function() {
	$("#shopName").css({
		'background' : "white"
	});
});
/* 상점명 키다운 */
$("#shopName").on('keyup', function() {
	var shopName = $("#shopName").val();
	var shopName_Valid = shopName_data(shopName)
	if(shopName_Valid) {
		$('#shopNameResult1').show().html("o 8~20자 영문대소문자+숫자 조합");
		$('#shopNameResult1').css('color','#0F851A')
	}else {
		$('#shopNameResult1').show().html("x 8~20자 영문대소문자+숫자 조합");
		$('#shopNameResult1').css('color','#B3575A')
	} 
});
/* 비밀번호 : 8~20자 영대소문자+숫자 조합 */
 function shopName_data(take) {
 	var pattern = new RegExp(/^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/);
 	return pattern.test(take);
}
/* 카카오톡아이디 포커스 */
$("#shopKakaoId").on('focus', function() {
	$("#shopKakaoId").css({
		'background' : "#E8F0FE"
	});
});
/* 카카오톡아이디 포커스 아웃*/
$("#shopKakaoId").on('focusout', function() {
	$("#shopKakaoId").css({
		'background' : "white"
	});
});

/* 상점이미지 포커스 */
$("#shopImg").on('focus', function() {
	$("#shopImg").css({
		'background' : "#E8F0FE"
	});
});
/* 상점이미지 포커스 아웃*/
$("#shopImg").on('focusout', function() {
	$("#shopImg").css({
		'background' : "white"
	});
});
/* 상점카테고리번호 포커스 */
$("#shopCategoryNo").on('focus', function() {
	$("#shopCategoryNo").css({
		'background' : "#E8F0FE"
	});
});
/* 상점카테고리번호 포커스 아웃*/
$("#shopCategoryNo").on('focusout', function() {
	$("#shopCategoryNo").css({
		'background' : "white"
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

/*$("#normalSubmit").click(function() {
	if(memberId_Valid) { 
		alert("확인")
		return true;
	}else{
		$("#memberId").focus;
		alert("확인")
		return false;
	}
}); */

}); //끝괄호
