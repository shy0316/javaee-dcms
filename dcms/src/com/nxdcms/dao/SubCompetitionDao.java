package com.nxdcms.dao;

import java.util.List;

import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;

public interface SubCompetitionDao {

	public boolean subCompetitionsave(Competition competition,Subcompetition subcompetition);
		
	public List<Subcompetition> querysubCompetitionByComp(Competition competition);
	
	public Subcompetition findbySubCompetitionId(Subcompetition subcomp);
	
	public boolean deleteSubcompetition(Subcompetition subcomp);
	
	public boolean modifySubcompetition(Subcompetition subcomp);
}
