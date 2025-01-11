<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Stylists</title>
</head>
<body>

<h2>Add New Stylist for Hairdresser</h2>


<%--@elvariable id="stylist" type=""--%>
<form:form action="/addStylist" modelAttribute="stylist">

    <form:label path="name">Name:</form:label><form:input path="name"/><br/>
    <form:errors path="name"/><br/>
    <form:label path="skills">Skills:</form:label><form:input path="skills"/><br/>
    <form:errors path="skills"/><br/>
    <form:label path="expertise">Expertise:</form:label><form:input path="expertise"/><br/>
    <form:errors path="expertise"/><br/>
    <form:label path="price">Price:</form:label><form:input path="price"/><br/>
    <form:errors path="price"/><br/>

    <input name="hairdresser" type="hidden" value="${hairdresser}"/><br>

    <input type="submit"/>
</form:form>
</body>
</html>