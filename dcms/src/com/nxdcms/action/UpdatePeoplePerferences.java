package com.nxdcms.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nxdcms.dao.RecommendDao;
import com.nxdcms.dao.impl.RecommendDaoImpl;

public class UpdatePeoplePerferences extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void init() throws ServletException {
		super.init();
		MyThread thread = MyThread.getUpdateBy24();
		thread.start();

	}

}

class MyThread extends Thread {

	private RecommendDao rd;

	private static class SingletonFactory {
		private static MyThread mythread = new MyThread();
	}

	public static MyThread getUpdateBy24() {
		return SingletonFactory.mythread;
	}

	private MyThread() {
		try {
			rd = new RecommendDaoImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void run() {
		while (true) {
			rd.SeekandUpdateStudentBy24();
			try {
				Thread.sleep(60 * 60 * 24 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}