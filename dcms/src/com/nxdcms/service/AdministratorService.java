package com.nxdcms.service;

import com.nxdcms.entity.Administrator;

public interface AdministratorService {
	public Administrator searchAdm(String admID, String admPassword);
	
	public Administrator searchAdm(String admID);
	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#addAdministrator(com.nxdcms.entity.Administrator)
	 */
	public boolean addAdministrator(Administrator administrator);

	
	//完善管理员信息（注册功能）
	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#perfectAdminInfo(com.nxdcms.entity.Administrator)
	 */
	public boolean perfectAdminInfo(Administrator administrator);

	//修改管理员密码
	/* (non-Javadoc)
	 * @see com.nxdcms.service.impl.AdministratorService#modifyAdminPassword(com.nxdcms.entity.Administrator, java.lang.String)
	 */
	public boolean modifyAdminPassword(Administrator administrator, String newPassword);
	
}
