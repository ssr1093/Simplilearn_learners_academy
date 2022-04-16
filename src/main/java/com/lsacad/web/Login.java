package com.lsacad.web;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String JDBCURL = "jdbc:mysql://localhost:3306/learners_academy";
		 String jdbcusername = "root";
		 String jdbcpassword = "Reddy";
		String jdbcriver = "com.mysql.cj.jdbc.Driver";
		
		try{
		        String username = request.getParameter("username");   
		        String password = request.getParameter("password");
		        Class.forName(jdbcriver);  // MySQL database connection
//		        com.mysql.cj.jdbc.Driver
		        Connection conn = DriverManager.getConnection(JDBCURL, jdbcusername,jdbcpassword);    
		        PreparedStatement pst = conn.prepareStatement("Select username,password from login where username=? and password=?");
		        pst.setString(1, username);
		        pst.setString(2, password);
		        ResultSet rs = pst.executeQuery();        
		        if(rs.next()) {
		        	HttpSession session =request.getSession();
		        	session.setAttribute("username", username);
		        	response.sendRedirect("Dashboard.jsp");
		        }
		        else {
					response.sendRedirect("Login.jsp");
				}

			}
		   catch(Exception e){       
		      e.printStackTrace();       
		   } 
	}
}
