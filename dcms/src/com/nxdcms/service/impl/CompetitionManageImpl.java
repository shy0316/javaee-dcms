package com.nxdcms.service.impl;


import java.util.List;

import com.nxdcms.dao.SubCompetitionDao;
import com.nxdcms.dao.impl.SubCompetitionDaoImpl;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;
import com.nxdcms.service.CompetitionManage;

public class CompetitionManageImpl implements CompetitionManage {

	public boolean SavesubCompInfo(Competition competition,
			Subcompetition subcompetition) {

		SubCompetitionDao scm = new SubCompetitionDaoImpl();
		if (scm.subCompetitionsave(competition, subcompetition)) {
			return true;
		} else {
			return false;
		}

	}

	public List<Subcompetition> queryclassifiedCompetition(
			Competition competition) {
		List<Subcompetition> subCompList = null;
		SubCompetitionDao scd = new SubCompetitionDaoImpl();
		subCompList = scd.querysubCompetitionByComp(competition);
		if (subCompList == null) {
			return null;
		} else {
			return subCompList;
		}

	}

	public Subcompetition querymyCompetition(Subcompetition subcompetition) {

		SubCompetitionDao scd = new SubCompetitionDaoImpl();
		Subcompetition subc = scd.findbySubCompetitionId(subcompetition);
		return subc;

	}

	public boolean deleteoneSubCompetition(Subcompetition subcompetition) {

		boolean flag;
		SubCompetitionDao smd = new SubCompetitionDaoImpl();
		flag = smd.deleteSubcompetition(subcompetition);

		return flag;
	}

	public boolean modifySubCompetition(Subcompetition subcompetition) {
		boolean flag = true;
		SubCompetitionDao scd = new SubCompetitionDaoImpl();
		flag = scd.modifySubcompetition(subcompetition);
		
		return flag;
	}

}
