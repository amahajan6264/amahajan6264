package com.ak.lambok;

public class StudentDriverClass {
	public static void main(String[] args) {
		StudentBean sb = new StudentBean();
		sb.setStduentName("Akshay");
		// System.out.println(sb.getStduentName());
		try {
			sb.setStudentBranch(null);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		// System.out.println(sb.getStudentBranch());
		System.out.println(sb);
	}
}
