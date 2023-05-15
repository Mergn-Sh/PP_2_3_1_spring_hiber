<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Update info</h2>
<br>

<form:form action="updateUser" modelAttribute="updateUser">
    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Email <form:input path="email"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>