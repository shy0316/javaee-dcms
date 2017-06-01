package com.nxdcms.service.impl;

import java.util.List;

import com.nxdcms.dao.*;
import com.nxdcms.dao.impl.Showdaoimpl;
import com.nxdcms.entity.*;
import com.nxdcms.service.Showservice;

public class Showserviceimpl implements Showservice{




	public List<Subcompetition> query() {
		Showdaoimpl sdi = new Showdaoimpl();
		List<Subcompetition> list=sdi.Query();
		return list;
	}

	public boolean modify(Subcompetition subcompetition) {
		Showdaoimpl sdi = new Showdaoimpl();
		if (sdi.Modify(subcompetition))
			return true;
		else
			return false;
	}
}
