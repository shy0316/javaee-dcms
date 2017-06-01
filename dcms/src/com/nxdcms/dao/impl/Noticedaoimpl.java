package com.nxdcms.dao.impl;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import com.nxdcms.dao.NoticeDao;
import com.nxdcms.entity.Notice;
import com.opensymphony.xwork2.ActionContext;

import utils.HibernateUtils;

import org.hibernate.Query;


public class Noticedaoimpl implements NoticeDao {
public boolean Add(Notice notice) {
		
		boolean flag = false;
        Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
		
			Notice notice2 = (Notice) session.get(Notice.class, notice.getNoticeContent());
			if (notice2 == null )
			{	
			    session.save(notice);
			    flag=true;
			
			}
			else {
				flag=false;
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
	

	


 public boolean Delete(Notice notice) {
	boolean flag = true;
	Session session = null;
	try {
		session = HibernateUtils.getSession();
		session.beginTransaction();
        //Query num = session.createQuery("select noticeid from Notice");
		Notice notice2 = (Notice) session.get(Notice.class, notice.getNoticeId());
		//锟斤拷锟捷匡拷锟叫讹拷应锟侥讹拷锟襟不达拷锟斤拷时锟斤拷get()锟斤拷锟斤拷锟斤拷锟斤拷null
		if (notice2 != null) {//?锟斤拷锟斤拷锟斤拷锟�
			
			flag = true;
			session.delete(notice2);//锟斤拷锟斤拷要删锟斤拷锟斤拷锟斤拷锟�
		} else {
			flag = false;
			System.out.println("锟斤拷要删锟斤拷锟斤拷锟斤拷挪锟斤拷锟斤拷锟�");
			
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

	
	public boolean Modify(Notice notice) {
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			// 锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷锟捷讹拷锟斤拷 锟角持撅拷状态 锟斤拷锟斤拷要update
			// 锟斤拷锟斤拷使锟矫达拷锟叫凤拷式 锟饺硷拷锟斤拷锟劫革拷锟斤拷 锟斤拷要锟斤拷new锟节革拷锟斤拷
			Notice notice2 = (Notice) session.load(Notice.class, notice.getNoticeId());
			// 锟斤拷锟斤拷锟斤拷示锟斤拷update
			if (notice2 != null) {
				
				notice2.setNoticeId(notice.getNoticeId());
				notice2.setNoticeContent(notice.getNoticeContent());
				notice2.setNoticeDate(notice.getNoticeDate());//锟斤拷锟矫革拷锟斤拷锟斤拷锟斤拷
				session.save(notice2);
				flag = true;
				
			}
			else{
				
				System.out.print("修改公告失败");
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
//后台公告页面管理点进去就出来的列表
	public List<Notice> Query() {
		Session session = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from Notice notice order by notice.noticeDate desc"); // from
																		// 锟斤拷锟斤拷
																				// 全锟斤拷锟斤拷询
		noticeList = query.list();
		for(Notice aNotice: noticeList)
		{
			System.out.println(aNotice.getNoticeContent());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return noticeList;

	}
	//首页查询
	public List<Notice> FrontQuery() {
		Session session = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from Notice notice order by notice.noticeDate desc"); // from
			query.setFirstResult(0);//从哪条开始取
			query.setMaxResults(9);//最多取几条
			
		noticeList = query.list();
		for(Notice aNotice: noticeList)
		{
			System.out.println(aNotice.getNoticeContent());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return noticeList;

	}
	



	
	public List<Notice> showMessage(Notice notice){
		boolean flag = true;
		List<Notice> noticeList2 = new ArrayList<Notice>();
		Session session = null;
		
		try {
			session = HibernateUtils.getSession();
		    session.beginTransaction();
			
			Notice notice2 = (Notice) session.get(Notice.class, notice.getNoticeId());  
			
			
			String noticeId = notice2.getNoticeId();
			
			String noticeDate = notice2.getNoticeDate();
			String noticeContent = notice2.getNoticeContent();
			ActionContext.getContext().put("noticeId",noticeId);
			
			ActionContext.getContext().put("noticeDate",noticeDate);
			ActionContext.getContext().put("noticeContent",noticeContent);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		
		return noticeList2;
		
	}
	//搜索时的公告查询
	public List<Notice> Search(Notice notice) {
		Session session = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		Query query=null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			String noticeContent=notice.getNoticeContent();
			String noticeDate = notice.getNoticeDate();
			String query1 = null;
			System.out.println("--------------noticeContent"+noticeContent);
			System.out.println("noticeDate"+noticeDate);
			if(noticeContent==null&&noticeContent.equals("")&&noticeDate==null&&noticeDate.equals("")){
				query1="from Notice notice";
			}
			else if(noticeContent!=null&&!noticeContent.equals("")){
			  query1="from Notice notice where notice.noticeContent like '%"+noticeContent+"%'" ;
			  System.out.println(query1);// from
			 }else if(noticeContent.equals("")&&!noticeDate.equals("")){
			  query1="from Notice notice where notice.noticeDate like '%"+noticeDate+"%'" ;
			  System.out.println(query1);
			 }else{
				 query1="from Notice notice";
				 System.out.println(query1);
			 }
			 
		query = session.createQuery(query1);	
		
		noticeList = query.list();
		/*for(Notice aNotice: noticeList)
		{
			System.out.println(aNotice.getNoticeContent());
			System.out.println("ss");
		}// 全锟斤拷锟斤拷询
*/		session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return noticeList;

	}
	
	
	
	
}
