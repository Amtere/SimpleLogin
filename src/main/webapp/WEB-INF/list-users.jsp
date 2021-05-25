<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<title>Users list</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>User Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add User"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<table>
				<tr>
					<th>ID</th>
					<th>USER</th>
					<th>PASS</th>
				</tr>
				
				<c:forEach var = "tempUser" items = "${users}">
					<tr>
						<td> ${tempUser.id} </td>
						<td> ${tempUser.userName} </td>
						<td> ${tempUser.password} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>