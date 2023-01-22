package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationApp extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set printWriter
		PrintWriter pw = res.getWriter();
		// set content on browser
		res.setContentType("text/html");
		// read the form data
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String Branch = req.getParameter("Branch");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String mobile = req.getParameter("Mobile");

		List<String> errorList = new ArrayList<>();
		if (fname.isEmpty()) {
			errorList.add("First name is required");
		}
		if (lname.isEmpty()) {
			errorList.add("Last name is required");
		}
		if (email.isEmpty()) {
			errorList.add("Email is required");
		}
		if (password.isEmpty()) {
			errorList.add("Password  is required");
		}
		if (Branch.isEmpty()) {
			errorList.add("Branch name is required");
		}
		if (address.isEmpty()) {
			errorList.add("Address is required");
		}
		if (mobile.isEmpty()) {
			errorList.add("Mobile no is required");
		}
		if (age.isEmpty()) {
			errorList.add("age is required");
		}
		if (gender.isEmpty()) {
			errorList.add("gender is required");
		} else {
			if (gender.contains("1")) {
				gender = "male";
			} else {
				gender = "female";
			}
		}

		if (errorList.size() > 0) {
			pw.println("<ul type='1' style='color:red'>");
			for (String list : errorList) {
				pw.println("<li> <h1 '>" + list + "</h1></li>");
			}
			pw.println("</ul>");
			return;
		}
		// display the data on browser as response
		pw.println("<h1 style='color:cyan'>");
		pw.println("First Name  is       : " + fname + "<br>");
		pw.println("Last Name is        : " + lname + "<br>");
		pw.println("Email Addrs is     : " + email + "<br>");
		pw.println("Password   is        : " + password + "<br>");
		pw.println("Branch Name is   : " + Branch + "<br>");
		pw.println("Age    is                 : " + age + "<br>");
		pw.println("Address is             : " + address + "<br>");
		pw.println("Mobile no  is        : " + mobile + "<br>");
		pw.println("Gender  is             : " + gender + "<br></P>");
		pw.println("</h1>");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
