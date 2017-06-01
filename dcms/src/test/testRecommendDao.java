package test;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.nxdcms.dao.RecommendDao;
import com.nxdcms.dao.impl.RecommendDaoImpl;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Student;
import com.nxdcms.entity.UserPerference;
import com.nxdcms.entity.UserPerferencesEntity;
import com.nxdcms.service.RecommendService;
import com.nxdcms.service.impl.RecommendServiceImpl;

import utils.HibernateUtils;

public class testRecommendDao {
	
	@Test
	public void testfindPerferenceById(){
		RecommendDao rd = new RecommendDaoImpl();
		UserPerference up = rd.findPerferenceById(14550000, 1);
		System.out.println(up.getPerferences());
	}
	
	@Test
	public void testSaveOrUpdate(){
		RecommendDao rd = new RecommendDaoImpl();
		rd.saveOrupdateById(14550000,5,4.3f);
		
	}
	
	
	@Test
	public void testfindByItemId(){
		RecommendDao rd = new RecommendDaoImpl();
		Competition competiotion = rd.findByItemId(3);
			System.out.println(competiotion.getComName());
	}
	
	@Test
	
	public void testfindAll(){
		RecommendDao rd = new RecommendDaoImpl();
		List<UserPerference> list= rd.findAllById(14550000);
	}
	
	@Test
	public void testRecommendItem(){
		RecommendService rs = new RecommendServiceImpl();
		Competition competition=rs.getRecommendItem(14550000);
		System.out.println(competition);
	}
	
	@Test
	public void testUpdateStudent(){
		RecommendDao rd = new RecommendDaoImpl();
		rd.saveOrUpdateStudent(14550000, 3);
	}
	
	
	@Test
	public void updateAllStudentBy24(){
		Session session = null;
		Transaction tx = null;
		Student student = new Student();
		try {
			session = HibernateUtils.getSession();
			tx= session.beginTransaction();
//更新咯 就根据ID 有些字段不更新 设置为false
			student.setStudentId("14550000");
			student.setRecommendedItem(4);
			session.saveOrUpdate(student);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			HibernateUtils.closeSession(session);
		}

	}
	
	@Test
	public void testRecommendDao(){
		RecommendDao rd = new RecommendDaoImpl();
		rd.SeekandUpdateStudentBy24();
	}
}
