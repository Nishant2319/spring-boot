<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student service</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
table {
	border-collapse: separate;
	border-spacing: 0 15px;
}

th {
	background-color: #4287f5;
	color: white;
}

th, td {
	width: 150px;
	text-align: center;
	border: 1px solid black;
	padding: 5px;
}

h2 {
	color: #4287f5;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${result.getClass().getSimpleName().equals('String')}">
			<h1>${result}</h1>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${result.size()==0}">
					<h1>Nothing to show</h1>
				</c:when>
				<c:otherwise>
					<h1>Students list</h1>
					<table>
						<tr>
							<th>Roll no.<span> </span></th>
							<th>name</th>
							<th>Age</th>
						</tr>
						<c:forEach items="${result}" var="i">
							<tr class="td" style="color: red;">
								<td>${i.roll}</td>
								<td>${i.name}</td>
								<td>${i.age}</td>
							</tr>
						</c:forEach>
					</table>

				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>


	<br>
	<a type="submit" class="btn btn-primary "
		style="margin-bottom: 15px; margin-top: 15px" href="/home">Home</a>
	<a type="submit" class="btn btn-primary " href="/logout">Logout</a>
</body>
</html>