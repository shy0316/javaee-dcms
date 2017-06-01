package com.nxdcms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nxdcms.entity.Administrator;
import com.nxdcms.entity.Student;
import com.nxdcms.service.impl.StudentServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{
	private Administrator administrator;
	private Student student;
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private StudentServiceImpl ssi;
	List<Administrator> list=new ArrayList<Administrator>();
	List<Student> Stulist=new ArrayList<Student>();
	
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public List<Administrator> getList() {
		return list;
	}

	public void setList(List<Administrator> list) {
		this.list = list;
	}
	
	
	//ѧ��ע��
	public String registStudent(){
		ActionContext act=ActionContext.getContext();
		//System.out.println("student++++ID������"+student.getStudentId());
		
		ssi=new StudentServiceImpl();
		if(ssi.addStu(student)){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}
}
