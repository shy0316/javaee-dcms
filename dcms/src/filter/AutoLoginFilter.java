package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="autoLoginFilter",urlPatterns="*.jsp")
public class AutoLoginFilter implements Filter{
	public void destroy() {
		
	}
	public void doFilter(ServletRequest Srequest, ServletResponse Sresponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) Srequest;
		HttpServletResponse response=(HttpServletResponse) Sresponse;
		String uri=request.getRequestURI();
		String stuId=(String) request.getSession().getAttribute("studentId");
		String adminId=(String) request.getSession().getAttribute("AdminId");

		if(uri.equals("/dcms/")){
			chain.doFilter(Srequest, Sresponse);
			return;
		}
		
		if(stuId!=null||adminId!=null){
			chain.doFilter(Srequest, Sresponse);
			return;
			
		}else{
			if(uri.equals("/dcms/personcenter.jsp")||uri.equals("/dcms/personalset.jsp")||uri.equals("/dcms/personal.jsp")){
				request.getRequestDispatcher("Student_login.jsp").forward(request, response);
			}else{
				chain.doFilter(Srequest, Sresponse);
			}
			
			
		}
	
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
