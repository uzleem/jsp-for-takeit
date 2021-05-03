package com.takeit.model.dto;

public class Cart {

	private String memberId;
	private String itemNo;
	private String itemName;
	private String sellerId;
	private String sellerName;
	private int cartItemQty;
	private int totalPrice;
	
	public Cart() {}

	/**장바구니 등록*/
	public Cart(String memberId, String itemNo, int cartItemQty) {
		super();
		this.memberId = memberId;
		this.itemNo = itemNo;
		this.cartItemQty = cartItemQty;
	}

	public Cart(String itemName, String sellerName, int cartItemQty, int totalPrice) {
		super();
		this.itemName = itemName;
		this.sellerName = sellerName;
		this.cartItemQty = cartItemQty;
		this.totalPrice = totalPrice;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getCartItemQty() {
		return cartItemQty;
	}

	public void setCartItemQty(int cartItemQty) {
		this.cartItemQty = cartItemQty;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(itemNo);
		builder.append(", ");
		builder.append(itemName);
		builder.append(", ");
		builder.append(sellerId);
		builder.append(", ");
		builder.append(sellerName);
		builder.append(", ");
		builder.append(cartItemQty);
		builder.append(", ");
		builder.append(totalPrice);
		return builder.toString();
	}
	
	
	
	
}
