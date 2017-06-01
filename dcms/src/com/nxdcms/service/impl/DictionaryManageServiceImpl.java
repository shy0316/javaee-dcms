package com.nxdcms.service.impl;

import java.util.List;

import com.nxdcms.dao.BaseDao;
import com.nxdcms.dao.impl.BaseDaoImpl;
import com.nxdcms.entity.dictionaryManage;
import com.nxdcms.service.DictionarytService;

public class DictionaryManageServiceImpl implements DictionarytService {

	private BaseDao bd = new BaseDaoImpl();
	public List<dictionaryManage> getAllManage() {
		return bd.findAllDictionary();
	}

}
