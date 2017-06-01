package com.nxdcms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;

import com.nxdcms.dao.CompetitionDao;
import com.nxdcms.dao.RecommendDao;
import com.nxdcms.dao.impl.CompetitionDaoImpl;
import com.nxdcms.dao.impl.RecommendDaoImpl;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.UserPerference;
import com.nxdcms.entity.UserPerferencesEntity;
import com.nxdcms.service.RecommendService;

/**
 * @author lah01
 *
 */
public class RecommendServiceImpl implements RecommendService {


		
	
	public void saveUserPerference(int userId, int itemId, float perference) {
		//这个是改了偏好表
		RecommendDao rd = new RecommendDaoImpl();
		//更新了偏好表
		rd.saveOrupdateById(userId, itemId, perference);
		//重新计算推荐见过更新到用户表
		try {
			long recommendedId = rd.updateUserRecommendItem(userId);
			rd.saveOrUpdateStudent(userId,(int)recommendedId);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//更新用户表
	}


	public List<Integer> getItemIdsList(List<UserPerference> list){
		RecommendDao rd = new RecommendDaoImpl();
		List<Integer> itemsIdList = new ArrayList();
		for(UserPerference up :list){
			itemsIdList.add((int)up.getCompetitionId());
		}
		return itemsIdList;
	}

	public UserPerferencesEntity showAllUserPerference(int userId) {
		//我评价的竞赛
		//这里面有竞赛的名字和这个人对应的打分
		RecommendDao rd = new RecommendDaoImpl();
		UserPerferencesEntity upe = new UserPerferencesEntity();
		List<UserPerference> up = rd.findAllById(userId);
		List<Integer> itemIdLists = getItemIdsList(up);
		List<Competition> competitionList = rd.findAllitems(itemIdLists);
		upe.setPerferenceslist(up);
		upe.setCompetitionlist(competitionList);
			return upe;
	}

	public Competition getRecommendItem(int userId) {
		RecommendDao rd = new RecommendDaoImpl();
		//获取推荐的item 
		Competition competition = null;
		long id = rd.findPerferenceById(userId);
		if(id==0){
			return null;
		}else{
			CompetitionDao cd = new CompetitionDaoImpl();
			competition = cd.queryRecommend((int)id);
			return competition;
		}
		//根据这个东西的ID 去查询competition
	}

	
	public void sendEmail(int userId) {
		
	}


	public void updateStudentPerference(int userId, int itemId) {
		RecommendDao rd = new RecommendDaoImpl();
		rd.saveOrUpdateStudent(userId, itemId);
	}
	
}
