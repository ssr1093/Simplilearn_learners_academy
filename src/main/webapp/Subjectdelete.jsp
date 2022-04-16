<%@page import="com.lsacad.bean.Subject"%>
<%@page import="com.lsacad.dao.SubjectsDAO"%>  
<jsp:useBean id="sub" class="com.lsacad.bean.Subject"></jsp:useBean>  
<jsp:setProperty property="*" name="stud"/>  
<%  
	SubjectsDAO.deleteSubjects(sub);
		
		response.sendRedirect("Subjectlist.jsp");  
%>  