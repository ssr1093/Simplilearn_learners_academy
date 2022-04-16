<!DOCTYPE html>  
  
<%@page import="com.lsacad.bean.Classes"%>
<%@page import="java.util.*"%>
<%@page import="com.lsacad.dao.ClassesDAO"%>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Classes</title>  
</head>  
<body>  
  <a href="Dashboard.jsp">Home</a>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <br/><a href="Classadd.html">Add New Class</a>  
<h1>Class List</h1>  
  
<%  
List<Classes> classes =ClassesDAO.listClasses();  
request.setAttribute("list",classes);  
%>  
  
<table border="1" width="90%">  
<tr><th>Id</th><th>Section</th><th>Teacher</th><th>Subject</th>  
<th>Time</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="cls">  
<tr><td>${cls.getId()}</td><td>${cls.getSection()}</td><td>${cls.getTeacher()}</td>  
<td>${cls.getSubject()}</td><td>${cls.getTime()}</td>
<td><a href="Classeditform.jsp?id=${cls.getId()}">Edit</a></td>  
<td><a href="Classdelete.jsp?id=${cls.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  

  
</body>  
</html> 