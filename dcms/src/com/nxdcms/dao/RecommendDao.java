package com.nxdcms.dao;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;

import com.nxdcms.entity.Competition;
import com.nxdcms.entity.UserPerference;

public interface RecommendDao {
	
	public List<UserPerference> findAllById(int userId);
	
	public void saveOrupdateById(int userId,int itemId, float perference);
	
	public UserPerference findPerferenceById(int userId,int item);
	
	public Competition findByItemId(int item);
	
	public List<Competition> findAllitems(List<Integer> itemsIds);
	
	public long findPerferenceById(int userId);
	
	public void saveOrUpdateStudent(int userId,int itemId);
	
	public void SeekandUpdateStudentBy24();
	
	public long updateUserRecommendItem(long userId) throws TasteException;
	
}
