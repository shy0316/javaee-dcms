package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public  class JsonUtils {
	public static JsonConfig getSubCompetition(){
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object arg0, String arg1, Object arg2) {
				if (arg1.equals("subcompetitions")) {
					return true;
				} else {
					return false;
				}
			}
		});
		config.setExcludes(new String[] { "handler", "hibernateLazyInitializer" });
		return config;
	}
	

}