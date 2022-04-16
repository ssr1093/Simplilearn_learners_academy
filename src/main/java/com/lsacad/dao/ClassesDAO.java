
	package com.lsacad.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.lsacad.bean.Classes;

	public class ClassesDAO {

		private static String JDBCURL = "jdbc:mysql://localhost:3306/learners_academy";
		private static String jdbcusername = "root";
		private static String jdbcpassword = "Reddy";
		private static String jdbcriver = "com.mysql.cj.jdbc.Driver";
		
		//com.mysql.cj.jdbc.ClientPreparedStatement: select * from learners_academy.classes
		
//		queries for add, delete, update the students
		private static final String classesInsertQuery= "Insert into classes (section, teacher, subject, time) "
				+ "values (?, ?, ?, ?)";
		

		private static final String SELECT_classesBY_ID = "select id,section, teacher, subject, time from classes where id =?";
		private static final String SELECT_ALL_classes = "select * from classes";
		private static final String DELETE_classes_SQL = "delete from classes where id = ?";
		private static final String UPDATE_classes_SQL = "update classes set section = ?, teacher = ?, subject= ?, time =? where id = ?";
		
		
		public ClassesDAO() {
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
	public static int insertclass(Classes cls) {
//		try with resource method
		int status = 0;
		try (Connection connection =getconnection(); PreparedStatement ps = connection.prepareStatement(classesInsertQuery)) {
	        ps.setInt(1, cls.getSection());
	        ps.setString(2, cls.getTeacher());
	        ps.setString(3, cls.getSubject());
	        ps.setString(4, cls.getTime());
	       
	        System.out.println(ps);
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }return status;
		
	}
	//list query
	public static List<Classes> listClasses() {
		List<Classes> list = new ArrayList<Classes>();
		try {
			Connection connection =getconnection();
			PreparedStatement ps =connection.prepareStatement(SELECT_ALL_classes);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classes cls = new Classes();
				cls.setId(rs.getInt("id"));
				cls.setSection(rs.getInt("section"));
				cls.setTeacher(rs.getString("teacher"));
				cls.setSubject(rs.getString("subject"));
				cls.setTime( rs.getString("time"));
				list.add(cls);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	// select student query
	public static Classes selectclass(int id) {
		 Classes classes= null;

	try {
		Connection connection =getconnection();
		PreparedStatement preparedStatement =connection.prepareStatement(SELECT_classesBY_ID);
		System.out.println(preparedStatement);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			classes = new Classes();
			classes.setSection(rs.getInt("section"));
			classes.setTeacher(rs.getString("teacher"));
			classes.setSubject(rs.getString("subject"));
			classes.setTime( rs.getString("time"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return classes;
	}
	//delete query
	public static boolean deleteClasses(Classes cls) {
		boolean deleted = false; 
		try {
			Connection connection =getconnection();
		
			PreparedStatement ps =connection.prepareStatement(DELETE_classes_SQL);
			ps.setInt(1, cls.getId());
			deleted=ps.executeUpdate()>0;
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
	return deleted;

	}
	//update query
	public static int updateClasses(Classes cls) {
		int updated = 0; 
		try {
			Connection connection =getconnection();
		
			PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_classes_SQL);
			preparedStatement.setInt(1, cls.getSection());
	        preparedStatement.setString(2, cls.getTeacher());
	        preparedStatement.setString(3, cls.getSubject());
	        preparedStatement.setString(4, cls.getTime());
			updated=preparedStatement.executeUpdate();
		}
	 catch (Exception e) {
		e.printStackTrace();
	}
	return updated;

	}

	}


