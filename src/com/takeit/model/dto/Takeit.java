package com.takeit.model.dto;

/**
 * 잇거래 도메인 클래스
 * 
 * @author 김태경
 */
public class Takeit {
	
	/**잇거래번호:필수입력*/
	private String takeitNo;
	
	/**상점구역코드:필수*/
	private String shopLocCode;
	
	/**상점명:필수*/
	private String shopLocName;
	
	/**회원구역번호:(구역번호:29,30),필수입력 */
	private String memberLocNo;
	
	/**모집금액:모집금액 :100만원,필수입력*/
	private int takeitPrice;
	
	/**현재 모집된 금액:필수*/
	private int takeitCurrPrice;
	
	/**모집시작일자:takeit등록일자 */
	private String takeitDate;
	
	/**모집마감일자:100만원 충족 or 등록후 7일 경과,필수입력 */
	private String takeitEndDate;
	
	/**잇거래진행여부:DEFAULT 'T',필수입력*/
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
