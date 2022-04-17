<%@page import="com.lsacad.bean.Teacher"%>
<%@page import="com.lsacad.dao.TeacherDAO"%>  
<jsp:useBean id="teach" class="com.lsacad.bean.Teacher"></jsp:useBean>  
<jsp:setProperty property="*" name="teach"/>  
<%  
	TeacherDAO.deleteTeacher(teach);		
		response.sendRedirect("TeacherList.jsp");  
%>  