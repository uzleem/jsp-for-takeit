package com.takeit.model.dto;

import java.io.Serializable;

/**
 * 주문상세 도메인 클래스
 * 
 * @author 김태경
 */
public class OrderDetail implements Serializable {
	/** 주문 상품 번호, 사용자 입력, 필수 */
	private String itemNo;
	/** 상품명, itemNo로 접근, 필수 */
	private String itemName;
	/** 주문수량, 사용자 입력, 필수 */
	private int itemQty;
	/** 주문 결제금액, 시스템 계산, 필수 */
	private int itemPayPrice;
	/** 상품이미지, itemNo로 접근, 필수 */
	private String itemImg;
	/** 상품 잇거래여부, itemNo로 접근 , 필수 */
	private String itemTakeit;
	/** 상품 판매자 아이디, itemNo로 접근, 필수 */
	private String sellerId;


	public OrderDetail() {
	}

	/***
	 * @param itemNo		주문 상품번호
	 * @param itemName		주문 상품명
	 * @param itemQty		주문 상품수량
	 * @param itemPayPrice	주문 결제금액
	 * @param itemImg		주문 상품 이미지
	 */
	public OrderDetail(String itemNo, String itemName, int itemQty, int itemPayPrice, String itemImg) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.itemPayPrice = itemPayPrice;
		this.itemImg = itemImg;
	}

	
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getItemTakeit() {
		return itemTakeit;
	}

	public void setItemTakeit(String itemTakeit) {
		this.itemTakeit = itemTakeit;
	}

	
	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public int getItemPayPrice() {
		return itemPayPrice;
	}

	public void setItemPayPrice(int itemPayPrice) {
		this.itemPayPrice = itemPayPrice;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

}
