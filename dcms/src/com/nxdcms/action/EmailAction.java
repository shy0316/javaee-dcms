package com.nxdcms.action;
import java.util.ArrayList;
import java.util.List;

import com.nxdcms.dao.impl.MailAuthenticator;
import com.nxdcms.entity.Student;
import com.opensymphony.xwork2.ActionSupport;

public class EmailAction extends ActionSupport {
	
	Student student  = new Student();
	MailAuthenticator mail = new MailAuthenticator();
	List<Student> list = new ArrayList<Student>();
	String email = null;
	String src = null;


	public String execute() throws Exception {
		System.out.println(email);
		System.out.println(src);
		if(mail.SendEmail(email, src)){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	public MailAuthenticator getMail() {
		return mail;
	}
	
	public void setMail(MailAuthenticator mail) {
		this.mail = mail;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getSrc() {
		return src;
	}
	
	
	public void setSrc(String src) {
		this.src = src;
	}
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public List<Student> getList() {
		return list;
	}
	
	public void setList(List<Student> list) {
		this.list = list;
	}
}
