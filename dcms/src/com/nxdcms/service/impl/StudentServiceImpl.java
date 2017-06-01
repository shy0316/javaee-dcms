package com.nxdcms.service.impl;

import com.nxdcms.dao.impl.StudentDaoImpl;
import com.nxdcms.entity.Student;
import com.nxdcms.service.StudentService;

public class StudentServiceImpl implements StudentService{
private StudentDaoImpl sdi=new StudentDaoImpl();
	public Student searchStu(String stuId, String stuPassword) {
		Student student=sdi.searchStu(stuId,stuPassword);
		return student;
	}

	public Student searchStu(String stuId) {
		Student student=sdi.searchStu(stuId);
		return student;
	}

	public boolean addStu(Student student) {
		boolean flag=sdi.addStu(student);
		return flag;
	}

	public boolean perfectStuInfo(Student student) {
		boolean flag=sdi.perfectStuInfo(student);
		return flag;
	}

	public boolean modifyStuPassword(Student student, String newPassword) {
		boolean flag=sdi.modifyStuPassword(student, newPassword);
		return flag;
	}

}
