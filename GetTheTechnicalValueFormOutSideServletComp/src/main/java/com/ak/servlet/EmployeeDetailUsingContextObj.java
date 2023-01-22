package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeDetailUsingContextObj extends HttpServlet {
	private static final String Get_EMP_BY_ENO = "select  firstname,collegname,id,class1,fees from hkbuddy where id=?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get printwriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// read data from table
		int no = Integer.parseInt(req.getParameter("eno"));
		ServletContext sc = getServletContext();
		String driverClass = sc.getInitParameter("driverclass");
		String dburl = sc.getInitParameter("dburl");
		String dbuser = sc.getInitParameter("dbuser");
		String dbpwd = sc.getInitParameter("dbpwd");

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(dburl, dbuser, dbpwd);
				PreparedStatement ps = con.prepareStatement(Get_EMP_BY_ENO)) {
			if (ps != null)
				ps.setInt(1, no);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs != null) {
					if (rs.next()) {

						pw.println("<h1 style='color:blue;text-align:center'>Student Details are</h1>");
//						pw.println("<p style='text-align:center'><b>Student Name::" + rs.getString(1) + "</b></p>");
//						pw.println("<p style='text-align:center'><b>Student college::" + rs.getString(2) + "</b></p>");
//						pw.println("<p style='text-align:center'><b>Student Id::" + rs.getString(3) + "</b></p>");
//						pw.println(
//								"<p style='text-align:center'><b>Section of student::" + rs.getString(4) + "</b></p>");
//						pw.println("<p style='text-align:center'><b>Course fees::" + rs.getString(5) + "</b></p>");
						pw.println("<table border='1' align='center' bgcolor='cyan' width='30%'>");
						pw.println("<tr height=\"50px\">");
						pw.println("<td>Student name ::</td>");
						pw.println("<td>" + rs.getString(1) + "</td>");
						pw.println("</tr>");
						pw.println("<tr height=\"50px\">");
						pw.println("<td>Student college ::</td>");
						pw.println("<td>" + rs.getString(2) + "</td>");
						pw.println("</tr>");
						pw.println("<tr height=\"50px\">");
						pw.println("<td>Student id ::</td>");
						pw.println("<td>" + rs.getString(3) + "</td>");
						pw.println("</tr>");
						pw.println("<tr height=\"50px\">");
						pw.println("<td>Section of Student::</td>");
						pw.println("<td>" + rs.getString(4) + "</td>");
						pw.println("</tr>");
						pw.println("<tr height=\"50px\">");
						pw.println("<td>Course fees ::</td>");
						pw.println("<td>" + rs.getString(5) + "</td>");
						pw.println("</tr>");

						pw.println("<table>");
					} else {
						pw.println("<h1 style='color:red;text-align:center'>Employee Not Found</h1>");
					} // else
				} // if
				pw.println("<br><br><p style='text-align:center;color:red'><a href='search.html'>Home Page</a>");
				// close stream
				pw.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
