package com.takeit.model.dto;

import java.io.Serializable;

/**
 * 회원가입 : 일반회원 도메인
 * @author 임우진
 * 
 */
public class Member implements Serializable{	
	
	/**
	 * @param 멤버변수 
	 * memberId : 아이디
	 * memberPw : 비밀번호
	 * name : 이름
	 * mobile : 이메일
	 * entryDate : 생일
	 * zipNo : 우편번호
	 * roadAddrPart1 : 도로명 주소
	 * addrDetail : 상세 주소
	 * point : 적릭금
	 * birth : 생일
	 * grade : 등급
	 * memberLocNo : 회원구역번호
	 * shopLocCode : 상점구역코드
	 */
	private String memberId;
	private String memberPw;
	private String name;
	private String mobile;
	private String email;
	private String entryDate; // TIMESTAMP 형식으로 DB에서 처리할때 TO_CHAR 필요
	private String zipNo;
	private String roadAddrPart1;
	private String addrDetail;
	private int point;
	private String birth;
	private String grade;
	private String memberLocNo;
	private String shopLocCode;
	
	/* 기본 생성자 */
	public Member() {}

	/* 사용자 입력 데이터 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String zipNo,
			String roadAddrPart1, String addrDetail, String birth) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.zipNo = zipNo;
		this.roadAddrPart1 = roadAddrPart1;
		this.addrDetail = addrDetail;
		this.birth = birth;
	}

	/* 전체 데이터 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String zipNo, String roadAddrPart1, String addrDetail, int point, String birth, String grade,
			String memberLocNo, String shopLocCode) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = entryDate;
		this.zipNo = zipNo;
		this.roadAddrPart1 = roadAddrPart1;
		this.addrDetail = addrDetail;
		this.point = point;
		this.birth = birth;
		this.grade = grade;
		this.memberLocNo = memberLocNo;
		this.shopLocCode = shopLocCode;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", entryDate=" + entryDate + ", zipNo=" + zipNo + ", roadAddrPart1="
				+ roadAddrPart1 + ", addrDetail=" + addrDetail + ", point=" + point + ", birth=" + birth + ", grade="
				+ grade + ", memberLocNo=" + memberLocNo + ", shopLocCode=" + shopLocCode + "]";
	}	
}
