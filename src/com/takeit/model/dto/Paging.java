package com.takeit.model.dto;

public class Paging {
	private int where = 1;		// 내가 클릭한 페이지 번호
	private int go;				// 현재 페이지 번호
	private int gogroup;		// 그룹페이지
	private int wheregroup = 1; // 페이지 그룹
	private int startRowNo;		// 조회 시작 번호
	private int endRowNo;		// 조회 마지막 번호
	private int finalPageNo = 5;// 마지막 페이지 번호
	private int startPageNo;	// 시작 페이지
	private int endPageNo;		// 끝 페이지
	private int totalCount;		// 게시글 전체 수
	private int maxrows = 5;	// 한번에 보여질 레코드 수
	private int nextGroup;		// 다음 페이지 그룹
	private int priorGroup;		// 이전 페이지 그룹
	private int totalGroup;		// 전체 페이지 그룹
	private int totalPages;		// 전체 페이지 수
	
	public Paging() {}

	public int getWhere() {
		return where;
	}

	public void setWhere(int where) {
		this.where = where;
	}

	public int getGo() {
		return go;
	}

	public void setGo(int go) {
		this.go = go;
	}

	public int getGogroup() {
		return gogroup;
	}

	public void setGogroup(int gogroup) {
		this.gogroup = gogroup;
	}

	public int getWheregroup() {
		return wheregroup;
	}

	public void setWheregroup(int wheregroup) {
		this.wheregroup = wheregroup;
	}

	public int getStartRowNo() {
		return startRowNo;
	}

	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}

	public int getEndRowNo() {
		return endRowNo;
	}

	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getMaxrows() {
		return maxrows;
	}

	public void setMaxrows(int maxrows) {
		this.maxrows = maxrows;
	}

	public int getNextGroup() {
		return nextGroup;
	}

	public void setNextGroup(int nextGroup) {
		this.nextGroup = nextGroup;
	}

	public int getPriorGroup() {
		return priorGroup;
	}

	public void setPriorGroup(int priorGroup) {
		this.priorGroup = priorGroup;
	}

	public int getTotalGroup() {
		return totalGroup;
	}

	public void setTotalGroup(int totalGroup) {
		this.totalGroup = totalGroup;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		this.makePaging();
	}

	private void makePaging() {
		if(this.totalCount == 0 ) return;				//전체 레코드 수가 0 이면 반환
		if(this.go == 0) { this.setGo(1); }				// go값이 처음에 0인 경우 오류 발생하여 1로 초기화
		
		// [1][2][3] 등 페이지 계산
		if(this.getGo() != 0) {
			this.where = this.getGo();
			this.wheregroup = (where - 1) / finalPageNo + 1;
			this.startPageNo = (wheregroup - 1) * finalPageNo + 1;
			this.endPageNo = startPageNo + finalPageNo - 1;
		}
		
		// 그룹 페이지 계산
		if(this.getGogroup() != 0) {
			this.wheregroup = this.getGogroup();
			this.startPageNo = ((wheregroup - 1) * finalPageNo + 1);
			this.where = startPageNo;
			this.endPageNo = startPageNo + finalPageNo - 1;
		}
		
		// 전체 페이지 계산
		this.totalPages = (this.totalCount - 1) / this.finalPageNo + 1;
		
		int startPage = this.startPageNo;
		int endPage = this.endPageNo;
		
		//마지막 페이지 > 전체 페이지? 전체 페이지를 마지막 페이지에 대입
		if(endPage > this.totalPages) {
			endPage = this.totalPages;
		}
		
		// 시작페이지 & 마지막 페이지
		this.setStartPageNo(startPage);
		this.setEndPageNo(endPage);
		
		//다음그룹 & 이전그룹
		this.setNextGroup(wheregroup + 1);
		this.setPriorGroup(wheregroup - 1);
		
		// 조회 시작 row, 조회 끝 row
		int startRow = ((where - 1) * maxrows);
		int endRow = startRow + maxrows - 1;
		if(endRow >= totalCount) {
			endRow = totalCount -1;
		}
		setStartRowNo(startRow);
		setEndRowNo(endRow);
		
		this.totalGroup = (this.totalPages - 1) / this.finalPageNo + 1;
		if (this.endPageNo > this.totalPages) {
			this.endPageNo = this.totalPages;
		}
		
	}
	
	
			
}
