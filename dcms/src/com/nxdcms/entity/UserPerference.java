package com.nxdcms.entity;

import java.io.Serializable;
import java.util.Date;

public class UserPerference implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8512269300545226897L;
	private long  studentId;
	private long  competitionId;
	private float perferences;
	private Date time;
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}
	public float getPerferences() {
		return perferences;
	}
	public void setPerferences(float perferences) {
		this.perferences = perferences;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserPerference [studentId=" + studentId + ", competitionId=" + competitionId + ", perferences="
				+ perferences + ", time=" + time + "]";
	}
	
	
}
