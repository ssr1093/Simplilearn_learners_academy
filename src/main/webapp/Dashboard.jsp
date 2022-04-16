<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dash Board</title>
<link rel="stylesheet" href="Style.css">  
</head>
<body>
<% 
if(session.getAttribute("username")==null) {
	response.sendRedirect("Login.jsp");
	
}
%>
<header>
		<nav class="Header"
			style="background-color: #BABE66">
			
				<h1 style="text-align: center;": center;">Learners Academy</h1>
			
					</nav>
</header>
<div class="sidenav">
  <a href="Dashboard.jsp" class="active">Home</a><br>
  <br>
  <a href="Studentlist.jsp">Student</a>
  <br>
   <br>
  <a href="Classlist.jsp">Classes</a><br><br>
  
  <a href="TeacherList.jsp">Teacher</a><br><br>
  <a href="SubjectsList.jsp">subjects</a><br><br>
   <a href="Logout.jsp">Logout</a><br>
</div>