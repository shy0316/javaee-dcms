package com.nxdcms.service;

import java.util.List;

import com.nxdcms.entity.Notice;




public interface Noticeservice {
	public boolean addNotice(Notice notice);
	public boolean delNotice (Notice notice);
	public boolean modifyNotice (Notice notice);
	public List queryNotice (Notice notice);
	public List frontqueryNotice (Notice notice);
	public List showMessage(Notice notice);
	public List searchNotice (Notice notice);
}
