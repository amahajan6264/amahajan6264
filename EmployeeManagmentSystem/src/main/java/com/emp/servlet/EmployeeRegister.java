package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.DaoClass;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;

@WebServlet("/EmpRegister")
public class EmployeeRegister extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set content type
		res.setContentType("text/html");
		// get print writer
		PrintWriter pw = res.getWriter();

		MultipartFormDataRequest mpreq;
		try {
			mpreq = new MultipartFormDataRequest(req);
			String name = mpreq.getParameter("ename");
			String eid = mpreq.getParameter("id");
			String Designation = mpreq.getParameter("desig");
			String address = mpreq.getParameter("address");
			String dateOfBirth = mpreq.getParameter("dob");
			String gender = mpreq.getParameter("gender");
			String companyName = mpreq.getParameter("cname");

			ArrayList<String> al = new ArrayList<>();
			al.add(name);
			al.add(eid);
			al.add(Designation);
			al.add(address);
			al.add(dateOfBirth);
			al.add(gender);
			al.add(companyName);

			// upload the file in server machine
			UploadBean upb = new UploadBean();
			upb.setFolderstore("C:/store");
			upb.setOverwrite(true);
			upb.setFilesizelimit(5000 * 1024);
			upb.store(mpreq);
			pw.print("<h1><b>files upload succesfully</b></h1>");

			// get the name of uploded file from server machine
			Vector<UploadParameters> vector = upb.getHistory();

			// ArrayList<String> fileList = new ArrayList<>();
			vector.forEach(up -> {
				al.add("C:/store/" + up.getFilename());
			});

			// checking for data inserted or not
			RequestDispatcher rd = req.getRequestDispatcher("/insertSuccess");
			if (DaoClass.insertEmp(al)) {
				req.setAttribute("att1", true);
				rd.include(req, res);
			} else {
				req.setAttribute("att1", false);
				rd.include(req, res);
			}

//			vector.forEach(up -> {
//				pw.println(up.getFilename());
//			});
		} catch (UploadException | IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
