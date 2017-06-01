package com.nxdcms.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;
import com.nxdcms.service.CompetitionManage;
import com.nxdcms.service.CompetitionService;
import com.nxdcms.service.impl.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompetitionAction extends ActionSupport{
	private Competition competition;
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	//做模糊查询时获取的竞赛名称，时间
	private String comName; 
	private Date startTime;
	private Date stopTime;
	List<Competition> list=new ArrayList<Competition>();
	List<Subcompetition> sublist=null;
	
	private File comLink;
	private String comLinkFileName;
	
	
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	public List<Competition> getList() {
		return list;
	}

	public void setList(List<Competition> list) {
		this.list = list;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public File getComLink() {
		return comLink;
	}

	public void setComLink(File comLink) {
		this.comLink = comLink;
	}


	public String getComLinkFileName() {
		return comLinkFileName;
	}

	public void setComLinkFileName(String comLinkFileName) {
		this.comLinkFileName = comLinkFileName;
	}

	//保存竞赛信息
	public String SaveCompetitionInfo() throws Exception{
		CompetitionService csi=new CompetitionServiceImpl();
		InputStream is = null;
		OutputStream os = null;
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		System.out.println("path:"+path);
		String mypath=path+"file\\";
		System.out.println("mypath1:"+mypath);
		
		try {
			if (comLink != null) {
				is = new BufferedInputStream(new FileInputStream(comLink));
				os = new BufferedOutputStream(new FileOutputStream(mypath + comLinkFileName));
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = is.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
				competition.setComLink(comLinkFileName);
				competition.setComLinkPath(mypath + comLinkFileName);							
				//System.out.println("getComLinkPath()："+competition.getComLinkPath());
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}	
		if (csi.SaveComInfo(competition)){
				return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
	
	//删除竞赛信息
	public String DeleteCompetitionInfo() throws Exception{
		CompetitionService csi=new CompetitionServiceImpl();

		if (csi.DeleteComInfo(competition)){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
	
	//修改竞赛信息
	public String ModifyCompetitionInfo() throws Exception{
		CompetitionService csi=new CompetitionServiceImpl();
		InputStream is = null;
		OutputStream os = null;
		//String mypath = "C:\\apache-tomcat-7.0.69-windows-x64\\apache-tomcat-7.0.69\\webapps\\competion\\comLink\\";
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		System.out.println("path:"+path);
		String mypath=path+"file\\";
		try {
			if(comLink != null){
				is = new BufferedInputStream(new FileInputStream(comLink));
				os = new BufferedOutputStream(new FileOutputStream(mypath + comLinkFileName)); 
				byte[] buffer = new byte[1024];
				int len =0;
				while((len = is.read(buffer))>0){
					os.write(buffer,0,len);
				}
				competition.setComLink(comLinkFileName);
				competition.setComLinkPath(mypath + comLinkFileName);
			}
		} finally {
			if(is != null){ is.close(); }
			if(os != null){ os.close(); }
		}
		
		if (csi.ModifyComInfo(competition)){
				return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
	
	//查询所用竞赛信息列表
	public String QueryCompetitionInfo() throws Exception{	
		CompetitionService csi=new CompetitionServiceImpl();

		this.setList(csi.queryComInfo(competition));
		return Action.SUCCESS;
	}
	
	//按照comid查询某一竞赛详细信息
	public String QueryCompetitionInfo2() throws Exception{	
		CompetitionService csi=new CompetitionServiceImpl();
		CompetitionManage cm = new CompetitionManageImpl();
		
		ActionContext ctx=ActionContext.getContext();
		//设置网站的访问次数
		Integer counter=(Integer) ctx.getApplication().get("counter");
		if(counter==null){
			counter=1;
		}else{
			counter++;
		}
		ctx.getApplication().put("counter", counter);
		//System.out.println(counter);
		
		//查询competition和subCompetition信息
		this.setList(csi.querySpecificComInfo(competition));
		sublist = cm.queryclassifiedCompetition(competition);
		
		return Action.SUCCESS;
	}

	//模糊查询竞赛信息
	public String search() throws Exception{
		CompetitionService csi=new CompetitionServiceImpl();
		
		this.setList(csi.search(competition));
		return Action.SUCCESS;
	}

	//模糊查询竞赛信息（作查询参赛学生信息用）
	public String joinSearch() throws Exception{
		CompetitionService csi=new CompetitionServiceImpl();
		String comName=this.getComName();
		Date startTime=this.getStartTime();
		Date stopTime=this.getStopTime();
		System.out.println("模糊查询竞赛信息（作查询参赛学生信息用）"+comName+startTime+stopTime);
		this.setList(csi.joinSearch(comName, startTime, stopTime));
		return Action.SUCCESS;
	}
	
}
