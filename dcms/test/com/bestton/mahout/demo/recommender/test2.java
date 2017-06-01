package com.bestton.mahout.demo.recommender;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.nxdcms.entity.Student;

import utils.HibernateUtils;

public class test2 {
		@Test
		public void testInsert(){
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtils.getSession();
				tx = session.beginTransaction();
				Student stu = null;
				int id  = 14550000;
				for(int i=0;i<1000;i++){
					stu = new Student();
					id = 14550000+i;
					stu.setStudentId(Integer.toString(id));
					stu.setStudentCollege("信息工程学院");
					stu.setStudentAge(19);
					stu.setStudentClass("软件工程"+i%6+"班");
					stu.setStudentName("张三");
					//?
					stu.setStudentIdcard("xxxxxxxxxxxx");
					stu.setStudentPassword("123456");
					stu.setStudentPhone("1381236124"+i%10);
					stu.setStudentStartYear("12312");
					//?
					stu.setStudentDiscipline("yyyyyyyyyy");
					stu.setStudentEmail("851071347@qq.com");
					session.save(stu);
					if(i%100==0){
						session.flush();
						session.clear();
					}
				}
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();

				}
			}
			HibernateUtils.closeSession(session);
				
		}
			
}
