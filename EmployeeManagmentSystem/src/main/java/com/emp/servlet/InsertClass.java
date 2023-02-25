package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertSuccess")
public class InsertClass extends HttpServlet {
	// do get method for getting the response from employeeresiter class
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set conetent type
		res.setContentType("text/html");
		// get print writer
		PrintWriter pw = res.getWriter();
		pw.println(" <h1 style='text-align:center;color:red'>Employee is Resister Succesfully<h1>");
		// close
		pw.close();
	}
}
