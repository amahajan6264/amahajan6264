package com.ak.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get print writer
		PrintWriter pw = res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("ename");
		String address=req.getParameter("eadd");
		UploadBean upb=new Upload();
		upb.setFolderStore("C:\\Users\\AKSHAY\\Downloads\\Advanced Java\store");
		upb.setO
		

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
