<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPEhtml>
<html>
<head>
	<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<br>
		Last Name; <form:input path="lastName" />
		<br>
		Country: 
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		
		<form:radiobuttons path="favoriteCountry" items="${student.favoriteRadios }" />
		<br>
		
		Window: <form:checkbox path="operatingSystem" value="Window" />
		Linus: <form:checkbox path="operatingSystem" value="Linus" />
		Mac: <form:checkbox path="operatingSystem" value="Mac" />
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>