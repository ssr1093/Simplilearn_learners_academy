<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.lsacad.dao.StudentDao, com.lsacad.bean.Student"%>  
  
<%  
			String id=request.getParameter("id");  
			Student stud = StudentDao.selectStudent(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="Studentedit.jsp" method="post">  
<input type="hidden" name="id" value="<%=stud.getId()%>"/>  
<table>  
<tr><td>First Name:</td><td>  

<input type="text" name="fname" value="<%= stud.getFname()%>"/></td></tr>  
<tr><td>Second Name:</td><td>  
<input type="text" name="lname" value="<%= stud.getLname()%>"/></td></tr>  
<tr><td>Subject:</td><td>  
<input type="text" name="subject" value="<%= stud.getAge()%>"/></td></tr>  
<tr><td>Class:</td><td>  

<input type="text" name="time" value="<%= stud.getAclass()%>"/></td></tr>  

</td> </tr>  
<tr><td colspan="2"><input type="submit" value="Change"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  