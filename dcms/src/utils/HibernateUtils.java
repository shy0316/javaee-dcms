package utils;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public  class HibernateUtils {
	private static SessionFactory factory=null;



	public static Session getSession() {
		return getSessionFactory().openSession();
	}
	
	public  static void closeSession(Session session){
		if(session !=null)
		{
			if(session.isOpen()){
				session.close();
			}
		}
			
	}
	
	public static SessionFactory getSessionFactory(){
		if(factory==null){
			Configuration cfg = new Configuration().configure();

			factory = cfg.buildSessionFactory();
		}
		return  factory;
		
	}
	public static void main(String[] args) {
		Session session = getSession();
		System.out.println(session);
	}
	
	
	@Test
	public void test(){
		Session session = getSession();
		System.out.println(session);
	}

}