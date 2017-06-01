package com.nxdcms.service;

import java.util.List;

import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;
 
public interface CompetitionManage {
		
	public boolean SavesubCompInfo(Competition competition , Subcompetition subcompetition);
		
	public List<Subcompetition> queryclassifiedCompetition(Competition competition);
	
	public Subcompetition querymyCompetition(Subcompetition subcompetition);
	
	public boolean deleteoneSubCompetition(Subcompetition subcompetition);
	
	public boolean modifySubCompetition(Subcompetition subcompetition);
}
