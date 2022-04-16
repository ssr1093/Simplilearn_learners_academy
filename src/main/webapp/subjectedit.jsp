<%@page import="com.lsacad.dao.StudentDao"%>
<jsp:useBean id="stud" class="com.lsacad.bean.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="stud"/>  
<%  

		int i = StudentDao.updateStudent(stud);
		response.sendRedirect("Subjectlist.jsp");  
%> 