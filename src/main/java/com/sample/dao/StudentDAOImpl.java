package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	CommonDAO comonDAO;
		
	
	public String addNewUser(String student_name, String father_name,
			String section, String type_of_student) { 
		String returnVal="failed";
		Connection con = null;
		PreparedStatement stmt=null;
		try{
			con = comonDAO.getDBConnection();
            stmt = con.prepareStatement("insert into Student (student_name, father_name, section, type_of_student) values(?,?,?,?)");
            stmt.setObject(1, student_name);
            stmt.setObject(2, father_name);
            stmt.setObject(3, section);
            stmt.setObject(4, type_of_student);
     
            int count=stmt.executeUpdate();
            if(count >= 1){
            	returnVal="success";
            }
            System.out.println("MSG : "+returnVal);
            

		}catch(Exception e){
			e.printStackTrace();

		}finally {
			try {
				stmt.close();
	    		con.close(); 
			}catch(Exception ex) {
				
			}
		}
		return returnVal;
		
	}

	
	public String update_student(String student_name, String father_name,
			String section, String type_of_student, String studentId) {
		
			 String returnVal="failed";
			 Connection con=null;
			 PreparedStatement stmt=null;
			try{
				con = comonDAO.getDBConnection();
	            stmt = con.prepareStatement("UPDATE Student SET student_name=?, father_name=?, section=?, type_of_student=? WHERE id=?");
	            stmt.setObject(1, student_name);
	            stmt.setObject(2, father_name);
	            stmt.setObject(3, section);
	            stmt.setObject(4, type_of_student);
	            stmt.setObject(5, studentId);
	            /*System.out.println(stmt.toString());*/
	            int count=stmt.executeUpdate();
	            if(count >= 1){
	            	returnVal="success";
	            }
	            System.out.println("MSG : "+returnVal);
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
		    		con.close(); 
				}catch(Exception ex) {
					
				}
			}
			return returnVal;

		}

	
	public List<Student> view_student(String student_name, String father_name,
			String section, String type_of_student) {
		Connection con = null;
		 PreparedStatement stmt=null;
		List<Student> list=new ArrayList<Student>();
		
		try{
			con = comonDAO.getDBConnection();
           stmt = con.prepareStatement("select student_name,father_name, section, type_of_student,id from student");
           ResultSet rs=stmt.executeQuery();
           while(rs != null && rs.next()){
         	  Student student=new Student();
         	student.setStudentName(rs.getString("student_name"));
         	student.setFatherName(rs.getString("father_name"));
         	student.setSection(rs.getString("section"));
         	student.setTypeOfStudent(rs.getString("type_of_student"));
         	student.setId(rs.getString("id"));
           	list.add(student);
           }
           /*System.out.println("list: "+list);*/
          
          

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	
	public String delete_student(String studentId) {
		
		 String returnVal="failed";
		 Connection con=null;
		 PreparedStatement stmt=null;
		try{
			con = comonDAO.getDBConnection();
           stmt = con.prepareStatement("Delete from Student WHERE id=?");
           stmt.setObject(1, studentId);
           /*System.out.println(stmt.toString());*/
           int count=stmt.executeUpdate();
           if(count >= 1){
           	returnVal="success";
           }
           System.out.println("MSG : "+returnVal);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
	    		con.close(); 
			}catch(Exception ex) {
				
			}
		}
		return returnVal;

	}
	

}
