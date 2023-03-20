package com.ak.lifecyle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/url")
public class LifeCyle extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("lifeCyle : init(config)");
	}

	public LifeCyle() {
		System.out.println("lifeCyle: 0 param constructor");
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("service method service(-,-)");
		PrintWriter pw = res.getWriter();
		res.setIntHeader("Refresh", 5);
		res.setContentType("text/html");
		pw.print("<h1><b>welcome to web</b></h1>");
		pw.close();

	}

	@Override
	public void destroy() {
		System.out.println("lilfeCyle : destroy()");
	}

}
