package com.emp.bean;

public class Employee {
	private int i;
	private String EmpName;
	private String EmpId;
	private String EmpDesignation;
	private String Address;
	private String photo;
	private String Resume;
	private String DateOfBirth;
	private static String CompanyName = "FSS";

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getEmpDesignation() {
		return EmpDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		EmpDesignation = empDesignation;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public static String getCompanyName() {
		return CompanyName;
	}

	public static void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}

}
