<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.lsacad.dao.ClassesDAO, com.lsacad.bean.Classes"%>  
  
<%  
			String id=request.getParameter("id");  
			Classes cls = ClassesDAO.selectclass(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="Classedit.jsp" method="post">  
<input type="hidden" name="id" value="<%=cls.getId() %>"/>  
<table>  
<tr><td>Section:</td><td>  
<input type="text" name="section" value="<%= cls.getSection()%>"/></td></tr>  
<tr><td>Teacher:</td><td>  
<input type="text" name="teacher" value="<%= cls.getTeacher()%>"/></td></tr>  
<tr><td>Subject:</td><td>  
<input type="text" name="subject" value="<%= cls.getSubject()%>"/></td></tr>  
<tr><td>Time:</td><td>  

<input type="text" name="time" value="<%= cls.getTime()%>"/></td></tr>  

</td></tr>  
<tr><td colspan="2"><input type="submit" value="Change"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  