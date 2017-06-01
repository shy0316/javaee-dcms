package com.nxdcms.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.Action;

import java.io.File;
import com.opensymphony.xwork2.ActionSupport;
public class UploadAction {
	
	private String title;
	
	 private File upload;
     private String uploadContentType;
     private String uploadFileName;

     public void setUpload(File file) {
        this.upload = file;
     }

     public void setUploadContentType(String contentType) {
        this.uploadContentType = contentType;
     }

     public void setUploadFileName(String filename) {
        this.uploadFileName = filename;
     }



	public String execute() throws Exception {
		System.out.println(title);
		System.out.println(uploadFileName);
		System.out.println(uploadContentType);
		InputStream is = null;
		OutputStream os = null;
		String mypath = "D:\\app\\项目\\apache-tomcat-7.0.68\\webapps\\news\\";

		try {
			if (upload != null) {
				is = new BufferedInputStream(new FileInputStream(upload));
				os = new BufferedOutputStream(new FileOutputStream(mypath
						+ uploadFileName));
				byte[] buffer = new byte[1024];
				int len = 0;

				while ((len = is.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
				
			}else {
				System.out.println("文件传输失败");
			}
			

			

		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}

		}
		return Action.SUCCESS;
		
		
	}
}
