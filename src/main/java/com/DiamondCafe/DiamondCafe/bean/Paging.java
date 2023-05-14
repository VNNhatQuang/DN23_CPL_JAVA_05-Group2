package com.DiamondCafe.DiamondCafe.bean;

public class Paging {
	public int pageIndex;
	public int pageSize;
	public int rowCount;
	public int pageCount;
	public String searchValue = "";
	
	public Paging() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paging(int pageIndex, int pageSize, int rowCount, String searchValue) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.searchValue = searchValue;
		
		if (this.pageSize == 0)
			this.pageCount = 1;
		this.pageCount = rowCount / this.pageSize;
		if (rowCount % this.pageSize > 0)
			this.pageCount++;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	
}
