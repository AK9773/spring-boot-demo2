package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.demo.dto.StudentDto;
import com.zensar.demo.entity.Student;
import com.zensar.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	Pageable p;

	@Override
	public StudentDto getStudent(int studentId) {
		Student student = studentRepository.findById(studentId).get();
		/*
		 * StudentDto dto = mapToDto(student); return dto;
		 */
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudents(int pageNumber, int pageSize, String sortBy, Direction dir) {

		// List<Student> listOfStudents = studentRepository.findAll();
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		

		//Page<Student> page = studentRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC,"studentName")));
		Page<Student> page = studentRepository.findAll(PageRequest.of(pageNumber, pageSize, dir, sortBy));
		for (Student student : page) { 
			listOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfDto;

	}

	@Override
	public StudentDto insertStudents(StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student newInserted = studentRepository.save(student);
		/*
		 * //StudentDto dto = new StudentDto();
		 * dto.setStudentId(newInserted.getStudentId());
		 * dto.setStudentAge(newInserted.getStudentAge());
		 * dto.setStudentName(newInserted.getStudentName());
		 */
		return modelMapper.map(newInserted, StudentDto.class);

		// return dto;

	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student student2 = studentRepository.save(student);
		// StudentDto dto = mapToDto(student2);
		return modelMapper.map(student2, StudentDto.class);
		// return dto;

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}
	/*
	 * public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge()); return student; }
	 * 
	 * public StudentDto mapToDto(Student student) { StudentDto dto = new
	 * StudentDto(); dto.setStudentId(student.getStudentId());
	 * dto.setStudentAge(student.getStudentAge());
	 * dto.setStudentName(student.getStudentName()); return dto; }
	 */
	
	@Override
	public List<StudentDto> getByStudentName(String studentName) {
		// return studentRepository.getByStudentName(studentName);
		List<Student> listOfStudents = studentRepository.findByStudentName(studentName);
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			listOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<StudentDto> findByStudentNameAndStudentAge(String studentName, int age) {

		// return studentRepository.findByStudentNameAndStudentAge(studentName, age);

		List<Student> listOfStudents = studentRepository.findByStudentNameAndStudentAge(studentName, age);
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			listOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<StudentDto> findByStudentNameOrStudentAge(String studentName, int age) {

		List<Student> listOfStudents = studentRepository.findByStudentNameOrStudentAge(studentName, age);
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			listOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<StudentDto> test(String studentName) {
		List<Student> listOfStudents = studentRepository.test(studentName);
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			listOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfDto;
	}

	@Override
	public List<Student> test1(String studentName, int age) {
		return studentRepository.findByStudentNameAndStudentAge(studentName, age);
	}

	@Override
	public List<StudentDto> findByStudentAgeGreaterThan(int age) {
		List<Student> listOfStudents = studentRepository.findByStudentAgeGreaterThan(age);
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			listOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfDto;
	}
}
