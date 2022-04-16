<!DOCTYPE html>  
  
<%@page import="com.lsacad.bean.Student"%>
<%@page import="java.util.*"%>
<%@page import="com.lsacad.dao.StudentDao"%>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Classes</title>  
</head>  
<body>  
  <a href="Dashboard.jsp">Home</a>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <br/><a href="Studentadd.html">Add New Student</a>  
<h1>Student List</h1>  
  
<%  
List<Student> student =StudentDao.listStudents();  
request.setAttribute("student", student);  
%>  
  
<table border="1" width="90%">  
<tr><th>Id</th><th>First Name</th><th>Second Name</th><th>Age</th>  
<th>Class</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${student}" var="stud">  
<tr><td>${stud.getId()}</td><td>${stud.getFname()}</td><td>${stud.getLname()}</td>  
<td>${stud.getAge()}</td><td>${stud.getAclass()}</td>
<td><a href="Studenteditform.jsp?id=${stud.getId()}">Edit</a></td>  
<td><a href="Studentdelete.jsp?id=${stud.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  

  
</body>  
</html> 