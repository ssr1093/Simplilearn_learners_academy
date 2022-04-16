<%@page import="com.lsacad.dao.ClassesDAO"%>  
<jsp:useBean id="cls" class="com.lsacad.bean.Classes"></jsp:useBean>  
<jsp:setProperty property="*" name="cls"/>  
  
<%  
int i = ClassesDAO.insertclass(cls);

if(i>0){  
response.sendRedirect("Classlist.jsp");  
}else{  
response.sendRedirect("ClassError.jsp");  
}  
%> 