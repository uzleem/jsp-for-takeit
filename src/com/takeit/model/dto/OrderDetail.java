package com.takeit.model.dto;

public class OrderDetail {
	private String itemNo;
	private String itemName;
	private int itemQty;
	private int itemPayPrice;
	private String itemImg;
	

	public OrderDetail() {
	}

	public OrderDetail(String itemNo, String itemName, int itemQty, int itemPayPrice, String itemImg) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.itemPayPrice = itemPayPrice;
		this.itemImg = itemImg;
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
