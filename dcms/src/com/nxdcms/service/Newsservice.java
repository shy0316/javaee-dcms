package com.nxdcms.service;

import java.util.List;

import com.nxdcms.entity.News;


public interface Newsservice {
public boolean addNews(News news);
public boolean delNews(News news);
public boolean modifyNews(News news);
public List queryNews(News news);
public List showDetails(News news);
public List showNews();
public List showIndexnews();
}
