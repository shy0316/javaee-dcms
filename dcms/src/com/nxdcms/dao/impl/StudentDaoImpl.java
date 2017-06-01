package com.nxdcms.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nxdcms.dao.StudentDao;
import com.nxdcms.entity.Administrator;
import com.nxdcms.entity.Student;

import utils.HibernateUtils;

public class StudentDaoImpl implements StudentDao{

	
	public Student searchStu(String stuId, String stuPassword) {
		Session session = null;
		Transaction tx = null;
		Student student = null;
		// ���ǰ̨���ܺ������
		String disgestPassword = this.md5disgest(stuPassword);
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, stuId);
			if (student!= null) {
				String password = student.getStudentPassword();
				if (password.equals(disgestPassword)) {
					return student;
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

	public Student searchStu(String stuId) {
		Session session = null;
		Transaction tx = null;
		Student student = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, stuId);
			if (student != null) {
				return student;
			}
			tx.commit();
			//HibernateUtils.closeSession(session);

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
//			HibernateUtils.closeSession(session);
		}

		//HibernateUtils.closeSession(session);
		return student;
	}

	public boolean addStu(Student student) {
		boolean flag = false;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			// get������������ ��������ڷ���null
			Student student2 = (Student) session.get(Student.class,
					student.getStudentId());

			if (student2 == null) {
				String password = student.getStudentPassword();
				// ��ü��ܺ������
				String disgestPassword = this.md5disgest(password);
				// �����ܺ������������ݿ�
				student.setStudentPassword(disgestPassword);
				session.save(student);
				flag = true;
			} else {
				System.out.println(student.getStudentId());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
//			HibernateUtils.closeSession(session);
		}
		return flag;
	}

	public boolean perfectStuInfo(Student student) {
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Student student2 = (Student) session.get(Student.class, student.getStudentId());  
			student2.setStudentAge(student.getStudentAge());;
			student2.setStudentCollege(student.getStudentCollege());
			student2.setStudentDiscipline(student.getStudentDiscipline());
			student2.setStudentEmail(student.getStudentEmail());
			student2.setStudentIdcard(student.getStudentIdcard());
			student2.setStudentName(student.getStudentName());
			student2.setStudentPhone(student.getStudentPhone());
			student2.setStudentStartYear(student.getStudentStartYear());
			flag = true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
//			HibernateUtils.closeSession(session);
		}
		return flag;
	}

	
	public boolean modifyStuPassword(Student student, String newPassword) {
		Session session = null;
		Transaction tx = null;
		
		boolean flag = false;
		
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String disgestPassword = this.md5disgest(newPassword);
			System.out.println("加密newpasswrod:"+disgestPassword);
			
			Student student2 = (Student) session.get(Student.class,student.getStudentId());  
			student2.setStudentPassword(disgestPassword);
//			session.saveOrUpdate(student2);			
			flag=true;			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
//			HibernateUtils.closeSession(session);
		}
		
		return flag;
	}
	
	// md5����
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
				// ת��Ϊ16����
				for (int i = 0; i < newByte.length; i++) {
					if ((newByte[i] & 0xff) < 0x10) {
						sb.append("0");
					}
					sb.append(Long.toString(newByte[i] & 0xff, 16));
				}
				return sb.toString();
			}
	
}
