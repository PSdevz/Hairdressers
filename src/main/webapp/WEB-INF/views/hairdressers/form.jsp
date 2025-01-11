<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Hairdresser</title>
</head>
<body>
<h2>Add a New Hairdresser</h2>

<%--@elvariable id="hairdresser" type=""--%>
<form:form action="/addHairdresser" modelAttribute="hairdresser">
    <form:label path="id">ID:</form:label><form:input path="id"/><br/>
    <form:errors path="id"/><br/>
    <form:label path="speciality">Speciality:</form:label><form:input path="speciality"/><br/>
    <form:errors path="speciality"/><br/>
    <form:label path="city">City:</form:label><form:input path="city"/><br/>
    <form:errors path="city"/><br/>
    <input type="submit"/>
</form:form>
</body>
</html>