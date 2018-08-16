package com.sample.dao;

import java.util.List;

import com.sample.model.Student;



public interface StudentDAO {

	String addNewUser(String student_name, String father_name, String section,
			String type_of_student);

	String update_student(String student_name, String father_name,
			String section, String type_of_student, String studentId);

	List<Student> view_student(String student_name, String father_name,
			String section, String type_of_student);

	String delete_student(String studentId);
	 
	
}
