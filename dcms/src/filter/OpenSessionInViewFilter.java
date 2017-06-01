package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;

import utils.HibernateUtils;

public class OpenSessionInViewFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(
	        ServletRequest arg0, 
	        ServletResponse arg1,
	        FilterChain chain) 
	                       throws IOException,   ServletException {
       Session session =  HibernateUtils.getSession();
		try {
	    
	            chain.doFilter(arg0, arg1);
	        } finally {
	            HibernateUtils.closeSession(session);
	        }
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


	}


