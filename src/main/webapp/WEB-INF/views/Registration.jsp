<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
<body>
    <div align="center">
        <form:form action="register" method="post" commandName="userForm" >
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" /></td>
                    <td><form:errors path="username" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                    <td><form:errors path="password" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><form:input path="email" /></td>
                     <td><form:errors path="email" cssClass="error" /></td>
                </tr>
                <tr>
                <td>Gender:</td>
                <td><form:select path="gender">
                        <form:option value="" label="Select Gender" />
                        <form:option value="MALE" label="Male" />
                        <form:option value="FEMALE" label="Female" />
                    </form:select></td>
                <td><form:errors path="gender" cssClass="error" /></td>
            </tr>
                <tr>
                    <td>Birthday (mm/dd/yyyy):</td>
                    <td><form:input path="birthDate" /></td>
                </tr>
                <tr>
                <td>Phone:</td>
                <td><form:input path="phone" /></td>
                <td><form:errors path="phone" cssClass="error" /></td>
            </tr>
                <tr>
                    <td>Profession:</td>
                    <td><form:select path="profession" items="${professionList}" /></td>
                </tr>
                <tr>
                    <td colspan="3" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>