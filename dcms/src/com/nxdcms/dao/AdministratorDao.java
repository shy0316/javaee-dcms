package com.nxdcms.dao;

import java.util.List;

import com.nxdcms.entity.Administrator;

public interface AdministratorDao {
	public Administrator searchAdm(String admID,String admPassword);
	public Administrator searchAdm(String admID);
	public boolean addAdministrator(Administrator administrator);
	public boolean perfectAdminInfo(Administrator administrator);//完善管理员信息（注册功能）
	public boolean modifyAdminPassword(Administrator administrator,String newPassword);
}
