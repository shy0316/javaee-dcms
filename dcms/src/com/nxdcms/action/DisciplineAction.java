package com.nxdcms.action;
import java.util.ArrayList;
import java.util.List;

import com.nxdcms.dao.impl.Discipline;
import com.nxdcms.entity.Student;
import com.opensymphony.xwork2.ActionSupport;

public class DisciplineAction extends ActionSupport {
	
	Student student  = new Student();
	Discipline dis = new Discipline();
	List<Student> list = new ArrayList<Student>();
	

	public String execute() {
		if(dis.Query()!=null){
			this.setList(dis.Query());
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}

	



	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Discipline getDis() {
		return dis;
	}
	
	public void setDis(Discipline dis) {
		this.dis = dis;
	}
	
	public List<Student> getList() {
		return list;
	}
	
	public void setList(List<Student> list) {
		this.list = list;
	}
}
