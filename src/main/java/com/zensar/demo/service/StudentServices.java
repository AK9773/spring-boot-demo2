package com.zensar.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.demo.dto.StudentDto;
import com.zensar.demo.entity.Student;

public interface StudentServices {
	public StudentDto getStudent(int studentId);

	public List<StudentDto> getAllStudents(int pageNumber, int pageSize, String sortBy, Direction dir);

	public StudentDto insertStudents(StudentDto studentDto);

	public StudentDto updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);
	
	List<StudentDto> getByStudentName(String studentName);
	
	List<StudentDto> findByStudentNameAndStudentAge(String studentName, int age);
	
	List<StudentDto> findByStudentNameOrStudentAge(String studentName, int age);
	
	List<StudentDto> findByStudentAgeGreaterThan(int age);
	
	List<StudentDto> test(String studentName);
	List<Student> test1(String studentName, int age);
}
