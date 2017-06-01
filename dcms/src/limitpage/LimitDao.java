package limitpage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.nxdcms.entity.Subcompetition;

public class LimitDao {
	
	public static PageObject queryByPage(Session session, int pageSize, int curPage
			, Class ObjClass, Order order,Criterion... criterions) {
		//返回值
		PageObject pageObject = null;
		Transaction transaction = null;
		System.out.println(pageSize+"===>"+curPage);
		try {
			//开始事务
			transaction = session.beginTransaction();
			//创建Criteria,Criteria实际上是一个查询容器
			//criteria还可以查询一个具体的实例
			/*
			 * Criteria criteria=session.createCriteria(User.class);
				User exampleuser=new User(“zx”);
				criteria.add(Example.create(exampleuser));
				List list=criteria.list();
				for(int i=0;i<list.size();i++){
				   User user=(User)list.get(i);
				   System.out.println(user.getName()+”\n”);
				}
			 * */
			Criteria criteria = session.createCriteria(ObjClass);
			//添加查询条件
			if (null != criterions) {
				for (Criterion criterion : criterions) {
					if (null != criterion)
					criteria.add(criterion);
				}
			}
			//添加排序
			if (null != order)
				criteria.addOrder(order);
			//分组与同级功能，获取行数赋值给totalRecord
			criteria.setProjection(Projections.rowCount());
			int totalRecord = Integer.parseInt(criteria.uniqueResult().toString());
			
			criteria.setProjection(null);
			
			//分页查询起始，和终止
			criteria.setFirstResult(pageSize * (curPage - 1));
			criteria.setMaxResults(pageSize);
		
			//得到结果集
			List list = criteria.list();
			
			//调试使用
//			System.out.println(list);
//			for(Object o: list){
//				Subcompetition sub = (Subcompetition)o;
//				System.out.println(sub.getAwardGrade());
//			}
//			System.out.println(pageSize+":"+ curPage+"::"+ totalRecord);

			//实例化返回值
			pageObject = new PageObject(pageSize, curPage, totalRecord, list);
			
			//提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
		return pageObject;
	}
}
