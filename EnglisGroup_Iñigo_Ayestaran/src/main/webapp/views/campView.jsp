<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="resources/css/style.css" var="urlCss" />
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<title>Summercamp</title>
</head>
<body>
	<h2>Summer Camp overview</h2>
	<table width="50%">
		<tr>
			<th>Name</th>
			<th>Postal Code</th>
			<th>Max Children</th>
		</tr>

		<spring:url value="/summercamp/add/" var="summerCampAddUrl" />

		<c:forEach items="${camps}" var="camp">
			<tr>
				<td><a href="${summerCampAddUrl}${camp.id}">${camp.manager.name}</a></td>
				<td>${camp.postalCode}</td>
				<td>${camp.maxChildren}</td>
			</tr>
		</c:forEach>

	</table>
	<br>
</body>
</html>