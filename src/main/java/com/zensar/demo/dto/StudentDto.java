package com.zensar.demo.dto;



public class StudentDto {
	public int studentId;
	public String studentName;
	public int studentAge;
	public StudentDto() {
		super();
	}
	public StudentDto(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ "]";
	}
	
	
}
