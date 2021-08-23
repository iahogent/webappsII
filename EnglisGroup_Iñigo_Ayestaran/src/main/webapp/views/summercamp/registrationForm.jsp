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
        <h1>${camp.manager.name}</h1>

        <form:form method="POST" action="${camp.id}" modelAttribute="person">

            <p><label>User Name:</label>
                <form:input path="name" size = "20"/>&nbsp;
                <form:errors path="name" cssClass="error"/>
            </p>
            
            
            <p><label>Num1:</label>
            	<form:input path="code1" size = "20"/>&nbsp;
            	<form:errors path="code1" cssClass="error"/>
            </p>
            
            <p><label>Num2:</label>
            	<form:input path="code2" size = "20"/>&nbsp;
            	<form:errors path="code2" cssClass="error"/>
            </p>
            
            <p>
                <input type="submit" value="OK" />           
            </p>

        </form:form>

    </body>
</html>