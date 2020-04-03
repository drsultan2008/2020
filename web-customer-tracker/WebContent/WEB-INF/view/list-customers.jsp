<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPEhtml>
<html>
<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customre Relation Manager</h2>
		</div>
		<div id="container">
			<div id="content">
				<input type="submit" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
				<table>
					<tr>
						<th>First Name </th>
						<th>Last Naem</th>
						<th>Email</th>
					</tr>
					<c:forEach var="iterCustomer" items="${customers}">
						<tr>
							<td>${iterCustomer.firstName}</td>
							<td>${iterCustomer.lastName}</td>
							<td>${iterCustomer.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>