package com.ak.lambok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentBean {

	private int studentId;
	@NonNull
	private String stduentName;

	private String studentAdd;

	public String getstudentAdd() {
		return this.studentAdd;
	}

	@NonNull
	private String studentBranch;

}
