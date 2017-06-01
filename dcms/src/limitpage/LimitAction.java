package limitpage;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.nxdcms.dao.impl.PageBean;
import com.nxdcms.entity.Notice;
import com.nxdcms.entity.Subcompetition;
import com.opensymphony.xwork2.Action;

import utils.HibernateUtils;

public class LimitAction implements Action {
	
	//获取表单的值
	private String pageSize ;
	private String curPage ;
	private String ntitle ;
	private String ndate ;
	private PageObject result = null;

	@Override
	public String execute() throws Exception {
		//调试使用
		System.out.println("当前页"+curPage+"每页行数"+pageSize+ntitle+ndate);

		//定义查询条件
		Criterion criterion0=null,criterion1=null,criterion2=null;
		
		//创建hibernate的session
		Session session = HibernateUtils.getSession();

		//定义hibernate所要查询类
		Class ObjClass = null;
		try {
			//实例化要查询的类名
			ObjClass = Class.forName("com.nxdcms.entity.Notice");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//过滤查询条件，没有查询条件就将空值传入方法
		if(ntitle!=null&&!"".equals(ntitle)&&!"null".equals(ntitle)){
			criterion0 = Restrictions.like("noticeContent", ntitle);
		}else{
			System.out.println("ntitle null");
		}
		if(ndate!=null&&!"".equals(ndate)&&!"null".equals(ndate)){
			criterion1 = Restrictions.like("noticeDate",ndate);
		}else{
			System.out.println("ndate null");
		}
		
		
		//定义排序（降序/升序）
		Order order = Order.asc("noticeDate");
		
		//参数传入工具，返回一个具体的分页类
		//注意最后三个查询条件可以不止三个，理论可以传入无限多个查询条件
		result = LimitDao.queryByPage(session, Integer.parseInt(pageSize), Integer.parseInt(curPage), ObjClass, order,
				criterion0, criterion1);
		
		//调试使用
		if (result == null) {
			System.out.println("po null");
		} else {
			for (Object o : result.getList()) {
				Notice s = (Notice) o;
				System.out.println(s.getNoticeContent());
			}
		}
		System.out.println(result);
		
		return "success";
	}
	
	
	//测试函数
	@Test
	public void test() {
		Session session = HibernateUtils.getSession();
		Class ObjClass = null;
		try {
			ObjClass = Class.forName("com.nxdcms.entity.Notice");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order order = Order.asc("NoticeId");
		Criterion criterion0 = Restrictions.like("noticeContent", ntitle);
		Criterion criterion1 = Restrictions.like("noticeDate", ndate);
		result = LimitDao.queryByPage(session, Integer.parseInt(pageSize), Integer.parseInt(curPage), ObjClass, order,
				criterion0, criterion1);
		if (result == null) {
			System.out.println("po null");
		} else {
			for (Object o : result.getList()) {
				Subcompetition s = (Subcompetition) o;
				System.out.println(s.getAwardGrade());
			}
		}
		System.out.println(result);
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getNtitle() {
		return ntitle;
	}


	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}


	public String getNdate() {
		return ndate;
	}


	public void setNdate(String ndate) {
		this.ndate = ndate;
	}


	public PageObject getResult() {
		return result;
	}

	public void setResult(PageObject result) {
		this.result = result;
	}



}
