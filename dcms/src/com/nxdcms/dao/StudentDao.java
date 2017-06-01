package com.nxdcms.dao;


import com.nxdcms.entity.Student;

public interface StudentDao {
	public Student searchStu(String stuId,String stuPassword);
	public Student searchStu(String stuId);
	public boolean addStu(Student student);
	public boolean perfectStuInfo(Student student);
	public boolean modifyStuPassword(Student student,String newPassword);
}
