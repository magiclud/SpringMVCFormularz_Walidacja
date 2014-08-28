<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration goes Successfully</title>
</head>
<body>
<h3>
Registration goes succesfully. 
</h3>
<strong>User Name:${user.username}</strong><br>
<strong>User Email:${user.email}</strong><br>
<strong>User Gender:${user.gender}</strong><br>
<strong>User Birthday:<fmt:formatDate value="${customer.birthday}" type="date" /></strong><br>
Please login now 
<a href="${pageContext.servletContext.contextPath}/login">logowanie</a>
</body>
</html>