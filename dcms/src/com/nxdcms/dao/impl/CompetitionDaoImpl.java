package com.nxdcms.dao.impl; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

import com.nxdcms.dao.CompetitionDao;
import com.nxdcms.entity.Competition;
import com.nxdcms.entity.Subcompetition;
import com.nxdcms.entity.collegedictionary;

public class CompetitionDaoImpl implements CompetitionDao {
	
	//卢迪部分需要此方法
	public Competition queryCompetition(int id) {
		Session session = null;
		Transaction tx = null;
		List<Subcompetition> subcompList = null;
		Competition competition = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			competition = (Competition) session.load(Competition.class, id);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return competition;
			
	}

	//保存用户信息
	public boolean subCompetitionSave(Competition competition) {
		boolean flag=false;
		Session session = null;
		try {
			//获取session session是hibernatesession 
			session = HibernateUtils.getSession();
			//Transaction 
			session.beginTransaction();
			 
			// get方法加载数据 如果不存在返回null
			Competition competition2 = (Competition) session.get(Competition.class, competition.getComId());		
			
			if(competition2==null){
				session.save(competition);
				flag=true;
			 }else{
				 System.out.println(competition.getComId());
			 }			 
			 session.getTransaction().commit();			 
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}
	//删除用户信息
	public boolean subCompetitionDelete(Competition competition){
		boolean flag = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			Competition competition2 = (Competition) session.get(Competition.class, competition.getComId()); 
			if (competition2 == null) {
				System.out.println("你要删除的竞赛信息不存在");
				flag = false;
			} else {
				flag = true;
				System.out.println(flag);
				System.out.println(competition2.getComId());
				session.delete(competition2);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}
	
	//修改竞赛信息
	public boolean subCompetitionModify(Competition competition) {
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			// 查上来的 数据都有 是持久状态 不需要update,建议使用此中方式 先加载再更新 不要先new在更新
			Competition competition2 = (Competition) session.get(Competition.class, competition.getComId());  
			if (competition2 != null ) {
				//competition2.setComId(competition.getComId());
				competition2.setComContent(competition.getComContent());
				competition2.setComLink(competition.getComLink());
				competition2.setComName(competition.getComName());
				competition2.setEnterStart(competition.getEnterStart());
				competition2.setEnterStop(competition.getEnterStop());
				competition2.setFlag(competition.getFlag());
				competition2.setHoldingUnit(competition.getHoldingUnit());
				competition2.setIssuer(competition.getIssuer());
				competition2.setPublishTime(competition.getPublishTime());
				competition2.setScale(competition.getScale());
				competition2.setType(competition.getType());
				
				session.save(competition2);
			} else {
				session.save(competition);	
			}
			flag = true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}
	
	//查询所用竞赛信息列表
	public List<Competition> subCompetitionQuery(Competition competition) {
		Session session = null;
		List<Competition> competitionList = new ArrayList<Competition>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Query query = session.createQuery("from Competition"); // 全部查询
		
			competitionList = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return competitionList;
	}
	
	//通过id查询
	public List<Competition> subCompetitionQuery2(Competition competition) {
		Session session = null;
		List<Competition> competitionList = new ArrayList<Competition>();
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			Competition competition2 = (Competition) session.get(Competition.class, competition.getComId());    //获取list指定对象值
			int comid = competition2.getComId();
			Query query = session.createQuery("from Competition competition where competition.comId=?"); // 查询comId=？的全部信息
			query.setInteger(0,comid);
		
			competitionList = query.list();
			/*for(Competition com: competitionList)
			{
				System.out.println(com.toString());
			}*/
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return competitionList;

	}

	//模糊查询
	public List<Competition> search(Competition competition){
		Session session=null;
		List<Competition> competitionList = new ArrayList<Competition>();		
		try{
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			//将前台的数据传到后台，用变量存储，前台写了4个需查询的条件
			String comName=competition.getComName();
			String scale=competition.getScale();
			int type=competition.getType();
			int flag=competition.getFlag();
			//测试输出
			System.out.println("comName"+comName);
			System.out.println("scale"+scale);
			System.out.println("type"+type);
			System.out.println("flag"+flag);
			//定义一些全局变量
			String[] con=new String[5];//定义分别代表四个查询条件的数组
			int[] temp=new int[5]; //通过optition中的值判断前台用户是否选择查询条件的数组，如果选了，将数组中的值设为1
			int j=0;//存储temp数组中共有几个“1”
			String Query=null;//查询语句
		
			//定义分别代表四个查询条件的数组
			con[1]="competition.comName like '%"+comName+"%'";
			con[2]="competition.scale='"+scale+"'";
			con[3]="competition.type="+type;
			con[4]="competition.flag="+flag;
		
			//如果用户在自选框选中的话 ，temp数组中相应变量设为1
			if(!(comName==null || comName.equals(""))){
				temp[1]=1;
			}
			if(!(scale==null || scale.equals(""))){
				temp[2]=1;
			}
			if(type==1 || type==0){
				temp[3]=1;
			}
			if(flag==1 || flag==0){
				temp[4]=1;
			}
		
			//查看temp数组中有几个1：即四个选项填了几个，存在j变量中
			for(int i=1;i<5;i++){
				if(temp[i]==1){
					j++;
				}
			}System.out.println("四个选项填了几个:"+j);
			
			//通过判断j中有几个1，来分别写四种情况
			switch (j){
				//j中只有没有1，全部查询
				case 0: Query="from Competition competition";
				//j中只有1个1，遍历出的1就是对应前台需要查询的那个语句
				case 1: {
					for(int k=1;k<5;k++){
						if(temp[k]==1){
							Query="from Competition competition where "+con[k];
						}
					}break;
				}
				case 2:{
				//j中有两个1，遍历出第1个后，第二个在剩下的几个中遍历
					for(int k=1;k<5;k++){
						if(temp[k]==1){
							Query="from Competition competition where "+con[k];
							for(int a=k;a<5;a++){
								if(temp[a]==1)
									Query=Query+" and "+con[a];
							}
						}
					}
					break;
				}
				case 3:{
					//j中有3个1，没想到好办法，就列出四种情况，找出不是1的，查剩下3个
					if(temp[1]!=1)
						Query="from Competition competition where "+con[2]+" and "+con[3]+" and "+con[4];
					if(temp[2]!=1)
						Query="from Competition competition where "+con[1]+" and "+con[3]+" and "+con[4];
					if(temp[3]!=1)
						Query="from Competition competition where "+con[2]+" and "+con[1]+" and "+con[4];
					if(temp[4]!=1)
						Query="from Competition competition where "+con[2]+" and "+con[3]+" and "+con[1];
					break;
					
				}
				case 4:{
					//有4个1，查询条件都加上
					Query="from Competition competition where "+con[1]+" and "+con[2]+" and "+con[3]+" and "+con[4];
					break;
				}
				default:break;
			}
					
			System.out.println(Query);
			Query query1=session.createQuery(Query);
			
			competitionList=query1.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return competitionList;		
	}
	
	//模糊查询竞赛信息（作查看学生参赛信息用）
	public List<Competition> joinSearch(String comName,Date startTime,Date stopTime){
		Session session = null;
		List<Competition> competitionList = new ArrayList<Competition>();
		String sql=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			if(comName.equals("")&&startTime==null){
				sql="from Competition competition";
			}else if(!(comName.equals(""))&&startTime==null){
				sql="from Competition competition where competition.comName like '%"+comName+"%'";
			}else if(comName.equals("")&& startTime!=null){
				sql="from Competition competition where competition.publishTime between '"+sdf.format(startTime)+"' and '"+sdf.format(stopTime)+"'";
			}
			System.out.println("sql:::"+sql);
			Query query = session.createQuery(sql);
		
			competitionList = query.list();
			for(Competition com: competitionList)
			{
				System.out.println("执行结果"+com.getEnterStop());
			}
			session.getTransaction().commit();

		} catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return competitionList;
		
	}

	public Competition queryRecommend(int id) {
		Competition competition = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			List competlist = session.createQuery("from Competition as comp where comp.comId=?").setInteger(0, id).list();
			competition = (Competition) competlist.get(0);
			System.out.println(competition.getComName());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		return competition;
	}

	public List<Competition> findAll() {
		List<Competition> list =null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			list = session.createQuery("from Competition").list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
		return list;
	}

}
