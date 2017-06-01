package com.nxdcms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.nxdcms.entity.Competition;
import com.nxdcms.entity.UserPerference;
import com.nxdcms.entity.UserPerferencesEntity;
import com.nxdcms.service.CompetitionService;
import com.nxdcms.service.RecommendService;
import com.nxdcms.service.impl.CompetitionServiceImpl;
import com.nxdcms.service.impl.RecommendServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import utils.JsonUtils;
import utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

public class RecommendAction extends ActionSupport {
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private RecommendService rs = new RecommendServiceImpl();
	private String userId;
	private String itemId;
	private String perference;
	private List<Competition> competitionList;
	private List<UserPerference> perferencesList;
	private CompetitionService cs = new CompetitionServiceImpl();
	{
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
	}
	public List<Competition> getCompetitionList() {
		return competitionList;
	}

	public List<UserPerference> getPerferencesList() {
		return perferencesList;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setPerference(String perference) {
		this.perference = perference;
	}


	
	public void LoadAllPerferences(){
		String Id = request.getParameter("Id");
		int uid = Integer.parseInt(Id);
		UserPerferencesEntity upe = null;
		upe = rs.showAllUserPerference(uid);
		JSONObject  ja1 =	JSONObject.fromObject(upe,JsonUtils.getSubCompetition());
		
		
		
		PrintWriter out;
		try {
			out = response.getWriter();
			
			out.println(ja1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadAllCompetitions(){
		competitionList = cs.loadAllCompetition();
		JSONArray  ja1=JSONArray.fromObject(competitionList,JsonUtils.getSubCompetition());
		
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(ja1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdatePerferences(){
		int uId = Integer.parseInt(userId);
		int iId = Integer.parseInt(itemId);
		float score = Float.parseFloat(perference);
		rs.saveUserPerference(uId, iId, score);
	}
	
	public void SendRecommendedItem(){
		String uId = request.getParameter("Id");
		int id = Integer.parseInt(uId);
		Competition  recommended = rs.getRecommendItem(id);
		
		JSONObject jo = JSONObject.fromObject(recommended,JsonUtils.getSubCompetition());
		PrintWriter out;
		try {
			out = response.getWriter();
			String js = jo.toString();
			out.println(js);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
