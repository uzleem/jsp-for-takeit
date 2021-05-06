package com.takeit.model.dto;

/**
 * 잇거래 도메인 클래스
 * @author 김태경
 */
public class Takeit {
	private String shopLocCode;
	private String takeitPrice;
	
	public Takeit() {}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	public String getTakeitPrice() {
		return takeitPrice;
	}

	public void setTakeitPrice(String takeitPrice) {
		this.takeitPrice = takeitPrice;
	}
	
}
