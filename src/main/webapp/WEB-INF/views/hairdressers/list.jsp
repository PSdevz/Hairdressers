<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hairdressers List</title>
</head>
<body>
<h2>Hairdressers List</h2>

<c:forEach items="${hairdressers}" var="hairdresser">
    <p>The Hairdresser with speciality <b><c:out value = "${hairdresser.speciality}"/></b>
        lives in <b><c:out value = "${hairdresser.city}"/></b>
       </p>
    <a href="/stylists?hairdresser=${hairdresser.id}">Show Stylists</a>
</c:forEach>

</body>
</html>