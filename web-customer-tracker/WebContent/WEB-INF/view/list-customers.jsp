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
						<!-- Construct an update link with customerId -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${iterCustomer.id}" />
						</c:url>
						
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${iterCustomer.id}" />
						</c:url>
						
						<tr>
							<td>${iterCustomer.firstName}</td>
							<td>${iterCustomer.lastName}</td>
							<td>${iterCustomer.email}</td>
							<td><a href="${updateLink}">Update</a></td>
							<td>|<a href="${deleteLink}">Delete</a></td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>