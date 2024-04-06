<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 8px;
}
</style>
</head>
<body bgcolor="pink">
	<h2>Employees</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.gender}</td>
					<td>${employee.age}</td>
					<td>${employee.salary}</td>
					<td><a href="editEmployee/${employee.id}">Edit</a> | <a
						href="deleteEmployee/${employee.id}"
						onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
