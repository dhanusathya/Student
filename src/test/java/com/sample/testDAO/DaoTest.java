package com.sample.testDAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sample.dao.StudentDAO;



@SuppressWarnings("deprecation")
public class DaoTest extends BaseDaoTest {
	
	@Mock
	StudentDAO studentDAO;
	
	@Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testByAddStudent(){
		
		init();
		String msg = "Success";
		
		when(studentDAO.addNewStudent(Matchers.anyString(),Matchers.anyString(),Matchers.anyString(),Matchers.anyString())).thenReturn(msg);
		
		assertEquals("Success",studentDAO.addNewStudent("Vetri", "Vel", "D", "Correspondance"));
	}
	
	@Test
	public void testByAddStudentWithNull(){
		
		init();
		String msg = "failed";
		
		when(studentDAO.addNewStudent(Matchers.anyString(),Matchers.anyString(),Matchers.anyString(),Matchers.anyString())).thenReturn(msg);
		
		assertEquals("failed",studentDAO.addNewStudent("", "Vel", "D", "Correspondance"));
	}
		  
	@Ignore
	public void testByUpdateStudent(){
		assertEquals("Success",studentDAO.update_student("Aksay", "Kumar", "D", "Regular",23));
		
	}
	
	/*@Test
	public void testByViewStudent(){
		assertEquals("success",studentDAO.view_student(student_name, father_name, section, type_of_student));
		
	}*/
	
	@Ignore
	public void testByDeleteStudent(){
		assertEquals("Success",studentDAO.delete_student(19));
		
	}
}
