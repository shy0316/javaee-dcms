package com.nxdcms.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.nxdcms.dao.BaseDao;
import com.nxdcms.dao.impl.BaseDaoImpl;
import com.nxdcms.entity.collegedictionary;
import com.nxdcms.service.DictionarytService;
import com.nxdcms.service.impl.DictionaryManageServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class BaseAction extends ActionSupport {
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();

	private String classname;
	private String name;
	private List result;
	private DictionarytService ds = new DictionaryManageServiceImpl();
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getClassname() {
		return classname;
	}

	public List getResult() {
		return result;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String loadDirectoryFrom() throws Exception {
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		System.out.println(classname);
		BaseDao bd = new BaseDaoImpl();
		result = bd.findCollegeDictionary(classname);
		return SUCCESS;
	}

	public void deleteDirectoryFrom() throws Exception {
		response.setCharacterEncoding("utf-8");
		BaseDao bd = new BaseDaoImpl();
		bd.deleteDictionary(classname, name);
	}
	
	
	public String loadAllDictionaryM(){
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		result = ds.getAllManage();
		return SUCCESS;
	}
	
}
