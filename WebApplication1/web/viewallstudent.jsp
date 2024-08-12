

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>


<%

    List<Student> list= StudentDao.viewAllStudent();
    request.setAttribute("list", list);

%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<div class="container">
    <h1 style="color: blue" class="p-3">List of Students</h1>
    <table border="1" class="table table-success table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Subject</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

        <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getEmail()}</td>
                <td>${s.getGender()}</td>
                <td>${s.getSubject()}</td>
                <td>
                    <a href="updatestudentform.jsp?id=${s.getId()}">Edit</a>
                    <a href="deletestudent.jsp?id=${s.getId()}">Delete</a>
                </td>
            </tr>

        </c:forEach>

    </tbody>   

</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

