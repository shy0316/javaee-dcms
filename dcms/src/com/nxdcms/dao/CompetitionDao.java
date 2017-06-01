package com.nxdcms.dao;

import java.util.Date;
import java.util.List;

import com.nxdcms.entity.Competition;

public interface CompetitionDao {
	public Competition queryCompetition(int id);
	public boolean subCompetitionSave(Competition competition);
	public boolean subCompetitionDelete(Competition competition);
	public boolean subCompetitionModify(Competition competition);
	public List  subCompetitionQuery(Competition competition);//列出所有信息
	public List  subCompetitionQuery2(Competition competition);//查询comId=？的全部信息
	public List  search(Competition commpetition);//模糊查询竞赛信息（作查看竞赛信息用）
	public List joinSearch(String comName,Date startTime,Date stopDate);//模糊查询竞赛信息（作查看学生参赛信息用）
	
	
	public List<Competition> findAll();
	
	public Competition queryRecommend(int id);
}
