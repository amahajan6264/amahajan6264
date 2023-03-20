package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet {

	private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO UPLOAD_EMPLOYEE(EMP_NAME,EMP_ADD,RESUME_PATH,PHOTO_PATH) VALUES(?,?,?,?)";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get print writer
		PrintWriter pw = res.getWriter();
		// set responce content type
		res.setContentType("text/html");
		// read form data
		Connection con = null;
		PreparedStatement ps = null;
		try {
			MultipartFormDataRequest mpreq = new MultipartFormDataRequest(req);
			String name = mpreq.getParameter("ename");
			String address = mpreq.getParameter("eadd");
			UploadBean upb = new UploadBean();

			// location of the folder on server machine
			upb.setFolderstore("C:/store");
			upb.setOverwrite(true);
			upb.setFilesizelimit(5000 * 1024);
			upb.store(mpreq);
			pw.print("<h1><b>files upload succesfully</b></h1>");

			// get the name of uploded file
			Vector<UploadParameters> vector = upb.getHistory();

			ArrayList<String> fileList = new ArrayList<>();
			vector.forEach(up -> {
				fileList.add("C:/store/" + up.getFilename());
			});
			vector.forEach(up -> {
				pw.println(up.getFilename());
			});

			// writer the jdbc code store the form data and file location in db table
			// load the jdbc driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}

			// establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost/ab", "root", "rootpassword");

			// create prepared statement
			ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);

			// set values to query params
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, fileList.get(1));
			ps.setString(4, fileList.get(0));

			// execute the query
			int count = ps.executeUpdate();
			if (count == 1) {
				pw.print("<h1 style='color:red:text-align:center'>Employee Register</h1>");
			} else {
				pw.print("<h1 style='color:red:text-align:center'>Employee is not register</h1>");
			}
//		} catch (UploadException e) {
//			System.out.println(e.getMessage());
//			System.out.println("Problem in uploading file");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rs = req.getRequestDispatcher("/ErrorServlet	");
			rs.forward(req, res);
		} finally {
			// close the prepare stmt
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			// close the connection obj
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
			// add hyperlink
		pw.print("<h1><a href='employee_register.html'>Home</a></h1>");
		pw.close();

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
