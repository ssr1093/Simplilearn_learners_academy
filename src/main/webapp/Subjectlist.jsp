<!DOCTYPE html>  
  
<%@page import="com.lsacad.bean.Subject"%>
<%@page import="java.util.*"%>
<%@page import="com.lsacad.dao.SubjectsDAO"%>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Classes</title>  
</head>  
<body>  
  <a href="Dashboard.jsp">Home</a>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <br/><a href="Subjectadd.html">Add New Subject</a>  
<h1>Subject List</h1>  
  
<%  
List<Subject> sub =SubjectsDAO.listSubject();  
request.setAttribute("sub", sub);  
%>  
  
<table border="1" width="90%">  
<tr><th>Id</th><th>Subject Name</th><th>Shortcut Name</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${sub}" var="sub">  
<tr><td>${sub.getId()}</td><td>${sub.getName()}</td>
 <td>${sub.getShortcut()}</td>
<td><a href="Subjecteditform.jsp?id=${sub.getId()}">Edit</a></td>  
<td><a href="Subjectdelete.jsp?id=${sub.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  

  
</body>  
</html> 