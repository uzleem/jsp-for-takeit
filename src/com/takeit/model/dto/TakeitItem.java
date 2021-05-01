package com.takeit.model.dto;

import java.io.Serializable;

//public class TakeitItem extends Item implements Serializable { 상속처리할것
public class TakeitItem implements Serializable {
	private String takeitNo;
	private int takeitPrice;
	private int takeitCurrPrice;
	private double takeitCustScore;
	private String takeitAlive; // boolean으로 할지 결정해야함 문자열위주로?
	private String memberLocNo;
	private String shopLocCode;
	//남은시간을 ajax로 처리하려면 모집일자를 통해서 서버를 통해 받아서 나타낸다 setInterval(ajax)함수를  이용하므로 도메인은 넣지않음  
	
}
