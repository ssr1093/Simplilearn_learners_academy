<%@page import="com.lsacad.dao.TeacherDAO"%>  
<jsp:useBean id="teacher" class="com.lsacad.bean.Teacher"></jsp:useBean>  
<jsp:setProperty property="*" name="teacher"/>  
  
<%  
int i = TeacherDAO.insertTeacher(teacher);

if(i>0){  
response.sendRedirect("Teacherlist.jsp");  
}else{  
response.sendRedirect("TeacherError.jsp");  
}  
%> 