package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Employee;
import com.emp.dao.DaoClass;

@WebServlet("RepostGeneration")
public class ReportGeneration extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set content type
		res.setContentType("text/html");
		// get print writer
		PrintWriter pw = res.getWriter();
		// get value from req;
		String eid = req.getParameter("eid");

		Employee ey = DaoClass.displayEmp(eid);

		pw.println("<body>");
		pw.println("<table>");

		pw.println("<tr><th>Employee Name</th><td>" + ey.getEmpName() + "</td></tr>");
		pw.println("<tr><th>Employee id</th><td>" + ey.getEmpId() + "</td></tr>");
		pw.println("<tr><th>Employee Designation</th><td>" + ey.getEmpDesignation() + "</td></tr>");
		pw.println("<tr><th>Employee Address</th><td>" + ey.getAddress() + "</td></tr>");
		pw.println("<tr><th>Employee Photo</th><td></td></tr>");
		pw.println("<tr><th>Employee Resume</th><td><a href='Employee_download?photoId=" + ey.getI()
				+ "'>download</td></tr>");
		pw.println("<tr><th>Employee Date of birth</th><td>" + ey.getDateOfBirth() + "</td></tr>");
		pw.println("<tr><th>Employee Compnay</th><td>" + ey.getCompanyName() + "</td></tr>");

		pw.println("</table>");
		pw.println("</body>");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}
}
