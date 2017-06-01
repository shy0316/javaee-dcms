package com.nxdcms.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.nxdcms.dao.CompetitionDao;
import com.nxdcms.dao.impl.CompetitionDaoImpl;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;
import com.nxdcms.service.CompetitionManage;
import com.nxdcms.service.impl.CompetitionManageImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import utils.WordString;

public class CompetionManageAction extends ActionSupport implements SessionAware {

	
	private Map<String,Object> session;
	private Subcompetition subCompetion;
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private File compBook;
	public String compBookFileName;
	private String compBookContentType;
	private String content;
	
	private File compAgreement;
	private String compAgreementFileName;
	private String compAgreementContentType;
	List<Subcompetition> subCompList = null;
	
	private File awardPic;
	private String awardPicFileName;
	private String awardPicContentType;
	
	private int ComId;//cpp加

	public int getComId() {
		return ComId;
	}

	public void setComId(int comId) {
		ComId = comId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public File getAwardPic() {
		return awardPic;
	}

	public void setAwardPic(File awardPic) {
		this.awardPic = awardPic;
	}

	public String getAwardPicFileName() {
		return awardPicFileName;
	}

	public void setAwardPicFileName(String awardPicFileName) {
		this.awardPicFileName = awardPicFileName;
	}

	public String getAwardPicContentType() {
		return awardPicContentType;
	}

	public void setAwardPicContentType(String awardPicContentType) {
		this.awardPicContentType = awardPicContentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public List<Subcompetition> getSubCompList() {
		return subCompList;
	}

	public void setSubCompList(List<Subcompetition> subCompList) {
		this.subCompList = subCompList;
	}

	public Subcompetition getSubCompetion() {
		return subCompetion;
	}

	public File getCompBook() {
		return compBook;
	}

	public void setCompBook(File compBook) {
		this.compBook = compBook;
	}

	public String getCompBookFileName() {
		return compBookFileName;
	}

	public void setCompBookFileName(String compBookFileName) {
		this.compBookFileName = compBookFileName;
	}

	public String getCompBookContentType() {
		return compBookContentType;
	}

	public void setCompBookContentType(String compBookContentType) {
		this.compBookContentType = compBookContentType;
	}

	public File getCompAgreement() {
		return compAgreement;
	}

	public void setCompAgreement(File compAgreement) {
		this.compAgreement = compAgreement;
	}

	public String getCompAgreementFileName() {
		return compAgreementFileName;
	}

	public void setCompAgreementFileName(String compAgreementFileName) {
		this.compAgreementFileName = compAgreementFileName;
	}

	public String getCompAgreementContentType() {
		return compAgreementContentType;
	}

	public void setCompAgreementContentType(String compAgreementContentType) {
		this.compAgreementContentType = compAgreementContentType;
	}

	public void setSubCompetion(Subcompetition subCompetion) {
		this.subCompetion = subCompetion;
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

	public String SaveCompetitionInfo() throws Exception {
		boolean flag = false;
		CompetitionManage cm = new CompetitionManageImpl();

		// 虚拟数据
		Competition competition = null;
		CompetitionDao cd = new CompetitionDaoImpl();
		competition =cd.queryCompetition(1);
		
		InputStream is = null;
		OutputStream os = null;
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		String mypath = path+"\\file\\";
		try {
			if (compBook != null) {
				is = new BufferedInputStream(new FileInputStream(compBook));
				os = new BufferedOutputStream(new FileOutputStream(mypath
						+ compBookFileName));
				byte[] buffer = new byte[1024];
				int len = 0;

				while ((len = is.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
				subCompetion.setCompBookName(compBookFileName);
				subCompetion.setCompBookpath(mypath + compBookFileName);

			}
			if (compAgreement != null) {

				is = new BufferedInputStream(new FileInputStream(compAgreement));
				os = new BufferedOutputStream(new FileOutputStream(mypath
						+ compAgreementFileName));
				byte[] buffer2 = new byte[1024];
				int len2 = 0;

				while ((len2 = is.read(buffer2)) > 0) {
					os.write(buffer2, 0, len2);
				}
				subCompetion.setCompAgreementName(compAgreementFileName);
				subCompetion.setCompAgreementpath(mypath
						+ compAgreementFileName);

			}

		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}

		}
		flag = cm.SavesubCompInfo(competition, subCompetion);

		if (flag == true) {
			return Action.SUCCESS;
		}

		else {
			return Action.ERROR;
		}
	}

	
	public String LoadsubCompetitionInfo() {

		CompetitionManage cm = new CompetitionManageImpl();

		Competition competition = new Competition();
		competition.setComId(ComId);
		subCompList = cm.queryclassifiedCompetition(competition);
	

		if (subCompList==null) {
			return Action.ERROR;
		} else {
			return Action.SUCCESS;
		}
	}

	public String ShowmyCompetition() {

		CompetitionManage cm = new CompetitionManageImpl();

		subCompetion = cm.querymyCompetition(subCompetion);
		if (subCompetion.getStuId1() != null)
			return Action.SUCCESS;
		else {
			return Action.ERROR;
		}
	}

	public String loadFileinDocs() {
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		String mypath = path+"\\file\\";
		String path2=mypath
						+subCompetion.getCompBookName();
		content = WordString.extractDoc(path2, "d:\\xxx.txt");
		
		return Action.SUCCESS;

	}
	
	public String deleteeachSubcompetition(){
		boolean flag=false;
		CompetitionManage cm = new CompetitionManageImpl();
		flag = cm.deleteoneSubCompetition(subCompetion);
		System.out.println(flag);
		if(flag == true){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}
	
	
	
	public String ModifySubcompetitionStep1() {
		CompetitionManage cm = new CompetitionManageImpl();

		subCompetion = cm.querymyCompetition(subCompetion);
		if (subCompetion.getStuId1() != null)
			return Action.SUCCESS;
		else {
			return Action.ERROR;
		}
	}

	public String ModifySubcompetitionStep2() throws Exception{
		boolean flag = true;
		CompetitionManage cm = new CompetitionManageImpl();
		
		
		InputStream is = null;
		OutputStream os = null;
	
		ActionContext ac =  ActionContext.getContext();
		ServletContext sContext = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);
		String path = sContext.getRealPath("/");
		String mypath = path+"\\file\\";
		

		try {
			if (compBook != null) {
				is = new BufferedInputStream(new FileInputStream(compBook));
				os = new BufferedOutputStream(new FileOutputStream(mypath
						+ compBookFileName));
				byte[] buffer = new byte[1024];
				int len = 0;

				while ((len = is.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
				subCompetion.setCompBookName(compBookFileName);
				subCompetion.setCompBookpath(mypath + compBookFileName);

			}
			if (compAgreement != null) {

				is = new BufferedInputStream(new FileInputStream(compAgreement));
				os = new BufferedOutputStream(new FileOutputStream(mypath
						+ compAgreementFileName));
				byte[] buffer2 = new byte[1024];
				int len2 = 0;

				while ((len2 = is.read(buffer2)) > 0) {
					os.write(buffer2, 0, len2);
				}
				subCompetion.setCompAgreementName(compAgreementFileName);
				subCompetion.setCompAgreementpath(mypath
						+ compAgreementFileName);

			}
			if(awardPic != null)
			{
				is = new BufferedInputStream(new FileInputStream(awardPic));
				os = new BufferedOutputStream(new FileOutputStream(mypath
						+ awardPicFileName));
				byte[] buffer3 = new byte[1024];
				int len3 = 0;

				while ((len3 = is.read(buffer3)) > 0) {
					os.write(buffer3, 0, len3);
				}
			
			
			//	subCompetion.setAwardPicName(awardPicFileName);
				subCompetion.setAwardPicpath(mypath
						+ awardPicFileName);
			}

		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}

		}
		
		
		flag = cm.modifySubCompetition(subCompetion);
		
		if(flag == true)
		{
			return Action.SUCCESS;
		}
		else{
			return Action.ERROR;
		}
	}
	
}
