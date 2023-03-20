package com.ak.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/Employee_download")
public class FileDownloadServlet extends HttpServlet {
	private static final String Get_RESUME_PATH_BY_NO = "SELECT RESUME_PATH FROM UPLOAD_EMPLOYEE WHERE EMP_NO=?";
	private static final String Get_PHOTO_PATH_BY_NO = "SELECT PHOTO_PATH FROM UPLOAD_EMPLOYEE WHERE EMP_NO=?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// check which download hyperlink is clicked (resume or photo)
		String query = null;
		int eno = 0;
		if (req.getParameter("resumeId") != null) { // for resume
			query = Get_RESUME_PATH_BY_NO;
			eno = Integer.parseInt(req.getParameter("resumeId"));
		} else { // for photo
			query = Get_PHOTO_PATH_BY_NO;
			eno = Integer.parseInt(req.getParameter("photoId"));
		}

		// get the connection from DaoClass
		PreparedStatement ps = null;
		Connection con = DaoClass.getConnection();
		String filePath = null;

		// create the prepare stmt
		try {
			ps = con.prepareStatement(query);

			// set value to query param
			ps.setInt(1, eno);

			// execute the query
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					filePath = rs.getString(1);
				} // if
			} // try
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// get length of the file and make it response content length
		File file = new File(filePath);
		// res.setContentLengthLong(file.length());

		// get file content type (MIME type) make it as response content type
		ServletContext sc = getServletContext();
		String mimeType = sc.getMimeType(filePath);
		mimeType = mimeType != null ? mimeType : "application/octet-stream";
		res.setContentType(mimeType);

		// Give instruction to browser to make the received content as the downloadable
		// file content
		res.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());

		// create InputStream pointing to the file
		InputStream is = new FileInputStream(filePath);

		// create output pointing to response object
		OutputStream os = res.getOutputStream();

		// copy file content to response obj (this complete file downloading)
		IOUtils.copy(is, os);

		is.close();
		os.close();
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
