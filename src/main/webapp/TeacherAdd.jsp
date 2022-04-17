<%@page import="com.lsacad.dao.TeacherDAO"%>  
<jsp:useBean id="teach" class="com.lsacad.bean.Teacher"></jsp:useBean>  
<jsp:setProperty property="*" name="teach"/>  
  
<%  
int i = TeacherDAO.insertTeacher(teach);

if(i == 0){

	response.sendRedirect("TeacherError.jsp");

}
else {
	response.sendRedirect("TeacherList.jsp");

}
%> 