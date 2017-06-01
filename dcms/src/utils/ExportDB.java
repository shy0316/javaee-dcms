package utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 将hbm生成ddl 是一个工具包哦
 **/
public class ExportDB {

	public static void main(String[] args) {
		// 默认读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
		// 打到控制台 输入到数据库 OK
	}

}
