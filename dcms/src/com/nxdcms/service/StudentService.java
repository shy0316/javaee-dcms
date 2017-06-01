package com.nxdcms.service;

import com.nxdcms.entity.Student;

public interface StudentService {

	Student searchStu(String stuId, String stuPassword);

	Student searchStu(String stuId);

	boolean addStu(Student student);

	boolean perfectStuInfo(Student student);

	boolean modifyStuPassword(Student student, String newPassword);

}