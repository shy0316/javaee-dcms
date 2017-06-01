package com.nxdcms.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.Notice;
import com.nxdcms.service.impl.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {

	private Notice notice;
	private String message;
	private HttpServletRequest request;
	private HttpServletResponse response;
	Noticeserviceimpl usi = new Noticeserviceimpl();
	Noticedaoimpl udi = new Noticedaoimpl();
	List<Notice> list = new ArrayList<Notice>();
	

	public List<Notice> getList() {
		return list;
	}

	public void setList(List<Notice> list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String add() throws Exception {
		if (usi.addNotice(notice)) {
			message = "��ӹ���ɹ�";

			return Action.SUCCESS;
		} else {
			message = "��ӹ���ʧ��";
			return Action.ERROR;
		}
	}

	public String del() throws Exception {
		if (usi.delNotice(notice)) {
			message = "ɾ������ɹ�";

			return Action.SUCCESS;
		} else {
			message = "ɾ������ʧ��";
			return Action.ERROR;
		}
	}

	public String update() throws Exception {
		if (usi.modifyNotice(notice)) {
			message = "�޸Ĺ���ɹ�";

			return Action.SUCCESS;
		} else {
			message = "�޸Ĺ���ʧ��";
			return Action.ERROR;
		}

	}

	
    public String list() throws Exception {
    	
	    this.setList(udi.Query());
	    return Action.SUCCESS;
    }
    
    public String frontlist() throws Exception {
    	response = ServletActionContext.getResponse();
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("Content-Type;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	List<Notice> lists=udi.FrontQuery();
    	String json = JSONArray.toJSONString(lists);
    	System.out.println(json);
	    out.println(json);
	    return null;
    }
    
   
   public String mes() throws Exception{
	   this.setList(usi.showMessage(notice));
		return Action.SUCCESS;
   }
   
   public String search() throws Exception{
		  this.setList(udi.Search(notice));
		  return Action.SUCCESS;
	  }
}
