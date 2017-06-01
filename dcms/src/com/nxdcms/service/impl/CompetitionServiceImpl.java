package com.nxdcms.service.impl;

import java.util.Date;
import java.util.List;

import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.Competition;
import com.nxdcms.service.CompetitionService;

public class CompetitionServiceImpl implements CompetitionService{
	public boolean SaveComInfo(Competition competition) {
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		if(cdi.subCompetitionSave(competition)){
			return true;
		}else{
			return false;
		}
	}
	public boolean DeleteComInfo(Competition competition) {
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		if(cdi.subCompetitionDelete(competition)){
			return true;
		}else{
			return false;
		}
	}
	public boolean ModifyComInfo(Competition competition) {
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		if(cdi.subCompetitionModify(competition)){
			return true;
		}else{
			return false;
		}
	}
	//��ѯ���о�����Ϣ���б�
	public List<Competition> queryComInfo(Competition competition) {
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		List<Competition> list=cdi.subCompetitionQuery(competition);
		return list;
	}
	//����comId��ѯĳһ������ϸ��Ϣ
	public List<Competition> querySpecificComInfo(Competition competition) {
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		List<Competition> list=cdi.subCompetitionQuery2(competition);
		return list;
	}
	//ģ����ѯ������Ϣ��Ϊ��ѯ��ϸ������Ϣ�ã�
	public List<Competition> search(Competition competition){
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		List<Competition> list=cdi.search(competition);
		return list;
	}
	
	//ģ����ѯ������Ϣ�����鿴ѧ��������Ϣ�ã�
	public List<Competition> joinSearch(String comName,Date startTime,Date stopTime){
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		List<Competition> list=cdi.joinSearch(comName,startTime,stopTime);
		return list;
	}
	
	
	public List<Competition> loadAllCompetition() {
		CompetitionDaoImpl cdi = new CompetitionDaoImpl();
		return cdi.findAll();
	}
}
