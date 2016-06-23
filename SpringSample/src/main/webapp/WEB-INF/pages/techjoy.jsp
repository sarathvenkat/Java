<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My First Page in Application</title>
</head>
<body>
<form:form action="saveEmployee" method="post" commandName="employ">
<h1 align="center">Employee Form</h1>
<table style="border:2px solid;" align="center">
<tr>
<td> FirstName :</td><td><form:input path="firstName"/></td></tr>
<tr><td> LastName :</td><td><form:input path="lastName"/></td></tr>
<tr><td>Joining Date :</td><td><form:input type="date" path="dateofJoining"/></td></tr>
<tr><td>Date of Birth :</td><td><form:input type="date" path="dateOfBirth"/></td></tr>
<tr><td align="center"><input  type="submit" value="save"></td></tr>
</table>
</form:form>
<c:if test="${!empty employed }">
<table align="center" style="border:2px solid black;">
<tr>
<th>Employee Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Date of Joining</th>
<th>Date of Birth</th>
<th>Edit</th>
</tr>

<c:forEach items="${employed}" var="emp">
<tr>
<td>${emp.emp_Id}</td>
<td>${emp.firstName}</td>
<td>${emp.lastName}</td>
<td>${emp.dateofJoining}</td>
<td>${emp.dateOfBirth}</td>
<td><a href="edit/${emp.emp_Id}">edit</a>/<a href="delete/${emp.emp_Id}">delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>