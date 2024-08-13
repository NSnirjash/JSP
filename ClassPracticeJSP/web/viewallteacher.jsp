

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Teacher" %>
<%@page import="dao.TeacherDao" %>
<%@page import="java.util.*" %>


<%

    List<Teacher> list= TeacherDao.viewAllTeacher();
    request.setAttribute("list", list);

%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<div class="container">
    <h1 style="color: blue" class="p-3">List of Teacher</h1>
    <table border="1" class="table table-success table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

        <c:forEach var="t" items="${list}">
            <tr>
                <td>${t.getId()}</td>
                <td>${t.getName()}</td>
                <td>${t.getDepartment()}</td>
                <td>${t.getGender()}</td>
                <td>
                    <a class="btn btn-primary" href="updateteacherform.jsp?id=${t.getId()}">Edit</a>
                    <a class="btn btn-danger" href="deleteteacher.jsp?id=${t.getId()}">Delete</a>
                </td>
            </tr>

        </c:forEach>

    </tbody>   

</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>