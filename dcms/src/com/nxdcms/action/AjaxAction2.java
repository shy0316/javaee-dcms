package com.nxdcms.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nxdcms.dao.impl.FenyeTest2;
import com.nxdcms.dao.impl.PageBean;
import com.nxdcms.entity.Subcompetition;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction2 extends ActionSupport {
	private FenyeTest2 ft2 = new FenyeTest2();
	private List<PageBean> result=null;
	private static PageBean p = new PageBean(0, 5,0);
	List<PageBean> list = new ArrayList<PageBean>();
//	private List<Subcompetition> list = new ArrayList<Subcompetition>();
	private String page;
	private String rows;
	private String grade="";
	private String teacher="";
	private String time="";
	

	
	private List<Subcompetition> list1 = new ArrayList<Subcompetition>();
	public String execute() {
		Subcompetition sub = new Subcompetition();
		
		if(time!=null&&!time.equals("")){
			int year = Integer.parseInt(time.split("-")[0]);
			int month = Integer.parseInt(time.split("-")[1]);
			int date = Integer.parseInt(time.split("-")[2]);
			System.out.println(year);
			sub.setAwarddate(new Date(year-1900, month-1, date));
		}
		if(grade!=null&&!grade.equals("")){
			
			sub.setAwardGrade(grade);
		}
		if(teacher!=null&&!teacher.equals("")){
			
			sub.setTeacher(teacher);
		}
		p.setRows(Integer.parseInt(rows));
		switch (page) {
		case "1"://首页
			p.setPage(0);
			break;
		case "2"://上一页
			p.setPage(p.getPage() - 1);
			if(p.getPage()<0){
				p.setPage(0);
			}
			System.out.println(p.getPage());
			break;
		case "3"://下一页
			System.out.println("OK");
			p.setPage(p.getPage() + 1);
//			System.out.println(p.getPage());
			if(p.getPage()>p.getLastpage()){
				p.setPage(p.getLastpage());
			}
			System.out.println(p.getPage());
			break;
		case "4"://尾页
			p.setPage(p.getLastpage());
			System.out.println(p.getPage());
			break;
		default:
			p.setPage(0);
			break;
		}
		this.setList(ft2.count(p,sub));
		result = list; 
		System.out.println(this.result);
		return SUCCESS;
	}
	public List<PageBean> getList() {
		return list;
	}

	public void setList(List<PageBean> list) {
		this.list = list;
	}

	public List<PageBean> getResult() {
		return result;
	}

	public void setResult(List<PageBean> result) {
		this.result = result;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getGrade() {
		return grade;
	}

}
