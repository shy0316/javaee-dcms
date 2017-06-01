package com.nxdcms.service;

import java.util.Date;
import java.util.List;

import com.nxdcms.entity.Competition;

public interface CompetitionService {
		public boolean SaveComInfo(Competition competition);
		public boolean DeleteComInfo(Competition competition);
		public boolean ModifyComInfo(Competition competition);
		public List queryComInfo(Competition competition);
		public List querySpecificComInfo(Competition competition);
		public List search(Competition competition);//ģ����ѯ������Ϣ�����鿴������Ϣ�ã�
		public List joinSearch(String comName,Date startTime,Date stopTime);//ģ����ѯ������Ϣ�����鿴ѧ��������Ϣ�ã�
		public List<Competition> loadAllCompetition();
		
}
