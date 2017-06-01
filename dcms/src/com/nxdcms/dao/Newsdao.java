package com.nxdcms.dao;

import java.util.List;

import com.nxdcms.entity.News;



public interface Newsdao {

	public boolean Add(News news);

	public boolean Delete(News news);

	public boolean Modify(News news);

	public List Query(News news);
	
	public List Details(News news);
	
	public List Show();
	
	public List ShowIndex();

}
