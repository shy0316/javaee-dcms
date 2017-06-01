package utils;

import com.jacob.com.*;
import com.jacob.activeX.*;

import java.io.*;

public class testCoding
{
  /*
   * 作者：郭喜跃/【捂汗县长】
   * 时间：2013-7-20
   * 程序功能：调用jacob包，在Microsoft Office 能够支持打开的文件类型中随意进行格式转换（本程序不是批量转换，一次只能转单个文件）。
   * 由于我电脑上安装的是Office 2013,所以甚至可以实现pdf与txt！用起来很方便，代码不算长吧？
   * 
   * */
  public static void main(String[] args)
  {
    //指定被转换文件的完整路径。 我这里的意图是把pdf转为txt
    String path = new String("d:\\qwewqeqwe.docx");
    //根据路径创建文件对象
    File docFile=new File(path);
    //获取文件名（包含扩展名）
    String filename=docFile.getName();
    //过滤掉文件名中的扩展名
    int filenamelength=filename.length();
    int dotposition=filename.indexOf(".");
    filename=filename.substring(0,dotposition);
    
    //设置输出路径，一定要包含输出文件名（不含输出文件的扩展名）
    String savepath = new String ("D:\\"+filename);	
    
    //启动Word程序
    ActiveXComponent app = new ActiveXComponent("Word.Application");		
    //接收输入文件和输出文件的路径，这两个参数名不能改！
    String inFile = path;
    String tpFile = savepath;
    //设置word不可见
    app.setProperty("Visible", new Variant(false));
    //这句不懂
    Object docs = app.getProperty("Documents").toDispatch();
    //打开输入的doc文档
    Object doc = Dispatch.invoke((Dispatch) docs,"Open", Dispatch.Method, new Object[]{inFile,new Variant(false), new Variant(true)}, new int[1]).toDispatch();
    
    //另存文件, 其中Variant(n)参数指定另存为的文件类型，详见代码结束后的文字
    Dispatch.invoke((Dispatch) doc,"SaveAs", Dispatch.Method, new Object[]{tpFile,new Variant(2)}, new int[1]);
    //这句也不懂
    Variant f = new Variant(false);
    //关闭并退出
    Dispatch.call((Dispatch) doc, "Close", f);
    app.invoke("Quit", new Variant[] {});
    System.out.println("转换完毕。");
   String content = getContent(tpFile+".txt");
   System.out.println(content);
//    WordString.forceDelete(tpFile+".txt");
  }
	public static String getContent(String file) {
		StringBuffer sb = new StringBuffer();
		String temp = "";
		
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "gbk");
			BufferedReader bis = new BufferedReader(isr);
			while((temp=bis.readLine()) != null)
				sb.append(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
