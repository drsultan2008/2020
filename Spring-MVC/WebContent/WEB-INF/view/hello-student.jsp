<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPEhtml>
<html>
<head>
	<title>Hello student</title>
</head>
<body>
	<h1>Full name: ${param.firstName} ${param.lastName} </h1>
	<h1>Country: ${param.country}</h1>
	<h1>Favorite Country: ${param.favoriteCountry }</h1>
	<h1>Operating System</h1>
	<ul>
		<c:forEach var="iter" items="${student.operatingSystem}">
			<li>${iter}</li>
		</c:forEach>
	</ul>
</body>
</html>