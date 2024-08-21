

<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>


<%
    String id=request.getParameter("id");    
    Student s=StudentDao.getById(Integer.parseInt(id));

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container p-3">
            <h1 style="color: blue" class="mt-3">Student Update Form</h1>
            <form action="updatestudent.jsp" method="post" class="mt-5">
            <input type="hidden" name="id" value="<%=s.getId()%>">   
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Name</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name" value="<%=s.getName()%>">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" value="<%=s.getEmail()%>">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Address</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" value="<%=s.getAddress()%>">
            </div>
            <div class="form-group">
                    <label for="gender">Gender</label>
                    <div>
                        <label>
                            <input type="radio" name="gender" value="Male" <%= "Male".equals(s.getGender()) ? "checked" : "" %> /> Male
                        </label>
                        <label>
                            <input type="radio" name="gender" value="Female" <%= "Female".equals(s.getGender()) ? "checked" : "" %> /> Female
                        </label>
                        <label>
                            <input type="radio" name="gender" value="Others" <%= "Others".equals(s.getGender()) ? "checked" : "" %> /> Others
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="subject">Subject</label>
                    <select name="subject" id="subject" class="form-control">
                        <option value="">Please Select</option>
                        <option value="Java" <%= "Java".equals(s.getSubject()) ? "selected" : "" %>>Java</option>
                        <option value="C#" <%= "C#".equals(s.getSubject()) ? "selected" : "" %>>C#</option>
                        <option value="PHP" <%= "PHP".equals(s.getSubject()) ? "selected" : "" %>>PHP</option>
                    </select>
                </div>    
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
                <button type="submit" class="btn btn-primary" onclick="updateStudent(Student s)" >Update</button>
        </form>
        </div>
            
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    
        
        
    </body>
</html>
