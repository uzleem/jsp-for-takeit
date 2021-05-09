package com.takeit.model.dto;

import java.io.Serializable;

/**
 * 상점구역 도메인 클래스
 * @author 김태경
 */
public class ShopLoc implements Serializable{
	
	/* 상점구역코드 : 필수데이터, 중복불가 */
	private String shopLocCode;
	
	/* 상점구역이름 : 필수데이터 */
	private String shopLocName;
	
	/* 위도 : 필수데이터 */
	private String shopLocLat;
	
	/* 경도 : 필수데이터 */
	private String shopLocLng;
	
	public ShopLoc() {	}

	public ShopLoc(String shopLocCode, String shopLocName, String shopLocLat, String shopLocLng) {
		super();
		this.shopLocCode = shopLocCode;
		this.shopLocName = shopLocName;
		this.shopLocLat = shopLocLat;
		this.shopLocLng = shopLocLng;
	}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	public String getShopLocName() {
		return shopLocName;
	}

	public void setShopLocName(String shopLocName) {
		this.shopLocName = shopLocName;
	}

	public String getShopLocLat() {
		return shopLocLat;
	}

	public void setShopLocLat(String shopLocLat) {
		this.shopLocLat = shopLocLat;
	}

	public String getShopLocLng() {
		return shopLocLng;
	}

	public void setShopLocLng(String shopLocLng) {
		this.shopLocLng = shopLocLng;
	}
	
	
}
