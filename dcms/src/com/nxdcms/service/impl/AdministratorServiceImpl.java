package com.nxdcms.service.impl;

import java.util.List;

import com.nxdcms.dao.impl.AdministratorDaoImpl;
import com.nxdcms.entity.Administrator;
import com.nxdcms.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService{
	private AdministratorDaoImpl administratorDaoimpl=new AdministratorDaoImpl();
	public Administrator searchAdm(String admID, String admPassword) {
		Administrator administrator=administratorDaoimpl.searchAdm(admID, admPassword);
		return administrator;
	}

	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#searchAdm(java.lang.String)
	 */
	public Administrator searchAdm(String admID) {
		Administrator administrator=administratorDaoimpl.searchAdm(admID);
		return administrator;
	}
	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#addAdministrator(com.nxdcms.entity.Administrator)
	 */
	public boolean addAdministrator(Administrator administrator) {
		boolean flag=administratorDaoimpl.addAdministrator(administrator);
		return flag;
	}

	
	//完善管理员信息（注册功能）
	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#perfectAdminInfo(com.nxdcms.entity.Administrator)
	 */
	public boolean perfectAdminInfo(Administrator administrator){
		boolean flag=administratorDaoimpl.perfectAdminInfo(administrator);
		return flag;
	}

	//修改管理员密码
	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#modifyAdminPassword(com.nxdcms.entity.Administrator, java.lang.String)
	 */
	public boolean modifyAdminPassword(Administrator administrator, String newPassword) {
		boolean flag=administratorDaoimpl.modifyAdminPassword(administrator, newPassword);
		return flag;
	}
	

	
	
}
