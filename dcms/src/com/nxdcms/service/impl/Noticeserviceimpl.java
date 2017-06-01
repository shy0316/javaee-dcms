package com.nxdcms.service.impl;

import java.util.List;

import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.Notice;
import com.nxdcms.service.Noticeservice;

public class Noticeserviceimpl implements Noticeservice {
	public boolean addNotice(Notice notice) {

		Noticedaoimpl udi = new Noticedaoimpl();
		if (udi.Add(notice))
			return true;
		else
			return false;

	}

	public boolean delNotice(Notice notice) {
		Noticedaoimpl udi = new Noticedaoimpl();
		if (udi.Delete(notice))
			return true;
		else
			return false;

	}

	public boolean modifyNotice(Notice notice) {
		Noticedaoimpl udi = new Noticedaoimpl();
		if (udi.Modify(notice))
			return true;
		else
			return false;

	}

	public List<Notice> queryNotice(Notice notice) {
		Noticedaoimpl udi = new Noticedaoimpl();
		List<Notice> list=udi.Query();
		return list;
	}

	//首页ajax公告查询
	public List<Notice> frontqueryNotice(Notice notice) {
		Noticedaoimpl udi = new Noticedaoimpl();
		List<Notice> list=udi.Query();
		return list;
	}
	
	public List<Notice> showMessage(Notice notice){
		Noticedaoimpl udi = new Noticedaoimpl();
		List<Notice> list=udi.showMessage(notice);
		return list;
	}
	
	public List<Notice> searchNotice(Notice notice){
		Noticedaoimpl udi = new Noticedaoimpl();
		List<Notice> list=udi.Search(notice);
		return list;
	}
	
	
	
	
}