package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * read wps/word2010+
 * 
 * @author lah01
 * 
 */
public class WordString {

	public static void main(String[] args) {
		String str = extractDoc("d:/qwewqeqwe.docx",
				"d:/java项目/hibernate项目/dcms/WebContent/file/1.txt");
		System.out.println(str);
	}

	/**
	 * 把word文档转换为TXT格式的文档
	 * 
	 * @param inputFile
	 *            word文件的绝对路径
	 * @param outputFile
	 *            转化为TXT文件后的绝对路径
	 * @return 转化之后的TXT文件的字符串
	 */
	public static String extractDoc(String inputFile, String outputFile) {

		String content = "";

		ComThread.InitSTA();

		// 打开word应用程序
		ActiveXComponent app = new ActiveXComponent("Word.Application");
		Dispatch doc2 = null;
		try {
			// 设置word不可见
			app.setProperty("Visible", new Variant(false));

			Dispatch doc1 = app.getProperty("Documents").toDispatch();// 所有文档窗口

			doc2 = Dispatch.invoke(
					doc1,
					"Open",
					Dispatch.Method,
					new Object[] { inputFile, new Variant(false),
							new Variant(true) }, new int[1]).toDispatch();

			// 作为TXT格式，保存到了临时文件
			Dispatch.invoke(doc2, "SaveAs", Dispatch.Method, new Object[] {
					outputFile, new Variant(7) }, new int[1]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭Word
			Variant f = new Variant(false);
			Dispatch.call(doc2, "Close", f);// doc2关闭
			app.invoke("Quit", new Variant[] {});// 退出word
			ComThread.Release();
			content = getContent(outputFile);
			// WordString.delete(outputFile);
			WordString.forceDelete(outputFile);
		}
		return content;

	}

	/**
	 * 删除文件
	 * 
	 * @param file
	 *            需要删除的文件的路径
	 */
	// public static void delete(String file) {
	// File afile = new File(file);
	// // boolean bool = false;
	// while(afile.exists())
	// {
	// afile.delete();
	// // int i = 1 ;
	// }

	// }
	/**
	 * 强力删除文件
	 * 
	 * @param file
	 *            需要删除的文件的路径
	 */
	public static boolean forceDelete(String file) {
		File f = new File(file);
		boolean result = false;
		int tryCount = 0;
		while (!result && tryCount++ < 10) {
			System.gc(); // System.gc()直接调用了系统内存回收
			result = f.delete();
		}
		return result;
	}

	/**
	 * 取得TXT文件的内容
	 * 
	 * @param file
	 *            TXT文件的路径
	 * @return TXT文件中的字符串
	 */
	public static String getContent(String file) {
		StringBuffer sb = new StringBuffer();
		String temp = "";
		String sb1 = "";
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(
					file), "gbk");
			BufferedReader bis = new BufferedReader(isr);
			int i=0;
			while ((temp = bis.readLine()) != null) {
				if(i!=0)
				sb.append("'");
				sb.append(temp);
				sb.append("'+");
				sb.append("'<br>'\r\n");
				sb.append("+");
				i++;
			}
			sb.append("'");
			sb1 = sb.toString().replace("//\\s+/","&nbsp;");
			System.out.println(sb1);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb1;
	}
}
