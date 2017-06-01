package com.nxdcms.dao.impl;

public class PageBean {

	private int page; // 第几页
	private int rows; // 每页的记录数
	private int start; // 起始页
	private int lastpage;//
	
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public PageBean(int page, int rows,int lastpage) {
		super();
		this.page = page;
		this.rows = rows;
		this.lastpage=lastpage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return (page-1)*rows;
	}
}
//public int add(int...a){//不定长参数函数
//int s=0;
//for(int i=0 ; i<a.length ; i++){
//	s+=a[i];
//}
//return s;
//}