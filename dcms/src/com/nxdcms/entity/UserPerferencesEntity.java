package com.nxdcms.entity;

import java.util.List;

public class UserPerferencesEntity {
	private List<UserPerference> perferenceslist;
	private List<Competition> competitionlist;
	public List<UserPerference> getPerferenceslist() {
		return perferenceslist;
	}
	public void setPerferenceslist(List<UserPerference> perferenceslist) {
		this.perferenceslist = perferenceslist;
	}
	public List<Competition> getCompetitionlist() {
		return competitionlist;
	}
	public void setCompetitionlist(List<Competition> competitionlist) {
		this.competitionlist = competitionlist;
	}
	
	
	
}
