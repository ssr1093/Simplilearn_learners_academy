<%@page import="com.lsacad.bean.Student"%>
<%@page import="com.lsacad.dao.StudentDao"%>  
<jsp:useBean id="stud" class="com.lsacad.bean.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="stud"/>  
<%  
	StudentDao.deleteStudent(stud);
		
		response.sendRedirect("Studentlist.jsp");  
%>  