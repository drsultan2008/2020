<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPEhtml>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Hello you, this is Homepage</h2>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button type="submit" name="logout"></button>
	</form:form>
</body>
</html>