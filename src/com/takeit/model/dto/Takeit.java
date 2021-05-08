package com.takeit.model.dto;

/**
 * 잇거래 도메인 클래스
 * 
 * @author 김태경
 */
public class Takeit {
	private String takeitNo;
	private String shopLocCode;
	private String shopLocName;
	private String memberLocNo;
	private int takeitPrice;
	private int takeitCurrPrice;
	private String takeitDate;
	private String takeitEndDate;
	private String takeitAlive;

	public Takeit() {
	}

	public String getTakeitNo() {
		return takeitNo;
	}

	public void setTakeitNo(String takeitNo) {
		this.takeitNo = takeitNo;
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

	public String getMemberLocNo() {
		return memberLocNo;
	}

	public void setMemberLocNo(String memberLocNo) {
		this.memberLocNo = memberLocNo;
	}

	public int getTakeitPrice() {
		return takeitPrice;
	}

	public void setTakeitPrice(int takeitPrice) {
		this.takeitPrice = takeitPrice;
	}

	public int getTakeitCurrPrice() {
		return takeitCurrPrice;
	}

	public void setTakeitCurrPrice(int takeitCurrPrice) {
		this.takeitCurrPrice = takeitCurrPrice;
	}

	public String getTakeitDate() {
		return takeitDate;
	}

	public void setTakeitDate(String takeitDate) {
		this.takeitDate = takeitDate;
	}

	public String getTakeitEndDate() {
		return takeitEndDate;
	}

	public void setTakeitEndDate(String takeitEndDate) {
		this.takeitEndDate = takeitEndDate;
	}

	public String getTakeitAlive() {
		return takeitAlive;
	}

	public void setTakeitAlive(String takeitAlive) {
		this.takeitAlive = takeitAlive;
	}

}
