package com.nxdcms.entity;

public class dictionaryManage {
	private String dictionaryId;
	private String className;
	private String chineseName;
	public String getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	@Override
	public String toString() {
		return "dictionaryManage [dictionaryId=" + dictionaryId + ", className=" + className + ", chineseName="
				+ chineseName + "]";
	}
	public dictionaryManage(String dictionaryId, String className, String chineseName) {
		super();
		this.dictionaryId = dictionaryId;
		this.className = className;
		this.chineseName = chineseName;
	}
	
	public dictionaryManage() {
		// TODO Auto-generated constructor stub
	}
	
}