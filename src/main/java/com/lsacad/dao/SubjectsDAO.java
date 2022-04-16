package com.lsacad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lsacad.bean.Subject;

public class SubjectsDAO {

	private static String JDBCURL = "jdbc:mysql://localhost:3306/learners_academy";
	private static String jdbcusername = "root";
	private static String jdbcpassword = "Reddy";
	private static String jdbcriver = "com.mysql.jdbc.Driver";
	
	
	
//	queries for add, delete, update the students
	private static final String subjectsInsertQuery= "Insert into subjects (name, shortcut) values (?, ?)";
	

	private static final String SELECT_subjectsBY_ID = "select id,name, shortcut from subjects where id =?";
	private static final String SELECT_ALL_subjects = "select * from subjects";
	private static final String DELETE_subjects_SQL = "delete from subjects where id = ?";
	private static final String UPDATE_subjects_SQL = "update subjects set name = ?,shortcut= ? where id = ?";
	
	
	public SubjectsDAO() {
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
public static int insertsubjet(Subject subject) {
	int status = 0;
//	try with resource method
	try (Connection connection =getconnection(); PreparedStatement ps = connection.prepareStatement(subjectsInsertQuery)) {
        ps.setString(1, subject.getName());
        ps.setString(2, subject.getShortcut());
        System.out.println(ps);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return status;
}
//list query
public static List<Subject> listSubject() {
	List<Subject> list = new ArrayList<Subject>();
	try {
		Connection connection =getconnection();
		PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_subjects);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Subject sub =new Subject();
			sub.setId(rs.getInt("id"));
			sub.setName(rs.getString("name"));
			sub.setShortcut(rs.getString("shortcut"));
			list.add(sub);
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	
}
// select student query
public static Subject selectSubject(int id) {
	Subject subject= null;

try {
	Connection connection =getconnection();
	PreparedStatement ps =connection.prepareStatement(SELECT_subjectsBY_ID);
	System.out.println(ps);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		Subject sub =new Subject();
		sub.setName(rs.getString("name"));
		sub.setShortcut(rs.getString("shortcut"));
	}
} catch (SQLException e) {
	e.printStackTrace();
}
	return subject;
}
//delete query
public static boolean deleteSubjects(Subject sub) {
	boolean deleted = false; 
	try {
		Connection connection =getconnection();
	
		PreparedStatement ps =connection.prepareStatement(DELETE_subjects_SQL);
		ps.setInt(1, sub.getId());
		deleted=ps.executeUpdate()>0;
	}
 catch (Exception e) {
	 e.printStackTrace();
}
return deleted;

}
//update query
public static int updateSubject(Subject sub) {
	int updated = 0; 
	try {
		Connection connection =getconnection();
	
		PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_subjects_SQL);
		preparedStatement.setString(1, sub.getName());
        preparedStatement.setString(2, sub.getShortcut());
        updated=preparedStatement.executeUpdate();
	}
 catch (Exception e) {
	e.printStackTrace();
}
return updated;

}

}
