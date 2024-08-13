

<jsp:useBean class="model.Teacher" id="t"/>
<%@page  import="dao.TeacherDao" %>
<jsp:setProperty name="t" property="*" />


<%
    
    TeacherDao.deleteTeacher(t);
    response.sendRedirect("viewallteacher.jsp");

%>
