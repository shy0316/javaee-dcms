package utils;

import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.poi.ss.usermodel.Workbook;


public class ResponseUtil {

//	public static void write(HttpServletResponse response,Object o)throws Exception{
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out=response.getWriter();
//		out.print(o.toString());
//		out.flush();
//		out.close();
//	}
//	
	public static void export(HttpServletResponse response,Workbook wb,String fileName)throws Exception{
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
		response.setContentType("application/ynd.ms-excel;charset=UTF-8");
		OutputStream os=response.getOutputStream();
		wb.write(os);
		
		os.flush();
		os.close();
		
		
		
	}

}
