<%@page import="com.lsacad.dao.ClassesDAO"%>  
<jsp:useBean id="cls" class="com.lsacad.bean.Classes"></jsp:useBean>  
<jsp:setProperty property="*" name="cls"/>  
<%  
ClassesDAO.deleteClasses(cls);  
response.sendRedirect("Classlist.jsp");  
%>  