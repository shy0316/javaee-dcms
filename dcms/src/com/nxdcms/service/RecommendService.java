package com.nxdcms.service;

import com.nxdcms.entity.Competition;
import com.nxdcms.entity.UserPerferencesEntity;

public interface RecommendService {
	public UserPerferencesEntity showAllUserPerference(int userId);
	
	public void saveUserPerference(int userId,int itemId,float perference); 
	
	public void sendEmail(int userId);
	
	public Competition getRecommendItem(int userId);
	
	//public void updateStudentPerference(int userId,int itemId);
	
}
