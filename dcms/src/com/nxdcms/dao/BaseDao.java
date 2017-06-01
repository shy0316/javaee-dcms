package com.nxdcms.dao;

import java.util.List;

import com.nxdcms.entity.collegedictionary;
import com.nxdcms.entity.dictionaryManage;

public interface BaseDao {
	public void addCollegeDictionary(String collegeName);
	
	public void addCompetitionLevel(String level);
	
	public void addCompetitionType(String Type);
	
	public List findCollegeDictionary(String className);
	
	public void deleteDictionary(String className,String name);

	public void addDictionaryManage(dictionaryManage dm);
	
	public List<dictionaryManage> findAllDictionary();
}
