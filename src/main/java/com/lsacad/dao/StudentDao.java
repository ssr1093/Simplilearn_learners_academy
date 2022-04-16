package com.lsacad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lsacad.bean.Student;

public class StudentDao {

	private static String JDBCURL = "jdbc:mysql://localhost:3306/learners_academy";
	private static String jdbcusername = "root";
	private static String jdbcpassword = "Reddy";
	private static String jdbcriver = "com.mysql.cj.jdbc.Driver";
	
	
	
//	queries for add, delete, update the students
	private static final String studentInsertQuery= "Insert into students (fname, lname, age, aclass ) values (?, ?, ?, ? )";
	

	private static final String SELECT_studentsBY_ID = "select id, fname, lname, age, aclass from students where id =?";
	private static final String SELECT_ALL_students = "select * from students";
	private static final String DELETE_students_SQL = "delete from students where id = ?";
	private static final String UPDATE_students_SQL = "update students set fname = ?, lname = ?,age= ?, aclass =? where id = ?";
	
	
	public StudentDao() {
	}
protected static Connection getconnection() {
	Connection connection = null;
	try {
		Class.forName(jdbcriver);
		connection = DriverManager.getConnection(JDBCURL, jdbcusername,jdbcpassword);
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch ( ClassNotFoundException e) {
		e.printStackTrace();
	}
	return connection;
	
}
//insert query
public static int insertstudent(Student stud) {
	int status = 0;

	try {
		Connection connection =getconnection();
		PreparedStatement ps = connection.prepareStatement(studentInsertQuery);
		ps.setString(1, stud.getFname());
        ps.setString(2, stud.getLname());
        ps.setInt(3, stud.getAge());
        ps.setString(4, stud.getAclass());
       
        System.out.println(ps);
        status = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return status;
}
//list query
public static List<Student> listStudents() {
	List<Student> students = new ArrayList<>();
	try {
		Connection connection =getconnection();
		PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_students);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Student stud = new Student();
			stud.setId(rs.getInt("id"));
			stud.setFname(rs.getString("fname"));
			stud.setLname(rs.getString("lname"));
			stud.setAge(rs.getInt("age"));
			stud.setAclass(rs.getString("aclass"));

			students.add(stud);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return students;
	
}
// select student query
public static Student selectStudent(int id) {
	 Student stud= null;

try {
	Connection connection =getconnection();
	PreparedStatement preparedStatement =connection.prepareStatement(SELECT_studentsBY_ID);
	preparedStatement.setInt(1, id);
	System.out.println(preparedStatement);
	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
		stud =new Student();
		stud.setId(rs.getInt(1));
		stud.setFname(rs.getString("fname"));
		stud.setLname(rs.getString("lname"));
		stud.setAge(rs.getInt("age"));
		stud.setAclass(rs.getString("aclass"));
	}
} catch (SQLException e) {
	e.printStackTrace();
}
	return stud;
}
//delete query
public static boolean deleteStudent(Student stud) {
	boolean deleted = false; 
	try {
		Connection connection =getconnection();
	
		PreparedStatement preparedStatement =connection.prepareStatement(DELETE_students_SQL);
		preparedStatement.setInt(1, stud.getId());
		deleted=preparedStatement.executeUpdate()>0;
	}
 catch (Exception e) {
	// TODO: handle exception
}
return deleted;

}
//update query
public static int updateStudent(Student student) {
	int updated = 0; 
	try {
		Connection connection =getconnection();
	
		PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_students_SQL);
		preparedStatement.setString(1, student.getFname());
		preparedStatement.setString(2, student.getLname());
		preparedStatement.setInt(3, student.getAge());
		preparedStatement.setString(4, student.getAclass());
		updated = preparedStatement.executeUpdate();
	}
 catch (Exception e) {
	e.printStackTrace();
}
return updated;

}

}
