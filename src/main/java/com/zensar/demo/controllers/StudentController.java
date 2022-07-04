package com.zensar.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.dto.StudentDto;
import com.zensar.demo.entity.Student;
import com.zensar.demo.service.StudentServices;

@RestController
@RequestMapping(value = "/student-api")
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)

	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentServices.getStudent(studentId), HttpStatus.CREATED);
		// return studentServices.getStudent(studentId);

	}

	// @RequestMapping(value = "/students", method = RequestMethod.GET)
	// Traditional way
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> getAllStudents(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "studentName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue ="DESC") Direction dir) {
		return new ResponseEntity<List<StudentDto>>(studentServices.getAllStudents(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);

	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudents(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentServices.insertStudents(studentDto), HttpStatus.OK);
	}

	// @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentServices.updateStudent(studentId, studentDto);
		return new ResponseEntity<String>("Student Updated Successfully", HttpStatus.OK);

	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {

		studentServices.deleteStudent(studentId);
		return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping("/students/studentName/{studentName}")
	public List<StudentDto> getByStudentName(@PathVariable("studentName") String studentName) {
		return studentServices.getByStudentName(studentName);
	}

	@GetMapping("/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameAndStudentAge(
			@PathVariable("studentName") String studentName, @PathVariable("studentAge") int age) {

		return new ResponseEntity<List<StudentDto>>(studentServices.findByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}

	@GetMapping("/students/NameAge/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameOrStudentAge(
			@PathVariable("studentName") String studentName, @PathVariable("studentAge") int age) {

		return new ResponseEntity<List<StudentDto>>(studentServices.findByStudentNameOrStudentAge(studentName, age),
				HttpStatus.OK);
	}

	@GetMapping("/students/studentAge/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentAgeGreaterThan(@PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentServices.findByStudentAgeGreaterThan(age), HttpStatus.OK);
	}

	@GetMapping("/students/studentName1/{studentName}")
	public List<StudentDto> test(@PathVariable("studentName") String studentName) {
		return studentServices.test(studentName);
	}

	@GetMapping("/students/studentName2/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> test1(@PathVariable("studentName") String studentName,
			@PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentServices.findByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}

}
