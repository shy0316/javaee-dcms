package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter {

	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        //POST的乱码解决方案
	        request.setCharacterEncoding("utf-8");
	        
	        //返回数据的乱码解决方案
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        
	        //将增强后的对象放行
	        MyRequest myRequest = new MyRequest(request);
	        chain.doFilter(myRequest, response);    //这样一来,后面所有的操作都是基于这个增强后的对象进行的
	    }
	    /**创建一个request对象的包装类:
	         1.编写一个类,实现与被增强对象相同的接口
	         2.在类中定义一个变量,记住被增强对象
	         3.在类中定义一个构造方法,接收被增强对象
	         4.覆写想要增强的方法
	         5.对于不想增强的方法,直接调用被增强对象(目标对象)的方法
	     包装设计模式"五步曲"
	     */
	    class MyRequest extends HttpServletRequestWrapper{
	        private HttpServletRequest request;
	        public MyRequest(HttpServletRequest request) {
	            super(request);
	            this.request = request;
	        }
	        public String getParameter(String name) {
	            //如果请求方式是POST,则不用增强,直接调用目标对象的方法
	            if(this.request.getMethod().equalsIgnoreCase("POST")){
	                return this.request.getParameter(name);
	            }
	            /*程序运行到此,请求方式必然为GET
	            先获取值,再进行手动转换*/
	            String value = this.request.getParameter(name);
	            try {
	                value = new String(value.getBytes("iso8859-1"),"utf-8");
	            } catch (UnsupportedEncodingException e) {
	                throw new RuntimeException(e);
	            }
	            return value;        //返回
	        }
	    }
	    
	    public void destroy() {
	        // TODO Auto-generated method stub
	    }
	    public void init(FilterConfig fConfig) throws ServletException {
	        // TODO Auto-generated method stub
	    }
}
