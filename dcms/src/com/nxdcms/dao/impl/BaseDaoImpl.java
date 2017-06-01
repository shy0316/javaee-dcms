package com.nxdcms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.TypedValue;

import com.nxdcms.dao.BaseDao;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;
import com.nxdcms.entity.collegedictionary;
import com.nxdcms.entity.compLeveldictionary;
import com.nxdcms.entity.competitiondictionary;
import com.nxdcms.entity.dictionaryManage;

import utils.HibernateUtils;

public class BaseDaoImpl implements BaseDao {

	public void addCollegeDictionary(String collegeName) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			collegedictionary cd = new collegedictionary();
			cd.setName(collegeName);
			session.save(cd);
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

	public List findCollegeDictionary(String className) {
		Session session = null;
		Transaction tx = null;
		List list = null;
		Class  cls = null;
		try {
			cls = Class.forName(className);
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(cls);
			list = crit.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		
		return list;
	}

	public void addCompetitionLevel(String level) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			compLeveldictionary cl = new compLeveldictionary();
			cl.setName(level);
			session.save(cl);
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

	public void addCompetitionType(String Type) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			competitiondictionary cd = new competitiondictionary();
			cd.setName(Type);
			session.save(cd);
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

	public void deleteDictionary(String className, String name) {
		Session session = null;
		Transaction tx = null;
		List list = null;
		Class  cls = null;
		try {
			cls = Class.forName(className);
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(cls);
			crit.add(Restrictions.eq("name",name));
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

	@Override
	public void addDictionaryManage(dictionaryManage dm) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			session.save(dm);
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

	@Override
	public List<dictionaryManage> findAllDictionary() {
		Session session = null;
		Transaction tx = null;
		List<dictionaryManage> dm = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			dm = session.createQuery("from dictionaryManage").list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		return dm;
	}



}
