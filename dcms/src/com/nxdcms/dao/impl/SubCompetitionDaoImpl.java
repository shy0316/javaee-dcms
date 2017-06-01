package com.nxdcms.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;
import utils.WordString;

import com.nxdcms.dao.SubCompetitionDao;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;

public class SubCompetitionDaoImpl implements SubCompetitionDao {

	public boolean subCompetitionsave(Competition competition,
			Subcompetition subcompetition) {
		Session session = null;
		Transaction tx = null;
		List<Subcompetition> subcompList = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(
					"from Subcompetition subcomp where subcomp.stuId1=?")
					.setString(0, subcompetition.getStuId1());
			subcompList = query.list();
			if (subcompList.isEmpty()) {
				subcompetition.setCompetition(competition);
				session.save(subcompetition);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}finally{
			//HibernateUtils.closeSession(session);			
		}

		return false;
	}

	public List<Subcompetition> querysubCompetitionByComp(
			Competition competition) {
		Session session = null;

		Transaction tx = null;
		List<Subcompetition> subComplist = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			subComplist = session
					.createQuery(
							"from Subcompetition subcomp where subcomp.competition.comId=?")
					.setInteger(0, competition.getComId()).list();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		return subComplist;
	}

	public Subcompetition findbySubCompetitionId(Subcompetition subcomp) {

		Session session = null;

		Transaction tx = null;
		Subcompetition subcompetition = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			subcompetition = (Subcompetition) session.get(Subcompetition.class,
					subcomp.getSubcompid());
			tx.commit();

		} catch (Exception e) {
			
			if (tx != null){
				tx.rollback();
			}
			e.printStackTrace();	
		}
		return subcompetition;
	}

	public boolean deleteSubcompetition(Subcompetition subcomp) {
		boolean flag = false;
		Session session = null;
		Transaction tx = null;
		Subcompetition subcompe = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			// 先查询 传过来一个Subcompetition对象 不是
			// JS控制了
			subcompe = (Subcompetition) session.get(Subcompetition.class,
					subcomp.getSubcompid());
			if (subcompe == null) {
				flag = false;
			} else {
				if(subcompe.getAwardPicpath()!=null){
					WordString.forceDelete(subcompe.getAwardPicpath());
				}
	if(subcompe.getCompAgreementpath()!=null){
		WordString.forceDelete(subcompe.getCompAgreementpath());
				}
	if(subcompe.getCompBookpath()!=null){
		WordString.forceDelete(subcompe.getCompBookpath());
	}
				session.delete(subcompe);
				flag = true;
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return flag;
	}

	public boolean modifySubcompetition(Subcompetition subcomp) {
		boolean flag = false;
		Session session = null;
		Transaction tx = null;
		Subcompetition subcompe = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			subcompe = (Subcompetition) session.get(Subcompetition.class,
					subcomp.getSubcompid());
			// modify
			if (subcompe != null) {
				subcompe.setAwarddate(subcomp.getAwarddate());
				subcompe.setAwardGrade(subcomp.getAwardGrade());
				subcompe.setAwardIntr(subcomp.getAwardIntr());
				subcompe.setAwardName(subcomp.getAwardName());
				subcompe.setCollege(subcomp.getCollege());
				subcompe.setStuId1(subcomp.getStuId1());
				subcompe.setStuId2(subcomp.getStuId2());
		
				if(subcomp.getAwardPicpath()!=null){
					if(subcompe.getAwardPicpath()!=null){
						WordString.forceDelete(subcompe.getAwardPicpath());	
					}
					subcompe.setAwardPicpath(subcomp.getAwardPicpath());
				}
				if(subcomp.getCompAgreementName()!=null){
					subcompe.setCompAgreementName(subcomp.getCompAgreementName());
					if(subcompe.getCompAgreementpath()!=null){
						WordString.forceDelete(subcompe.getCompAgreementpath());	
					}
					subcompe.setCompAgreementpath(subcomp.getCompAgreementpath());
				}
				if(subcomp.getCompBookName()!=null){
					subcompe.setCompBookName(subcomp.getCompBookName());
					if(subcompe.getCompBookpath()!=null){
						WordString.forceDelete(subcompe.getCompBookpath());	
					}
					subcompe.setCompBookpath(subcomp.getCompBookpath());
				}
				subcompe.setWorkName(subcomp.getWorkName());
				flag = true;
				session.save(subcompe);
				tx.commit();
			} else {
				flag = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return flag;
	}
}
