<%@page import="com.lsacad.dao.SubjectsDAO"%>
<jsp:useBean id="sub" class="com.lsacad.bean.Subject"></jsp:useBean>  
<jsp:setProperty property="*" name="sub"/>  
<%  

		int i = SubjectsDAO.updateSubject(sub);
		response.sendRedirect("Subjectlist.jsp");  
%> 