package com.takeit.model.dto;

/**
 * 배송상태 도메인 클래스
 * @author 김태경
 */
public class Shipping {
	
	/** 
	 * 배송상태코드 : 필수데이터, 중복불가 
	 * (O-GET, I-GET, I-MOVE, S-ARR, S-GO, DONE)
	 */
	private String shipStatusCode;
	
	/**
	 * 배송상태이름 : 필수데이터 
	 * (주문접수, 상품인수, 상품이동중, 배달지도착, 배달출발, 배달완료)
	 */
	private String shipStatus;
	
	public Shipping() {}

	public String getShipStatusCode() {
		return shipStatusCode;
	}

	public void setShipStatusCode(String shipStatusCode) {
		this.shipStatusCode = shipStatusCode;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
	
}
