package com.sample.testDAO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.dao.StudentDAO;



public class DaoTest extends BaseIntegrationTest {
	
	@Autowired
	StudentDAO studentDAO;
	
	
	@Test
	public void testByAddStudent(){
		
		init();
		
		assertEquals("success",studentDAO.addNewStudent("Amir", "Khan", "D", "Correspondance"));
		
	}

	@Test
	public void testByUpdateStudent(){
		assertEquals("success",studentDAO.update_student("Aksay", "Kumar", "D", "Regular","16"));
		
	}
	
	/*@Test
	public void testByViewStudent(){
		assertEquals("success",studentDAO.view_student(student_name, father_name, section, type_of_student));
		
	}*/
	
	@Test
	public void testByDeleteStudent(){
		assertEquals("success",studentDAO.delete_student("7"));
		
	}
}
