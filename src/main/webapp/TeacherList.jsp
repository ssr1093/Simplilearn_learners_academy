<!DOCTYPE html>  
  
<%@page import="com.lsacad.bean.Teacher"%>
<%@page import="java.util.*"%>
<%@page import="com.lsacad.dao.TeacherDAO"%>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Teachers</title>  
</head>  
<body>  
  <a href="Dashboard.jsp">Home</a>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <br/><a href="Teacheradd.html">Add New Teacher</a>  
<h1>Teachers List</h1>  
  
<%  
List<Teacher> teach =TeacherDAO.listTeacher();  
request.setAttribute("teach", teach);  
%>  
  
<table border="1" width="90%">  
<tr><th>Id</th><th>First Name</th><th>Second Name</th><th>Age</th>  
<th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${teach}" var="teach">  
<tr><td>${teach.getId()}</td><td>${teach.getFname()}</td>
<td>${teach.getLname()}</td>
 <td>${teach.getAge()}</td>
<td><a href="Teachereditform.jsp?id=${teach.getId()}">Edit</a></td>  
<td><a href="Teacherdelete.jsp?id=${teach.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  

  
</body>  
</html> 