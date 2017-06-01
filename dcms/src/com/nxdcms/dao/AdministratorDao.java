package com.nxdcms.dao;

import java.util.List;

import com.nxdcms.entity.Administrator;

public interface AdministratorDao {
	public Administrator searchAdm(String admID,String admPassword);
	public Administrator searchAdm(String admID);
	public boolean addAdministrator(Administrator administrator);
	public boolean perfectAdminInfo(Administrator administrator);//���ƹ���Ա��Ϣ��ע�Ṧ�ܣ�
	public boolean modifyAdminPassword(Administrator administrator,String newPassword);
}
