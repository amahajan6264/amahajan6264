package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Employee_delete")
public class Delete_emp extends HttpServlet {
	private static final String Delete_emp = "delete  from UPLOAD_EMPLOYEE where emp_no=?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get print writer
		PrintWriter pw = res.getWriter();
		// get hyperlink data
		int empno = Integer.parseInt(req.getParameter("empid"));
		// get the connection object
		try (Connection con = DaoClass.getConnection(); PreparedStatement ps = con.prepareStatement(Delete_emp)) {
			ps.setInt(1, empno);
			int a = ps.executeUpdate();
			if (a > 0) {
				pw.println("<h1 style='text-align:center;color:Green'>Employee is Deleted successfully</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.print("<h1 style='text-align:center;color:red'><a href='index.html'>Home Page</a></h1>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
