package com.nxdcms.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import utils.CodeUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.nxdcms.entity.Administrator;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Student;
import com.nxdcms.service.StudentService;
import com.nxdcms.service.impl.AdministratorServiceImpl;
import com.nxdcms.service.impl.StudentServiceImpl;

public class LoginAction extends BaseAction{
	
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request= ServletActionContext.getRequest();
	private ActionContext ctx;
	private Administrator administrator;
	private Student student=null;
	private String administratorId;
	private String administratorPassword;
	private String rememberMe;
	private String stuId;
	private String stuPassword;
	StudentService studentService;
	StudentServiceImpl ssi;
	AdministratorServiceImpl asi;
	List<Administrator> list=new ArrayList<Administrator>();
	Map<String,Object> map = new HashMap<String,Object>();
	
	


	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
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
	public String getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(String administratorId) {
		this.administratorId = administratorId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	public List<Administrator> getList() {
		return list;
	}
	public void setList(List<Administrator> list) {
		this.list = list;
	}
	
	public String LoginStu(){
		ctx=ActionContext.getContext();
		ssi = new StudentServiceImpl();
		asi=new AdministratorServiceImpl();
		String ID=this.getStuId();
		String password=this.getStuPassword();
		String remember=this.getRememberMe();
		Integer counter=(Integer) ctx.getApplication().get("counter");
		if(counter==null){
			counter=1;
		}else{
			counter++;
		}
		ctx.getApplication().put("counter", counter);
		
		student = ssi.searchStu(ID,password);
		administrator=asi.searchAdm(ID, password);
		System.out.println(administrator);
		HttpSession session = request.getSession();

		if(student!=null){	
			if(canLogin(ID,request)){
				if(remember!=null){
					Cookie cookie=new Cookie("student",ID);
					cookie.setMaxAge(60*60*24*30);
					ServletActionContext.getResponse().addCookie(cookie);
				}
				ctx.getSession().put("studentId",ID);	
				String name=student.getStudentName();
				request.getSession().setAttribute("stuMess", name+"，欢迎来到学科管理系统");
				session.setAttribute("sid", student.getStudentId());
				return Action.SUCCESS;
				
			}
		//检查是否是管理员
		} 
		if(administrator!=null){
			ctx.getSession().put("AdminId",ID);	
			String name=administrator.getAdministratorName();
			request.getSession().setAttribute("Admin", name);
			session.setAttribute("sid", administrator.getAdministratorId());
			return Action.ERROR;
		}
		return "loginfail";
		
	//	return Action.INPUT;
	}

	
	//判断不同浏览器上同一用户登录情况
	//用唯一的sessionId和studentId判断，放在map中
	//通过stuId取sessionId，如果sessionId为空，放入map，不为空，判断是否和当前sessionId相同，
	public boolean canLogin(String stuId,HttpServletRequest request){
		HttpSession session=request.getSession();
		Map<String,String> userSessionMap=null;
		//获取全局域
		ServletContext application=session.getServletContext();
		userSessionMap=(Map)application.getAttribute("userSessionMap");
		if(userSessionMap==null){
			userSessionMap=new HashMap<String,String>();
			userSessionMap.put(stuId,session.getId());
			application.setAttribute("userSessionMap", userSessionMap);
			return true;
		}
		String sessionId=userSessionMap.get(stuId);
		if(sessionId==null){
			userSessionMap.put(stuId,session.getId());
			return true;
		}
		
		
		if(!sessionId.equals(session.getId())){
			request.setAttribute("loginMessage", "您的账号已经登录，不能重复登录！");
			return false;
		}		
		
		return true;
	}
	 //�û��˳�  
    public String logoutAdmin() {  
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpSession session  = request.getSession(); 
    	ServletContext application=session.getServletContext();
    	Object obj = session.getAttribute("studentId");
    	Object objAdmin=session.getAttribute("AdminId");
    	
    	if(obj!=null){
    		session.invalidate();
    		application.removeAttribute("userSessionMap");
    		return Action.SUCCESS;
    	}
    	if(objAdmin!=null){
    		session.invalidate();
    		return Action.ERROR;
    	}
    	/*//ɾ��cookie
    	Cookie[] c=request.getCookies(); 
    	if(c!=null){
    		 for(int i=0;i<c.length;i++)
    		{
    			System.out.println("cookie"+i+"��ֵ��"+c[i].getName());
    			 if(c[i].getName().equals("administrator")){
    				 c[i].setMaxAge(0);
    			} 
    		}   
    	}*/
		return Action.INPUT;
    }
    //����ѧ����Ϣ
    public String perfectStuInfo() throws UnsupportedEncodingException{
    	studentService=new StudentServiceImpl();
    	if(studentService.perfectStuInfo(student)){
    		return Action.SUCCESS;
    	}else{
    		return Action.ERROR;
    	}
    }

    public void showStuInfo() throws IOException{
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html:utf-8");
    	
    	ssi = new StudentServiceImpl();
    	HttpSession session=ServletActionContext.getRequest().getSession();
    	String stuId=(String) session.getAttribute("studentId");
    	Student student=ssi.searchStu(stuId);
 
    	//后台从hibernate取出的student是存在session
    	//直接传map格式不正确
    	map.put("student",student);
    	
    	/*JSONArray json=JSONArray.fromObject(map);
    	System.out.println(json);*/
    	JsonConfig config=new JsonConfig();
    	String rs=JSONObject.fromObject(map,config).toString();
    	
    	PrintWriter out=response.getWriter();
    	out.print(rs);
    	//第二种方式：返回void，将map放在response的输出流中。
    	//原因：对象的元素也为对象时，，传到前台时报错，，内存溢出
    } 	
    
    //check and change student password
    public void StuPasswordcheck() throws IOException{
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type","text/html; charset=UTF-8");
		
		Student student=null;
		ssi=new StudentServiceImpl(); 
		PrintWriter out=response.getWriter();
		String stuId=(String) request.getSession().getAttribute("studentId");
		System.out.println("studnetId:"+stuId);
		String oldPass=request.getParameter("oldPass");
		String newPass=request.getParameter("newPass");
		String confirmPass=request.getParameter("confirmPass");
		String result="";
		boolean flag=true; 
		System.out.println(stuId+"   "+oldPass+"    "+newPass);
		
		student=ssi.searchStu(stuId, oldPass);
		if(student==null){
			//out.print("密码错误！\n");
			result+="密码错误,请重新输入！\n";
			flag=false;
			out.print(result);
		}
		
		if(flag==true){
			boolean isEqual= ssi.modifyStuPassword(student, newPass);
			System.out.println("equal:"+isEqual);
			if(isEqual==true){
				out.print("修改密码成功！");
			}else{
				out.print("修改密码失败！");
			}
		}
		
	
	}    	
    	
    public String registStudent() throws UnsupportedEncodingException{
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type","text/html; charset=UTF-8");
		
		ActionContext act=ActionContext.getContext();
		//System.out.println("student++++ID������"+student.getStudentId());
		
		ssi=new StudentServiceImpl();
		if(ssi.addStu(student)){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}		
	}
    
    public void createCode(){
    	CodeUtil codeUtil=new CodeUtil();
    	codeUtil.createCode(request,response);
    }
    
    public void codeCheck(){
		try {
			PrintWriter out=response.getWriter();
	    	String pic=request.getParameter("rand");
	    	String rand=(String) request.getSession().getAttribute("rand");
			System.out.println("pic:"+pic+"+++++++rand"+rand);
			if(pic.equals(rand) || rand.equals("")){
				out.print("true");
			}else{
				out.print("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}   	
    }
    
    public void stuIdCheck() throws IOException{
    	System.out.println("执行");
    	PrintWriter out=response.getWriter();
    	String stuId=request.getParameter("stuId");
		System.out.println("STUID::::"+stuId);
		StudentServiceImpl  ssi = new StudentServiceImpl();
		student = ssi.searchStu(stuId);
		if(student!=null){
			out.print("true");
		}else{
			out.print("false");
		}
    }
}
