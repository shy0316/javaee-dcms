package com.nxdcms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nxdcms.dao.Showdao;
import com.nxdcms.entity.Subcompetition;

import utils.HibernateUtils;

public class Showdaoimpl implements Showdao{



	public List<Subcompetition> Query() {
		Session session = null;
		List<Subcompetition> subcompetitionList = new ArrayList<Subcompetition>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			System.out.println("123");
			Query query = session.createQuery("from Subcompetition"); // from
																		// 类名
																				// 全部查询
		

			subcompetitionList = query.list();
		for(Subcompetition aSubcompetition: subcompetitionList)
		{
			System.out.println(aSubcompetition.getSubcompid());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return subcompetitionList;

	}
	
	public List<Subcompetition> content(Subcompetition subcompetition) {
		Session session = null;
		List<Subcompetition> subcompetitionList = new ArrayList<Subcompetition>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			System.out.println("123");
			Query query = session.createQuery("from Subcompetition subcomp where subcomp.Subcompid=?").setString(0, subcompetition.getSubcompid()); // from
																		// 类名
																				// 全部查询
		

			subcompetitionList = query.list();
		for(Subcompetition aSubcompetition: subcompetitionList)
		{
			System.out.println(aSubcompetition.getSubcompid());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return subcompetitionList;

	}
	
	public List<Subcompetition> Search(Subcompetition subcompetition) {
		Session session = null;
		List<Subcompetition> subcompetitionList = new ArrayList<Subcompetition>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			//System.out.println("123");
//			String awg = subcompetition.getAwardGrade();
//			String t = subcompetition.getTeacher();
//			String c = subcompetition.getCollege();
//			
//			

			
			Query query = null;

			
			if((subcompetition.getAwardGrade().equals("")) &&(subcompetition.getTeacher().equals(""))){
				
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.college like ?").setString(0, subcompetition.getCollege());
				
			}
			else if(subcompetition.getAwardGrade().equals("")){
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.teacher=? and subcomp.college like ?");
				query.setString(0, subcompetition.getTeacher());
				query.setString(1, subcompetition.getCollege());
				
				
			}
			else if(subcompetition.getTeacher().equals("")){
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awardGrade=? and subcomp.college like ?");
				query.setString(0, subcompetition.getAwardGrade());
				query.setString(1, subcompetition.getCollege());
			}
			else {
				
				query = session.createQuery(
						"from Subcompetition subcomp where subcomp.awardGrade like ? and subcomp.teacher like ? and subcomp.college like ?");
				query.setString(0, subcompetition.getAwardGrade());
				query.setString(1, subcompetition.getTeacher());
				query.setString(2, subcompetition.getCollege());
			}
			subcompetitionList = query.list();
//			Query query = session.createQuery(
//					"from Subcompetition subcomp where subcomp.awardGrade=? and subcomp.college=?");
//			query.setString(0, subcompetition.getAwardGrade());
//			query.setString(1, subcompetition.getCollege());
//			subcompetitionList = query.list();
		for(Subcompetition aSubcompetition: subcompetitionList)
		{
			System.out.println(aSubcompetition.getSubcompid());
		}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return subcompetitionList;

	}

	public boolean Modify(Subcompetition subcompetition) {
			Session session = null;
			boolean flag = false;
			try {
				session = HibernateUtils.getSession();
				session.beginTransaction();
				// 查上来的 数据都有 是持久状态 不需要update
				// 建议使用此中方式 先加载再更新 不要先new在更新
				Subcompetition subcompetition2 = (Subcompetition) session.load(Subcompetition.class, subcompetition.getSubcompid());
				// 可以显示的update
				if (subcompetition2 != null) {
					subcompetition2.setAwardName(subcompetition.getAwardName());
					session.save(subcompetition2);
					flag = true;
					
				}
				else{
					System.out.print("修改用户失败");
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

}
