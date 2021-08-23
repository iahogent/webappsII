<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<spring:url value="resources/css/style.css" var="urlCss"/>
		<title>Summer camp</title>
	</head>
	
	<body>
		<body>
		
		<h1>Postal Code</h1>
		
		<form:form method="POST" action="summercamp" modelAttribute="postalCode">
            <p><label>Postal code:</label>
            	<form:input path="postalCode" size = "20"/>&nbsp;
            	<form:errors path="postalCode" cssClass="error"/>
            </p>
            
            <p>
                <input type="submit" value="OK" />           
            </p>
            
		</form:form>
	</body>
	
</html>