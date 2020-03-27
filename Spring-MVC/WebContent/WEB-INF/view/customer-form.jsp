<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPEhtml>
<html>
<head>
	<title>Customer form</title>
	<style>
		.css{color:red}
	</style>
</head>
<body>
	<h1>The form:</h1>
	<form:form action="processForm" modelAttribute="customer">
		First Name: <form:input path="firstName" />
		<br><br>
		Last Name: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br><br>
		Free Passes: <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		<br><br>
		Postal Code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>