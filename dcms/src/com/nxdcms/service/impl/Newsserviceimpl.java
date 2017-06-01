package com.nxdcms.service.impl;

import java.util.List;

import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.News;
import com.nxdcms.service.Newsservice;


public class Newsserviceimpl implements Newsservice {

	public boolean addNews(News news) {

		Newsdaoimpl udi = new Newsdaoimpl();
		if (udi.Add(news))
			return true;
		else
			return false;

	}


	public boolean delNews(News news) {
		Newsdaoimpl udi = new Newsdaoimpl();
		if (udi.Delete(news))
			return true;
		else
			return false;
	}

	public boolean modifyNews(News news) {
		Newsdaoimpl udi = new Newsdaoimpl();
		if (udi.Modify(news))
			return true;
		else
			return false;
	}


	public List<News> queryNews(News news) {
		Newsdaoimpl udi = new Newsdaoimpl();
		List<News> list=udi.Query(news);
		return list;
	}
	
	public List<News> showDetails(News news){
		Newsdaoimpl udi = new Newsdaoimpl();
		List<News> list=udi.Details(news);
		return list;
	}
	
	public List<News> showNews(){
		Newsdaoimpl udi = new Newsdaoimpl();
		List<News> list=udi.Show();
		return list;
	}
	
	public List<News> showIndexnews(){
		Newsdaoimpl udi = new Newsdaoimpl();
		List<News> list=udi.Show();
		return list;
	}

}