package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBInitializationLogic extends HttpServlet {
	@Override
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("DBInitializlationLogic : init(config)");
		System.out.println("Driver class name : " + sc.getInitParameter("dbclass"));
		System.out.println("Data base url         : " + sc.getInitParameter("dburl"));
		System.out.println("Data base user       : " + sc.getInitParameter("dbuser"));
		System.out.println("Data base pwd       :" + sc.getInitParameter("dbpwd"));
	}

	public DBInitializationLogic() {
		System.out.println("DBInitializationLogic : 0-param constructor");
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.println("<b>Hello Browswer</b>");
		System.out.println("service(-,-)");
	}

	@Override
	public void destroy() {
		System.out.println("DBInitilizationLogic : destroy()");
	}
}
