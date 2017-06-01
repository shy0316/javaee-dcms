package com.nxdcms.entity;

import java.util.List;

public class PageObject {
	private int pageSize;
	private int curPage;
	private int totalRecord;
	private List list;
	
	public PageObject(int pageSize, int curPage, int totalRecord, List list) {
		super();
		this.pageSize = pageSize;
		this.curPage = curPage;
		this.totalRecord = totalRecord;
		this.list = list;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
