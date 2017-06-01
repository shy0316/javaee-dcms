package com.nxdcms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Student;

import utils.HibernateUtils;

public class Discipline {
	@Test
	public List<Student> Query() {
		Session session = null;
		List<Student> student = new ArrayList<Student>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			System.out.println("123");
			Query query = session.createQuery("select new Student(studentEmail,recommendedItem) from Student"); // from
			Query query2 = null;														
			student = query.list();
			String sql = null;
			long RecommendedItem;
			for(int i=0 ; i<student.size() ; i++){
				RecommendedItem = student.get(i).getRecommendedItem();
				 sql = String.format("select comName from Competition where comId = %d", RecommendedItem);
				query2 = session.createQuery(sql);
				if(i%200==0){
					session.flush();
					session.clear();
				}
			
				
				student.get(i).setRecommendedName(query2.list().get(0).toString());
			}
			
	
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
		}
		return student;

	}
//	public List<Student> discipline(String discipline) {
//		Session session = null;
//		List<Student> student = new ArrayList<Student>();
//		try {
//			session = HibernateUtils.getSession();
//			session.beginTransaction();
//			System.out.println("123");
//			String hql = String.format("from Competition where comId", discipline);
//			Query query = session.createQuery("from Competition where comId"); // from
//																		// 类名
//																				// 全部查询
//			student = query.list();
//		for(Student astudent: student)
//		{
//			System.out.println(astudent.getStudentDiscipline()+" ;  "+astudent.getStudentEmail());
//		}
//			session.getTransaction().commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		} finally {
//		}
//		return student;
//
//	}
}
