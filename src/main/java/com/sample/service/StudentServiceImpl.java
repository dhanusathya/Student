package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.StudentDAO;
import com.sample.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	

	
	public String addNewUser(String student_name, String father_name,
			String section, String type_of_student) {
		return studentDAO.addNewUser(student_name, father_name,section, type_of_student);
	}

	
	public String update_student(String student_name, String father_name,
			String section, String type_of_student, String studentId) {
		
		return studentDAO.update_student(student_name, father_name, section, type_of_student, studentId);
	}

	
	public List<Student> view_student(String student_name, String father_name,
			String section, String type_of_student) {
		
		return studentDAO.view_student(student_name,father_name, section, type_of_student);
	}

	
	public String delete_student(String studentId) {
		return studentDAO.delete_student(studentId);
	}

}