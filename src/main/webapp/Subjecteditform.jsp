<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.lsacad.dao.SubjectsDAO, com.lsacad.bean.Subject"%>  
  
<%  
			String id=request.getParameter("id");  
			Subject sub = SubjectsDAO.selectSubject(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="Subjectedit.jsp" method="post">  
<input type="hidden" name="id" value="<%=sub.getId()%>"/>  
<table>  
<tr><td>Subject Name:</td><td>  
<input type="text" name="name" value="<%= sub.getName()%>"></td></tr>
<tr><td>Shotcut:</td><td>  
<input type="text" name="shortcut" value="<%= sub.getShortcut()%>"/></td></tr>  </td> </tr>  
<tr><td colspan="2"><input type="submit" value="Change"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  