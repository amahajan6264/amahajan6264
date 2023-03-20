package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerServlet extends HttpServlet {
	private static final String Insert_Into_Customer_table = "INSERT INTO SERVLET_TABLE(CNAME,CADD,BILLAMT,MOBILENO) VALUES(?,?,?,?)";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get printwriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// read data from table
		String name = req.getParameter("cname");
		String address = req.getParameter("cadd");
		float amt = Float.parseFloat(req.getParameter("cbillamt"));
		Long mobile = Long.parseLong(req.getParameter("cmno"));

		// get pooled jdbc on object
		try (Connection con = getPooledConnection();
				PreparedStatement ps = con.prepareStatement(Insert_Into_Customer_table)) {
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setFloat(3, amt);
			ps.setLong(4, mobile);

			// exeucte the reuslts
			int result = ps.executeUpdate();
			if (result == 1) {
				pw.println("<h1 style='color:green'>Customer is registerd </h1>");
			} else {
				pw.println("<h1 style='color:green'>Customer is not registerd </h1>");
			}

			// add hyperlink
			pw.println("<br><br><a href='search.html'>Home</a>");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro when data inserted into DB");
		}

	}

	// create helper method for jndi
	private Connection getPooledConnection() {

		InitialContext ic = null;
		Connection con = null;
		DataSource ds = null;
		// create initialContext object
		try {
			ic = new InitialContext();
		} catch (NamingException e) {

			e.printStackTrace();
			System.out.print("Error with getting connection");
		}
		// perfrom lookup operation
		try {
			String jndiName = getServletConfig().getInitParameter("DsJndi");
			ds = (DataSource) ic.lookup(jndiName);
		} catch (NamingException e1) {
			// e1.printStackTrace();
			System.out.println("Error with getting connection at time of  lookup operation");
		}

		try {
			con = ds.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();

			System.out.print("Error with getting connection get ");
		}
		return con;
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
