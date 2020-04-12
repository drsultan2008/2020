<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPEhtml>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Hello you, this is Homepage</h2>
	<!-- Display username and role: -->
	<p>User: <security:authentication property="principal.username" /></p>
	<p>Role: <security:authentication property="principal.authorities" /> </p>
	<!-- Addlink to leader -->
	<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/leaders">Leader Meeting</a> (Only for Admin)
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
	<a href="${pageContext.request.contextPath}/system">Manager Meeting</a> (Only for Manager)
	</security:authorize>
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button type="submit" name="logout"></button>
	</form:form>
</body>
</html>