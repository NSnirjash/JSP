<%-- 
    Document   : employeeaddform
    Created on : Jul 4, 2024, 1:12:04 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee Form</h1>
        
        <form action="saveemployee.jsp" method="post">
            
            Name:  <input type="text" name="name"> <br>
            Email  <input type="email" name="email"> <br>
            Address  <input type="text" name="address"> <br> 
            
            <input type="submit" value="Save"> <br>
            
        </form>
    </body>
</html>
