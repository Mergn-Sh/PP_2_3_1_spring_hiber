<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All users</h2>
<br>

<table>
    <tr>Name</tr>
    <tr>Surname</tr>
    <tr>Email</tr>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>