<%@page import="com.lsacad.dao.ClassesDAO"%>
<jsp:useBean id="cls" class="com.lsacad.bean.Classes"></jsp:useBean>  
<jsp:setProperty property="*" name="cls"/>  
<%  

	int i = ClassesDAO.updateClasses(cls);
		response.sendRedirect("Classlist.jsp");  
%> 