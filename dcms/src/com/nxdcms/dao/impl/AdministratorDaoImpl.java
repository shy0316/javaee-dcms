package com.nxdcms.dao.impl;

import java.util.List;
import java.security.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nxdcms.dao.AdministratorDao;
import com.nxdcms.entity.Administrator;
import com.nxdcms.entity.Competition;

import utils.HibernateUtils;

public class AdministratorDaoImpl implements AdministratorDao {
	public Administrator searchAdm(String admID, String admPassword) {
		Session session = null;
		Transaction tx = null;
		Administrator administrator = null;
		// 获得前台加密后的密码
		String disgestPassword = this.md5disgest(admPassword);
		System.out.println("管理员"+admID+":"+admPassword);
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			administrator = (Administrator) session.load(Administrator.class,admID);
		
			if (administrator != null) {
				String password = administrator.getAdministratorPassword();
				System.out.println(password.length());
				System.out.println(disgestPassword.length());
				if (disgestPassword.trim().equals(password.trim())) {
					return administrator;
				}
			}
			tx.commit();
//			HibernateUtils.closeSession(session);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
//			HibernateUtils.closeSession(session);
		}
//		HibernateUtils.closeSession(session);
		return null;

	}

	// 按照用户ID搜索用户
	public Administrator searchAdm(String admID) {
		Session session = null;
		Transaction tx = null;
		Administrator administrator = null;

		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			administrator = (Administrator) session.get(Administrator.class, admID);
			if (administrator != null) {
				return administrator;
			}

			tx.commit();
			HibernateUtils.closeSession(session);

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			HibernateUtils.closeSession(session);
		}

		HibernateUtils.closeSession(session);
		return administrator;
	}

	// 增加用户
	public boolean addAdministrator(Administrator administrator) {
		boolean flag = false;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			// get方法加载数据 如果不存在返回null
			Administrator administrator2 = (Administrator) session.get(Administrator.class,
					administrator.getAdministratorId());

			if (administrator2 == null) {
				String password = administrator.getAdministratorPassword();
				// 获得加密后的密码
				String disgestPassword = this.md5disgest(password);
				// 将加密后的密码存入数据库
				administrator.setAdministratorPassword(disgestPassword);
				session.save(administrator);
				flag = true;
			} else {
				System.out.println(administrator.getAdministratorId());
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

	// 完善管理员的信息，相当于修改管理员信息
	public boolean perfectAdminInfo(Administrator administrator) {
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			// 查上来的 数据都有 是持久状态 不需要update,建议使用此中方式 先加载再更新 不要先new在更新
			Administrator administrator2 = (Administrator) session.get(Administrator.class, administrator.getAdministratorId());  
			if (administrator2 != null ) {
				administrator2.setAdministratorName(administrator.getAdministratorName());
				administrator2.setAdministratorCollege(administrator.getAdministratorCollege());
				administrator2.setAdministratorEmail(administrator.getAdministratorEmail());
				administrator2.setAdministratorPhnoe(administrator.getAdministratorPhnoe());
				session.save(administrator2);
			} else {
				session.save(administrator);	
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

	//修改管理员密码
	public boolean modifyAdminPassword(Administrator administrator, String newPassword) {
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			/*if (administrator!= null && newPassword!=null) {
				System.out.println(administrator.getAdministratorPassword()+"newPassword:"+newPassword);
				// 获得加密后的密码
				String disgestPassword = this.md5disgest(newPassword);
				administrator.setAdministratorPassword(disgestPassword);
				
				//System.out.println("mimamimamima"+administrator.getAdministratorPassword());
				//session.save(administrator);
				flag = true;
			}*/	
			// 获得加密后的密码
			String disgestPassword = this.md5disgest(newPassword);
			
			Administrator administrator2 = (Administrator) session.get(Administrator.class, administrator.getAdministratorId());  
			if (administrator2 != null ) {
				administrator2.setAdministratorPassword(disgestPassword);
				session.save(administrator2);
			} else {
				session.save(administrator);	
			}
			flag=true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return flag;
	}

	// md5加密
		private String md5disgest(String str) {
			byte[] strByte = str.getBytes();
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			md.update(strByte);
			byte[] newByte = md.digest();
			StringBuilder sb = new StringBuilder();
			// 转换为16进制
			for (int i = 0; i < newByte.length; i++) {
				if ((newByte[i] & 0xff) < 0x10) {
					sb.append("0");
				}
				sb.append(Long.toString(newByte[i] & 0xff, 16));
			}
			return sb.toString();
			/*
			 * try { // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”） MessageDigest disdigest =
			 * MessageDigest.getInstance("md5"); // 输入的字符串转换成字节数组 byte[] digest =
			 * disdigest.digest(key.getBytes()); String base =
			 * base64.encode(digest); return base.substring(0, base.length() - 1); }
			 * catch (NoSuchAlgorithmException e) { throw new RuntimeException(e); }
			 */
		}
	

	
}
