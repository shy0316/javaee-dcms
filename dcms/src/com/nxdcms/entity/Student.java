package com.nxdcms.entity;
// Generated 2016-10-14 10:20:41 by Hibernate Tools 3.2.2.GA

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {

	private String studentId;
	private String studentPassword;
	private String studentName;
	private int studentAge;
	private String studentCollege;
	private String studentDiscipline;
	private String studentClass;
	private String studentStartYear;
	private String studentIdcard;
	private String studentEmail;
	private String studentPhone;
	private long recommendedItem;
	private String recommendedName;
	

	public String getRecommendedName() {
		return recommendedName;
	}

	public void setRecommendedName(String recommendedName) {
		this.recommendedName = recommendedName;
	}

	public Student() {
	}
	
	public Student(String studentEmail, long recommendedItem) {
		super();
		this.studentEmail = studentEmail;
		this.recommendedItem = recommendedItem;
	}

	public Student(String studentId, String studentPassword, String studentName, int studentAge, String studentCollege,
			String studentDiscipline, String studentClass, String studentStartYear, String studentIdcard,
			String studentPhone) {
		this.studentId = studentId;
		this.studentPassword = studentPassword;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentCollege = studentCollege;
		this.studentDiscipline = studentDiscipline;
		this.studentClass = studentClass;
		this.studentStartYear = studentStartYear;
		this.studentIdcard = studentIdcard;
		this.studentPhone = studentPhone;
	}

	public Student(String studentId, String studentPassword, String studentName, int studentAge, String studentCollege,
			String studentDiscipline, String studentClass, String studentStartYear, String studentIdcard,
			String studentEmail, String studentPhone) {
		this.studentId = studentId;
		this.studentPassword = studentPassword;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentCollege = studentCollege;
		this.studentDiscipline = studentDiscipline;
		this.studentClass = studentClass;
		this.studentStartYear = studentStartYear;
		this.studentIdcard = studentIdcard;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentPassword() {
		return this.studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return this.studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentCollege() {
		return this.studentCollege;
	}

	public void setStudentCollege(String studentCollege) {
		this.studentCollege = studentCollege;
	}

	public String getStudentDiscipline() {
		return this.studentDiscipline;
	}

	public void setStudentDiscipline(String studentDiscipline) {
		this.studentDiscipline = studentDiscipline;
	}

	public String getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentStartYear() {
		return this.studentStartYear;
	}

	public void setStudentStartYear(String studentStartYear) {
		this.studentStartYear = studentStartYear;
	}

	public String getStudentIdcard() {
		return this.studentIdcard;
	}

	public void setStudentIdcard(String studentIdcard) {
		this.studentIdcard = studentIdcard;
	}

	public String getStudentEmail() {
		return this.studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPhone() {
		return this.studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public long getRecommendedItem() {
		return recommendedItem;
	}

	public void setRecommendedItem(long recommendedItem) {
		this.recommendedItem = recommendedItem;
	}
}
