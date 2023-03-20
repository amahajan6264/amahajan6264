package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get printwriter
		PrintWriter pw = res.getWriter();

		// print the error deail
		pw.println("<br><br><br><br>");
		pw.println("<h1 style='color:red;text-align:center'>Internal problem please try again</h1>");
		pw.println("<h1 style='color:red;text-align:center'><a href='index.html'>Home</a></h1>");

		// close the stream
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
