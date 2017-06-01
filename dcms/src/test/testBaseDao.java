package test;

import com.nxdcms.dao.BaseDao;
import com.nxdcms.dao.impl.BaseDaoImpl;

public class testBaseDao {
	public static void main(String[] args) {
		BaseDao bd = new BaseDaoImpl();
//		bd.addCollegeDictionary("信息工程学院");
//		bd.addCollegeDictionary("电子工程学院");
//		bd.addCollegeDictionary("商学院");
//		bd.addCollegeDictionary("美术学院");
		bd.addCompetitionLevel("院级");
		bd.addCompetitionLevel("校级");
		bd.addCompetitionLevel("市级");
		bd.addCompetitionLevel("省级");
		bd.addCompetitionLevel("国家级");
		
		//bd.addCollegeDictionary("环境工程学院");
	}
}
