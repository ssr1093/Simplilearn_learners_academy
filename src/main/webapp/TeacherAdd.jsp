<%@page import="com.lsacad.dao.StudentDao"%>  
<jsp:useBean id="stud" class="com.lsacad.bean.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="stud"/>  
  
<%  
int i = StudentDao.insertstudent(stud);

if(i>0){  
response.sendRedirect("Studentlist.jsp");  
}else{  
response.sendRedirect("StudentError.jsp");  
}  
%> 