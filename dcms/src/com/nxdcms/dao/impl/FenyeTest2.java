package com.nxdcms.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nxdcms.entity.Subcompetition;

import utils.HibernateUtils;

public class FenyeTest2 {
	static FenyeTest2 ft = new FenyeTest2();
	List<Subcompetition> list = new ArrayList<Subcompetition>();
	static Query query = null;
	static Query query1 = null;
	String hql = "";
//	public static List<Test> main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Session session = null;
//		try {
//			session = HibernateUtils.getSession();
//			session.beginTransaction();
//			long begin = System.currentTimeMillis();
//			// String hql = "select count(*) from Test";
//			String hql = "from Test ";
//			Query query = session.createQuery(hql); // from
//			query.setFirstResult(100000); //开始记录
//			query.setMaxResults(10); //查询多少条
//			long end = System.currentTimeMillis();
//			// 类名
//			query.list();
//
//			List<Test> list = query.list();
//			for (Test t : list) {
//				System.out.println(t.getId());
//			} // 全部查询
////			int count1 = ((Number) query.uniqueResult()).intValue();
////			System.out.println(count1);
//
//			session.getTransaction().commit();
//
//			
//			System.out.println((end - begin) / 1000.0);
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		} finally {
//			HibernateUtils.closeSession(session);
//		}
//	}
	public List<Subcompetition> fenye(PageBean page,Subcompetition subcompetition) {
		// TODO Auto-generated method stub

		Session session = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = "";
		if(subcompetition.getAwarddate()!=null){
			date = format.format(subcompetition.getAwarddate());
			System.out.println(date);
		}
		System.out.println(date);
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
	
			String grade = subcompetition.getAwardGrade();
			String teacher = subcompetition.getTeacher();
			
			if(("".equals(grade)||(grade==null)) && ("".equals(teacher)||(teacher==null)) && ("".equals(date)||(date==null))){
				query = session.createQuery("from Subcompetition");
				hql = "select count(*) from Subcompetition";
			}else if(("".equals(grade)||grade==null) && ("".equals(date)||date==null)){
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.teacher = ?").setString(0, teacher);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.teacher = '%s'", teacher);
			}
			else if(("".equals(teacher)||(teacher==null)) && ("".equals(date)||(date==null))) {
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awardGrade = ?").setString(0, grade);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade = '%s'", grade);
			}
			else if(("".equals(grade)||grade==null) &&("".equals(teacher)||teacher==null)){
				System.out.println("4444444444444444");
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awarddate = ?").setString(0, date);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awarddate = '%s'", date);
			}
			else if(("".equals(grade)||grade==null)){
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.teacher=? and subcomp.awarddate =?");
				query.setString(0, teacher);
				query.setString(1, date);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.teacher='%s' and subcomp.awarddate = '%s'", teacher,date);
			}
			else if("".equals(teacher)||teacher==null){
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awardGrade=? and subcomp.awarddate = ?");
				query.setString(0, grade);
				query.setString(1, date);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade='%s' and subcomp.awarddate = '%s'", grade,date);
			}
			else if("".equals(date)||date==null){
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awardGrade=? and subcomp.teacher = ?");
				query.setString(0, grade);
				query.setString(1, teacher);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade='%s' and subcomp.teacher ='%s'", grade,teacher);
			}
			else {
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awardGrade like ? and subcomp.teacher like ? and subcomp.awarddate = ?");
				query.setString(0, grade);
				query.setString(1, teacher);
				query.setString(2, date);
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade='%s' and subcomp.teacher ='%s' and subcomp.awarddate = '%s'", grade,teacher,date);
			}
			query.setFirstResult(page.getStart()); //开始记录
			query.setMaxResults(page.getRows()); //查询多少条
			list = query.list();
			//查询记录数
			query1=session.createQuery(hql);
			int count1 = ((Number) query1.uniqueResult()).intValue();
			page.setLastpage(count1%page.getRows()==0?(count1/page.getRows()):(count1/page.getRows()+1));
		for(Subcompetition aSubcompetition: list)
		{
			System.out.println(aSubcompetition.getSubcompid());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
		}
		return list;
	}
	
	
	public List<PageBean> count(PageBean page,Subcompetition subcompetition) {
		// TODO Auto-generated method stub
		List<PageBean> list = new ArrayList<PageBean>();
		Session session = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = "";
		if(subcompetition.getAwarddate()!=null){
			date = format.format(subcompetition.getAwarddate());
			System.out.println(date);
		}
		System.out.println(date);
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
	
			String grade = subcompetition.getAwardGrade();
			String teacher = subcompetition.getTeacher();
			
			if(("".equals(grade)||(grade==null)) && ("".equals(teacher)||(teacher==null)) && ("".equals(date)||(date==null))){
				hql = "select count(*) from Subcompetition";
			}else if(("".equals(grade)||grade==null) && ("".equals(date)||date==null)){
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.teacher = '%s'", teacher);
			}
			else if(("".equals(teacher)||(teacher==null)) && ("".equals(date)||(date==null))) {
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade = '%s'", grade);
			}
			else if(("".equals(grade)||grade==null) &&("".equals(teacher)||teacher==null)){
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awarddate = '%s'", date);
			}
			else if(("".equals(grade)||grade==null)){
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.teacher='%s' and subcomp.awarddate = '%s'", teacher,date);
			}
			else if("".equals(teacher)||teacher==null){
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade='%s' and subcomp.awarddate = '%s'", grade,date);
			}
			else if("".equals(date)||date==null){
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade='%s' and subcomp.teacher ='%s'", grade,teacher);
			}
			else {
				hql = String.format("select count(*) from Subcompetition subcomp where subcomp.awardGrade='%s' and subcomp.teacher ='%s' and subcomp.awarddate = '%s'", grade,teacher,date);
			}
			//查询记录数
			query1=session.createQuery(hql);
			int count1 = ((Number) query1.uniqueResult()).intValue();
			page.setLastpage(count1%page.getRows()==0?(count1/page.getRows()):(count1/page.getRows()+1));
			list.add(page);
		for(PageBean aSubcompetition: list)
		{
			System.out.println(aSubcompetition.getPage());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
		}
		return list;
	}
//	public static void testAdd() {
//		long begin = System.currentTimeMillis();
//		Configuration config = new Configuration();
//		config.configure();
//		SessionFactory factory = config.buildSessionFactory();
//		Session session = factory.openSession(); 
//		Transaction tx = session.beginTransaction();
//		for (int i = 0; i < 100000; i++) { // 插入100万条数据
//			Test test = new Test("a" + i);
//			session.save(test);
//			if (i % 100 == 0) { // 每一千条刷新并写入数据库
//				session.flush();
//				session.clear();
//			}
//		}
//		tx.commit();
//		session.close();
//		long end = System.currentTimeMillis();
//		System.out.println((end - begin) / 1000.0);
//	}
}
