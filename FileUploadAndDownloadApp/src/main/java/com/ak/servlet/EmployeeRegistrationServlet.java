package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get print writer
		PrintWriter pw = res.getWriter();
		// set responce content type
		res.setContentType("text/html");
		// read form data
		try {
			MultipartFormDataRequest mpreq = new MultipartFormDataRequest(req);
			String name = mpreq.getParameter("ename");
			String address = mpreq.getParameter("eadd");
			UploadBean upb = new UploadBean();

			upb.setFolderstore("C:/store");
			upb.setOverwrite(false);
			upb.setFilesizelimit(5000 * 1024);
			upb.store(mpreq);
		} catch (UploadException e) {
			System.out.println(e.getMessage());
			System.out.println("Problem in uploading file");
		}
		pw.print("<b>files upload succesfully</b>");
		pw.print("<h1><a href='employee_register.html'>Home</a></h1>");
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
