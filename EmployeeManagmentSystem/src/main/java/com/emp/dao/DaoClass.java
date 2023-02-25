package com.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.emp.bean.Employee;

public class DaoClass {

	// constructor for loading the database driver
	public DaoClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// connection method for getting the connection from database
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql//localhost:3306/EmpDb", "root", "rootpassword");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

//delete the employee by employee id
	public static boolean DeleteEmp(String eid) {
		boolean flag = true;
		String query = "delete EmployeeTable where id=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, eid);
			int result = ps.executeUpdate();
			if (result == 0) {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	// insert the employee in employee table
	public static boolean insertEmp(ArrayList<String> al) {

		String query = "insert into EmployeeTable (name,id,designation,address,gender,photo,resume) values(?,?,?,?,?,?,?)";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, al.get(1));
			ps.setString(2, al.get(2));
			ps.setString(3, al.get(3));
			ps.setString(4, al.get(4));
			ps.setString(5, al.get(5));
			ps.setString(6, al.get(6));
			ps.setString(7, al.get(7));

			int result = ps.executeUpdate();

			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// display the employee by employee id
	public static Employee displayEmp(String eid) {
		Employee emp = new Employee();
		String query = "select *From EmployeeTable where eid=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			ps.setString(1, eid);
			while (rs.next()) {
				emp.setI(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpId(rs.getString(3));
				emp.setEmpDesignation(rs.getString(4));
				emp.setAddress(rs.getString(5));
				emp.setPhoto(rs.getString(6));
				emp.setResume(rs.getString(7));
				emp.setDateOfBirth(rs.getString(8));
				emp.setCompanyName(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	// update the employee data
	public static void updateEmp(String eid) {
		String query = "update table EmployeeTable set ";
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
