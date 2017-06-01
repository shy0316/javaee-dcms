package com.nxdcms.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.nxdcms.dao.RecommendDao;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Student;
import com.nxdcms.entity.UserPerference;

import utils.HibernateUtils;
import utils.RecommendUtils;

public class RecommendDaoImpl implements RecommendDao {

	public List<UserPerference> findAllById(int userId) {
		List<UserPerference> list = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			list = (List<UserPerference>) session.createQuery("from UserPerference as up where up.studentId = ?")
					.setInteger(0, userId).list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return list;
	}

	public void saveOrupdateById(int userId, int itemId, float perference) {
		UserPerference up = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			up = new UserPerference();
			up.setStudentId(userId);
			up.setCompetitionId(itemId);
			up.setTime(new Date());
			up.setPerferences(perference);
			session.saveOrUpdate(up);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public UserPerference findPerferenceById(int userId, int item) {
		UserPerference up = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			List list = session.createQuery("from UserPerference as uf where uf.studentId=? and uf.competitionId=?")
					.setInteger(0, userId).setInteger(1, item).list();
			up = (UserPerference) list.get(0);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return up;
	}

	public Competition findByItemId(int item) {
		Competition competition = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			competition = (Competition) session.get(Competition.class, item);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return competition;
	}

	public List<Competition> findAllitems(List<Integer> itemsIds) {
		List<Competition> competitionlist = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			competitionlist = (List<Competition>) session.createQuery("from Competition as cp where cp.comId in(:ids)")
					.setParameterList("ids", itemsIds).list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return competitionlist;

	}

	public long findPerferenceById(int userId) {
		Session session = null;
		Transaction tx = null;
		Student student = null;
		java.lang.String id = Integer.toString(userId);
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, id);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}

		return student.getRecommendedItem();
	}

	public void saveOrUpdateStudent(int userId, int itemId) {
		Session session = null;
		Transaction tx = null;
		Student student = null;
		java.lang.String id = Integer.toString(userId);
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, Integer.toString(userId));
			student.setRecommendedItem(itemId);
			//更新完毕
			System.out.println("已经更新");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	public void SeekandUpdateStudentBy24() {
		ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(RecommendUtils.getRecommendDateSource());
		
		JDBCDataModel model = new MySQLJDBCDataModel(connectionPool, "userperference", "student_Id", "competition_Id",
				"perferences", "time");

		UserSimilarity userSim = null;
		NearestNUserNeighborhood userNei = null;
		try {
			Session session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			userSim = new EuclideanDistanceSimilarity(model);
			userNei = new NearestNUserNeighborhood(10, userSim, model);
			Recommender cachingRecommender = new GenericUserBasedRecommender(model, userNei, userSim);
			// 遍历获得的全部用户
			int i = 0;
			for (LongPrimitiveIterator it = model.getUserIDs(); it.hasNext();) {
				// 获取单个用户ID
				long userId = it.nextLong();
				i++;
				// 20表示推荐个数
				List<RecommendedItem> recommendations = cachingRecommender.recommend(userId, 1);
				Student student = (Student) session.get(Student.class, Long.toString(userId));
				student.setRecommendedItem(recommendations.get(0).getItemID());
				session.save(student);
				if (i % 50 == 0) { 
					session.flush();
					session.clear();
				}
				// 该用户没有推荐
				if (recommendations.size() == 0) {
					System.out.println("UserId" + userId + ":no Recommendations");
				}
				// 输出推荐后的数据
				for (RecommendedItem recommendedItem : recommendations) {
					System.out.println("UserId" + userId + ":" + recommendedItem);
				}
			}
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public long updateUserRecommendItem(long userId) throws TasteException {
		ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(RecommendUtils.getRecommendDateSource());
		JDBCDataModel model = new MySQLJDBCDataModel(connectionPool, "userperference", "student_Id", "competition_Id", "perferences", "time");
		long itemId = 0 ;
		final UserSimilarity userSim = new EuclideanDistanceSimilarity(model);
		final NearestNUserNeighborhood userNei = new NearestNUserNeighborhood(10, userSim, model); 
        
        Recommender cachingRecommender = new GenericUserBasedRecommender(model, userNei, userSim);  
          
        RecommenderBuilder bulider = new RecommenderBuilder() {
			//匿名内部类final
			public Recommender buildRecommender(DataModel model) throws TasteException {
				return new GenericUserBasedRecommender(model, userNei, userSim);
			}
		};

        for(LongPrimitiveIterator it =model.getUserIDs();it.hasNext();)  
        {  
        	
        	long uId =it.nextLong();  
            
        	if(userId == userId){
        		List<RecommendedItem> recommendations = cachingRecommender.recommend(uId, 1);  
                
                if(recommendations.size() ==0)  
                {  
                    System.out.println("UserId"+userId+":no Recommendations");  
                }  
                  
                for (RecommendedItem recommendedItem : recommendations) {  
                	itemId=recommendedItem.getItemID();
                    System.out.println("UserId"+userId+":的推荐竞赛ID为"+itemId);  
                }  
                break;	
        	}
        	continue;
        }  
      
      
		return itemId;
	}

}
