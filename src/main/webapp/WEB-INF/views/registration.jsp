

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
</head>
<body>
	<h2>User Registration Form</h2>
	<form action="registerEmp" method="post">
		<label for="name">Name:</label> <input type="text" id="name"
			name="name" required><br>
		<br> <label for="gender">Gender:</label> <select id="gender"
			name="gender" required>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
		</select><br>
		<br> <label for="age">Age:</label> <input type="number" id="age"
			name="age" required><br>
		<br> <label for="salary">Salary:</label> <input type="number"
			id="salary" name="salary" required><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>
