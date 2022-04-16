package com.lsacad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lsacad.bean.Teacher;

public class TeacherDAO {

	private static String JDBCURL = "jdbc:mysql://localhost:3306/learners_academy";
	private static String jdbcusername = "root";
	private static String jdbcpassword = "Reddy";
	private static String jdbcriver = "com.mysql.cj.jdbc.Driver";
	
	
	
//	queries for add, delete, update the students
	private static final String teachersInsertQuery= "Insert into teachers (fname, lname,age) values (?, ?, ?)";
	

	private static final String SELECT_teachersBY_ID = "select id,fname, lname,age, class from teachers where id =?";
	private static final String SELECT_ALL_teachers = "select * from teachers";
	private static final String DELETE_teachers_SQL = "delete from teachers where id = ?";
	private static final String UPDATE_teachers_SQL = "update teachers set fname = ?, lname = ?,age= ? where id = ?";
	
	
	public TeacherDAO() {
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
public static int insertTeacher(Teacher teacher) {
	int status = 0;

//	try with resource method
	try (Connection connection =getconnection(); PreparedStatement preparedStatement = connection.prepareStatement(teachersInsertQuery)) {
        preparedStatement.setString(1, teacher.getFname());
        preparedStatement.setString(2, teacher.getLname());
        preparedStatement.setInt(3, teacher.getAge());
       
       
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return status;
}
//list query
public static List<Teacher> listTeacher() {
	List<Teacher> teachers = new ArrayList<Teacher>();
	try {
		Connection connection =getconnection();
		PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_teachers);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setId(rs.getInt("id"));
			teacher.setFname( rs.getString("fname"));
			teacher.setLname(rs.getString("lname"));
			teacher.setAge(rs.getInt("age"));
			teachers.add(teacher);
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return teachers;
	
}
// select student query
public static Teacher selectTeacher(int id) {
	 Teacher teachers= null;

try {
	Connection connection =getconnection();
	PreparedStatement preparedStatement =connection.prepareStatement(SELECT_teachersBY_ID);
	System.out.println(preparedStatement);
	preparedStatement.setInt(1, id);
	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
		Teacher teacher =new Teacher();
		teacher.setFname( rs.getString("fname"));
		teacher.setLname(rs.getString("lname"));
		teacher.setAge(rs.getInt("age"));
	}
} catch (SQLException e) {
	e.printStackTrace();
}
	return teachers;
}
//delete query
public static boolean deleteTeacher(Teacher teacher) {
	boolean deleted = false; 
	try {
		Connection connection =getconnection();
	
		PreparedStatement preparedStatement =connection.prepareStatement(DELETE_teachers_SQL);
		preparedStatement.setInt(1, teacher.getId());
		deleted=preparedStatement.executeUpdate()>0;
	}
 catch (Exception e) {
	// TODO: handle exception
}
return deleted;

}
//update query
public static int updateteacher(Teacher teacher) {
	int updated = 0; 
	try {
		Connection connection =getconnection();
	
		PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_teachers_SQL);
		preparedStatement.setString(1, teacher.getFname());
        preparedStatement.setString(2, teacher.getLname());
        preparedStatement.setInt(3, teacher.getAge());
        updated=preparedStatement.executeUpdate();
	}
 catch (Exception e) {
	e.printStackTrace();
}
return updated;

}

}
