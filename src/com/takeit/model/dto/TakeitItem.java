package com.takeit.model.dto;

import java.io.Serializable;

/**
 * 잇거래상품 도메인 클래스
 * @author 김태경
 */
public class TakeitItem extends Item implements Serializable {
	
	/**잇거래번호:필수*/
	private String takeitNo;
	
	/**모집금액:필수입력
	 * 모집금액 :100만원
	 */
	private int takeitPrice;
	
	/**현재 모집된 금액:필수*/
	private int takeitCurrPrice;
	
	/**모집시작일자:필수
	 * 시작일자 :takeit등록일자 
	 */
	private String takeitDate;
	
	/**고객평점:필수
	 * DEFAULT 5.0
	 */
	private double takeitCustScore;
	
	/**잇거래진행여부:필수
	 * DEFAULT 'T'
	 */
	private String takeitAlive;
	
	/**회원구역번호:필수
	 * 구역번호:29,30
	 */
	private String memberLocNo;
	
	/**상점구역코드:필수
	 * 상점구역코드&회원구역 코드가 일치하면 잇거래 구매가능
	 */
	private String shopLocCode;
	
	/**상점구역이름:필수
	 * 구역이름:AA,BB
	 */
	private String shopLocName;
	
	/** 기본 생성자 */
	public TakeitItem() {}
	
	public TakeitItem(String takeitNo, int takeitPrice, int takeitCurrPrice, String takeitDate, double takeitCustScore,
			String takeitAlive, String memberLocNo, String shopLocCode) {
		super();
		this.takeitNo = takeitNo;
		this.takeitPrice = takeitPrice;
		this.takeitCurrPrice = takeitCurrPrice;
		this.takeitDate = takeitDate;
		this.takeitCustScore = takeitCustScore;
		this.takeitAlive = takeitAlive;
		this.memberLocNo = memberLocNo;
		this.shopLocCode = shopLocCode;
	}

	
	public String getShopLocName() {
		return shopLocName;
	}

	public void setShopLocName(String shopLocName) {
		this.shopLocName = shopLocName;
	}

	public String getTakeitDate() {
		return takeitDate;
	}

	public void setTakeitDate(String takeitDate) {
		this.takeitDate = takeitDate;
	}

	public String getTakeitNo() {
		return takeitNo;
	}

	public void setTakeitNo(String takeitNo) {
		this.takeitNo = takeitNo;
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

	public double getTakeitCustScore() {
		return takeitCustScore;
	}

	public void setTakeitCustScore(double takeitCustScore) {
		this.takeitCustScore = takeitCustScore;
	}

	public String getTakeitAlive() {
		return takeitAlive;
	}

	public void setTakeitAlive(String takeitAlive) {
		this.takeitAlive = takeitAlive;
	}

	public String getMemberLocNo() {
		return memberLocNo;
	}

	public void setMemberLocNo(String memberLocNo) {
		this.memberLocNo = memberLocNo;
	}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(takeitNo);
		builder.append(", ");
		builder.append(takeitPrice);
		builder.append(", ");
		builder.append(takeitCurrPrice);
		builder.append(", ");
		builder.append(takeitDate);
		builder.append(", ");
		builder.append(takeitCustScore);
		builder.append(", ");
		builder.append(takeitAlive);
		builder.append(", ");
		builder.append(memberLocNo);
		builder.append(", ");
		builder.append(shopLocCode);
		return builder.toString();
	}
}
