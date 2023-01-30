package com.ak.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SendRedirection extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get pritWriter
		PrintWriter pw = res.getWriter();
		// set the content type
		res.setContentType("text/html");
		// read the form data
		String ss = req.getParameter("ss");
		String engine = req.getParameter("engine");
		// send hyperlink to browswer url to complete sendRedirection
		if (engine.equalsIgnoreCase("engine")) {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.google.com/search?q=" + ss
					+ "'>click the google search engine</a></h1>");
		} else if (engine.equalsIgnoreCase("bing")) {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.bing.com/search?p=" + ss
					+ "'>click the bing search engine</a></h1>");
		} else {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.yahoo.com/search?q=" + ss
					+ "'>click the yahoo search engine</a></h1>");
		}
		// close the stream
		pw.close();

	}// doGet(-,-);

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);

	}
}
