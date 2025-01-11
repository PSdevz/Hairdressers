<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
    <title>Stylists List</title>
</head>
<body>
<h2>Stylists List</h2>

<c:forEach items="${stylists}" var="stylist">
    <br>Name: <b><c:out value = "${stylist.name}"/></b>
    <br>Skills:  <c:out value = "${stylist.skills}"/>
    <br>Expertise: <c:out value = "${stylist.expertise}"/>
    <br>Price: <c:out value = "${stylist.price}"/>
</c:forEach>
<br>
<a href="/newStylist?hairdresser=${hairdresser}">Add New Stylist</a>
</body>
</html>