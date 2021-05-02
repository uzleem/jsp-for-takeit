package com.takeit.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/** 
 * <pre>
 * 객체 생성없이 사용하기 위한 공통기능 유틸클래스
 * </pre>

 */
public class Utility {

	/* 랜덤값 반환 메서드 */
	public static String getSecureString(int length, boolean isUpper) {
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		String secureCode = "";
		for (int index = 0; index < length; index++) {
			if (extractNo.nextBoolean()) {
				secureCode += extractNo.nextInt(10); // 0 ~ 9 숫자
			} else {
				if (isUpper) {	// 영문 대문자
					secureCode += (char)(extractNo.nextInt(26) + 65);
				} else {		// 영문 소문자
					secureCode += (char)(extractNo.nextInt(26) + 97);
				}
			}
		}
		
		return secureCode;
	}
	
	/**
	 * 현재날짜 반환 
	 * @return 현재 기본형식(년도4-월2-일2) 날짜 
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
	}
	
	public static String getCurrentDate(String pattern) {
		return getCurrentDate(pattern, Locale.KOREA);
	}
	
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * <pre>
	 * 보안문자 숫자형식 반환
	 * </pre>
	 * @return 보안문자 숫자6자리 반환
	 */
	public static String getSecureNumber() {
		return getSecureNumber(6);
	}
	
	public static String getSecureNumber(int length) {
		StringBuilder secureNumber = new StringBuilder();
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		for (int index = 0; index < length; index++) {
			secureNumber.append(random.nextInt(10));
		}
		return secureNumber.toString();
	}
	
	/**
	 * <pre>
	 * 보안문자 숫자+영문조합 반환
	 * </pre>
	 * @return 기본 숫자+영문조합 6자리 
	 */
	public static String getSecureNumberAndString() {
		return getSecureNumberAndString(6, true);
	}
	
	public static String getSecureNumberAndString(int length) {
		return getSecureNumberAndString(length, true);
	}

	/**
	 * <pre>
	 * 보안문자 숫자+영문조합 반환
	 * </pre>
	 * @param length 길이
	 * @param isUpper 보안영문 대소문자 
	 * @return 지정한 길의 영문대소문자+숫자결합 
	 */
	public static String getSecureNumberAndString(int length, boolean isUpper) {
		StringBuilder secureNumber = new StringBuilder();
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		for (int index = 0; index < length; index++) {
			if (random.nextBoolean()) {
				secureNumber.append(random.nextInt(10));
			} else {
				if (isUpper) {
					secureNumber.append((char)(random.nextInt(26) + 65));
				} else {
					secureNumber.append((char)(random.nextInt(26) + 97));
				}
			}
		}
		return secureNumber.toString();
	}	
	
	public static void main(String[] args) {
		System.out.println("\n현재날짜");
		System.out.println(Utility.getCurrentDate());
		System.out.println(Utility.getCurrentDate("yyyy.MM.dd"));
		System.out.println(Utility.getCurrentDate("MM.dd"));
		System.out.println(Utility.getCurrentDate("HH:mm:ss"));
		System.out.println(Utility.getCurrentDate("[a]hh:mm:ss"));
		System.out.println(Utility.getCurrentDate("[a]hh:mm:ss", Locale.US));
		System.out.println(Utility.getCurrentDate("[a]hh:mm:ss", Locale.CHINA));
		
		System.out.println("\n보안문자 : 숫자형식");
		System.out.println(Utility.getSecureNumber());
		System.out.println(Utility.getSecureNumber(6));
		System.out.println(Utility.getSecureNumber(8));
		System.out.println(Utility.getSecureNumber(12));
		
		System.out.println("\n보안문자 : 숫자 + 대문자");
		System.out.println(Utility.getSecureNumberAndString());
		System.out.println(Utility.getSecureNumberAndString(4));
		System.out.println(Utility.getSecureNumberAndString(10));
		
		System.out.println("\n보안문자 : 숫자 + 대.소문자");
		System.out.println(Utility.getSecureNumberAndString(10, true));
		System.out.println(Utility.getSecureNumberAndString(12, false));
	}
}
