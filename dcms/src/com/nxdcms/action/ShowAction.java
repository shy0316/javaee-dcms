package com.nxdcms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.*;
import com.nxdcms.service.impl.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import utils.Excelutils;
import utils.ResponseUtil;

public class ShowAction extends ActionSupport implements ModelDriven<Subcompetition>{

	private Subcompetition subcompetition = new Subcompetition();
	private HttpServletRequest request;
	private HttpServletResponse response;

	Showserviceimpl ssi = new Showserviceimpl();
	Showdaoimpl sdi = new Showdaoimpl();
	List<Subcompetition> list = new ArrayList<Subcompetition>();

	static List<Subcompetition> list2 = new ArrayList<Subcompetition>();



	

//	public Subcompetition getSubcompetition() {
//		return subcompetition;
//	}
//
//
//
//	public void setSubcompetition(Subcompetition subcompetition) {
//		this.subcompetition = subcompetition;
//	}



	public List<Subcompetition> getList() {
		return list;
	}

	public void setList(List<Subcompetition> list) {
		this.list = list;
	}




	public String update() throws Exception {
		System.out.println("www");
		if (ssi.modify(subcompetition)) {
			return Action.SUCCESS;
		} else {	
			return Action.ERROR;
		}

	}

	public String list() throws Exception {
		System.out.println("000");
		this.setList(ssi.query());
		return Action.SUCCESS;

	}
	
	public String export() throws Exception {
		System.out.println("000");
		Workbook wb=new HSSFWorkbook();
		this.setList(ssi.query());
		Excelutils ex =new Excelutils();
		ex.export(list, wb);
		ResponseUtil.export(ServletActionContext.getResponse(), wb, "poi.xls");
		return Action.SUCCESS;

	}
	
	public String content() throws Exception {
		System.out.println("111");
		System.out.println(subcompetition.getSubcompid());
		this.setList(sdi.content(subcompetition));
		return Action.SUCCESS;

	}
	public String search() throws Exception {
		System.out.println("000");
//		String awardGrade = request.getParameter("search");
		
		System.out.println(subcompetition.getAwardGrade());
		System.out.println(subcompetition.getTeacher());
		
		System.out.println(subcompetition.getCollege());
		
		
		this.setList(sdi.Search(subcompetition));
		list2 = sdi.Search(subcompetition);
		System.out.println(list2.get(0).getSubcompid());
		return Action.SUCCESS;

	}
	
	public String export1() throws Exception {
		
		//this.setList(sdi.Search(subcompetition));
		Workbook wb=new HSSFWorkbook();
		Excelutils ex =new Excelutils();
		ex.export(list2, wb);
		ResponseUtil.export(ServletActionContext.getResponse(), wb, "poi.xls");
		return Action.SUCCESS;

	}


	public Subcompetition getModel() {
		// TODO Auto-generated method stub
		return subcompetition;
	}
}
