<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="resources/css/style.css" var="urlCss"/>
        <link rel="STYLESHEET" href="${urlCss}" type="text/css" /> 
        <title>Summer Camp</title>
    </head>
    <body>
        <h1>Summer Camp Login</h1>

        <form:form method="POST" action="login" modelAttribute="login">

            <p><label>User:</label>
                <form:input path="name" size = "20"/>&nbsp;
                <form:errors path="name" cssClass="error"/>
            </p>
            
            
            <p><label>Password:</label>
            	<form:input path="password" size = "20"/>&nbsp;
            	<form:errors path="password" cssClass="error"/>
            </p>
            
            <p>
                <input type="submit" value="OK" />           
            </p>

        </form:form>

    </body>
</html>