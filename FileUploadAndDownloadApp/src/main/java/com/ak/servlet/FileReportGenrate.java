package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileReportGenrate extends HttpServlet {
	private static final String GET_THE_DATA = "SELECT *FROM UPLOAD_EMPLOYEE";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get print writer
		PrintWriter pw = res.getWriter();
		// set contentype
		res.setContentType("text/html");

		// write the jdbc code
		// load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getMessage());
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ab", "root", "rootpassword");
				PreparedStatement ps = con.prepareStatement(GET_THE_DATA);
				ResultSet rs = ps.executeQuery()) {
			// process the result data
			pw.println(
					"<body bgcolor='cyan'><marquee direction='right'><h1 style='color:red'>Detail of the employee</h1></marquee>");

			pw.println("<br><table border='7' align='center' bgcolor='cyan'>");
			pw.println(
					"<tr><th>EMP_NO</th><th>EMP_NAME</th><th>EMP_ADD</th><th>EMP_RESUME</th><th>EMP_PHOTO</th><th>Delete Emp</th></tr>");
			while (rs.next()) {
				pw.println("<tr height='70'><td>" + rs.getInt(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td><a href='Employee_download?resumeId=" + rs.getInt(1) + "'>download</td>");
				pw.println("<td><a href='Employee_download?photoId=" + rs.getInt(1) + "'>download</td> ");
				pw.println("<td><a href='Employee_delete?empid=" + rs.getInt(1) + "'>delete</td></tr>");
			} // while
			pw.println("</table></body>");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pw.println("<h1 style='color:red;text-align:center'><a href='index.html'>Home</a></h1>");

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
