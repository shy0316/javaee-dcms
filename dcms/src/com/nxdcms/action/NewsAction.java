package com.nxdcms.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.nxdcms.dao.impl.*;
import com.nxdcms.entity.News;
import com.nxdcms.service.impl.*;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {

	private News news;
	private String message;
	private HttpServletRequest request;
	private HttpServletResponse response;
	Newsserviceimpl usi = new Newsserviceimpl();
	Newsdaoimpl udi = new Newsdaoimpl();
	List<News> list = new ArrayList<News>();
	
	private String newsPhotoFileName;
	private File newsPhoto;
	private String newsPhotoContentType;
	
	public String getNewsPhotoFileName() {
		return newsPhotoFileName;
	}

	public void setNewsPhotoFileName(String newsPhotoFileName) {
		this.newsPhotoFileName = newsPhotoFileName;
	}

	public File getNewsPhoto() {
		return newsPhoto;
	}

	public void setNewsPhoto(File newsPhoto) {
		this.newsPhoto = newsPhoto;
	}

	public String getNewsPhotoContentType() {
		return newsPhotoContentType;
	}

	public void setNewsPhotoContentType(String newsPhotoContentType) {
		this.newsPhotoContentType = newsPhotoContentType;
	}

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String add() throws Exception {
		InputStream is = null;
		OutputStream os = null;
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		String mypath = path+"\\file\\";
		
		try {
			if(newsPhoto != null){
				is = new BufferedInputStream(new FileInputStream(newsPhoto));
				os = new BufferedOutputStream(new FileOutputStream(mypath + newsPhotoFileName)); 
				byte[] buffer = new byte[1024];
				int len =0;
				while((len = is.read(buffer))>0){
					os.write(buffer,0,len);
				}
				news.setNewsPhotoName(newsPhotoFileName);
				news.setNewsPhotoPath(mypath + newsPhotoFileName);
			}
		} finally {
			if(is != null){ is.close(); }
			if(os != null){ os.close(); }
		}	
		if (usi.addNews(news)) {
			message = "添加用户成功";

			return Action.SUCCESS;
		} else {
			message = "添加用户失败";
			return Action.ERROR;
		}
	}

	public String del() throws Exception {
		if (usi.delNews(news)) {
			message = "删除用户成功";

			return Action.SUCCESS;
		} else {
			message = "删除用户失败";
			return Action.ERROR;
		}
	}

	public String update() throws Exception {
		InputStream is = null;
		OutputStream os = null;
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		String mypath = path+"\\file\\";
		try {
			if(newsPhoto != null){
				is = new BufferedInputStream(new FileInputStream(newsPhoto));
				os = new BufferedOutputStream(new FileOutputStream(mypath + newsPhotoFileName)); 
				byte[] buffer = new byte[1024];
				int len =0;
				while((len = is.read(buffer))>0){
					os.write(buffer,0,len);
				}
				news.setNewsPhotoName(newsPhotoFileName);
				news.setNewsPhotoPath(mypath + newsPhotoFileName);
			}
		} finally {
			if(is != null){ is.close(); }
			if(os != null){ os.close(); }
		}
		if (usi.modifyNews(news)) {
			message = "修改用户成功";

			return Action.SUCCESS;
		} else {
			message = "修改用户失败";
			return Action.ERROR;
		}

	}

	
	public String search() throws Exception {
		System.out.println(news.getNewsTitle());
		this.setList(udi.Query(news));
		System.err.println("++++++++Query++++++++"+udi.Query(news).toString());
		return Action.SUCCESS;

	}
	
	public String list() throws Exception {
		this.setList(udi.list());
		
		return Action.SUCCESS;

	}
	public String details() throws Exception {
		System.out.println(news.getNewsTitle());
		this.setList(usi.showDetails(news));
		System.err.println("++++++++Query++++++++"+udi.Details(news).toString());
		return Action.SUCCESS;
	}
	
	public String show() throws Exception {
		this.setList(usi.showNews());
		return Action.SUCCESS;
	}
	
	public String showIndex() throws Exception {
		this.setList(usi.showIndexnews());
		System.err.println("------ShowIndex---------"+udi.ShowIndex().toString());
		return Action.SUCCESS;
	}

}
