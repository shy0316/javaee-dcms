package utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.nxdcms.dao.BaseDao;
import com.nxdcms.dao.impl.BaseDaoImpl;
import com.nxdcms.entity.collegedictionary;

public class testBaseDao {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		List list = null;
		Class  cls = null;
		try {
			cls = Class.forName("com.nxdcms.entity.collegedictionary");
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(cls);
			crit.add(Restrictions.eq("name","师范学院"));
			list = crit.list();
			session.delete(list.get(0));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}

	}
}
