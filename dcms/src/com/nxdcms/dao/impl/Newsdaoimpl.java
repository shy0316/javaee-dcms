package com.nxdcms.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ElseIf;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.nxdcms.dao.Newsdao;
import com.nxdcms.entity.News;
import com.opensymphony.xwork2.ActionContext;

import utils.HibernateUtils;

public class Newsdaoimpl implements Newsdao {

	public boolean Add(News news) {

		boolean flag = false;

		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			// get方法加载数据 如果不存在返回null
			News news2 = (News) session.get(News.class, news.getNewsTitle());
			if (news2 == null) {
				session.save(news);
				flag = true;
			} else {
				System.out.println(news.getNewsTitle());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}

	public boolean Delete(News news) {
		boolean flag = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			System.out.println(news.getNewsTitle());
			System.out.println(news);
			News news2 = (News) session.get(News.class, news.getNewsTitle());    //获取list指定对象值
			if (news2 == null) {
				System.out.println("你要删除的帐号不存在");
				flag = false;
			} else {
				flag = true;
				session.delete(news2);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}

	public boolean Modify(News news) {
//		System.err.println("++++++");
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			// 查上来的 数据都有 是持久状态 不需要update,建议使用此中方式 先加载再更新 不要先new在更新
//			News news2 = (News) session.load(News.class, news.getNewsTitle()); //可以显示的update
			News news2 = (News) session.get(News.class, news.getNewsTitle());    //获取list指定对象值
			if (news2 != null ) {
				news2.setNewsTitle(news.getNewsTitle());
				news2.setNewsIssuedate(news.getNewsIssuedate());
				news2.setNewsIssuer(news.getNewsIssuer());
				news2.setNewsContent(news.getNewsContent());
				news2.setNewsPhotoName(news.getNewsPhotoName());
				news2.setNewsPhotoPath(news.getNewsPhotoPath());

				session.save(news2);
			} else {
				session.save(news);	
			}
			flag = true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}
	//@org.junit.Test
	public List<News> Query(News news) {
		Session session = null;
		List<News> newsList = new ArrayList<News>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();//前面事务会被第二次事务执行前调用flush()函数
			
			String newsTitle = news.getNewsTitle();
			System.out.println(newsTitle);
			String newsIssuer = news.getNewsIssuer();
			String newsIssuedate = news.getNewsIssuedate(); 
			String sql1 = "from News news order by news.newsIssuedate desc";                                             //全查询     hibernate查询占位符写法 :name(query,setString("name",值))  /  query.(,setString(?出现次序,值))
			String sql2 = "from News news where news.newsTitle like:newsTitle order by news.newsIssuedate desc";    //单条件模糊查询
			String sql3 = "from News news where news.newsIssuer like:newsIssuer order by news.newsIssuedate desc";
			String sql4 = "from News news where news.newsIssuedate like:newsIssuedate order by news.newsIssuedate desc";
			String sql5 = "from News news where news.newsTitle like:newsTitle and news.newsIssuer like:newsIssuer order by news.newsIssuedate desc";            //双条件查询 
			String sql6 = "from News news where news.newsTitle like:newsTitle and news.newsIssuedate like:newsIssuedate order by news.newsIssuedate desc";
			String sql7 = "from News news where news.newsIssuer like:newsIssuer and news.newsIssuedate like:newsIssuedate order by news.newsIssuedate desc";
			String sql8 = "from News news where news.newsTitle like:newsTitle and news.newsIssuer like:newsIssuer and news.newsIssuedate like:newsIssuedate order by news.newsIssuedate desc";
			Query query = null;
			if(newsTitle.equals("") && newsIssuer.equals("") && newsIssuedate.equals("")){
				query = session.createQuery(sql1);
			}else if(!newsTitle.equals("") && newsIssuer.equals("") && newsIssuedate.equals("")){
				query = session.createQuery(sql2).setString("newsTitle", "%"+newsTitle+"%"); 
			}else if(newsTitle.equals("") && !newsIssuer.equals("") && newsIssuedate.equals("")){
				query = session.createQuery(sql3).setString("newsIssuer", "%"+newsIssuer+"%"); 
			}else if(newsTitle.equals("") && newsIssuer.equals("") && !newsIssuedate.equals("")){
				query = session.createQuery(sql4).setString("newsIssuedate", "%"+newsIssuedate+"%"); 
			}else if(!newsTitle.equals("") && !newsIssuer.equals("") && newsIssuedate.equals("")){
				query = session.createQuery(sql5); 
				query.setString("newsTitle", "%"+newsTitle+"%");
				query.setString("newsIssuer", "%"+newsIssuer+"%");
			}else if(!newsTitle.equals("") && newsIssuer.equals("") && !newsIssuedate.equals("")){
				query = session.createQuery(sql6); 
				query.setString("newsTitle", "%"+newsTitle+"%");
				query.setString("newsIssuedate", "%"+newsIssuedate+"%");
			}else if(newsTitle.equals("") && !newsIssuer.equals("") && !newsIssuedate.equals("")){
				query = session.createQuery(sql7); 
				query.setString("newsIssuedate", "%"+newsIssuedate+"%");
				query.setString("newsIssuer", "%"+newsIssuer+"%");
			}else if(!newsTitle.equals("") && !newsIssuer.equals("") && !newsIssuedate.equals("")){
				query = session.createQuery(sql8); 
				query.setString("newsTitle", "%"+newsTitle+"%");
				query.setString("newsIssuedate", "%"+newsIssuedate+"%");
				query.setString("newsIssuer", "%"+newsIssuer+"%");
			}else{
				query = session.createQuery(sql1);
			}
					
			newsList = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return newsList;
	}

	
	
	
	
	public List<News> list() {
		Session session = null;
		List<News> newsList = new ArrayList<News>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();//前面事务会被第二次事务执行前调用flush()函数		
			
			String sql1 = "from News";                                             //全查询     hibernate查询占位符写法 :name(query,setString("name",值))  /  query.(,setString(?出现次序,值))
			Query query = null;
			
				query = session.createQuery(sql1);
			
			newsList = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return newsList;
	}
	
	
	public List<News> Details(News news){
		boolean flag = true;
		List<News> newsList2 = new ArrayList<News>();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			//指定新闻内容详情
			News news2 = (News) session.get(News.class, news.getNewsTitle());    //获取list指定对象值
			String newsTitle_details = news2.getNewsTitle();
			String sql_details = "from News news where news.newsTitle =:newsTitle";
			Query query = session.createQuery(sql_details).setString("newsTitle",newsTitle_details); 
			System.out.println("----------in details----------");
			newsList2 = query.list();
			//指定新闻修改 显示内容
			System.out.println(news2.getNewsTitle());
			System.out.println(news2);
			String newsTitle = news2.getNewsTitle();
			String newsIssuer = news2.getNewsIssuer();
			String newsIssuedate = news2.getNewsIssuedate();
			String newsContent = news2.getNewsContent();
			String newsPhotoName = news2.getNewsPhotoName();
			String newsPhotoPath = news2.getNewsPhotoPath();
			ActionContext.getContext().put("newsTitle",newsTitle);
			ActionContext.getContext().put("newsIssuer",newsIssuer);
			ActionContext.getContext().put("newsIssuedate",newsIssuedate);
			ActionContext.getContext().put("newsContent",newsContent);
			ActionContext.getContext().put("newsPhotoName",newsPhotoName);
			ActionContext.getContext().put("newsPhotoPath",newsPhotoPath);
			System.out.println(newsTitle + newsIssuer + newsIssuedate + newsContent + newsPhotoName + newsPhotoPath);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return newsList2;
	}
	
	public List<News> Show(){
		List<News> newsList3 = new ArrayList<News>();
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Query query = session.createQuery("from News news order by news.newsIssuedate desc");
			newsList3 = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return newsList3;
	}
	
	public List<News> ShowIndex(){
		List<News> newsList4 = new ArrayList<News>();
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Query query = session.createQuery("from News news order by news.newsIssuedate desc");
			query.setFirstResult(0); //开始记录  
			query.setMaxResults(7); //查询出来的记录数
			newsList4 = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return newsList4;
	}
	
	
}



