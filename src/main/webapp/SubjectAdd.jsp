<%@page import="com.lsacad.dao.SubjectsDAO"%>  
<jsp:useBean id="sub" class="com.lsacad.bean.Subject"></jsp:useBean>  
<jsp:setProperty property="*" name="sub"/>  
  
<%  
int i = SubjectsDAO.insertsubjet(sub);

if(i>0){  
response.sendRedirect("Subjectlist.jsp");  
}else{  
response.sendRedirect("SubjectError.jsp");  
}  
%> 